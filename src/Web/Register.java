package Web;

import java.util.Date;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		
		
		
		 response.setContentType("text/html");
		    
	     
	  //   /*
	     
		    String fname = request.getParameter("fname");
		    String mname = request.getParameter("mname");
		    String lname = request.getParameter("lname");
		    String gender = request.getParameter("gender");
		    String dobmonth = request.getParameter("dobmonth");
		    String dobday = request.getParameter("dobday");
		    String dobyear = request.getParameter("dobyear");
		    String email = request.getParameter("email");
		    String phone = request.getParameter("phone");
		    String country = request.getParameter("country");
		    String address = request.getParameter("address");
		    String pcode = request.getParameter("pcode");
		    String dob = dobday+"-"+dobmonth+"-"+dobyear;
		  
		    
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		    Date date = new Date();
		    
		    String reportDate = dateFormat.format(date);
		  //  System.out.println(reportDate);
		    
	  try {
		    	
		  
		 
	      
	    

			 String QUERY = "INSERT INTO register "+
		             "  VALUES (user_id.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?"+
		             "        )";

		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "karthik", "karthik12");

		
		PreparedStatement ps = connection.prepareStatement(QUERY,
				new String[] { "id" });
		 ps.setString(1, fname);
		    ps.setString(2, mname);
		    ps.setString(3, lname);
		    ps.setString(4, gender);
		    ps.setString(5, dob);
		    ps.setString(6, email);
		    ps.setString(7, phone);
		    ps.setString(8, country);
		    ps.setString(9, address);
		    ps.setString(10, pcode); 
		    ps.setString(11, reportDate);
		    
		    
		    
	
		int studentId = 0;

	
		if (ps.executeUpdate() > 0) {

			
			ResultSet generatedKeys = ps.getGeneratedKeys();

			if (null != generatedKeys && generatedKeys.next()) {

			
				studentId = generatedKeys.getInt(1);
				String id = Integer.toString(studentId);
				
				 HttpSession auth = request.getSession();
			      	
			     	auth.setAttribute("auth","yes"); 
			     	auth.setAttribute("id", id); 
						    
						
				
				//System.out.println(studentId);
			}

		}
			
		  
		  
		  
		  
		  
			
			
		connection.commit();
		connection.close();
			    
		    
			   response.sendRedirect("index.jsp?msg=succes");
			   
			   
			    
			} 
	  catch (Exception e) {
				
				
				response.sendRedirect("Register.jsp?msg=fail");
				   
				
				
				e.printStackTrace();
			}
		
	 
		
		//*/
		
		
		
		
		//response.sendRedirect("index.jsp?msg=succes");
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
