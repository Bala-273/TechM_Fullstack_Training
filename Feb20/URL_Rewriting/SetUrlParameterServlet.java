package feb20_SessionManagement;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SetUrlParameterServlet")
public class SetUrlParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get parameters from request object.
        String userName = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();

        // Check for null and empty values.
        if (userName == null || userName.equals("") || password == null || password.equals("")) {
            out.print("Please enter both username and password. <br><br>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
            requestDispatcher.include(request, response);
        } 
        // Check for valid username and password.
        else if (userName.equals("Bala") && password.equals("123")) {
            out.println("Logged in successfully.<br>");
            out.println("Click the link below to see stored values:<br>");
            
            // **URL Rewriting: Redirect with parameters**
            out.println("<a href='GetUrlParameterServlet?user=" + userName + "&pass=" + password + "'>View Details</a>");
        } 
        else {
            out.print("Invalid username or password! <br><br>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
            requestDispatcher.include(request, response);
        }
        out.close();
    }
}
