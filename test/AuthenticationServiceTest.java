import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthenticationServiceTest {
    private AuthenticationService authService;

    @BeforeEach
    public void setUp() {
        authService = new AuthenticationService();
        authService.registerUser("Joan", "password123");
    }

    @Test
    public void testSuccessfulLogin() {
        assertTrue(authService.login("Joan", "password123"));
    }

    @Test
    public void testFailedLoginWithWrongPassword() {
        assertFalse(authService.login("Joan", "wrongpassword"));
    }

    @Test
    public void testFailedLoginWithNonExistentUser() {
        assertFalse(authService.login("Josep", "password123"));
    }
}
    