package NicuClasses;

import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Scanner;

public class SmartSecuritySystem extends HomeEntertainmentSystem {
    private boolean isAlarmActivated;
    private boolean isSurveillanceOn;

    // Constructor implicit
    public SmartSecuritySystem() {
        this.isAlarmActivated = false;
        this.isSurveillanceOn = false;
    }

    // Constructor cu toți parametrii
    public SmartSecuritySystem(boolean initialAlarmState, boolean initialSurveillanceState) {
        this.isAlarmActivated = initialAlarmState;
        this.isSurveillanceOn = initialSurveillanceState;
    }

    // Constructor de copiere
    public SmartSecuritySystem(SmartSecuritySystem other) {
        this.isAlarmActivated = other.isAlarmActivated;
        this.isSurveillanceOn = other.isSurveillanceOn;
    }

    // Rescriem metoda toString()
    @Override
    public String toString() {
        return "SmartSecuritySystem{" +
                "isAlarmActivated=" + isAlarmActivated +
                ", isSurveillanceOn=" + isSurveillanceOn +
                '}';
    }

    public void activateAlarm() {
        isAlarmActivated = true;
        System.out.println("Alarma activata. Fii precaut!");
    }

    public void deactivateAlarm() {
        isAlarmActivated = false;
        System.out.println("Alarma dezactivata. Totul in ordine.");
    }

    public void turnOnSurveillance() {
        isSurveillanceOn = true;
        System.out.println("Sistemul de supraveghere este acum activ.");
    }

    public void turnOffSurveillance() {
        isSurveillanceOn = false;
        System.out.println("Sistemul de supraveghere este oprit.");
    }


    public boolean isAlarmActivated() {
        return isAlarmActivated;
    }

    public boolean isSurveillanceOn() {
        return isSurveillanceOn;
    }

    public void ControlSpecifiedDevice() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        // Executăm opțiunile
        do {
            System.out.println("Alege o opțiune pentru Smart Security System:");
            System.out.println("1. Activează alarma");
            System.out.println("2. Dezactivează alarma");
            System.out.println("3. Porneste supravegherea");
            System.out.println("4. Oprește supravegherea");
            System.out.println("5. Afisare 10 instante");
            System.out.println("6. Afisare instante filtrate");
            System.out.println("7. Ieșire");

            System.out.print("Introdu opțiunea ta: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    activateAlarm();
                    break;
                case "2":
                    deactivateAlarm();
                    break;
                case "3":
                    turnOnSurveillance();
                    break;
                case "4":
                    turnOffSurveillance();
                    break;
                case "5":
                    displayInstances(SmartSecuritySystem.SmartSecuritySystemInstances());
                case "6":
                    SmartSecuritySystem.displayFilteredInstances();
                case "7":
                    System.out.println("Ieșire");
                    break;
                default:
                    System.out.println("Opțiune invalidă");
            }

        } while (!choice.equals("5"));
    }
    public static SmartSecuritySystem[] SmartSecuritySystemInstances() {
        SmartSecuritySystem[] smartSecuritySystems = new SmartSecuritySystem[10];
        for (int i = 0; i < 10; i++) {
            smartSecuritySystems[i] = new SmartSecuritySystem();
        }
        return smartSecuritySystems;
    }

    public static void displayFilteredInstances() {
        SmartSecuritySystem[] smartSecuritySystems = SmartSecuritySystemInstances();

        System.out.println("Instantele clasei SmartSecuritySystem filtrate");
        for (SmartSecuritySystem instance : smartSecuritySystems) {
            boolean condition1 = !instance.isAlarmActivated();
            boolean condition2 = !instance.isSurveillanceOn();

            if (condition1 && condition2) {
                System.out.println(instance.toString());
            }
        }
    }


}
