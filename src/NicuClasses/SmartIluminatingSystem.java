package NicuClasses;

import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Scanner;

public class SmartIluminatingSystem extends HomeEntertainmentSystem {
    private int lightIntensity;
    private boolean isTurnedOn;

    //Constructor implicit
    public SmartIluminatingSystem() {
        this.lightIntensity = 50; // setează intensitatea luminoasă inițială la 50
        this.isTurnedOn = false; // sistemul de iluminat este oprit când este creat
    }

    //Constructor cu parametri
    public SmartIluminatingSystem(int initialIntensity, boolean initialOnState) {
        if (initialIntensity >= 0 && initialIntensity <= 100) {
            this.lightIntensity = initialIntensity;
        } else {
            System.out.println("Intensitatea luminoasă trebuie să fie între 0 și 100. Setată la 50 implicit.");
            this.lightIntensity = 50;
        }

        this.isTurnedOn = initialOnState;
    }

    //Constructor de copiere
    public SmartIluminatingSystem(SmartIluminatingSystem other) {
        this.lightIntensity = other.lightIntensity; // setează intensitatea luminoasă inițială la 50
        this.isTurnedOn = other.isTurnedOn; // sistemul de iluminat este oprit când este creat
    }

    //Rescriem metoda toString()
    @Override
    public String toString() {
        return "SmartClimateControl{" +
                "Intensitatea luminii: " + lightIntensity +
                ", isTurnedOn=" + isTurnedOn +
                '}';
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
    public int getIntensity() {
        return lightIntensity;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    //Metoda main pentru testarea metodelor si initializarea instantelor
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartIluminatingSystem iluminatingSystem = new SmartIluminatingSystem();

        int choice;

        do {
            System.out.println("\nMeniu de testare:");
            System.out.println("1. Testare constructor de baza");
            System.out.println("2. Testare constructor cu parametri");
            System.out.println("3. Testare metode turnOn si turnOff");
            System.out.println("4. Testare metoda setIntensity");
            System.out.println("5. Iesire");

            System.out.print("Alege optiunea: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testConstructorDeBaza(iluminatingSystem);
                    break;
                case 2:
                    testConstructorCuParametri(scanner);
                    break;
                case 3:
                    testMetodeTurnOnSiTurnOff(iluminatingSystem);
                    break;
                case 4:
                    testMetodaSetIntensity(scanner, iluminatingSystem);
                    break;
                case 5:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Optiune invalida. Te rog sa alegi din nou.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void testConstructorDeBaza(SmartIluminatingSystem iluminatingSystem) {
        System.out.println("\nTestare constructor de baza:");
        System.out.println("Intensitatea luminii: " + iluminatingSystem.getIntensity());
        System.out.println("Este pornit: " + iluminatingSystem.isTurnedOn());
    }

    private static void testConstructorCuParametri(Scanner scanner) {
        System.out.println("\nTestare constructor cu parametri:");
        System.out.print("Introdu intensitatea initiala (0-100): ");
        int intensity = scanner.nextInt();
        System.out.print("Este sistemul pornit? (true/false): ");
        boolean isTurnedOn = scanner.nextBoolean();
        SmartIluminatingSystem iluminatingSystem = new SmartIluminatingSystem(intensity, isTurnedOn);
        System.out.println("Intensitatea luminii: " + iluminatingSystem.getIntensity());
        System.out.println("Este pornit: " + iluminatingSystem.isTurnedOn());
    }

    private static void testMetodeTurnOnSiTurnOff(SmartIluminatingSystem iluminatingSystem) {
        System.out.println("\nTestare metode turnOn si turnOff:");
        iluminatingSystem.turnOn();
        System.out.println("Este pornit: " + iluminatingSystem.isTurnedOn());
        iluminatingSystem.turnOff();
        System.out.println("Este pornit: " + iluminatingSystem.isTurnedOn());
    }

    private static void testMetodaSetIntensity(Scanner scanner, SmartIluminatingSystem iluminatingSystem) {
        System.out.println("\nTestare metoda setIntensity:");
        iluminatingSystem.turnOn(); // Asigura că sistemul este pornit
        System.out.print("Introdu noua intensitate a luminii (0-100): ");
        int newIntensity = scanner.nextInt();
        iluminatingSystem.setIntensity(newIntensity);
        System.out.println("Intensitatea luminii: " + iluminatingSystem.getIntensity());
    }
    public void ControlSpecifiedDevice(SmartIluminatingSystem iluminatingSystem) {
        // Instanta pentru citirea datelor de la tastatura
        Scanner scanner = new Scanner(System.in);
        // Declaram
        String choice;

        // Executam optiunile
        do {
            System.out.println("Alege o opțiune pentru Smart Iluminating System:");
            System.out.println("1. Porneste iluminatul");
            System.out.println("2. Opreste iluminatul");
            System.out.println("3. Seteaza intensitatea");
            System.out.println("4. Iesire");

            System.out.print("Introdu optiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    iluminatingSystem.turnOn();
                    break;
                case "2":
                    iluminatingSystem.turnOff();
                    break;
                case "3":
                    System.out.print("Introdu noua intensitate a luminii (0-100): ");
                    int newIntensity = scanner.nextInt();
                    iluminatingSystem.setIntensity(newIntensity);
                    break;
                case "4":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }

        } while (!choice.equals("4"));
    }


}
