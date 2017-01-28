<!DOCTYPE html>
<html >
<head>
<style>



</style>
  <meta charset="UTF-8">
 
  
  
      <link rel="stylesheet" href="css/style2.css">

  

<%	
String name=(String)session.getAttribute("name");  
String role=(String)session.getAttribute("role");
String count=(String)session.getAttribute("count");  
String ref = "logout.jsp";
%>
 
  <% 
  if(role == null||!(role.equals("admin")||role.equals("editor"))) {
  name = "Login";
  ref = "login.jsp";
  }
  else {
	  
	name = "Welcome" + " " + name+" (" + role+ ")" + " " + "Logout ";  
  }
  %>
  
  
</head>

<body>
  <header>
  <form class="login-form"  action="Registertest" method="post">
  
<nav id='cssmenu'>
<div class="logo"><a href="#">Insurance Portal </a></div>
<div id="head-mobile"></div>
<div class="button"></div>
<form action="" method="post">
<ul>
<li><button type="submit" onclick="form.action='viewPolicy_Client';">HOME</button></li>
<li><button type="submit" onclick="form.action='viewPolicy_Client';">PaymentPortal</button></li>
<li><button type="submit" onclick="form.action='viewPolicy_Client';">PolicySummary</button></li>
<li><button type="submit" onclick="form.action='viewPolicy_Client';">ViewPolicy</button></li>
   <% 
  if(!role.equals("0")) {
	  %>
 <li class="active2" ><a href="errorWork.jsp">
  
 
  <%out.println(count); %>
  
  </a></li>
   <% 
   }%>
  
  
  
 
    <li class="active" ><a href="<%out.println(ref); %>">
  
 
  <%out.println(name); %>
  
  </a></li>
 
  
   
    
</ul>
</form>
</nav>
</header>
  <script src='js/jquery.min.js'></script>

    <script src="js/index.js"></script>

</body>
</html>
