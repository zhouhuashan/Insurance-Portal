package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewPolicy_Admin
 */
public class viewPolicy_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 String id = request.getParameter("id");
		  id = id.replace(" ", "").replace("\n", "").replace("\r", "");
		   
		
		   // String button = request.getParameter("button");
		    
		  //System.out.print(id+ button);
		  int k = Integer.parseInt(id);//number = Integer.parseInt(id); 
		   //System.out.println(k);
		  
		  
		  

			
	       try{
	           Class.forName("oracle.jdbc.OracleDriver");
	           String url = "jdbc:oracle:thin:@10.113.17.65:1521/xe";
	           Connection con = DriverManager.getConnection(url,"karthik","karthik12");
	           
	           String sql = "select * from policy where id=?";
	           PreparedStatement ps = con.prepareStatement(sql);
	           ps.setInt(1, k);
	           
	           ResultSet rs = ps.executeQuery();
	         
	           ArrayList row4 = new ArrayList();
	           
	         ArrayList row5 = new ArrayList();
	         ArrayList row6 = new ArrayList();
	         ArrayList row7 = new ArrayList();
	           while (rs.next()){
	               
	               
                 row4.add(rs.getString(2));
                 row5.add(rs.getString(3));
                 row6.add(rs.getString(14));
                 row7.add(rs.getString(15));
             
         

          
        }

   request.setAttribute("propertyList4", row4);
   request.setAttribute("id", id);
   request.setAttribute("propertyList5", row5);
   request.setAttribute("propertyList6", row6);
   request.setAttribute("propertyList7", row7);
    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/viewPolicy_Admin.jsp");
    requestDispatcher.forward(request,response);


	           con.close();
	           
	       }
	catch(Exception e){ 
		
		 out.println("<font color='red'><b>Error connecting to database. Try Again</b></font>");
	           e.printStackTrace();

	}
		
		    
	
	
	
	
	
	
	
	
	
	
	
	}

}
