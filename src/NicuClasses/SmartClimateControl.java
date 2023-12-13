package NicuClasses;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;
import BogdanClasses.DVDPlayer;
import BogdanClasses.SoundBarBox;
import BogdanClasses.TvWithSpeakers;
import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Scanner;

public class  SmartClimateControl extends HomeEntertainmentSystem {
    private int temperature;
    private boolean isHeatingOn;
    private boolean isCoolingOn;

    //Constructor implicit
    public SmartClimateControl() {
        this.temperature = 20; // Setam valoare initiala cu 20 grade C
        this.isHeatingOn = false; // Incalzirea este off by default
        this.isCoolingOn = false; // Racirea este off by default
    }

    //Constructor cu toti parametrii
    public SmartClimateControl(int initialTemperature, boolean initialHeatingState, boolean initialCoolingState) {
        this.temperature = initialTemperature;
        this.isHeatingOn = initialHeatingState;
        this.isCoolingOn = initialCoolingState;
    }

    //Constructor de copiere
    public SmartClimateControl(SmartClimateControl other) {
        this.temperature = other.temperature;
        this.isHeatingOn = other.isHeatingOn;
        this.isCoolingOn = other.isCoolingOn;
    }

    //Rescriem metoda toString()
    @Override
    public String toString() {
        return "SmartClimateControl{" +
                "temperature=" + temperature +
                ", isHeatingOn=" + isHeatingOn +
                ", isCoolingOn=" + isCoolingOn +
                '}';
    }


    public void increaseTemperature() {
        if (temperature < 30) {
            temperature++;
            System.out.println("Temperatura a crescut cu " + temperature + " grade Celsius.");
        } else {
            System.out.println("Temperatura maxima atinsa (30 grade Celsius).");
        }
    }

    public void decreaseTemperature() {
        if (temperature > 10) {
            temperature--;
            System.out.println("Temperatura a scazut la " + temperature + " grade Celsius.");
        } else {
            System.out.println("Temperatura minima atinsa (10 grade Celsius).");
        }
    }

    public void turnOnHeating() {
        isHeatingOn = true;
        System.out.println("Incalzirea este pornita");
    }

    public void turnOffHeating() {
        isHeatingOn = false;
        System.out.println("Incalzirea este oprita");
    }

    public void turnOnCooling() {
        isCoolingOn = true;
        System.out.println("Racirea este pornita");
    }

    public void turnOffCooling() {
        isCoolingOn = false;
        System.out.println("Racirea este oprita");
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isHeatingOn() {
        return isHeatingOn;
    }

    public boolean isCoolingOn() {
        return isCoolingOn;
    }

    public static void main(String[] args) {

        //Menu de testare a clasei SmartClimateControl
        Scanner scanner = new Scanner(System.in);
        SmartClimateControl climateControl = new SmartClimateControl();

        int choice;

        do {
            System.out.println("\nMeniu de testare:");
            System.out.println("1. Testare constructor de baza");
            System.out.println("2. Testare constructor cu parametri");
            System.out.println("3. Testare metode increaseTemperature si decreaseTemperature");
            System.out.println("4. Testare metode turnOnHeating si turnOffHeating");
            System.out.println("5. Testare metode turnOnCooling si turnOffCooling");
            System.out.println("6. Testare cu mod dinamic si introducere de la tastatura");
            System.out.println("7. Afisare 10  instante ");
            System.out.println("0. Iesire");

            System.out.print("Alege optiunea: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testConstructorDeBaza(climateControl);
                    break;
                case 2:
                    testConstructorCuParametri(scanner);
                    break;
                case 3:
                    testMetodeIncreaseSiDecrease(climateControl);
                    break;
                case 4:
                    testMetodeTurnOnSiTurnOffHeating(climateControl);
                    break;
                case 5:
                    testMetodeTurnOnSiTurnOffCooling(climateControl);
                    break;
                case 6:
                    testModDinamicSiIntroducere(scanner);
                    break;
                case 7:
                    displayInstances(SmartClimateControl.SmartClimateControlInstances());
                    ;
                    break;
                case 0:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Optiune invalida. Te rog sa alegi din nou.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void testConstructorDeBaza(SmartClimateControl control) {
        System.out.println("\nTestare constructor de baza:");
        System.out.println("Temperatura: " + control.getTemperature());
        System.out.println("Incalzirea este pornita: " + control.isHeatingOn());
        System.out.println("Racirea este pornita: " + control.isCoolingOn());
    }

    private static void testConstructorCuParametri(Scanner scanner) {
        System.out.println("\nTestare constructor cu parametri:");
        System.out.print("Introdu temperatura (10-30): ");
        int temperature = scanner.nextInt();
        System.out.print("Este incalzirea pornita? (true/false): ");
        boolean heating = scanner.nextBoolean();
        System.out.print("Este racirea pornita? (true/false): ");
        boolean cooling = scanner.nextBoolean();
        SmartClimateControl control = new SmartClimateControl(temperature, heating, cooling);
        System.out.println("Temperatura: " + control.getTemperature());
        System.out.println("Incalzirea este pornita: " + control.isHeatingOn());
        System.out.println("Racirea este pornita: " + control.isCoolingOn());
    }

    private static void testMetodeIncreaseSiDecrease(SmartClimateControl control) {
        System.out.println("\nTestare metode increaseTemperature si decreaseTemperature:");
        control.increaseTemperature();
        System.out.println("Temperatura crescuta: " + control.getTemperature());
        control.decreaseTemperature();
        System.out.println("Temperatura scazuta: " + control.getTemperature());
    }

    private static void testMetodeTurnOnSiTurnOffHeating(SmartClimateControl control) {
        System.out.println("\nTestare metode turnOnHeating si turnOffHeating:");
        control.turnOnHeating();
        System.out.println("Incalzirea este pornita: " + control.isHeatingOn());
        control.turnOffHeating();
        System.out.println("Incalzirea este oprita: " + control.isHeatingOn());
    }

    private static void testMetodeTurnOnSiTurnOffCooling(SmartClimateControl control) {
        System.out.println("\nTestare metode turnOnCooling si turnOffCooling:");
        control.turnOnCooling();
        System.out.println("Racirea este pornita: " + control.isCoolingOn());
        control.turnOffCooling();
        System.out.println("Racirea este oprita: " + control.isCoolingOn());
    }

    private static void testModDinamicSiIntroducere(Scanner scanner) {
        System.out.println("\nTestare cu mod dinamic si introducere de la tastatura:");
        System.out.print("Introdu temperatura initiala (10-30): ");
        int initialTemperature = scanner.nextInt();
        System.out.print("Este incalzirea pornita? (true/false): ");
        boolean initialHeatingState = scanner.nextBoolean();
        System.out.print("Este racirea pornita? (true/false): ");
        boolean initialCoolingState = scanner.nextBoolean();

        SmartClimateControl climateControlParameters = new SmartClimateControl(initialTemperature, initialHeatingState, initialCoolingState);

        System.out.println("Temperatura: " + climateControlParameters.getTemperature());
        System.out.println("Incalzirea este pornita: " + climateControlParameters.isHeatingOn());
        System.out.println("Racirea este pornita: " + climateControlParameters.isCoolingOn());
    }
   @Override
    public void ControlSpecifiedDevice() {
        // Instanta pentru citirea datelor de la tastatura
        Scanner scanner = new Scanner(System.in);
        // Declaram
        String choice;
        //Instanta pentru controlSpecifiedDevice
        SmartClimateControl climateControl = new SmartClimateControl();

        // Executam optiunile
        do {
            System.out.println("Alege o opțiune pentru Smart Climate Control:");
            System.out.println("1. Creste temperatura");
            System.out.println("2. Scade temperatura");
            System.out.println("3. Porneste incalzirea");
            System.out.println("4. Opreste incalzirea");
            System.out.println("5. Porneste racirea");
            System.out.println("6. Opreste racirea");
            System.out.println("7. Afisare 10 instante");
            System.out.println("8. Afisare instante filtrate");
            System.out.println("9. Iesire");

            System.out.print("Introdu optiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    climateControl.increaseTemperature();
                    break;
                case "2":
                    climateControl.decreaseTemperature();
                    break;
                case "3":
                    climateControl.turnOnHeating();
                    break;
                case "4":
                    climateControl.turnOffHeating();
                    break;
                case "5":
                    climateControl.turnOnCooling();
                    break;
                case "6":
                    climateControl.turnOffCooling();
                    break;
                case "7":
                    displayInstances(SmartClimateControl.SmartClimateControlInstances());
                    break;
                case "8":
                    SmartClimateControl.displayFilteredInstances();
                    break;
                case "9":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }

        } while (!choice.equals("9"));
    }

    //Metoda care creaza un vector cu 10 instante
    public static SmartClimateControl[] SmartClimateControlInstances() {
        SmartClimateControl[] smartClimateControls = new SmartClimateControl[10];
        for (int i = 0; i < 10; i++) {
            smartClimateControls[i] = new SmartClimateControl();
        }
        return smartClimateControls;
    }

    public static void displayFilteredInstances() {
        SmartClimateControl[] smartClimateControls = SmartClimateControlInstances();
        Random random = new Random();
        System.out.println("Instantele clasei SmartClimateControl filtrate");


        for (SmartClimateControl instance : smartClimateControls) {

            boolean condition1 = !instance.isPoweredOn();
            boolean condition2 = instance.isCoolingOn;

            // conditie aleatoare
            boolean randomCondition = random.nextBoolean();

            if (condition1 && condition2 && randomCondition) {
                System.out.println(instance.toString());
            }
        }

    }



}

