package NicuClasses;

import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Scanner;

public class SmartIluminatingSystem extends HomeEntertainmentSystem {
    private int lightIntensity;
    private boolean isTurnedOn;

    public SmartIluminatingSystem() {
        this.lightIntensity = 50; // setează intensitatea luminoasă inițială la 50
        this.isTurnedOn = false; // sistemul de iluminat este oprit când este creat
    }

    public SmartIluminatingSystem(int initialIntensity, boolean initialOnState) {
        if (initialIntensity >= 0 && initialIntensity <= 100) {
            this.lightIntensity = initialIntensity;
        } else {
            System.out.println("Intensitatea luminoasă trebuie să fie între 0 și 100. Setată la 50 implicit.");
            this.lightIntensity = 50;
        }

        this.isTurnedOn = initialOnState;
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Sistemul de iluminat: Pornit");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Sistemul de iluminat: Oprit");
    }

    public void setIntensity(int intensity) {
        if (isTurnedOn) {
            if (intensity >= 0 && intensity <= 100) {
                this.lightIntensity = intensity;
                System.out.println("Sistemul de iluminat: Intensitate setată la " + intensity);
            } else {
                System.out.println("Intensitatea luminoasă trebuie să fie între 0 și 100");
            }
        } else {
            System.out.println("Nu poți seta intensitatea când sistemul de iluminat este oprit");
        }
    }

    public void setState(boolean state){

    }

    // Alte metode specifice funcționalităților sistemului de iluminat inteligent

    public int getIntensity() {
        return lightIntensity;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    //Metoda main pentru testarea metodelor si initializarea instantelor
    public static void main(String[] args) {
        Scanner IluminatingSystem = new Scanner(System.in);

        System.out.print("Introdu intensitatea inițială a luminii (0-100): ");
        int initialIntensity = IluminatingSystem.nextInt();

        System.out.print("Este sistemul pornit? (true/false): ");
        boolean initialOnState = IluminatingSystem.nextBoolean();

        //Constructor cu 2 parametri test
        SmartIluminatingSystem IluminatingSystemParameters = new SmartIluminatingSystem(initialIntensity, initialOnState);

        System.out.println("Intensitatea luminii: " + IluminatingSystemParameters.getIntensity());
        System.out.println("Este pornit: " + IluminatingSystemParameters.isTurnedOn());

        // Testeaza metodele turnOn si turnOff
        IluminatingSystemParameters.turnOn();
        System.out.println("Este pornit: " + IluminatingSystemParameters.isTurnedOn());
        IluminatingSystemParameters.turnOff();
        System.out.println("Este pornit: " + IluminatingSystemParameters.isTurnedOn());


        IluminatingSystemParameters.turnOn(); // Asigura că sistemul este pornit

        System.out.print("Introdu noua intensitate a luminii (0-100): ");
        int newIntensity = IluminatingSystem.nextInt();
        IluminatingSystemParameters.setIntensity(newIntensity);
        System.out.println("Intensitatea luminii: " + IluminatingSystemParameters.getIntensity());

        IluminatingSystem.close();

        System.out.println("       ");



    }
}