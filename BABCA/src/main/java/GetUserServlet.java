

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Lesson 39 (task 2) and Lesson 40 (task 2)
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        
        if ((login != null && !login.isEmpty()) || (email != null && !email.isEmpty())) {
        	try {
    			User u = UserDB.searchUser(login, email);
    			
    			if (u != null) {
        	        response.getWriter().append("ID: " + u.getId() + " Login: " + u.getLogin() + " Email: " + u.getEmail());
    			}
    			else {
    				response.getWriter().append("User not found");
    			}
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
        }
        else {
			response.getWriter().append("Input login or email in the url!");
        }
    }
}
