<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
function validateForm() {
txt1 = document.getElementById("pass").value;
txt2 = document.getElementById("pass2").value;
if (txt1 == txt2){
	
	 return true;
	
}

	alert("Wrong Confirm Password");
	 return false;

}
</script>




<%

	
String auth=(String)session.getAttribute("auth");  
String id=(String)session.getAttribute("id");  

	if(auth == null||id == null || !auth.equals("yes")) {
	response.sendRedirect("Register.jsp?msg=fail2");


}

%>






<%String msg = request.getParameter("msg");


if(msg == null){
	
	msg = " ";
	
	
}
else if(msg.equals("fail")){
	msg = "User Alredy Exist";
	
}
else if(msg.equals("succes")){
	msg = "Data updated now create user";
	
}
	


%>
<link href="css/style.css" rel="stylesheet" >

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body background="img/login2.jpg">

<div>
  <div class="form">
    <h1>Register</h1>
    
    
     <p class="message"><% out.println(msg); %></p>
    <form class="login-form"  action="Login" method="post" onsubmit="return validateForm()">
      <input type="text" name="user" placeholder="Enter Username"/>
      <input type="password" name="pass" placeholder="Enter Password"/>
       <input type="password" name="pass2" placeholder="Confirm password"/>
    
    <select name="role" >
	<option value="editor" selected="selected">Select Role</option>
    <option value="editor">Editor</option>
    <option value="admin">Admin</option>
   </select>
   
      <button type="submit">SignUp</button>
       <br><br><br><br><br>
     </form>
  </div>
</div>

</body>
</html>