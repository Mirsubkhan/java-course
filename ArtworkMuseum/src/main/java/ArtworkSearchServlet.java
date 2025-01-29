

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/searchArtworks")
public class ArtworkSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String yearStr = request.getParameter("year");
        String category = request.getParameter("category");
        String place = request.getParameter("place");

        Integer year = null;
        if (yearStr != null && !yearStr.isEmpty()) {
            try {
                year = Integer.parseInt(yearStr);
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Invalid year format!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        }

        try {
            List<Artwork> artworks = ArtworkDatabase.searchArtworks(title, author, year, category, place);

            if (artworks.isEmpty()) {
                request.setAttribute("message", "No artworks found!");
            } else {
                request.setAttribute("artworks", artworks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Database error occurred!");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
