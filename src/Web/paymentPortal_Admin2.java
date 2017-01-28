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
public class paymentPortal_Admin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id5");
		  id = id.replace(" ", "").replace("\n", "").replace("\r", "");
		  int k = Integer.parseInt(id);//number = Integer.parseInt(id); 
		  
		  //System.out.println(k+"worked");
		  String validity2 = request.getParameter("renew");

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
				 
				// System.out.println(validity);
	
	
	
				 
				 
				 
				 
				 
				 

				 Class.forName("oracle.jdbc.OracleDriver")	;
					String url="jdbc:oracle:thin:@localhost:1521/xe";
					Connection con=DriverManager.getConnection(url,"karthik","karthik12");
					PreparedStatement ps = con.prepareStatement("Insert into policy(validity) values(?) where id=?");
					ps.setInt(2, k);	
					ps.setString(1, validity);
				    ps.executeUpdate();
				    
				    /*
			
				int studentId = 0;

			
				if (ps.executeUpdate() > 0) {

					
						
						System.out.println(studentId);
					}

				
				  	*/
					
				con.commit();
				con.close();
					    
				    
					   response.sendRedirect("search.jsp?msg=policy2");
					   
					   
					    
					} 
			  catch (Exception e) {
						
						
						response.sendRedirect("search.jsp?msg=fail2");
						   
						
						
						e.printStackTrace();
					}
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
	
	
	}

}
