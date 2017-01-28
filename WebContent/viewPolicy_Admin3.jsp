<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewPolicy</title>
<link href="css/style.css" rel="stylesheet" >
<%@page import="java.util.ArrayList" %>

<% 
        
 ArrayList rows8 = new ArrayList();
 rows8 = (ArrayList ) request.getAttribute("propertyList8");
 

        
 %>
</head>
<body>
<center>

<jsp:include page="menu.jsp" />  
<div class="content">
<b4>Policy Summary</b4>
<br><br>
<b1>PolicyName:</b1><b2><%= rows8.get(1)%></b2>
<b1>Valid Till:</b1><b2><%= rows8.get(2)%></b2>
<b1>LastRenewalDate:</b1><b2><%= rows8.get(14)%></b2>
<br><br><br>
<b4>PersonalDetails</b4><br><br><br>
<b1>FirstName:</b1><b2><%= rows8.get(3)%></b2>
<b1>MiddleName:</b1><b2><%= rows8.get(4)%></b2>
<b1>LastName:</b1><b2><%= rows8.get(5)%></b2> <br><br><br>
<b1>Gender:</b1><b2><%= rows8.get(6)%></b2>
<b1>DateOFBirth:</b1><b2><%= rows8.get(7)%></b2>
<b1>Email:</b1><b2><%= rows8.get(8)%></b2><br><br><br>
<b1>Phone:</b1><b2><%= rows8.get(9)%></b2>
<b1>Country:</b1><b2><%= rows8.get(10)%></b2>
<b1>Address:</b1><b2><%= rows8.get(11)%></b2><br><br><br>
<b1>Pincode:</b1><b2><%= rows8.get(12)%></b2>
<b1>PolicyCreatedOn:</b1><b2><%= rows8.get(13)%></b2>

<br>
<form action="" method="post">
	  <input type="hidden" name="policy" value="<%= rows8.get(1)%>">
	  <input type="hidden" name="validity" value="<%= rows8.get(2)%>">
	  <input type="hidden" name="fname" value="<%= rows8.get(3)%>">
	  <input type="hidden" name="mname" value="<%= rows8.get(4)%>">
	  <input type="hidden" name="lname" value="<%= rows8.get(5)%>">
	  <input type="hidden" name="gender" value="<%= rows8.get(6)%>">
	  <input type="hidden" name="dob" value="<%= rows8.get(7)%>">
	  <input type="hidden" name="email" value="<%= rows8.get(8)%>">
	  <input type="hidden" name="phone" value="<%= rows8.get(9)%>">
	  <input type="hidden" name="country" value="<%= rows8.get(10)%>">
	  <input type="hidden" name="address" value="<%= rows8.get(11)%>">
	  <input type="hidden" name="pcode" value="<%= rows8.get(12)%>">
	  <input type="hidden" name="createddate" value="<%= rows8.get(13)%>">
	  <input type="hidden" name="updateddate" value="<%= rows8.get(14)%>">
	  
<div class="search2">
    
<button type="submit" onclick="form.action='errorWork.jsp';">Save To PDF</button>
<button type="submit" onclick="form.action='errorWork.jsp';">Mail As PDF</button>
</form>

</div>

</div>
</center>
</body>
</html>