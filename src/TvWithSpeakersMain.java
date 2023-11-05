import BogdanClasses.TvWithSpeakers;

import java.util.Scanner;

//Testarea clasei TvWithSpeakers//
public class TvWithSpeakersMain {
    public static void main(String[] args) {
        TvWithSpeakers tvWithSpeakers = new TvWithSpeakers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMeniu Televizor cu Sistem de Boxe:");
            System.out.println("1. Pornire/Oprit Televizor");
            System.out.println("2. Ajustare Volum");
            System.out.println("3. Schimbare Canal");
            System.out.println("4. Pornire/Oprit Sistem de Boxe");
            System.out.println("5. Afisare Info Televizor");
            System.out.println("6. Iesire");
            System.out.print("Introdu nr optiunii : ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    if (tvWithSpeakers.isPoweredOn()) {
                        tvWithSpeakers.powerOff();
                    } else {
                        tvWithSpeakers.powerOn();
                    }
                    break;
                case "2":
                    if (tvWithSpeakers.isPoweredOn()) {
                        System.out.print("Introdu volumul: ");
                        int volume = scanner.nextInt();
                        tvWithSpeakers.adjustVolume(volume);
                    } else {
                        System.out.println("Televizorul trebuie sa fie pornit pentru a ajusta volumul.");
                    }
                    break;
                case "3":
                    if (tvWithSpeakers.isPoweredOn()) {
                        System.out.print("Introduceți canalul dorit: ");
                        int channel = scanner.nextInt();
                        tvWithSpeakers.changeChannel(channel);
                    } else {
                        System.out.println("Televizorul trebuie sa fie pornit pentru a schimba canalul.");
                    }
                    break;
                case "4":
                    tvWithSpeakers.toggleSpeakers();
                    break;
                case "5":
                    tvWithSpeakers.TVInfo();
                    break;
                case "6":
                    System.out.println("Inchide programul.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Optiunea este invalida.");
            }
        }
    }
}
