
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ルート詳細データ</title>
</head>
<body>
<%
HttpSession se = request.getSession();
userInfoBean ub = (userInfoBean)se.getAttribute("userBean");%>
<h1>ルート詳細データ</h1>

<TABLE width="70%" height="5%">
    <TR>
    <TD align="center" valign="middle">日付</TD>
 <% //   <TD align="center" valign="middle">回数</TD>%>
    <TD align="center" valign="middle">走行距離</TD>
    <TD align="center" valign="middle">スタート時間</TD>
    <TD align="center" valign="middle">フィニッシュ時間</TD>
	</TR>
	
	<%
   ArrayList<routeBean> list = (ArrayList<routeBean>)request.getAttribute("routeList");
   for (int i=0; i<list.size(); i++) {
	   routeBean rb = (routeBean)list.get(i);
	%>
	<TR>
    <TD align="center" valign="middle"><%=rb.getDate() %></TD>
    <%//<TD align="center" valign="middle"><%=rb.getNo() %></TD>%>
    <TD align="center" valign="middle"><%=rb.getDistance() %> km</TD>
    <TD align="center" valign="middle"><%=rb.getStart() %></TD>
    <TD align="center" valign="middle"><%=rb.getFinish() %></TD>
	</TR>

	<%
	} 
	%>

</TABLE>
<br>
	<%se.setAttribute("userBean",ub); %>
<a href="MyPage.jsp">マイページに戻る</a><br>
</body>
</html>
