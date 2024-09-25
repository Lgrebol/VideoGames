import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        // Registrem un usuari per a la prova
        authService.registerUser("Joan", "password123");

        Scanner scanner = new Scanner(System.in);
        
        // Demanem credencials d'usuari
        System.out.print("Insereix el nom d'usuari: ");
        String nickname = scanner.nextLine();
        
        System.out.print("Insereix la contrasenya: ");
        String password = scanner.nextLine();
        
        // Realitzem el login
        if (authService.login(nickname, password)) {
            System.out.println("Dades correctes!");

            VideogamesLibrary library = new VideogamesLibrary();
            Videogame videogame1 = library.find(new User(nickname, password), "Return to Monkey Island");
            videogame1.showData();

            System.out.println("\n** USERS WHO HAVE CONSULTED");
            Set<User> usersWhoHaveConsulted = videogame1.getUsersWhoHaveConsulted();
            for (User user : usersWhoHaveConsulted) {
                System.out.println(user.getNickname());
            }
        } else {
            System.out.println("Nom d'usuari o contrasenya incorrectes.");
        }

        scanner.close();
    }
}
