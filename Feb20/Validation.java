package feb20;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginPage")  // Maps to the form action
public class Validation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();

        String name = request.getParameter("uname");
        String pass = request.getParameter("upass");

        if ("Bala".equals(name) && "123".equals(pass)) {
            request.getSession().setAttribute("username", name);  // Store in session
            response.sendRedirect("welcome");
        } else {
            pwriter.print("<h2 style='color:red;'>Username or password is incorrect!</h2>");
            RequestDispatcher dis = request.getRequestDispatcher("index.html");
            dis.include(request, response);
        }
        pwriter.close();
    }
}
