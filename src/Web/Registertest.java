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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registertest
 */
public class Registertest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		
		
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
	     
	     
	    String data = request.getParameter("data");
	   data = data + "%";
	   
	    //         get from db      String role = request.getParameter("role");
	    
	    

	    
	    
       try{
           Class.forName("oracle.jdbc.OracleDriver");
           String url = "jdbc:oracle:thin:@10.113.17.65:1521/xe";
           Connection con = DriverManager.getConnection(url,"karthik","karthik12");
           
           String sql = "select id,username from login where username like ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, data);
           
           ResultSet rs = ps.executeQuery();
         
           ArrayList row = new ArrayList();
           ArrayList row2 = new ArrayList();
           while (rs.next()){
           
          
                   row.add(rs.getString(1));
                   row2.add(rs.getString(2));
         

          
        }

    request.setAttribute("propertyList", row);
    request.setAttribute("propertyList2", row2);
    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/newpolicy_select.jsp");
    requestDispatcher.forward(request,response);

           
           /*
           ArrayList Rows = new ArrayList();
       	
        	while (rs.next()){
        	 ArrayList row = new ArrayList();
             for (int i = 1; i <= 7 ; i++){
                     row.add(rs.getString(i));
             }
             Rows.add(row);
        	
        	}
        	
        	
        	

 request.setAttribute("propertyList", Rows);
 RequestDispatcher rd = request.getRequestDispatcher("newpolicy_select.jsp");
 rd.forward(request, response);  

        	*/
        	
       	 //cokie be careful so go for session
       	
       	//String role = rs.getString(3);
       
       	
       	
       //System.out.println(rs.getString(1)+rs.getString(2) );
       	
       	
       	 //auth.invalidate();


       	 //String name2=(String)auth.getAttribute("name");  
       	 //out.println(name2);
       	 
       	 //out.println("<font color='red'><b>Welcome User</b></font>"+username);
            //RequestDispatcher rd = request.getRequestDispatcher("secure.jsp");
            //rd.include(request, response);  
         
       	
       	
       	//  response.sendRedirect("search.jsp");
       	 
       
        
           

           con.close();
           
       }
catch(Exception e){ 
	
	 out.println("<font color='red'><b>Error connecting to database. Try Again</b></font>");
           e.printStackTrace();

}
	
	
	
	 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
	}
	
	
	
}
