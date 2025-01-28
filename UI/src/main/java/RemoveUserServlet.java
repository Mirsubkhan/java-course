

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeUser")
public class RemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginOrEmail = request.getParameter("loginOrEmail");

        if (UserStorage.removeUser(loginOrEmail)) {
            request.setAttribute("message", "User successfully removed!");
        } else {
            request.setAttribute("message", "User not found!");
        }

        request.getRequestDispatcher("remove.jsp").forward(request, response);
	}

}
