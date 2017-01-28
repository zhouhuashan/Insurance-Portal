<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String msg = request.getParameter("msg");


if(msg == null){
	
	msg = " ";
	
	
}
else if(msg.equals("fail")){
	msg = "No recods found try again";
	
}
else if(msg.equals("fail2")){
	msg = "Error creating policy Please try again";
	
}
else if(msg.equals("fail3")){
	msg = "Error validating payment";
	
}
else if(msg.equals("policy")){
	msg = "Policy created successfully";
	
}
else if(msg.equals("pay")){
	msg = "Please Input user to proceed to payment";
	
}
else if(msg.equals("policy2")){
	msg = "Please input user to check policy";
	
}
else if(msg.equals("newpolicy")){
	msg = "Please input user to create new policy";
	
}
else if(msg.equals("viewpolicy")){
	msg = "Please input user to view policy";
	
}
%>
<%

	
String name=(String)session.getAttribute("name");  
String role=(String)session.getAttribute("role");  


	
	if(role == null||!(role.equals("admin")||role.equals("editor"))) {
	response.sendRedirect("login.jsp?msg=login");


}
else if (!(role.equals("admin"))){
		
		response.sendRedirect("privilage.jsp");

	}

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>

<link href="css/style.css" rel="stylesheet" >

</head>
<jsp:include page="menu.jsp" />  
<body>
<center>
<div class="content">
<div class="search">
<p class="message"><% out.println(msg); %></p><br>

<form  action="Registertest" method="post">
      <input type="text" name="data" placeholder="Enter UserName ..."/>
      
      <button type="submit">Search</button>
     
    </form>










</div>


</div>
</center>

</body>
</html>