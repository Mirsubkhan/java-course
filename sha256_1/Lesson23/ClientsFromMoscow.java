package Lesson23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClientsFromMoscow {

	public static void main(String[] args) {
		List<String> clients = Arrays.asList(
	            "Наташа-Moscow", "Анна-Екатеринбург", "Иван-Moscow", 
	            "Олег-Казань", "Елена-Moscow", "Максим-Moscow", 
	            "Мария-Самара", "Дмитрий-Moscow", "Виктория-Красноярск", 
	            "Алексей-Челябинск", "Алина-Moscow", "Артём-Пермь", 
	            "Светлана-Moscow", "Роман-Ростов-на-Дону", 
	            "Полина-Омск", "Михаил-Хабаровск", "Екатерина-Саратов", 
	            "Андрей-Калининград"
	   );
		
		List<String> moscowClients = clients.stream().
				filter(client -> client.toLowerCase()
				.contains("moscow")).sorted()
				.collect(Collectors.toList());
		
		System.out.println("Moscow clients: " + moscowClients);
	}

}
