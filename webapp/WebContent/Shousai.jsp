<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細データ</title>
</head>
<body>
<h1>詳細データ</h1>

<TABLE>
    <TR>
    <TD>日付</TD>
    <TD>体重</TD>
    <TD>摂取カロリー</TD>
    <TD>回数</TD>
    <TD>走行距離</TD>
    <TD>走行時間</TD>
	</TR>
	
	<%
	calBean cb = new calBean();
	ArrayList<calBean> list = cb.getRecords();
	%>


</TABLE>
<a href="MyPage.jsp">マイページに戻る</a><br>
</body>
</html>