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

<TABLE>
    <TR>
    <TD>日付</TD>
    <TD>体重</TD>
    <TD>摂取カロリー</TD>
	</TR>
	
	<%
   ArrayList<calBean> list = (ArrayList<calBean>)request.getAttribute("calList");
   for (int i=0; i<list.size(); i++) {
	   calBean cb = (calBean)list.get(i);
	%>
	
	<TR>
    <TD><%=cb.getDate() %></TD>
    <TD><%=cb.getWeight() %>kg</TD>
    <TD><%=cb.getCal() %>kcal</TD>
	</TR>

	<%
	} 
	%>

</TABLE>
<a href="MyPageSelectServlet">マイページに戻る</a><br>
</body>
</html>