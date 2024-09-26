import java.util.HashMap;
import java.util.Map;

public class VideogamesLibrary {
    private Map<String, Videogame> videogames = new HashMap<>();

    public VideogamesLibrary() {
        videogames.put("Return to Monkey Island", new Videogame("Return to Monkey Island"));
        videogames.put("The Witcher 3", new Videogame("The Witcher 3"));
    }

    public Videogame find(User user, String title) {
        Videogame videogame = videogames.get(title);
        if (videogame != null) {
            videogame.addUsersWhoHaveConsulted(user);
        }
        return videogame;
    }

    public void addReviewToGame(User user, String title, int rating, String comment) {
        Videogame videogame = find(user, title);
        if (videogame != null) {
            Reviews review = new Reviews(user, rating, comment);
            videogame.addReview(review);
            System.out.println("Review added successfully!");
        } else {
            System.out.println("Videogame not found.");
        }
    }

    public void showVideogameDetails(String title) {
        Videogame videogame = videogames.get(title);
        if (videogame != null) {
            videogame.showData();
        } else {
            System.out.println("Videogame not found.");
        }
    }
}
