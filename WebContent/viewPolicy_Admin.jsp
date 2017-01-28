<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Policy Summary</title>


<link href="css/style.css" rel="stylesheet" >

<link href="css/table.css" rel="stylesheet" >
<%@page import="java.util.ArrayList" %>

<% 
ArrayList rows4 = new ArrayList();
ArrayList rows5 = new ArrayList();
ArrayList rows6 = new ArrayList();
ArrayList rows7 = new ArrayList();
rows4 = (ArrayList ) request.getAttribute("propertyList4");
rows5 = (ArrayList ) request.getAttribute("propertyList5");
rows6 = (ArrayList ) request.getAttribute("propertyList6");
rows7 = (ArrayList ) request.getAttribute("propertyList7");

String id = (String)request.getAttribute("id");
        
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

</head>
<body>

<jsp:include page="menu.jsp" />  

<center>

<div class="content">

<table class="responstable">

	  <tr>
		  <th>PolicyName</th>
		  <th>ValidTill</th>
		  <th>CreationDate</th>
		  <th>RenewalDate</th>
		  <th>Action</th>
		   <th>Action2</th>
   
	  </tr>
	  <% for (int i=0;i<rows4.size();i++)
{
%>
<form action="" method="post">
	  <tr>
	  <td data-th="PolicyName"><%out.println(rows4.get(i));%></td>
	  
	  <td data-th="ValidTill"><b><%out.println(rows5.get(i));%></b></td>
	  
	  <td data-th="CreationDate"><%out.println(rows6.get(i));%></td>
	  
	  <td data-th="RenewalDate"><%out.println(rows7.get(i));%></td>
	   <td data-th="Action"><button type="submit" onclick="form.action='viewPolicy_Admin3';">ViewPolicy</button></td>
	   <td data-th="Action2"><button type="submit" onclick="form.action='payment.jsp';">RenewNow</button></td>
	  </tr>	
	  
	  <input type="hidden" name="policy" value="<%= rows4.get(i)%>">
	  <input type="hidden" name="validity" value="<%= rows5.get(i)%>">
	  <input type="hidden" name="createddate" value="<%= rows6.get(i)%>">
	  <input type="hidden" name="updateddate" value="<%= rows7.get(i)%>">
	   <input type="hidden" name="id" value="<%= id%>">
	  
	  
	  
	  
</form>  
	<% }
 %>
 
  
  
  


</table>

























</div>















</center>
</body>
</html>