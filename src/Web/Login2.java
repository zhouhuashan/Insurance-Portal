package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import oracle.jdbc.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Login2
 */
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		
		
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
	     
	     
	    String username = request.getParameter("user");
	    String password = request.getParameter("pass");
	    //         get from db      String role = request.getParameter("role");
	    
	    

	    
	    
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@10.113.17.65:1521/xe";
            Connection con = DriverManager.getConnection(url,"karthik","karthik12");
            
            String sql = "select * from login where username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
         if(rs.next())
         {
        	 //cokie be careful so go for session
        	
        	String role = rs.getString(3);
        	int id = rs.getInt(4);
        	//System.out.println(id);
        	String id2 = Integer.toString(id);
        	//System.out.println(id2);
        	 HttpSession auth = request.getSession();
         	
        	auth.setAttribute("name",username); 
        	auth.setAttribute("role",role); 
        	auth.setAttribute("id",id2); 
        	 //auth.invalidate();


        	 //String name2=(String)auth.getAttribute("name");  
        	 //out.println(name2);
        	 
        	 //out.println("<font color='red'><b>Welcome User</b></font>"+username);
             //RequestDispatcher rd = request.getRequestDispatcher("secure.jsp");
             //rd.include(request, response); 
        	if(!role.equals("admin")){
        		//request.setAttribute("id", id2);
        		//response.sendRedirect("/viewPolicy_Client");
        		
        	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/viewPolicy_Client");
        	    requestDispatcher.forward(request,response);

        	}
        	else if(role.equals("admin")) {
             response.sendRedirect("secure.jsp");
        	}
                
        }
         
         else  {
        	 
        	 response.sendRedirect("login.jsp?msg=fail");
        	 	 
        	 
        	 
        	 /*
        	 
        	 out.println("<font color='red'><b>Login Failure</b></font>");
             RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
             rd.include(request, response);
        	*/ 
        	 
         }
            

            con.close();
            
        }
catch(Exception e){ 
	
	 out.println("<font color='red'><b>Error connecting to database. Try Again</b></font>");
            e.printStackTrace();

}
	
	
	
	
	
	
	
	}

}
