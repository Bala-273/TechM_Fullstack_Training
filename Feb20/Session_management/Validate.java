package feb20_SessionManagement;



import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Validate")
public class Validate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("user");
        String pass = request.getParameter("pass");

        if (pass.equals("1234")) {
            // Creating a session
            HttpSession session = request.getSession();
            session.setAttribute("user", name);

            // Redirecting to Welcome servlet
            response.sendRedirect("Welcome");
        } else {
            response.getWriter().println("<h3>Invalid Password! Try Again.</h3>");
        }
    }

    // ✅ Add doGet() to prevent 405 errors
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("f1.html");  // Redirect user to login form
    }
}
