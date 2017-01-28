package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class viewPolicy_Client
 */
public class viewPolicy_Client extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		response.setContentType("text/html");
		// System.out.println("hi");
		
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		//String id = request.getParameter("id");
		// System.out.println(id+"worked");
		 
	
		  id = id.replace(" ", "").replace("\n", "").replace("\r", "");
		   
		
		   
		  int k = Integer.parseInt(id);//number = Integer.parseInt(id); 
		  
		  //System.out.println(k+"worked");
		  
		  

			
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
	         
	         
	         
	         Calendar now = Calendar.getInstance();
			 now.add(Calendar.MONTH,4);
			 int k1 = now.get(Calendar.MONTH);
			 k1++;
				 String date3 = (now.get(Calendar.DATE )
		                 + "-"
		                 +k1
		                 + "-"
		                 +  now.get(Calendar.YEAR)); 
				 
				 //System.out.println(date3);
				 
				 int count = 0;
	         
	         
	           while (rs.next()){
	               
	               
                 row4.add(rs.getString(2));
                 row5.add(rs.getString(3));
                 row6.add(rs.getString(14));
                row7.add(rs.getString(15));
                String test = rs.getString(3);
                
               // System.out.println(test);
                
    				 
 			    if (date3.compareTo(test) > 0) {
 		           // System.out.println("Date1 is after Date2");
 			    	count++;
 		        } else if (date3.compareTo(test) < 0) {
 		          // System.out.println("Date1 is before Date2");
 		        	
 		        } else if (date3.compareTo(test) == 0) {
 		           // System.out.println("Date1 is equal to Date2");
 		        }

 			  // System.out.println(count);  
        }
	           
	         
	        // System.out.println(count);    
	           String count3 = Integer.toString(count);
	           HttpSession auth = request.getSession();
	         	
	        	auth.setAttribute("count",count3); 

	              
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           
	           

   request.setAttribute("propertyList4", row4);
   request.setAttribute("id", id);
   request.setAttribute("propertyList5", row5);
   request.setAttribute("propertyList6", row6);
   request.setAttribute("propertyList7", row7);
    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/viewPolicy_Client.jsp");
    requestDispatcher.forward(request,response);


	           con.close();
	           
	       }
	catch(Exception e){ 
		
		 out.println("<font color='red'><b>Error connecting to database. Try Again</b></font>");
	           e.printStackTrace();

	}
		
		   
//	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
