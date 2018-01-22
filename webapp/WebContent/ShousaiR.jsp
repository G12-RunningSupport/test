
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
<h1>ルート詳細データ</h1>

<TABLE>
    <TR>
    <TD>日付</TD>
    <TD>回数</TD>
    <TD>走行距離</TD>
    <TD>スタート時間</TD>
    <TD>フィニッシュ時間</TD>
	</TR>
	
	<%
   ArrayList<routeBean> list = (ArrayList<routeBean>)request.getAttribute("routeList");
   for (int i=0; i<list.size(); i++) {
	   routeBean rb = (routeBean)list.get(i);
	%>
	
	<TR>
    <TD><%=rb.getDate() %></TD>
    <TD><%=rb.getNo() %></TD>
    <TD><%=rb.getDistance() %></TD>
    <TD><%=rb.getStart() %></TD>
    <TD><%=rb.getFinish() %></TD>
	</TR>

	<%
	} 
	%>

</TABLE>
<a href="MyPage.jsp">マイページに戻る</a><br>
</body>
</html>
