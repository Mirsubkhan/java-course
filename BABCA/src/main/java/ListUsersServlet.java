

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ListUsersServlet")
public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListUsersServlet() {
		super();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        try {
			List<User> users = UserDB.getAllUsers();
	    	// Lesson 39 (task 1) and Lesson 40 (task 1)

			// READ 👇👇👇
			// I decided to show the amount of users without the servlet "CountUsersServlet.java" and without the query "SELECT COUNT(*) FROM Users"
			// I think, it's great to have another solution :) 
			response.getWriter().append("Amount of users: " + users.size());
	        
	        for(User u : users) {
	        	response.getWriter().append("ID: " + u.getId() + " Login: " + u.getLogin() + " Email: " + u.getEmail());
	        }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

    }
}
