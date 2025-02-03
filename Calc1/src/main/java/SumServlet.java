

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CalculatorServlet")
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
	    int num2 = Integer.parseInt(request.getParameter("num2"));
		String res = "The sum of " + num1 + " and " + num2 + " is " + (num1 + num2);
		
		request.setAttribute("res", res);
		request.getRequestDispatcher("calc.jsp").forward(request, response);;
	}

}
