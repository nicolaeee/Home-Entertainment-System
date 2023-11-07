//Importarea claselor

import BogdanClasses.SoundBarBox;
import BogdanClasses.TvWithSpeakers;
import NicuClasses.SmartClimateControl;
import NicuClasses.SmartClimateControlMain;
import NicuClasses.SmartIluminatingSystem;
import NicuClasses.SmartIluminatingSystemMain;

import java.util.Scanner;

public class HomeEntertainmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Alege clasa pe care vrei sa o testezi:");
            System.out.println("1. SoundBarBox");
            System.out.println("2. TvWithSpeakers");
            System.out.println("3. SmartIluminatingSystem");
            System.out.println("4. SmartClimateControlMain");
            System.out.println("5. Iesire");

            System.out.print("Introdu nr clasei: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    SoundBarBoxMain.main(null); // Apelez metoda main din clasa SoundBarBoxMain
                    break;
                case "2":
                    TvWithSpeakersMain.main(null); // Apelez metoda main din clasa TvWithSpeakersMain
                    break;
                case "3":
                    SmartIluminatingSystemMain.main(null); // Apelez metoda main din clasa SmartIluminatingSystemMain
                    break;
                case "4":
                    SmartClimateControlMain.main(null); // Apelez metode main din clasa SmartClimateControlMain
                case "5":
                    System.out.println("Inchide programul.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Optiunea este invalida.");
            }
        }
    }
}

/**/

/**/


