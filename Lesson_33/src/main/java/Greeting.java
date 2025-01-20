

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/Greeting")
public class Greeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Greeting() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", java.util.Locale.ENGLISH);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedDate = "Today is " + now.format(dateFormatter);
        String formattedTime = "Time is: " + now.format(timeFormatter);
		
		request.setAttribute("name", name.isBlank()? "guest": name);
		request.setAttribute("time", formattedDate + " | " + formattedTime);
		request.getRequestDispatcher("Greeting.jsp").forward(request, response);
	}

}
