import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("testNickname");
    }

    @Test
    public void testConstructorAssignsIdAndNickname() {
        assertNotNull(user.getNickname());
        assertEquals("testNickname", user.getNickname());
        assertEquals(User.getLastId(), user.getId());
    }

    @Test
    public void testSetNickname() {
        user.setNickname("newNickname");
        assertEquals("newNickname", user.getNickname());
    }

    @Test
    public void testSetName() {
        user.setName("John");
        assertEquals("John", user.getName());
    }

    @Test
    public void testSetLastName() {
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetBirthDate() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        user.setBirthDate(birthDate);
        assertEquals(birthDate, user.getBirthDate());
    }

    @Test
    public void testStaticIdIncrement() {
        User user2 = new User("anotherNickname");
        assertEquals(user.getId() + 1, user2.getId());
        assertEquals(User.getLastId(), user2.getId());
    }
}
