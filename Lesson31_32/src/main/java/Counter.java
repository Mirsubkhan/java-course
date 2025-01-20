

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/Count")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> vowelsMap = new HashMap<>();
	private HashMap<String, Integer> marksMap = new HashMap<>();
	private HashMap<String, Integer> consonantsMap = new HashMap<>();
       
    public Counter() {
        super();
        vowelsMap.put("а", 0);
		vowelsMap.put("о", 0);
		vowelsMap.put("у", 0);
		vowelsMap.put("и", 0);
		vowelsMap.put("э", 0);
		vowelsMap.put("ы", 0);
		vowelsMap.put("я", 0);
		vowelsMap.put("ю", 0);
		vowelsMap.put("е", 0);
		vowelsMap.put("ё", 0);
		
		consonantsMap.put("б", 0);
		consonantsMap.put("в", 0);
		consonantsMap.put("г", 0);
		consonantsMap.put("д", 0);
		consonantsMap.put("ж", 0);
		consonantsMap.put("з", 0);
		consonantsMap.put("й", 0);
		consonantsMap.put("к", 0);
		consonantsMap.put("л", 0);
		consonantsMap.put("м", 0);
		consonantsMap.put("н", 0);
		consonantsMap.put("п", 0);
		consonantsMap.put("р", 0);
		consonantsMap.put("с", 0);
		consonantsMap.put("т", 0);
		consonantsMap.put("ф", 0);
		consonantsMap.put("х", 0);
		consonantsMap.put("ч", 0);
		consonantsMap.put("ц", 0);
		consonantsMap.put("ш", 0);
		consonantsMap.put("щ", 0);
		consonantsMap.put("ь", 0);
		consonantsMap.put("ъ", 0);
		
		marksMap.put(".", 0);
		marksMap.put(",", 0);
		marksMap.put("!", 0);
		marksMap.put("?", 0);
		marksMap.put(";", 0);
		marksMap.put(":", 0);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String text = request.getParameter("text").toLowerCase();
		
		for(char c : text.toCharArray()) {
			String key = "" + c;
			
			if (vowelsMap.containsKey(key)) {
				vowelsMap.put(String.valueOf(key), vowelsMap.get(key)+1);
			}
			
			else if (marksMap.containsKey(key)) {
				marksMap.put(String.valueOf(key), marksMap.get(key)+1);
			}
			
			else if (consonantsMap.containsKey(key)) {
				consonantsMap.put(String.valueOf(key), consonantsMap.get(key)+1);
			}
		}
		
		
		
		request.setAttribute("vowels", vowelsMap.values().stream().mapToInt(Integer::intValue).sum());
		request.setAttribute("marks", marksMap.values().stream().mapToInt(Integer::intValue).sum());
		request.setAttribute("consonants", consonantsMap.values().stream().mapToInt(Integer::intValue).sum());
		
		request.setAttribute("vowelsList", getFormattedSymbols(vowelsMap));
		request.setAttribute("marksList", getFormattedSymbols(marksMap));
		request.setAttribute("consonantsList", getFormattedSymbols(consonantsMap));
		
		request.getRequestDispatcher("Counter.jsp").forward(request, response);
	}
	
	private String getFormattedSymbols(HashMap<String, Integer> map) {
		String res = "- ";
		
		for(String s : map.keySet()) {
			if(map.get(s) > 0) {
				res += s + " - ";
			}
		}
		
		return res;
	}

}
