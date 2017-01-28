<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/style.css" rel="stylesheet" >

<%@page import="java.util.ArrayList" %>

<% 
 ArrayList rows = new ArrayList();
 ArrayList rows2 = new ArrayList();
 rows = (ArrayList ) request.getAttribute("propertyList");
 rows2 = (ArrayList ) request.getAttribute("propertyList2");
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
<title>Results</title>
</head>
<body>



<center>
<jsp:include page="menu.jsp" />  
<div class="content">
<form action="" method="post">

 <select name="id" >


<% for (int i=0;i<rows2.size();i++)
          {
	%>
       
     <option value=" <% out.println(rows.get(i));%>">
   <% out.println(rows2.get(i));%>
   
 
     </option>    
             
              
              

        <%  } %>
          
      </select>  
       <br><br><br>  
    <div class="search2">
    
    <button type="submit" value="ViewPolicy" name="button" onclick="form.action='viewPolicy_Admin';">ViewPolicy</button>
     
       <button type="submit" value="ViewPolicy" name="button" onclick="form.action='viewPolicy_Admin';">PaymentPortal</button>
      <button type="submit" value="NewPolicy" name="button" onclick="form.action='GetData';">NewPolicy</button>
     
      
        </div>
  
      
      
       
</div>






</center>
</body>
</html>