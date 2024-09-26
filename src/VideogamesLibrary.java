import java.util.ArrayList;
import java.util.List;

public class VideogamesLibrary {
    private List<Videogame> videogames;

    public VideogamesLibrary() {
        this.videogames = new ArrayList<>();
        populateLibrary(); // Mètode per afegir alguns jocs de mostra
    }

    private void populateLibrary() {
        Videogame game1 = new Videogame("Forager");
        game1.setGenre("Survival");
        game1.setPlatforms("PC");
        game1.setPrice(40);
        videogames.add(game1);

        Videogame game2 = new Videogame("The Long Dark");
        game2.setGenre("Survival");
        game2.setPlatforms("PC");
        game2.setPrice(35);
        videogames.add(game2);

        Videogame game3 = new Videogame("Terraria");
        game3.setGenre("Sandbox");
        game3.setPlatforms("PC");
        game3.setPrice(20);
        videogames.add(game3);
        
        // Afegir més jocs aquí si vols
    }

    public List<Videogame> searchGames(String genre, String platform, float minPrice, float maxPrice) {
        List<Videogame> results = new ArrayList<>();
        for (Videogame game : videogames) {
            if (game.getGenre().equalsIgnoreCase(genre) &&
                game.getPlatforms().equalsIgnoreCase(platform) &&
                game.getPrice() >= minPrice &&
                game.getPrice() <= maxPrice) {
                results.add(game);
            }
        }
        return results;
    }

    public Videogame find(User user, String name) {
        for (Videogame game : videogames) {
            if (game.getName().equalsIgnoreCase(name)) {
                game.addUsersWhoHaveConsulted(user);
                return game;
            }
        }
        return null;
    }
}
