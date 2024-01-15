package BogdanClasses;

//Importarea claselor
import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class SoundBarBox extends HomeEntertainmentSystem implements Serializable {

    //Declar si initializez variabile
    private int volume = 35;
    private int bass = 22;
    private int balance = 50;
    private static SoundBarBox[] soundBarBoxes = SoundBarBox.SoundBarBoxInstances();

    //Constructor fara argumente
    public SoundBarBox() {
    }

    //Constructor cu toate argumentele
    public SoundBarBox(boolean isPoweredOn, int volume, int bass, int balance) {
        this.isPoweredOn = true;
        this.volume = volume;
        this.bass = bass;
        this.balance = balance;
    }

    //Constructor pentru copiere
    public SoundBarBox(SoundBarBox other) {
        this.isPoweredOn = other.isPoweredOn;
        this.volume = other.volume;
        this.bass = other.bass;
        this.balance = other.balance;
    }

    @Override
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("DVDPlayer-ul a fost pornit");
    }

    @Override
    public void powerOff() {
        isPoweredOn = false;
        System.out.println("DVDPlayer-ul a fost oprit");
    }

    //Metoda pentru a ajusta volumul soundbar-ului
    public void adjustVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volumul soundbar-ului a fost setat la:" + volume);
        } else {
            System.out.println("Volumul soundbar-ului trebuie sa aibe valori intre 0 si 100");
        }
    }

    //Metoda pentru a ajusta bass-ul
    public void adjustBass(int bass) {
        if (bass >= 0 && bass <= 100) {
            this.bass = bass;
            System.out.println("Volumul bass-ului a fost setat la:" + bass);
        } else {
            System.out.println("Volumul bass-ului trebuie sa aibe valori intre 0 si 100");
        }
    }

    // Metoda pentru a ajusta echilibrul
    public void adjustBalance(int balance) {
        if (balance >= 0 && balance <= 100) {
            this.balance = balance;
            System.out.println("Balanta a fost setata la:" + balance);
        } else {
            System.out.println("Balanta trebuie sa aibe valori intre 0 si 100");
        }
    }

    // Metoda pentru redarea audio
    public void playAudio(String audio) {
        if (isPoweredOn) {
            System.out.println("SoundBar: Redare audio - " + audio);
        } else {
            System.out.println("SoundBar: Soundbar-ul este oprit");
        }
    }

    // Metoda pentru mute
    public void mute() {
        if (isPoweredOn) {
            this.volume = 0;
            System.out.println("Sunetul este oprit");
        } else {
            System.out.println("Nu poti opri sunetul atunci cand soundbar-ul este oprit");
        }
    }

    // Metoda pentru a obtine volumul curent
    public int getVolume() {
        return volume;
    }

    // Metoda pentru a obtine echilibrul
    public int getBalance() {
        return balance;
    }

    // Metoda pentru a obtine bass-ul
    public int getBass() {
        return bass;
    }

    // Metoda pentru a afisa informatiile despre soundbar
    public void infoSoundBar() {
        System.out.println("Info soundbar:");
        System.out.println("Pornit/Oprit:" + (isPoweredOn ? "Pornit" : "Oprit"));
        System.out.println("Volum:" + volume);
        System.out.println("Bass:" + bass);
        System.out.println("Balanta:" + balance);
    }

    // Redefinirea metodei toString pentru a afisa datele
    @Override
    public String toString() {
        return "SoundBarBox { " + "Volume=" + volume + ", Bass=" + bass + ", isPoweredOn=" + isPoweredOn + ", Balance=" + balance + " }";
    }


    // Implementarea metodei de control pentru SoundBar
    @Override
    public void ControlSpecifiedDevice() {
        //Instanta pentru citirea datelor de la tastatura
        Scanner scanner = new Scanner(System.in);
        //declaram
        String choice;

        //Executam optiunile
        do {
            System.out.println("Alege o opțiune pentru SoundBar:");
            System.out.println("1. Pornire SoundBar");
            System.out.println("2. Oprire SoundBar");
            System.out.println("3. Ajustare volum");
            System.out.println("4. Ajustare bass");
            System.out.println("5. Ajustare echilibru");
            System.out.println("6. Redare audio");
            System.out.println("7. Oprire sunet");
            System.out.println("8. Afisare Informatii");
            System.out.println("9. Afisare Instante");
            System.out.println("10. Afisare Instante Filtrate");
            System.out.println("11. Scriere");
            System.out.println("12. Citire");
            System.out.println("13. Iesire");


            System.out.print("Introdu optiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    powerOn();
                    break;
                case "2":
                    powerOff();
                    break;
                case "3":
                    System.out.print("Introdu volumul: ");
                    int newVolume = scanner.nextInt();
                    adjustVolume(newVolume);
                    break;
                case "4":
                    System.out.print("Introdu bass-ul: ");
                    int newBass = scanner.nextInt();
                    adjustBass(newBass);
                    break;
                case "5":
                    System.out.print("Introdu echilibrul: ");
                    int newBalance = scanner.nextInt();
                    adjustBalance(newBalance);
                    break;
                case "6":
                    System.out.print("Introdu numele fisierului audio: ");
                    String audioFile = scanner.next();
                    playAudio(audioFile);
                    break;
                case "7":
                    mute();
                    break;
                case "8":
                    infoSoundBar();
                    break;
                case "9":
                    displayInstances(SoundBarBox.SoundBarBoxInstances());
                    break;
                case "10":
                    SoundBarBox.displayFilteredInstances();
                    break;
                case "11":
                    writeToFile("instances.txt", soundBarBoxes);
                    System.out.println("Instantele au fost scrise in fisier");
                    break;
                case "12":
                   SoundBarBox[] readInstances = readFromFile("instances.txt");
                    if (readInstances != null) {
                        System.out.println("Instantele citite din fisier sunt:");
                        for (SoundBarBox instance : readInstances) {
                            System.out.println(instance.toString());
                        }
                    } else {
                        System.out.println("Nu s-au putut citi instantele din fisier");
                    }
                    break;
                case "13":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }

        } while (!choice.equals("13"));
    }

    //Metoda care creaza un vector cu 10 instante
    public static SoundBarBox[] SoundBarBoxInstances() {
        SoundBarBox[] soundBarBoxInst = new SoundBarBox[10];
        for (int i = 0; i < 10; i++) {
            soundBarBoxInst[i] = new SoundBarBox();
        }
        return soundBarBoxInst;
    }

    //Metoda care afiseza instantele filtrate

    public static void displayFilteredInstances() {
        SoundBarBox[] soundBarBoxes = SoundBarBoxInstances();

        Random random = new Random();

        for (SoundBarBox instance : soundBarBoxes) {
            // verificare conditii de filtrare
            boolean condition1 = !instance.isPoweredOn();
            boolean condition2 = instance.getVolume() > 20;

            //conditie aleatoare
            boolean randomCondition = random.nextBoolean();

            if (condition1 && condition2 && randomCondition) {
                System.out.println(instance.toString());
            }
        }
    }

    public static void writeToFile(String fileName, SoundBarBox[] instances) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(instances);
            System.out.println("Datele au fost scrise in fisier ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda pentru a citi instanțe dintr-un fișier
    public static SoundBarBox[] readFromFile(String fileName) {
        SoundBarBox[] instances = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            instances = (SoundBarBox[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instances;
    }


}