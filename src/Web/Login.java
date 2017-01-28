package Web;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
    //int count1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4655486875726167149L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.setContentType("text/html");
	    
		 HttpSession auth = request.getSession();
	        String id2=(String)auth.getAttribute("id");  
	        int id = Integer.parseInt(id2);  // cast to int
	         
	  
	     
	     
	    String username = request.getParameter("user");
	    String password = request.getParameter("pass");
	    String role = request.getParameter("role");
	    
	    
	   
	    
  try {
	    	
	  Class.forName("oracle.jdbc.OracleDriver")	;
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		Connection con=DriverManager.getConnection(url,"karthik","karthik12");
		    
		    PreparedStatement ps = con.prepareStatement("Insert into login values(?,?,?,?)");
		    ps.setString(1, username);
		    ps.setString(2, password);
		    ps.setString(3, role);
		    ps.setInt(4, id);
		    
		   ps.executeUpdate();
		
		    con.commit();
		    con.close();
		    
		    auth.setAttribute("id","NULL"); 
        	auth.setAttribute("auth","NULL"); 
		    
		    
		   response.sendRedirect("Register.jsp?msg=succes");
		   
		   
		    
		} 
  catch (Exception e) {
			
			
			response.sendRedirect("Register.jsp?msg=fail");
			   
			
			
			e.printStackTrace();
		}
	
 
	    
	    
		
	}

}
