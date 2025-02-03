import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NameServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); 
        
        if (name == null || name.isBlank()) {
            name = "Guest";
        }
        
        request.setAttribute("name", name); 
        request.getRequestDispatcher("Greeting.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        if (name == null || name.isBlank()) { 
            name = "Guest"; 
        }

        request.setAttribute("name", name);
        request.getRequestDispatcher("Greeting2.jsp").forward(request, response);
    }

}
