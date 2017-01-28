package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Policy
 */
public class Policy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	

		
		 response.setContentType("text/html");
		    
		 String id = request.getParameter("id");
		   id = id.replace(" ", "").replace("\n", "").replace("\r", "");
		  int k = Integer.parseInt(id);//number = Integer.parseInt(id);
	  //   /*
		    String policy = request.getParameter("policy");
		    String validity2 = request.getParameter("validity");
		    String fname = request.getParameter("fname");
		    String mname = request.getParameter("mname");
		    String lname = request.getParameter("lname");
		    String gender = request.getParameter("gender");
		    String dob = request.getParameter("dob");
		    //String dobmonth = request.getParameter("dobmonth");
		 //   String dobday = request.getParameter("dobday");
		   // String dobyear = request.getParameter("dobyear");
		    String email = request.getParameter("email");
		    String phone = request.getParameter("phone");
		    String country = request.getParameter("country");
		    String address = request.getParameter("address");
		    String pcode = request.getParameter("pcode");
		  //  String dob = dobday+"-"+dobmonth+"-"+dobyear;
		  
		    
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		    Date date = new Date();
		    
		    String reportDate = dateFormat.format(date);
		    

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
		    
		   // System.out.println(reportDate);
		    
	  try {
		    	
		  
		 
	      
		
		 Class.forName("oracle.jdbc.OracleDriver")	;
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			Connection con=DriverManager.getConnection(url,"karthik","karthik12");
			PreparedStatement ps = con.prepareStatement("Insert into policy values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, k);	
			ps.setString(2, policy);
			ps.setString(3, validity);
			ps.setString(4, fname);
		    ps.setString(5, mname);
		    ps.setString(6, lname);
		    ps.setString(7, gender);
		    ps.setString(8, dob);
		    ps.setString(9, email);
		    ps.setString(10, phone);
		    ps.setString(11, country);
		    ps.setString(12, address);
		    ps.setString(13, pcode); 
		    ps.setString(14, reportDate);
		    ps.setString(15, reportDate);
		    ps.executeUpdate();
		    
		    /*
	
		int studentId = 0;

	
		if (ps.executeUpdate() > 0) {

			
				
				System.out.println(studentId);
			}

		
		  	*/
			
		con.commit();
		con.close();
			    
		    
			   response.sendRedirect("search.jsp?msg=policy");
			   
			   
			    
			} 
	  catch (Exception e) {
				
				
				response.sendRedirect("search.jsp?msg=fail2");
				   
				
				
				e.printStackTrace();
			}
		
	 
		
		//*/
		
		
		
		
		//response.sendRedirect("index.jsp?msg=succes");
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
