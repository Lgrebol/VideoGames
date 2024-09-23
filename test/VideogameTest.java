import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class VideogameTest {

    private Videogame videogame;
    private User user;

    @BeforeEach
    public void setUp() {
        videogame = new Videogame("The Legend of Zelda");
        user = new User("testUser");
    }

    @Test
    public void testConstructorAssignsName() {
        assertNotNull(videogame.getName());
        assertEquals("The Legend of Zelda", videogame.getName());
    }

    @Test
    public void testSetName() {
        videogame.setName("Super Mario");
        assertEquals("Super Mario", videogame.getName());
    }

    @Test
    public void testSetGenre() {
        videogame.setGenre("Action-Adventure");
        assertEquals("Action-Adventure", videogame.getGenre());
    }

    @Test
    public void testSetPlayersNumber() {
        videogame.setPlayersNumber(4);
        assertEquals(4, videogame.getPlayersNumber());
    }

    @Test
    public void testSetPrice() {
        videogame.setPrice(59.99f);
        assertEquals(59.99f, videogame.getPrice());
    }

    @Test
    public void testSetPlatforms() {
        videogame.setPlatforms("Nintendo Switch");
        assertEquals("Nintendo Switch", videogame.getPlatforms());
    }

    @Test
    public void testSetSetting() {
        videogame.setSetting("Fantasy");
        assertEquals("Fantasy", videogame.getSetting());
    }

    @Test
    public void testSetRecommendedAgePEGI() {
        videogame.setRecommendedAgePEGI("12");
        assertEquals("12", videogame.getRecommendedAgePEGI());
    }

    @Test
    public void testSetSpecificContentPEGI() {
        videogame.setSpecificContentPEGI("Violence");
        assertEquals("Violence", videogame.getSpecificContentPEGI());
    }

    @Test
    public void testSetRequirements() {
        videogame.setRequirements("Minimum: 8GB RAM, GTX 1050");
        assertEquals("Minimum: 8GB RAM, GTX 1050", videogame.getRequirements());
    }

    @Test
    public void testAddUsersWhoHaveConsulted() {
        videogame.addUsersWhoHaveConsulted(user);
        Set<User> users = videogame.getUsersWhoHaveConsulted();
        assertTrue(users.contains(user));
    }

    @Test
    public void testGetUsersWhoHaveConsulted() {
        videogame.addUsersWhoHaveConsulted(user);
        Set<User> users = videogame.getUsersWhoHaveConsulted();
        assertNotNull(users);
        assertEquals(1, users.size());
        assertTrue(users.contains(user));
    }

    @Test
    public void testShowData() {
        videogame.setGenre("Adventure");
        videogame.setPlayersNumber(1);
        videogame.setPrice(49.99f);
        videogame.setPlatforms("Nintendo Switch");
        videogame.setSetting("Fantasy World");
        videogame.setRecommendedAgePEGI("12");
        videogame.setSpecificContentPEGI("Mild Violence");
        videogame.setRequirements("8GB RAM, GTX 1050");

        videogame.showData();
    }
}
