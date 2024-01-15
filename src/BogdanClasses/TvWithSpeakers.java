package BogdanClasses;

//Importarea claselor
import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class TvWithSpeakers extends HomeEntertainmentSystem implements Serializable {

    //Declar si initializez variabilele
    private int volume = 20;
    private int channel = 1;
    private boolean areSpeakersOn = false;
    private static TvWithSpeakers[] tvWithSpeakers = TvWithSpeakers.TvWithSpeakersInstances();

    //Constructor fara argumente
    public TvWithSpeakers() {
    }

    // Constructor cu argumente
    public TvWithSpeakers(boolean isPoweredOn, int volume, int channel, boolean isSpeakersOn) {
        this.isPoweredOn = isPoweredOn;
        this.volume = volume;
        this.channel = channel;
        this.areSpeakersOn = isSpeakersOn;
    }

    // Constructor de copiere
    public TvWithSpeakers(TvWithSpeakers other) {
        this.isPoweredOn = other.isPoweredOn;
        this.volume = other.volume;
        this.channel = other.channel;
        this.areSpeakersOn = other.areSpeakersOn;
    }

    @Override
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("TvWithSpeakers a fost pornit");
    }

    @Override
    public void powerOff() {
        isPoweredOn = false;
        System.out.println("TvWithSpeakers a fost oprit");
    }

    // Metoda pentru a ajusta volumul televizorului
    public void adjustVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volumul televizorului a fost setat la " + volume);
        } else {
            System.out.println("Volumul trebuie sa fie intre 0 si 100.");
        }
    }

    // Metoda pentru a schimba canalul televizorului
    public void changeChannel(int channel) {
        if (channel > 0) {
            this.channel = channel;
            System.out.println("Canalul a fost schimbat la " + channel);
        } else {
            System.out.println("Canalul trebuie sa fie mai mare decat 0");
        }
    }

    // Metoda pentru a porni sau opri sistemul de boxe
    public void toggleSpeakers() {
        if (isPoweredOn()) {
            areSpeakersOn = true;
            System.out.println("Sistemul de boxe a fost pornit");
        } else {
            areSpeakersOn = false;
            System.out.println("Televizorul trebuie sa fie pornit pentru a controla sistemul de boxe");
        }
    }

    // Metoda pentru a verifica daca televizorul este pornit/oprit
    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    // Metoda pentru a obține volumul televizorului
    public int getVolume() {
        return volume;
    }

    // Metoda pentru a obtine canalul televizorului
    public int getChannel() {
        return channel;
    }

    // Metoda pentru a verifica daca boxele sunt pornite/oprite
    public boolean areSpeakersOn() {
        return areSpeakersOn;
    }

    // Metoda pentru a afisa informatiile despre TvWithSpeakers
    public void tvInfo() {
        System.out.println("Info Televizor:");
        System.out.println("Pornit/Oprit: " + (isPoweredOn ? "Pornit" : "Oprit"));
        System.out.println("Volum: " + volume);
        System.out.println("Canal: " + channel);
        System.out.println("Stare Sistem de Boxe: " + (areSpeakersOn ? "Pornit" : "Oprit"));
    }

    // Redefinirea metodei toString pentru a afisa datele
    @Override
    public String toString() {
        return "TvWithSpeakers { " + "IsPoweredOn=" + isPoweredOn + ", Volume=" + volume + ", Channel=" + channel + ", AreSpeakersOn=" + areSpeakersOn + " }";
    }

    // Implementarea metodei de control pentru TvWithSpeakers
    @Override
    public void ControlSpecifiedDevice() {
        // Instanta pentru citirea datelor de la tastatura
        Scanner scanner = new Scanner(System.in);
        // Declarare variabila
        String choice;

        // Executam optiunile
        do {
            System.out.println("Alege o opțiune pentru Televizorul cu Boxe:");
            System.out.println("1. Pornire Televizor");
            System.out.println("2. Oprire Televizor");
            System.out.println("3. Ajustare Volum");
            System.out.println("4. Schimbare Canal");
            System.out.println("5. Pornire/Oprire Sistem de Boxe");
            System.out.println("6. Afisare Informatii Televizor");
            System.out.println("7. Afisare Instante");
            System.out.println("8. Afisare Instante Filtrate");
            System.out.println("9.Scriere");
            System.out.println("10. Citire");
            System.out.println("11. Iesire");

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
                    System.out.print("Introdu canalul: ");
                    int newChannel = scanner.nextInt();
                    changeChannel(newChannel);
                    break;
                case "5":
                    toggleSpeakers();
                    break;
                case "6":
                    tvInfo();
                    break;
                case "7":
                    displayInstances(TvWithSpeakers.TvWithSpeakersInstances());
                    break;
                case "8":
                    TvWithSpeakers.displayFilteredInstances();
                    break;
                case "9":
                    writeToFile("instances.txt", tvWithSpeakers);
                    System.out.println("Instantele au fost scrise in fisier");
                    break;
                case "10":
                    TvWithSpeakers[] readInstances = readFromFile("instances.txt");
                    if (readInstances != null) {
                        System.out.println("Instantele citite din fisier sunt:");
                        for (TvWithSpeakers instance : readInstances) {
                            System.out.println(instance.toString());
                        }
                    } else {
                        System.out.println("Nu s-au putut citi instantele din fisier");
                    }
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
                    break;
                case "11":
                    System.out.println("Iesire");
            }

        } while (!choice.equals("11"));
    }

    //Metoda care creaza un vector cu 10 instante
    public static TvWithSpeakers[] TvWithSpeakersInstances() {
        TvWithSpeakers[] tvWithSpeakersInst = new TvWithSpeakers[10];
        for (int i = 0; i < 10; i++) {
            tvWithSpeakersInst[i] = new TvWithSpeakers();
        }
        return tvWithSpeakersInst;
    }

    //Metoda care afiseza instantele filtrate
    public static void displayFilteredInstances() {
        TvWithSpeakers[] tvWithSpeakers = TvWithSpeakersInstances();

        Random random = new Random();

        for (TvWithSpeakers instance : tvWithSpeakers) {
            // conditii de filtrare
            boolean condition1 = !instance.isPoweredOn();
            boolean condition2 = instance.getVolume() > 10;

            // conditie aleatoare
            boolean randomCondition = random.nextBoolean();

            if (condition1 && condition2 && randomCondition) {
                System.out.println(instance.toString());
            }
        }
    }

    //Metoda pentru a scrie in fisier
    public static void writeToFile(String fileName, TvWithSpeakers[] instances) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(instances);
            System.out.println("Datele au fost scrise in fisier ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda pentru a citi instanțe dintr-un fisier
    public static TvWithSpeakers[] readFromFile(String fileName) {
        TvWithSpeakers[] instances = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            instances = (TvWithSpeakers[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instances;
    }

}
