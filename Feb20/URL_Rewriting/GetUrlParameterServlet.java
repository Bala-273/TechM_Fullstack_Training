package feb20_SessionManagement;



import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetUrlParameterServlet")
public class GetUrlParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve parameters from the URL
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");

        out.println("<html><body>");
        out.println("<h2>Retrieved Parameters via URL Rewriting</h2>");
        out.println("<p>Username: " + userName + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("</body></html>");

        out.close();
    }
}
