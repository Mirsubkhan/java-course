

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/visitCounter")
public class Counter8 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String COOKIE_NAME = "visitCount";
       
    public Counter8() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        Cookie[] cookies = request.getCookies();
        int visitCount = 0;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_NAME.equals(cookie.getName())) {
                    try {
                        visitCount = Integer.parseInt(cookie.getValue());
                    } catch (NumberFormatException e) {
                        visitCount = 0;
                    }
                    break;
                }
            }
        }
        
        visitCount++;

        Cookie visitCookie = new Cookie(COOKIE_NAME, String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(visitCookie);
        
        request.setAttribute("visitCount", visitCount);
        request.getRequestDispatcher("/visitCounter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie visitCookie = new Cookie(COOKIE_NAME, "0");
        visitCookie.setMaxAge(0);
        response.addCookie(visitCookie);
        
        response.sendRedirect("visitCounter");
    }
}
