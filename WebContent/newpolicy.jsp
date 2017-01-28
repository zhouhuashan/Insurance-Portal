<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" >
<%@page import="java.util.ArrayList" %>

<% 
        
 ArrayList rows3 = new ArrayList();
 rows3 = (ArrayList ) request.getAttribute("propertyList3");
 

        
 %>
 
<%

String msg = request.getParameter("msg");

if(msg == null){
	
	msg = " ";
	
	
}
else if(msg.equals("fail")){
	msg = "Unable to fetch the required details";
	
}
else if(msg.equals("fail2")){
	msg = "Please fill these details before creating a new user";
	
}


else if(msg.equals("succes")){
	msg = "Data updated Sucessfully";
	
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
<title>Registration</title>
</head>
<body>

<%

	/*
String name=(String)session.getAttribute("name");  
String role=(String)session.getAttribute("role");  
	
	if(role == null||!(role.equals("admin"))) {
	response.sendRedirect("login.jsp?msg=login");

}
*/
%>


<jsp:include page="menu.jsp" />  
  
  
  
  
  
  <center>
  
<div class="content">

   <p class="message"><% out.println(msg); %></p> <br><br>
    <form class="login-form"  action="Policy" method="post">
    <!-- Hidden 1 -->
     <input type="hidden" name="id" value="<%= rows3.get(0)%>">  
    <h3>PolicyName </h3><input type="text" name="policy" placeholder="Enter Policy name"> </input> 
  <h3>  Validity </h3><input type="text" name="validity" placeholder="Valid for in months"> </input>
   <br><br><br><br><br>
    
    <h3>FirstName</h3> <input type="text" name="fname" placeholder="Enter First Name" value="<%= rows3.get(1)%>"> </input> 
   <h3>MiddleName </h3> <input type="text" name="mname" placeholder="Enter Middle Name" value="<%= rows3.get(2)%>"> </input> 
   <h3> LastName</h3> <input type="text" name="lname" placeholder="Enter Last Name" value="<%= rows3.get(3)%>">  </input>
     <br><br><br><br><br>
<!-- HIdden 2 -->
<input type="hidden" name="gender" value="<%= rows3.get(4)%>">  
     <input type="hidden" name="dob" value="<%= rows3.get(5)%>">  
    
    <h3>Email</h3>  <input type="text" name="email" placeholder="Enter Email" value="<%= rows3.get(6)%>"></input> 
  <h3>   Phone</h3> <input type="text" name="phone" placeholder="Enter Phone" value="<%= rows3.get(7)%>">  </input> 
    <h3>Country</h3> <input type="text" name="country" placeholder="Enter Country" value="<%= rows3.get(8)%>"> </input> 
     <br><br><br><br><br>
   <h3> Address</h3> <textarea rows="5" cols="30" name="address" placeholder="Enter Address" value="<%= rows3.get(9)%>">
</textarea>
 <h3>PinCode</h3> <input type="text" name="pcode" placeholder="Enter Pincode" value="<%= rows3.get(10)%>" > </input> 
     <br>
      <button  type="submit">Submit</button>
     </form>
  















</div>












</center>

</body>
</html>