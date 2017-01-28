package Web;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
		Calendar now = Calendar.getInstance();
		int k3=18;
		 now.add(Calendar.MONTH,k3);
		 int k1 = now.get(Calendar.MONTH);
		 k1++;
			 String k = (now.get(Calendar.DATE )
	                 + "-"
	                 +k1
	                 + "-"
	                 +  now.get(Calendar.YEAR)); 
			 System.out.println("Current date : " + k); 
	
		 
	
	
	
	
	
	
	
	
	
	}

}
