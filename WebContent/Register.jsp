<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" >
<%
String msg = request.getParameter("msg");

if(msg == null){
	
	msg = " ";
	
	
}
else if(msg.equals("fail")){
	msg = "Unable to update details contact your admin";
	
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

   <p class="message"><% out.println(msg); %></p> <br>
    <form action="Register" method="post">
    <h3>
    FirstName </h3> <input type="text" name="fname" placeholder="Enter First Name"> </input> 
   <h3> MiddleName </h3>  <input type="text" name="mname" placeholder="Enter Middle Name"> </input> 
     <h3>LastName </h3> <input type="text" name="lname" placeholder="Enter Last Name">  </input> 
    <br><br><br><br>
    
    <h3>SelectGender: </h3> <select name="gender" >
    <option selected="selected">SelectGender</option>
    <option value="male">Male</option>
   <option value="female">Female</option>
   <option value="other">Other</option>
    </select>
   

<!-- date of bith drop down -->


  <h3>DOB:</h3> <select name="dobmonth">
	<option> - Month - </option>
	<option value="01">January</option>
	<option value="02">Febuary</option>
	<option value="03">March</option>
	<option value="04">April</option>
	<option value="05">May</option>
	<option value="06">June</option>
	<option value="07">July</option>
	<option value="08">August</option>
	<option value="09">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select>

<select name="dobday">
	<option> - Day - </option>
	<option value="01">1</option>
	<option value="02">2</option>
	<option value="03">3</option>
	<option value="04">4</option>
	<option value="05">5</option>
	<option value="06">6</option>
	<option value="07">7</option>
	<option value="08">8</option>
	<option value="09">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
	<option value="21">21</option>
	<option value="22">22</option>
	<option value="23">23</option>
	<option value="24">24</option>
	<option value="25">25</option>
	<option value="26">26</option>
	<option value="27">27</option>
	<option value="28">28</option>
	<option value="29">29</option>
	<option value="30">30</option>
	<option value="31">31</option>
</select>

<select name="dobyear">
	<option> - Year - </option>
	<option value="2017">2017</option>
	<option value="2016">2016</option>
	<option value="2015">2015</option>
	<option value="2014">2014</option>
	<option value="2013">2013</option>
	<option value="2012">2012</option>
	<option value="2011">2011</option>
	<option value="2010">2010</option>
	<option value="2009">2009</option>
	<option value="2008">2008</option>
	<option value="2007">2007</option>
	<option value="2006">2006</option>
	<option value="2005">2005</option>
	<option value="2004">2004</option>
	<option value="2003">2003</option>
	<option value="2002">2002</option>
	<option value="2001">2001</option>
	<option value="2000">2000</option>
	<option value="1999">1999</option>
	<option value="1998">1998</option>
	<option value="1997">1997</option>
	<option value="1996">1996</option>
	<option value="1995">1995</option>
	<option value="1994">1994</option>
	<option value="1993">1993</option>
	<option value="1992">1992</option>
	<option value="1991">1991</option>
	<option value="1990">1990</option>
	<option value="1989">1989</option>
	<option value="1988">1988</option>
	<option value="1987">1987</option>
	<option value="1986">1986</option>
	<option value="1985">1985</option>
	<option value="1984">1984</option>
	<option value="1983">1983</option>
	<option value="1982">1982</option>
	<option value="1981">1981</option>
	<option value="1980">1980</option>
	<option value="1979">1979</option>
	<option value="1978">1978</option>
	<option value="1977">1977</option>
	<option value="1976">1976</option>
	<option value="1975">1975</option>
	<option value="1974">1974</option>
	<option value="1973">1973</option>
	<option value="1972">1972</option>
	<option value="1971">1971</option>
	<option value="1970">1970</option>
	<option value="1969">1969</option>
	<option value="1968">1968</option>
	<option value="1967">1967</option>
	<option value="1966">1966</option>
	<option value="1965">1965</option>
	<option value="1964">1964</option>
	<option value="1963">1963</option>
	<option value="1962">1962</option>
	<option value="1961">1961</option>
	<option value="1960">1960</option>
	<option value="1959">1959</option>
	<option value="1958">1958</option>
	<option value="1957">1957</option>
	<option value="1956">1956</option>
	<option value="1955">1955</option>
	<option value="1954">1954</option>
	<option value="1953">1953</option>
	<option value="1952">1952</option>
	<option value="1951">1951</option>
	<option value="1950">1950</option>
	<option value="1949">1949</option>
	<option value="1948">1948</option>
	<option value="1947">1947</option>
	
</select>

<br><br><br><br>
     
    
   <h3> Email </h3> <input type="text" name="email" placeholder="Enter Email"></input> 
    <h3> Phone </h3><input type="text" name="phone" placeholder="Enter Phone">  </input> 
   <h3> Country</h3> <input type="text" name="country" placeholder="Enter Country"> </input> 
    <br><br><br><br>
    <h3>Address</h3> <textarea rows="5" cols="30" name="address" placeholder="Enter Address">
</textarea>
 <h3>PinCode </h3><input type="text" name="pcode" placeholder="Enter Pincode"> </input> </h3>
     <br>
      <button  type="submit">Submit</button>
     </form>
  















</div>













 </center>

</body>
</html>