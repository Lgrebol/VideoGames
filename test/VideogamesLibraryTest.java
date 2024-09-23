import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideogamesLibraryTest {

    private VideogamesLibrary library;
    private User user;

    @BeforeEach
    public void setUp() {
        library = new VideogamesLibrary();
        user = new User("testUser");
    }

    @Test
    public void testFindVideogameExists() {
        Videogame videogame = library.find(user, "Return to Monkey Island");
        assertNotNull(videogame);
        assertEquals("Return to Monkey Island", videogame.getName());
        assertTrue(videogame.getUsersWhoHaveConsulted().contains(user));
    }

    @Test
    public void testFindVideogameDoesNotExist() {
        Videogame videogame = library.find(user, "Nonexistent Game");
        assertNull(videogame);
    }

    @Test
    public void testFindAddsUserToConsultedList() {
        Videogame videogame = library.find(user, "Return to Monkey Island");
        assertTrue(videogame.getUsersWhoHaveConsulted().contains(user));
    }

    @Test
    public void testCreateInitialVideogames() {
        Videogame videogame1 = library.find(user, "Return to Monkey Island");
        assertNotNull(videogame1);
        assertEquals("Return to Monkey Island", videogame1.getName());
        assertEquals(15539, videogame1.getPlayersNumber());
        assertEquals(22.99f, videogame1.getPrice());

        Videogame videogame2 = library.find(user, "Dummy name");
        assertNotNull(videogame2);
        assertEquals("Dummy name", videogame2.getName());
        assertEquals("Dummy Genre", videogame2.getGenre());
    }
}
