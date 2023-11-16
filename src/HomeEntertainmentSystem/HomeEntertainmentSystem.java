package HomeEntertainmentSystem;

//Importarea claselor

import BogdanClasses.DVDPlayer;
import BogdanClasses.SoundBarBox;
import BogdanClasses.TvWithSpeakers;
import NicuClasses.SmartClimateControl;
import NicuClasses.SmartIluminatingSystem;

import java.util.Scanner;

//Aici este clasa parinte
public class HomeEntertainmentSystem {
    protected boolean isPoweredOn;

    //Metoda care indica daca dispozitivul nostru este pornit
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("Dispozitivul a fost pornit.");
    }

    //Metoda care indica daca dispozitivul nostru este oprit
    public void powerOff() {
        isPoweredOn = false;
        System.out.println("Dispozitivul a fost oprit.");
    }

    //Metoda pentru a returna starea dispozitivului(pornit/oprit)
    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    //Metoda care afiseaza daca dispozitivul este pornit/oprit
    public void displayStatus() {
        System.out.println("Starea sistemului:");
        System.out.println("Dispozitivul este " + (isPoweredOn ? "pornit" : "oprit") + ".");

    }

    //Metoda ce va avea ca scop pornirea/oprirea,starea sistemului si controlarea dispozitivelor
    public void ControlDevice() {
        //Instanta care citeste datele de la tastatura
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Alege una dintre urmatoarele optiuni:");
            System.out.println("1. Starea dispozitivului");
            System.out.println("2. Controleaza dispozitivul");
            System.out.println("3. Iesire");

            System.out.println("Introdu optiunea:");
            choice = scanner.next();

            //Executam optiunile
            switch (choice) {
                case "1":
                    displayStatus();
                    break;
                case "2":
                    ControlSpecifiedDevice();
                    break;
                case "3":
                    System.out.println("Iesire din program");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }
        } while (!choice.equals("3"));
    }

    //Aici cream o metoda goala si pe care o vom suprascrie ulterior in clasele pe care le avem
    public void ControlSpecifiedDevice() {
        System.out.println("Controlul dispozitivului");
    }

    //Aici este main-ul clasei HomeEntertainmentSystem
    public static void main(String[] args) {
        HomeEntertainmentSystem system = new HomeEntertainmentSystem();
        Scanner scanner = new Scanner(System.in);

        // Cream un meniu pentru a putea accesa si testa cu usurinta fiecare clasa
        while (true) {
            System.out.println("Alege clasa pe care vrei sa o testezi:");
            System.out.println("1. SoundBarBox");
            System.out.println("2. TvWithSpeakers");
            System.out.println("3. SmartIluminatingSystem");
            System.out.println("4. SmartClimateControl");
            System.out.println("5. Iesire");

            System.out.print("Introdu numarul clasei: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    testSoundBarBox();
                    break;
                case "2":
                    testTvWithSpeakers();
                    break;
                case "3":
                    testDVDPlayer();
                case "4":
                    System.out.println("Inchide programul");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Optiunea este invalida");
            }
        }
    }

    private static void testSoundBarBox() {
        SoundBarBox soundBarBox = new SoundBarBox();
        soundBarBox.ControlDevice();
    }

    private static void testTvWithSpeakers() {
        TvWithSpeakers tvWithSpeakers = new TvWithSpeakers();
        tvWithSpeakers.ControlDevice();
    }

    private static void testDVDPlayer() {
        DVDPlayer dvdPlayer = new DVDPlayer();
        dvdPlayer.ControlDevice();
    }
}
/**/

/**/


