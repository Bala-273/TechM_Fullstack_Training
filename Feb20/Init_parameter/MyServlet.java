package feb20;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/config",
    initParams = {
        @WebInitParam(name = "address", value = "Chennai"),
        @WebInitParam(name = "email", value = "abcd@gmail.com"),
        @WebInitParam(name = "phone", value = "9384564715")
    }
)
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String address;
    private String email;
    private String phone;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        address = config.getInitParameter("address");
        email = config.getInitParameter("email");
        phone = config.getInitParameter("phone");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>ServletConfig Example</h1>");
        out.println("<p>Address: " + address + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("</body></html>");
        out.close();
    }
}
