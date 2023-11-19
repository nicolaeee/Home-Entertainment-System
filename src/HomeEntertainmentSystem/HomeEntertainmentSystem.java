package HomeEntertainmentSystem;

//Importarea claselor

import BogdanClasses.DVDPlayer;
import BogdanClasses.SoundBarBox;
import BogdanClasses.TvWithSpeakers;
import NicuClasses.SmartClimateControl;
import NicuClasses.SmartIluminatingSystem;
import NicuClasses.SmartSecuritySystem;

import java.util.Scanner;

//Aici este clasa parinte
public class HomeEntertainmentSystem {
    protected boolean isPoweredOn;

    //Metoda care indica daca dispozitivul nostru este pornit
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("Dispozitivul a fost pornit");
    }

    //Metoda care indica daca dispozitivul nostru este oprit
    public void powerOff() {
        isPoweredOn = false;
        System.out.println("Dispozitivul a fost oprit");
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

    //Metoda de baza toString care e mostenita si apoi redifinita in alte clasele(comun)
    public String toString() {
        return " ";
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
            System.out.println("3. DVDPlayer");
            System.out.println("4. SmartClimateControl");
            System.out.println("5. SmartIluminatingSystem");
            System.out.println("6. SmartSecuritySystem");
            System.out.println("7. Iesire");

            System.out.print("Introdu numarul clasei: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    testSoundBarBox();
                    displayInstances(SoundBarBox.SoundBarBoxInstances());
                    break;
                case "2":
                    testTvWithSpeakers();
                    displayInstances(TvWithSpeakers.TvWithSpeakersInstances());
                    break;
                case "3":
                    testDVDPlayer();
                    displayInstances(DVDPlayer.DVDPlayerInstances());
                case "4":
                    testSmartClimateControl();
                case "5":
                    testSmartIluminatingSystem();
                case "6":
                    testSmartSecuritySystem();
                case "7":
                    System.out.println("Inchide programul");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Optiunea este invalida");
            }
        }
    }

    //Cream instante si apelam metoda ControlDevice()
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

    private static void testSmartClimateControl(){
        //Instanta pentru testare a clasei SmartClimateControl - 2
        SmartClimateControl smartClimateControl = new SmartClimateControl();
        smartClimateControl.ControlDevice();
    }

    private static void testSmartIluminatingSystem(){
        //Instanta pentru testare a clasei SmartClimateControl - 3
        SmartIluminatingSystem smartIluminatingSystem = new SmartIluminatingSystem();
        smartIluminatingSystem.ControlDevice();
    }

<<<<<<< HEAD
    //Afisam instantele
    public static void displayInstances(Object[] instances) {
        System.out.println("Instantele clasei:");
        for (Object instance : instances) {
            System.out.println(instance.toString());
        }
=======
    private static void testSmartSecuritySystem(){
        //Instanta pentru testare a clasei SmartClimateControl - 3
        SmartSecuritySystem smartSecuritySystem = new SmartSecuritySystem();
        smartSecuritySystem.ControlDevice();
>>>>>>> 68c908155adecf06d6d50dee3746c39fe9188489
    }
}
/**/

/**/


