<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<%@ page import = "java.text.*"%>
<%@ page import="design.*" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カロリー入力画面</title>
</head>
<body>

<%RequestDispatcher dispatcher;
HttpSession se = request.getSession();
userInfoBean ub = (userInfoBean)se.getAttribute("userBean");%>
<%se.setAttribute("userBean",ub);%>
<% 
	GregorianCalendar cal = new GregorianCalendar();
	SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
	String datestr = format.format(cal.getTime());
	out.println(""+datestr+"");

%>

<br>
摂取カロリー
<form action="/webapp/CalUpdateServlet">
	<input type="TEXT" name="number"> kcal
<br>
体重<br>
	<!--form action="/webapp/CalUpdateServlet"-->
	<input type="TEXT" name="weight"> kg<br>
	<input type="SUBMIT" value="登録"><br>
</form>

<a href="MyPage.jsp">戻る</a>

</body>
</html>