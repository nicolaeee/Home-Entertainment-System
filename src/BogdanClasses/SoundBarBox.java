package BogdanClasses;

//Importarea claselor
import HomeEntertainmentSystem.HomeEntertainmentSystem;
import java.util.Scanner;

public class SoundBarBox extends HomeEntertainmentSystem {

    //Declar si initializez variabile
    private int volume = 35;
    private int bass = 22;
    private int balance = 50;


    //Constructor fara argumente
    public SoundBarBox() {
    }

    //Constructor cu toate argumentele
    public SoundBarBox(boolean isPoweredOn,int volume, int bass, int balance) {
        this.isPoweredOn=isPoweredOn;
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
        return "SoundBarBox { " +"Volume=" + volume +", Bass=" + bass +", isPoweredOn=" + isPoweredOn +", Balance=" + balance +" }";
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
            System.out.println("8. Iesire");

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
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }

        } while (!choice.equals("8"));
    }

    //Metoda care creaza un vector cu 10 instante
    public static SoundBarBox[] SoundBarBoxInstances() {
        SoundBarBox[] soundBarBoxInst = new SoundBarBox[10];
        for (int i = 0; i < 10; i++) {
            soundBarBoxInst[i] = new SoundBarBox();
        }
        return soundBarBoxInst;
    }
}
