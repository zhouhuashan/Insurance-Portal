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
 * Servlet implementation class viewPolicy_Admin3
 */
public class viewPolicy_Admin3 extends HttpServlet {
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
		  int k = Integer.parseInt(id);//number = Integer.parseInt(id);
	  //   /*
		    String policy = request.getParameter("policy");
		    String validity = request.getParameter("validity");
		    String createddate = request.getParameter("createddate");
		    String updateddate = request.getParameter("updateddate");
		    
		   // System.out.println(k+policy+validity+createddate+updateddate);
	
	
		    try{
		           Class.forName("oracle.jdbc.OracleDriver");
		           String url = "jdbc:oracle:thin:@10.113.17.65:1521/xe";
		           Connection con = DriverManager.getConnection(url,"karthik","karthik12");
		           
		           String sql = "select * from policy where id=? and policy=? and validity=? and createddate=? and updatedate=?";
		           PreparedStatement ps = con.prepareStatement(sql);
		           ps.setInt(1, k);
		           ps.setString(2, policy);
		           ps.setString(3, validity);
		           ps.setString(4, createddate);
		           ps.setString(5, updateddate);
		           
		         ResultSet rs = ps.executeQuery();
		         ArrayList row8 = new ArrayList();
		    
		           while (rs.next()){
		               
		        	   for (int i = 1; i <= 15 ; i++){
	                 row8.add(rs.getString(i));
	                 
		              }
	         

	          
	        }

	   request.setAttribute("propertyList8", row8);
	  
	  RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/viewPolicy_Admin3.jsp");
	  requestDispatcher.forward(request,response);


		           con.close();
		          // System.out.println("ok");
		       }
		catch(Exception e){ 
			
			 out.println("<font color='red'><b>Error connecting to database. Try Again</b></font>");
		           e.printStackTrace();

		}
			
			
	
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
	
	}

}
