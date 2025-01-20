

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Math")
public class Max_Min_Avg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Max_Min_Avg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res = null;
		
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			int num3 = Integer.parseInt(request.getParameter("num3"));
			int rb = Integer.parseInt(request.getParameter("command"));
			
			if (rb == 0) {
				res = "Average -> " + (num + num2 + num3) / 3;
			}
			else if (rb == 1) {
				res = "Max -> " + Math.max(num, Math.max(num2, num3));
			}
			else {
				res = "Min -> " + Math.min(num, Math.min(num2, num3));
			}
		}
		catch (Exception e){
			res = "Error -> Choose some method or input all numbers!";
		}
		finally {
			request.setAttribute("res", res);
			request.getRequestDispatcher("MaxMinAvg.jsp").forward(request, response);
		}
	}

}
