import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        Scanner scanner = new Scanner(System.in);

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

        System.out.println("\n=== Login ===");
        System.out.print("Insert your username: ");
        String loginNickname = scanner.nextLine();

        System.out.print("Insert your password: ");
        String loginPassword = scanner.nextLine();

        if (authService.login(loginNickname, loginPassword)) {
            System.out.println("Correct credentials!");
            User loggedInUser = new User(loginNickname, loginPassword);
            VideogamesLibrary library = new VideogamesLibrary();
            Videogame videogame1 = library.find(loggedInUser, "Return to Monkey Island");
            videogame1.showData();

            videogame1.showReviews();

            System.out.println("\nDo you want to add a review? (yes/no)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter a rating (1-5): ");
                int rating = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter a comment: ");
                String comment = scanner.nextLine();

                Reviews review = new Reviews(loggedInUser, rating, comment);
                videogame1.addReview(review);
                System.out.println("Review added successfully!");

                videogame1.showReviews();
            }

            System.out.println("\n** USERS WHO HAVE CONSULTED");
            Set<User> usersWhoHaveConsulted = videogame1.getUsersWhoHaveConsulted();
            for (User user : usersWhoHaveConsulted) {
                System.out.println(user.getNickname());
            }
        } else {
            System.out.println("Incorrect username or password.");
        }

        scanner.close();
    }
}
