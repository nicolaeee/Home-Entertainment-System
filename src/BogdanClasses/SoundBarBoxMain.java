package BogdanClasses;

import BogdanClasses.SoundBarBox;

import java.util.Scanner;
import java.util.Arrays;

public class SoundBarBoxMain {
    public static void main(String[] args) {

        // Crearea si afisarea a cel puțin 3 instante din clasa SoundBarBox
        SoundBarBox soundBar1 = new SoundBarBox(8, 40, true, 50);
        SoundBarBox soundBar2 = new SoundBarBox(24, 50, true, 65);
        SoundBarBox soundBar3 = new SoundBarBox(12, 30, false, 43);

        System.out.println("Instante:");
        System.out.println("SoundBar 1:");
        soundBar1.infoSoundBar();
        System.out.println("SoundBar 2:");
        soundBar2.infoSoundBar();
        System.out.println("SoundBar 3:");
        soundBar3.infoSoundBar();

        // Crearea unui vector cu cel putin 10 instante ale clasei SoundBarBox
        SoundBarBox[] soundBars = new SoundBarBox[10];
        for (int i = 0; i < 10; i++) {
            soundBars[i] = new SoundBarBox(i * 10, i * 5, i % 2 == 0, i * 10 + 5);
        }

        // Afisarea instantelor din vector
        System.out.println("Instante din vector:");
        for (int i = 0; i < 10; i++) {
            System.out.println("SoundBar " + (i + 1) + ":");
            soundBars[i].infoSoundBar();
        }

        // Testarea clasei SoundBarBox
        SoundBarBox soundBar = new SoundBarBox(); // Creez o instanta
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMeniu Soundbar:");
            System.out.println("1. Pornire/Oprire Soundbar");
            System.out.println("2. Ajustare Volum");
            System.out.println("3. Ajustare Bass");
            System.out.println("4. Ajustare Balanta");
            System.out.println("5. Redare Audio");
            System.out.println("6. Mute");
            System.out.println("7. Informatii soundbar");
            System.out.println("8. Iesire");

            System.out.print("Introdu numarul cu optiunea: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    if (soundBar.isPoweredOn()) {
                        soundBar.PowerOff();
                    } else {
                        soundBar.PowerOn();
                    }
                    break;
                case "2":
                    if (soundBar.isPoweredOn()) {
                        System.out.print("Introdu nivelul volumului: ");
                        int volume = scanner.nextInt();
                        soundBar.AdjustVolume(volume);
                    } else {
                        System.out.println("Soundbar-ul trebuie sa fie pornit pentru a ajusta volumul.");
                    }
                    break;
                case "3":
                    if (soundBar.isPoweredOn()) {
                        System.out.print("Introdu nivelul bass-ului: ");
                        int bassLevel = scanner.nextInt();
                        soundBar.AdjustBass(bassLevel);
                    } else {
                        System.out.println("Soundbar-ul trebuie sa fie pornit pentru a ajusta bass-ul.");
                    }
                    break;
                case "4":
                    if (soundBar.isPoweredOn()) {
                        System.out.print("Introdu nivelul balantei: ");
                        int balance = scanner.nextInt();
                        soundBar.AdjustBalance(balance);
                    } else {
                        System.out.println("Soundbar-ul trebuie sa fie pornit pentru a ajusta balanta.");
                    }
                    break;
                case "5":
                    if (soundBar.isPoweredOn()) {
                        System.out.print("Introdu audio pentru redare: ");
                        String audio = scanner.next();
                        soundBar.playAudio(audio);
                    } else {
                        System.out.println("Soundbar-ul trebuie sa fie pornit pentru a reda audio.");
                    }
                    break;
                case "6":
                    if (soundBar.isPoweredOn()) {
                        soundBar.mute();
                    } else {
                        System.out.println("Soundbar-ul trebuie sa fie pornit pentru a opri sunetul.");
                    }
                    break;
                case "7":
                    soundBar.infoSoundBar();
                    break;
                case "8":
                    System.out.println("Inchide programul.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Optiunea este incorecta.");
            }
        }
    }
}
