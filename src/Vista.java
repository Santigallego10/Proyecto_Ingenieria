//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Service.UserService;
import dominio.User;
import interfaces.UserRepository;
import util.InMemoryUserRepository;

import java.util.Scanner;

public class Vista {
    private UserService userService;
    private Scanner scanner;

    public Vista(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Get user");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                System.out.print("Enter user ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter user name: ");
                String name = scanner.nextLine();
                userService.addUser(id, name);
                System.out.println("User added.");
            } else if (option == 2) {
                System.out.print("Enter user ID: ");
                String id = scanner.nextLine();
                User user = userService.getUser(id);
                if (user != null) {
                    System.out.println("User found: " + user);
                } else {
                    System.out.println("User not found.");
                }
            } else if (option == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);
        Vista consoleUI = new Vista(userService);
        consoleUI.start();
    }
}
