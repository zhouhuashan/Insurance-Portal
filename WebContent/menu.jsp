<!DOCTYPE html>
<html >
<head>




  <meta charset="UTF-8">
 
  
  
      <link rel="stylesheet" href="css/style2.css">

  

<%	
String name=(String)session.getAttribute("name");  
String role=(String)session.getAttribute("role");  
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
<div class="logo"><a href="secure.jsp">Insurance Portal </a></div>
<div id="head-mobile"></div>
<div class="button"></div>

<ul>
<li><a href='secure.jsp'>HOME</a></li>
<li><a href='search.jsp?msg=pay'>Payment Portal</a></li>
<li><a href='search.jsp?msg=policy2'>Policy</a>
   <ul>
      <li><a href='search.jsp?msg=newpolicy'>New Policy</a>
        
      </li>
      <li><a href='search.jsp?msg=viewpolicy'>View Policy</a>
          </li>
   </ul>
</li>
<li><a href='Register.jsp'>Registration</a></li>
  
 
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
