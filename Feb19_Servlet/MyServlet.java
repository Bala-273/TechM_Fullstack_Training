package feb19;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet") // ✅ Registers servlet at /MyServlet
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET requests
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Get parameters from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Print parameters in console (for debugging)
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);

		// Set response content type
		response.setContentType("text/html");      
		
		// Get PrintWriter object
		PrintWriter writer = response.getWriter();    

		// Write HTML response
		writer.println("<html><body>");
		writer.println("<h2>Html file from Servlet!</h2>");
		writer.println("<h2>Your username is: " + username + "<br/>");
		writer.println("Your password is: " + password + "</h2>");
		writer.println("</body></html>");
		
		// Close the writer
		writer.close();
	}
}
