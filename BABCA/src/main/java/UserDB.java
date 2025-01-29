import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "SYS AS SYSDBA"; 
    private static final String DB_PASSWORD = "man8ix"; 

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    public static List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, login, email FROM TUsers";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");

                User user = new User(id, login, email);
                users.add(user);
            }
        }
        return users;
    }
    
    public static User searchUser(String login, String email) throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        
        StringBuilder query = new StringBuilder("SELECT id, login, email FROM TUsers WHERE 1=1");
        
        if (login != null && !login.isEmpty()) {
            query.append(" AND login LIKE ?");
        }
        if (email != null && !email.isEmpty()) {
            query.append(" AND email LIKE ?");
        }
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query.toString())) {

            int index = 1;
            
            if (login != null && !login.isEmpty()) {
                statement.setString(index++, "%" + login + "%");
            }
            if (email != null && !email.isEmpty()) {
                statement.setString(index++, "%" + email + "%");
            }
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String loginstr = resultSet.getString("login");
                    String emailstr = resultSet.getString("email");

                    User user = new User(id, loginstr, emailstr);
                    users.add(user);
                }
            }
        }

        return users.size() >= 1? users.get(0): null;
    }
}

