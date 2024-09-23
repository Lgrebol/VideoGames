import java.util.Set;

public class Main {
    public static void main(String[] args) {
        VideogamesLibrary library = new VideogamesLibrary();

        User joan = new User("Joan");
        Videogame videogame1 = library.find(joan, "Return to Monkey Island");
        videogame1.showData();

        User josep = new User("Josep");
        Videogame videogame2 = library.find(josep, "Return to Monkey Island");
        videogame2.showData();

        System.out.println("\n** USERS WHO HAVE CONSULTED");
        Set<User> usersWhoHaveConsulted = videogame1.getUsersWhoHaveConsulted();
        for (User user : usersWhoHaveConsulted) {
            System.out.println(user.getNickname());
        }
    }
}