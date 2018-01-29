<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カロリー詳細データ</title>
</head>
<body>
<h1>詳細データ</h1>

<TABLE width="45%" height="5%">
    <TR>
    <TD align="center" valign="middle">日付</TD>
    <TD align="center" valign="middle">体重</TD>
    <TD align="center" valign="middle">摂取カロリー</TD>
	</TR>
	
	<%
   ArrayList<calBean> list = (ArrayList<calBean>)request.getAttribute("calList");
   for (int i=0; i<list.size(); i++) {
	   calBean cb = (calBean)list.get(i);
	%>
	
	<TR>
    <TD align="center" valign="middle"><%=cb.getDate() %></TD>
    <TD align="right" valign="middle"><%=cb.getWeight()%> kg</TD>
    <TD align="center" valign="middle"><%=cb.getCal() %> kcal</TD>
	</TR>

	<%
	} 
	%>

</TABLE>
<br>
<a href="MyPage.jsp">マイページに戻る</a><br>
</body>
</html>