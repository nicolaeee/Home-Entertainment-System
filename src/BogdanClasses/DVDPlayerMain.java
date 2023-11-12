package BogdanClasses;

//Importarea claselor
import java.util.Scanner;

public class DVDPlayerMain {
    public static void main(String[] args) {
        // Instanta pentru DVDPlayer
        DVDPlayer dvdPlayer = new DVDPlayer();

        // Meniu principal
        Scanner scanner = new Scanner(System.in);
        String choice;

        // Executam operatiile
        do {
            System.out.println("\nMeniu principal:");
            System.out.println("1. Control DVDPlayer");
            System.out.println("2. Creare vector cu 10 instanțe");
            System.out.println("3. Iesire");

            System.out.print("Introdu optiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    dvdPlayer.ControlSpecifiedDevice();
                    break;
                case "2":
                    // Creez un vector cu 10 instante de DVDPlayer(22.11.2023)
                    DVDPlayer[] dvdPlayers = new DVDPlayer[10];
                    for (int i = 0; i < 10; i++) {
                        dvdPlayers[i] = new DVDPlayer(i % 2 == 0, i % 3 == 0, i % 4 == 0);
                    }

                    // Afisez informatiile pentru fiecare DVDPlayer(22.11.2023)
                    System.out.println("Instante din clasa DVDPlayer:");
                    for (int i = 0; i < 10; i++) {
                        System.out.println("DVDPlayer " + (i + 1) + ":");
                        System.out.println(dvdPlayers[i].toString());
                        System.out.println("------------------------");
                    }
                    break;
                case "3":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }
        } while (!choice.equals("3"));

        //Inchidem scanner-ul
        scanner.close();
    }
}
