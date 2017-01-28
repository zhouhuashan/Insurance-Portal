<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" >
<link href="css/dash.css" rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged in</title>



<%

	
String name=(String)session.getAttribute("name");  
String role=(String)session.getAttribute("role");  

/* if(name != "karthik"){  
  
    out.print("Please login first");  
    request.getRequestDispatcher("login.html").include(request, response);  
}  
*/


//if(role == null||!role.equals("admin")){
	
	if(role == null||!(role.equals("admin")||role.equals("editor"))) {
	response.sendRedirect("login.jsp?msg=login");


}
else if (!(role.equals("admin"))){
		
		response.sendRedirect("privilage.jsp");

	}

%>




</head>
<body>

<jsp:include page="menu.jsp" />  
  <center>
<div class="content">



<h1>Policy summaray</h1>

<div class="box">
  <div class="box__header">
    <h3 class="box__header-title">Dashboard</h3>
  </div><br><br>
  <div class="box__body">
    <div class="stats stats--main">
      <div class="stats__amount">126</div>
      <div class="stats__caption">Customer Count</div>
      <div class="stats__change">
        <div class="stats__value stats__value--positive">+6%</div>
        <div class="stats__period">this week</div>
      </div>
    </div>

    <div class="stats">
      <div class="stats__amount">87359</div>
      <div class="stats__caption">Policy Count</div>
      <div class="stats__change">
        <div class="stats__value stats__value--negative">-12%</div>
        <div class="stats__period">this week</div>
      </div>
    </div>

    <div class="stats">
      <div class="stats__amount">6302</div>
      <div class="stats__caption">About to expire</div>
      <div class="stats__change">
        <div class="stats__value">+78</div>
        <div class="stats__period">this week</div>
      </div>
    </div>

  </div>
</div>














</div>

</center>
</body>
</html>