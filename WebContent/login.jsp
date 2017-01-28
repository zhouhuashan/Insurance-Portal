<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<%String msg = request.getParameter("msg");


if(msg == null){
	
	msg = " ";
	
	
}
else if(msg.equals("succes")){
	msg = "User Created. Please Login Here";
	
}
else if(msg.equals("login")){
	msg = "Please Login First";
	
}
else if(msg.equals("fail")){
	msg = "Wrong Username or Password";
	
}

%>

<link href="css/style.css" rel="stylesheet" >


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>


</head>
<body background="img/logo4.jpg">

<div class="login-page">
  <div class="form">
    <h1>Login</h1>
    
    <p class="message"><% out.println(msg); %></p>
    <form class="login-form"  action="Login2" method="post">
      <input type="text" name="user" placeholder="Enter Username"/>
      <input type="password" name="pass" placeholder="Enter Password"/>
      <button type="submit">login</button>
      <br><br><br>
       </form>
  </div>
</div>

</body>
</html>