package BogdanClasses;

import BogdanClasses.TvWithSpeakers;

import java.util.Scanner;

//Testarea clasei TvWithSpeakers//
public class TvWithSpeakersMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crearea și afisarea a cel putin 3 instante din clasa TvWithSpeakers
        TvWithSpeakers tv1 = new TvWithSpeakers(true, 31, 3, true);
        TvWithSpeakers tv2 = new TvWithSpeakers(false, 45, 1, false);
        TvWithSpeakers tv3 = new TvWithSpeakers();

        System.out.println("Instante:");
        System.out.println("TV 1:");
        tv1.TVInfo();
        System.out.println("TV 2:");
        tv2.TVInfo();
        System.out.println("TV 3:");
        tv3.TVInfo();

        // Crearea unui vector cu cel putin 10 instante ale clasei TvWithSpeakers
        TvWithSpeakers[] tvArray = new TvWithSpeakers[10];
        for (int i = 0; i < 10; i++) {
            boolean poweredOn = i % 2 == 0;
            int volume = i * 10;
            int channel = i + 1;
            boolean speakersOn = i % 3 == 0;
            tvArray[i] = new TvWithSpeakers(poweredOn, volume, channel, speakersOn);
        }

        // Afisarea instanttlor din vector
        System.out.println("Instante din vector:");
        for (int i = 0; i < 10; i++) {
            System.out.println("TV " + (i + 1) + ":");
            tvArray[i].TVInfo();
        }

        // Testarea clasei TvWithSpeakers
        TvWithSpeakers tv = new TvWithSpeakers(); // Creez o instanță
        while (true) {
            System.out.println("\nMeniu Televizor cu Sistem de Boxe:");
            System.out.println("1. Pornire/Oprit Televizor");
            System.out.println("2. Ajustare Volum");
            System.out.println("3. Schimbare Canal");
            System.out.println("4. Pornire/Oprit Sistem de Boxe");
            System.out.println("5. Afișare Info Televizor");
            System.out.println("6. Ieșire");
            System.out.print("Introdu numărul opțiunii: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    if (tv.isPoweredOn()) {
                        tv.powerOff();
                    } else {
                        tv.powerOn();
                    }
                    break;
                case "2":
                    if (tv.isPoweredOn()) {
                        System.out.print("Introdu volumul: ");
                        int volume = scanner.nextInt();
                        tv.adjustVolume(volume);
                    } else {
                        System.out.println("Televizorul trebuie să fie pornit pentru a ajusta volumul.");
                    }
                    break;
                case "3":
                    if (tv.isPoweredOn()) {
                        System.out.print("Introduceți canalul dorit: ");
                        int channel = scanner.nextInt();
                        tv.changeChannel(channel);
                    } else {
                        System.out.println("Televizorul trebuie să fie pornit pentru a schimba canalul.");
                    }
                    break;
                case "4":
                    tv.toggleSpeakers();
                    break;
                case "5":
                    tv.TVInfo();
                    break;
                case "6":
                    System.out.println("Închide programul.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opțiunea este incorectă.");
            }
        }
    }
}
