/*
package BogdanClasses;

import java.util.Scanner;

public class SoundBarBoxMain {
    public static void main(String[] args) {
        //Instanta pentru SoundBarBox
        SoundBarBox soundBar = new SoundBarBox();

        //Meniu principal
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nMeniu principal:");
            System.out.println("1. Control SoundBar");
            System.out.println("2. Creare vector cu instanțe");
            System.out.println("3. Iesire");

            System.out.print("Introdu optiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    soundBar.ControlSpecifiedDevice();
                    break;
                case "2":
                    //Creez un vector cu cele 10 instante din clasa SoundBarBox(22.11.2023)
                    SoundBarBox[] soundBars = new SoundBarBox[10];
                    for (int i = 0; i < 10; i++) {
                        soundBars[i] = new SoundBarBox(i * 10, i * 5, i % 2 == 0, i * 10 + 5);
                    }

                    //Afisez instantele pt fiecare clasa(22.11.2023)
                    System.out.println("Instante din clasa SoundBarBox:");
                    for (int i = 0; i < 10; i++) {
                        System.out.println("SoundBar " + (i + 1) + ":");
                        soundBars[i].infoSoundBar();
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

*/