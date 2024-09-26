import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        Scanner scanner = new Scanner(System.in);

        // ** Registre **
        System.out.println("=== Registration ===");
        System.out.print("Enter a username to register: ");
        String regNickname = scanner.nextLine();

        System.out.print("Enter a password: ");
        String regPassword = scanner.nextLine();

        if (authService.registerUser(regNickname, regPassword)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed: User already exists.");
            scanner.close();
            return;
        }

        // ** Login **
        System.out.println("\n=== Login ===");
        System.out.print("Insert your username: ");
        String loginNickname = scanner.nextLine();

        System.out.print("Insert your password: ");
        String loginPassword = scanner.nextLine();

        if (authService.login(loginNickname, loginPassword)) {
            System.out.println("Correct credentials!");
            User loggedInUser = new User(loginNickname, loginPassword);
            VideogamesLibrary library = new VideogamesLibrary();

            // ** Cerca de jocs **
            System.out.println("\n=== Search for a game ===");
            System.out.print("Enter the genre you're looking for (e.g., Survival): ");
            String genre = scanner.nextLine();

            System.out.print("Enter the platform (e.g., PC): ");
            String platform = scanner.nextLine();

            System.out.print("Enter minimum price: ");
            float minPrice = Float.parseFloat(scanner.nextLine());

            System.out.print("Enter maximum price: ");
            float maxPrice = Float.parseFloat(scanner.nextLine());

            List<Videogame> foundGames = library.searchGames(genre, platform, minPrice, maxPrice);
            
            if (foundGames.isEmpty()) {
                System.out.println("No games found with the given criteria.");
                scanner.close();
                return;
            } else {
                System.out.println("Games found:");
                for (Videogame game : foundGames) {
                    System.out.println("- " + game.getName() + " (" + game.getPrice() + "€)");
                }
            }

            // ** Elecció del joc per consultar i deixar ressenya **
            System.out.print("\nEnter the name of the game you want to review: ");
            String gameName = scanner.nextLine();

            Videogame videogame = library.find(loggedInUser, gameName);

            if (videogame != null) {
                videogame.showData();

                System.out.println("\nDo you want to add a review? (yes/no)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("yes")) {
                    System.out.print("Enter a rating (1-5): ");
                    int rating = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter a comment: ");
                    String comment = scanner.nextLine();

                    Reviews review = new Reviews(loggedInUser, rating, comment);
                    videogame.addReview(review);
                    System.out.println("Review added successfully!");

                    videogame.showReviews();
                }

                System.out.println("\n** USERS WHO HAVE CONSULTED");
                for (User user : videogame.getUsersWhoHaveConsulted()) {
                    System.out.println(user.getNickname());
                }
            } else {
                System.out.println("Game not found.");
            }
        } else {
            System.out.println("Incorrect username or password.");
        }

        scanner.close();
    }
}
