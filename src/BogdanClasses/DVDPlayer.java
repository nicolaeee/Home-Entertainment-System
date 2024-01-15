package BogdanClasses;

//Importarea claselor
import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class DVDPlayer extends HomeEntertainmentSystem implements Serializable {

    //Declar si initializez variabilele
    private boolean isDiscInserted;
    private boolean isPlaying;
    private static DVDPlayer[] dvdPlayers = DVDPlayer.DVDPlayerInstances();


    // Constructor fara argumente
    public DVDPlayer() {
    }

    // Constructor cu toate argumentele
    public DVDPlayer(boolean isPoweredOn, boolean isDiscInserted, boolean isPlaying) {
        this.isPoweredOn = isPoweredOn;
        this.isDiscInserted = isDiscInserted;
        this.isPlaying = isPlaying;
    }

    // Constructor de copiere
    public DVDPlayer(DVDPlayer other) {
        this.isPoweredOn = other.isPoweredOn;
        this.isDiscInserted = other.isDiscInserted;
        this.isPlaying = other.isPlaying;
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

    // Metoda pentru a introduce un disc în DVDPlayer
    public void insertDisc() {
        if (isPoweredOn()) {
            isDiscInserted = true;
            System.out.println("Discul a fost introdus");
        } else {
            System.out.println("DVDPlayer-ul trebuie sa fie pornit pentru a introduce un disc");
        }
    }

    // Metoda pentru a scoate discul din DVDPlayer
    public void ejectDisc() {
        if (isPoweredOn()) {
            isDiscInserted = false;
            isPlaying = false;
            System.out.println("Discul a fost scos");
        } else {
            System.out.println("DVDPlayer-ul trebuie sa fie pornit pentru a scoate un disc");
        }
    }

    // Metoda pentru a reda discul
    public void play() {
        if (isPoweredOn() && isDiscInserted) {
            isPlaying = true;
            System.out.println("Redare in curs");
        } else if (!isPoweredOn()) {
            System.out.println("DVDPlayer-ul trebuie sa fie pornit pentru a reda un disc");
        } else {
            System.out.println("Nu exista disc in DVDPlayer");
        }
    }

    //Metoda pentru a opri redarea
    public void stop() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Redare oprita");
        } else {
            System.out.println("DVDPlayer-ul nu reda in acest moment");
        }
    }

    //Metoda pentru a verifica daca este introdus un disc
    public boolean isDiscInserted() {
        return isDiscInserted;
    }

    //Metoda pentru a verifica daca se reda un disc
    public boolean isPlaying() {
        return isPlaying;
    }

    // Metoda pentru a afisa informatiile despre TvWithSpeakers
    public void dvdInfo() {
        System.out.println("Info Televizor:");
        System.out.println("Pornit/Oprit: " + (isPoweredOn ? "Pornit" : "Oprit"));
        System.out.println("isDiscInserted: " + isDiscInserted);
        System.out.println("isPlaying: " + isPlaying);
    }

    //Redefinirea metodei toString pentru a afisa datele
    @Override
    public String toString() {
        return "DVDPlayer { " + "isPoweredOn=" + isPoweredOn + ", isDiscInserted=" + isDiscInserted + ", isPlaying=" + isPlaying + " }";
    }

    //Redefinirea metodei de control pentru DVDPlayer
    @Override
    public void ControlSpecifiedDevice() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Alege o opțiune pentru DVDPlayer:");
            System.out.println("1. Pornire DVDPlayer");
            System.out.println("2. Oprire DVDPlayer");
            System.out.println("3. Introducere disc");
            System.out.println("4. Scoatere disc");
            System.out.println("5. Redare");
            System.out.println("6. Oprire redare");
            System.out.println("7. Afisare Informatii");
            System.out.println("8. Afisare Instante");
            System.out.println("9. Afisare Instante Filtrate");
            System.out.println("10. Scriere");
            System.out.println("11. Citire");
            System.out.println("12. Iesire");


            System.out.print("Introdu opțiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    powerOn();
                    break;
                case "2":
                    powerOff();
                    break;
                case "3":
                    insertDisc();
                    break;
                case "4":
                    ejectDisc();
                    break;
                case "5":
                    play();
                    break;
                case "6":
                    stop();
                    break;
                case "7":
                    dvdInfo();
                    break;
                case "8":
                    displayInstances(DVDPlayer.DVDPlayerInstances());
                    break;
                case "9":
                    DVDPlayer.displayFilteredInstances();
                    break;
                case "10":
                writeToFile("instances.txt", dvdPlayers);
                System.out.println("Instantele au fost scrise in fisier");
                    break;
                case "11":
                    DVDPlayer[] readInstances = readFromFile("instances.txt");
                    if (readInstances != null) {
                        System.out.println("Instantele citite din fisier sunt:");
                        for (DVDPlayer instance : readInstances) {
                            System.out.println(instance.toString());
                        }
                    } else {
                        System.out.println("Nu s-au putut citi instantele din fisier");
                    }
                    break;
                case "12":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }

        } while (!choice.equals("12"));
    }

    //Metoda care creaza un vector cu 10 instante
    public static DVDPlayer[] DVDPlayerInstances() {
        DVDPlayer[] dvdPlayerInst = new DVDPlayer[10];
        for (int i = 0; i < 10; i++) {
            dvdPlayerInst[i] = new DVDPlayer();
        }
        return dvdPlayerInst;
    }

    //Metoda care afiseza instantele filtrate
    public static void displayFilteredInstances() {
        DVDPlayer[] dvdPlayers = DVDPlayerInstances();

        Random random = new Random();

        for (DVDPlayer instance : dvdPlayers) {

            boolean condition = !instance.isPoweredOn();

            boolean randomCondition = random.nextBoolean();

            if (condition && randomCondition) {
                System.out.println(instance.toString());
            }
        }
    }

    //Metoda pentru a scrie in fisier
    public static void writeToFile(String fileName, DVDPlayer[] instances) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(instances);
            System.out.println("Datele au fost scrise in fisier ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda pentru a citi instante dintr-un fișier
    public static DVDPlayer[] readFromFile(String fileName) {
        DVDPlayer[] instances = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            instances = (DVDPlayer []) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instances;
    }


}
