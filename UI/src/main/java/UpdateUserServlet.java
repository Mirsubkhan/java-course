

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
        String newLogin = request.getParameter("newLogin");
        String newEmail = request.getParameter("newEmail");

        if (UserStorage.updateUser(login, newLogin, newEmail)) {
            request.setAttribute("message", "User successfully updated!");
        } else {
            request.setAttribute("message", "User not found!");
        }

        request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
