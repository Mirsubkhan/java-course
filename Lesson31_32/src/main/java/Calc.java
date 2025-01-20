

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("regularEx").replaceAll(" ", "");

	    try {
	        String regex = "(\\d+)([+\\-*/])(\\d+)";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(text);

	        if (matcher.matches()) {
	            int v1 = Integer.parseInt(matcher.group(1));
	            String op = matcher.group(2);
	            int v2 = Integer.parseInt(matcher.group(3));

	            int res = switch (op) {
	                case "+" -> v1 + v2;
	                case "-" -> v1 - v2;
	                case "/" -> v1 / v2;
	                case "*" -> v1 * v2;
	                default -> throw new IllegalArgumentException("Unexpected operator: " + op);
	            };

	            request.setAttribute("res", res);
	        } else {
	            throw new IllegalArgumentException("Invalid input format. Example: 3+2");
	        }
	    } catch (Exception e) {
	        request.setAttribute("res", "Error: " + e.getMessage());
	    }

	    request.getRequestDispatcher("Calculator.jsp").forward(request, response);
	}

}
