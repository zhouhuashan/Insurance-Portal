package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class paymentPortal_Admin
 */
public class paymentPortal_Admin extends HttpServlet {
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
		    String validity2 = request.getParameter("renew_validity");
		    String validity4 = request.getParameter("validity");
		    String createddate = request.getParameter("createddate");
		    String updateddate = request.getParameter("updateddate");
		    String price = request.getParameter("price");
		    //System.out.println(k+policy+validity2+createddate+updateddate);
	
		    Calendar now = Calendar.getInstance();
		    int validity3 = Integer.parseInt(validity2);
			 now.add(Calendar.MONTH,validity3);
			 int k1 = now.get(Calendar.MONTH);
			 k1++;
				 String validity = (now.get(Calendar.DATE )
		                 + "-"
		                 +k1
		                 + "-"
		                 +  now.get(Calendar.YEAR)); 
		    
				 //System.out.println(validity);
				 
				//  /*
		    try {
		    	
				  
				 
			      
		    	 
				
				
				 Class.forName("oracle.jdbc.OracleDriver")	;
					String url="jdbc:oracle:thin:@localhost:1521/xe";
					Connection con=DriverManager.getConnection(url,"karthik","karthik12");
					PreparedStatement ps = con.prepareStatement("Update policy set validity=? where id=? and policy=? and createddate=? and updatedate=?");
					ps.setString(1, validity);
					ps.setInt(2, k);	
					ps.setString(3, policy);
					ps.setString(4, createddate);
					ps.setString(5, updateddate);
				   
				    
				    ps.executeUpdate();
				    
				 
					
				con.commit();
				con.close();
					    
				   request.setAttribute("price", price);
					  
					  RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/paymentportal.jsp");
					  requestDispatcher.forward(request,response);
					 
					    
					} 
			  catch (Exception e) {
						
						
						response.sendRedirect("search.jsp?msg=fail3");
						   
						
						
						e.printStackTrace();
					}
	
	//*/
	}

}
