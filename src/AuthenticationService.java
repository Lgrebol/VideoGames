import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, User> users = new HashMap<>();

    public boolean registerUser(String nickname, String password) {
        if (users.containsKey(nickname)) {
            return false;
        } else {
            users.put(nickname, new User(nickname, password));
            return true;
        }
    }

    public boolean login(String nickname, String password) {
        User user = users.get(nickname);
        return user != null && user.getPassword().equals(password);
    }
}
