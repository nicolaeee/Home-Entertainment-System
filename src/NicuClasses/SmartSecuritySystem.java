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
        System.out.println("Alarm activated. Be cautious!");
    }

    public void deactivateAlarm() {
        isAlarmActivated = false;
        System.out.println("Alarm deactivated. All clear.");
    }

    public void turnOnSurveillance() {
        isSurveillanceOn = true;
        System.out.println("Surveillance system is now active.");
    }

    public void turnOffSurveillance() {
        isSurveillanceOn = false;
        System.out.println("Surveillance system is turned off.");
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

        // Executam optiunile
        do {
            System.out.println("Choose an option for Smart Security System:");
            System.out.println("1. Activate Alarm");
            System.out.println("2. Deactivate Alarm");
            System.out.println("3. Turn On Surveillance");
            System.out.println("4. Turn Off Surveillance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
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
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (!choice.equals("5"));
    }
}
