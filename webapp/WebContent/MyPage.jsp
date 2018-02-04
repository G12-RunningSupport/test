<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ</title>
</head>
<body>
<%//userInfoBean ub = (userInfoBean)request.getAttribute("userBean");
HttpSession se = request.getSession();
userInfoBean ub = (userInfoBean)se.getAttribute("userBean");
int hei = ub.getHeight();
%>
	ようこそ<%out.print(ub.getId());%>さん<br><br>
	
	目標体重：<%= hei*hei*22/10000 %> kg　目標BMI：22<br>
	現在体重：<% int wei=ub.getNowWheight();
				if(wei != -1){
					out.print(wei+" kg　現在BMI："+(wei*10000/hei/hei));
				}else{
					out.print("まだ登録されていません");
				}
	%><br>
	<br>
	
	[ランキング]<br>
<TABLE>
	<TR>
    <TD>ID</TD>
    <TD>走行距離</TD>
    <TD>日付</TD>
	</TR>
	<%	
	routeBean rb = new routeBean();
	 ArrayList<routeBean> list = rb.getRank();
	/*ArrayList<routeBean> list = (ArrayList<routeBean>)request.getAttribute("routeList")*/; 
   for (int i=0; i<list.size(); i++) {
	   routeBean rb2 = (routeBean)list.get(i);
	%>

	<TR>
    <TD><%=i+1  %>位  <%=rb2.getId() %></TD>
    <TD><%=rb2.getDistance() %>km</TD>
    <TD><%=rb2.getDate() %></TD>
	</TR>  
	
	<%
	}
	%>

</TABLE>

<br>

<!--
<form action="/webapp/inputServlet">
	<input type="SUBMIT" value="ルート入力" ><br>
</form>

<form action="/webapp/inputServlet">
	<input type="SUBMIT" value="カロリー入力"><br>
</form>
-->
<% se.setAttribute("userBean", ub); %>
<a href="CalSelectServlet">カロリー詳細を表示する</a><br>
<a href="RouteSelectServlet">ルート詳細を表示する</a><br>
<a href="calEditor.jsp">カロリー入力</a><br>
<a href="htmltest.jsp">ルート入力</a><br>

</body>
</html>