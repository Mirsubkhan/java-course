import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static List<User> users = new ArrayList<>();
    private static int nextId = 1;

    public static synchronized boolean addUser(String login, String email, String password) {
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login) || user.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        User newUser = new User();
        newUser.setId(nextId++);
        newUser.setLogin(login);
        newUser.setEmail(email);
        newUser.setPassword(password);
        users.add(newUser);
        return true;
    }

    public static synchronized boolean removeUser(String loginOrEmail) {
        return users.removeIf(user -> 
            user.getLogin().equalsIgnoreCase(loginOrEmail) || 
            user.getEmail().equalsIgnoreCase(loginOrEmail)
        );
    }

    public static synchronized boolean updateUser(String login, String newLogin, String newEmail) {
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                if (newLogin != null && !newLogin.isEmpty()) {
                    for (User u : users) {
                        if (u.getLogin().equalsIgnoreCase(newLogin)) {
                            return false; 
                        }
                    }
                    user.setLogin(newLogin);
                }
                if (newEmail != null && !newEmail.isEmpty()) {
                    for (User u : users) {
                        if (u.getEmail().equalsIgnoreCase(newEmail)) {
                            return false;
                        }
                    }
                    user.setEmail(newEmail);
                }
                return true;
            }
        }
        return false;
    }

    public static synchronized User findUser(String login) {
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                return user;
            }
        }
        return null; 
    }

    public static synchronized List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
