import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String nickname, String password) {
        users.put(nickname, new User(nickname, password));
    }

    public boolean login(String nickname, String password) {
        User user = users.get(nickname);
        return user != null && user.getPassword().equals(password);
    }
}
