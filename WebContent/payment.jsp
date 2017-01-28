<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" >

 <%

	
String name=(String)session.getAttribute("name");  
String role=(String)session.getAttribute("role");  


	
	if(role == null||!(role.equals("admin")||role.equals("editor"))) {
	response.sendRedirect("login.jsp?msg=login");


}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Portal</title>

<%

String id = (String)session.getAttribute("id5");









%>


</head>
<body>
<center>
<jsp:include page="menu.jsp" />  
<div class="content">

<form  action="paymentPortal_Admin" method="post">
<div class="search">


<input type="text" placeholder="Renew for in months" name="renew_validity"/><br>
<input type="text" placeholder="Expected Price" name="price"/><br>

<input type="hidden" name="id" value="<%= request.getParameter("id")%>">
<input type="hidden" name="policy" value="<%= request.getParameter("policy")%>">
<input type="hidden" name="validity" value="<%= request.getParameter("validity")%>">
<input type="hidden" name="createddate" value="<%= request.getParameter("createddate")%>">
<input type="hidden" name="updateddate" value="<%= request.getParameter("updateddate")%>">
<div>
<button type="submit">CheckOut</button>



</form>
</div>
</center>
</body>
</html>