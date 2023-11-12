package BogdanClasses;

//Importarea claselor
import java.util.Scanner;

//Main-ul clasei SoundBarBox
public class TvWithSpeakersMain {
    public static void main(String[] args) {
        //Instanta pentru TvWithSpeakers
        TvWithSpeakers tvWithSpeakers = new TvWithSpeakers();
        //Instanta pentru citirea datelor de la tastatura
        Scanner scanner = new Scanner(System.in);
        String choice;

        //Executam operatiile
        do {
            System.out.println("\nMeniu principal pentru Televizorul cu Boxe:");
            System.out.println("1. Control Televizor");
            System.out.println("2. Creare vector cu instanțe");
            System.out.println("3. Iesire");

            System.out.print("Introdu optiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    tvWithSpeakers.ControlSpecifiedDevice();
                    break;
                case "2":
                    TvWithSpeakers[] tvsWithSpeakers = new TvWithSpeakers[10];
                    for (int i = 0; i < 10; i++) {
                        tvsWithSpeakers[i] = new TvWithSpeakers(i % 2 == 0, i * 10, i + 1, i % 3 == 0);
                    }

                    System.out.println("Instante din clasa TvWithSpeakers:");
                    for (int i = 0; i < 10; i++) {
                        System.out.println("TvWithSpeakers " + (i + 1) + ":");
                        tvsWithSpeakers[i].tvInfo();
                        System.out.println("------------------------");
                    }
                    break;
                case "3":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida.");
            }
        } while (!choice.equals("3"));

        //Inchidem scanner-ul
        scanner.close();
    }
}
