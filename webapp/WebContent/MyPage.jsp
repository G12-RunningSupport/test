<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ</title>
</head>
<body>
<%userInfoBean ub = (userInfoBean)request.getAttribute("userBean");%>
	ようこそ<%ub.getId(); %>さん
※ランキングを表示<br>
<br>

<!--
<form action="/webapp/inputServlet">
	<input type="SUBMIT" value="ルート入力" ><br>
</form>

<form action="/webapp/inputServlet">
	<input type="SUBMIT" value="カロリー入力"><br>
</form>
-->
<% request.setAttribute("userBean", ub); %>
<a href="CalSelectServlet">カロリー詳細を表示する</a><br>
<a href="RouteSelectServlet">ルート詳細を表示する</a><br>
<a href="calEditor.jsp">カロリー入力</a><br>
<a href="inputRoute.jsp">ルート入力</a><br>

</body>
</html>