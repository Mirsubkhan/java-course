

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
        User user = UserStorage.findUser(login);

        if (user != null) {
            request.setAttribute("message", "User found: " + user.getLogin() + " (" + user.getEmail() + ")");
        } else {
            request.setAttribute("message", "User not found!");
        }

        request.getRequestDispatcher("find.jsp").forward(request, response);
	}

}
