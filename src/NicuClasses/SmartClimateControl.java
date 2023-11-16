package NicuClasses;
import java.util.Scanner;

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
        SmartClimateControl control = new SmartClimateControl();

        // Testarea consturctului de baza
        System.out.println("Temperatura: " + control.getTemperature());
        System.out.println("Incalzirea este pornita: " + control.isHeatingOn());
        System.out.println("Racirea este pornita: " + control.isCoolingOn());

        // Testarea consturctului cu parametri
        SmartClimateControl control2 = new SmartClimateControl(25, true, false);
        System.out.println("Temperatura: " + control2.getTemperature());
        System.out.println("Incalzirea este pornita: " + control2.isHeatingOn());
        System.out.println("Racirea este pornita: " + control2.isCoolingOn());

        // Testarea metodelor increaseTemperature si decreaseTemperature
        control.increaseTemperature();
        System.out.println("Temperatura: " + control.getTemperature());
        control.decreaseTemperature();
        System.out.println("Temperatura: " + control.getTemperature());

        // Testarea metodelor turnOnHeating si turnOffHeating
        control.turnOnHeating();
        System.out.println("Incalzirea este pornita: " + control.isHeatingOn());
        control.turnOffHeating();
        System.out.println("Incalzirea este pornita: " + control.isHeatingOn());

        // Testarea metodelor turnOnHeating si turnOffHeating
        control.turnOnCooling();
        System.out.println("Racirea este pornita: " + control.isCoolingOn());
        control.turnOffCooling();
        System.out.println("Racirea este pornita: " + control.isCoolingOn());

        //Testarea cu mod dinamic si introducere de la tastatura
        Scanner ClimateControl = new Scanner(System.in);

        System.out.print("Introdu temperatura initiala (10-30): ");
        int initialTemperature = ClimateControl.nextInt();

        System.out.print("Este incalzirea pornita? (true/false): ");
        boolean initialHeatingState =   ClimateControl.nextBoolean();

        System.out.print("Este racirea pornita? (true/false): ");
        boolean initialCoolingState = ClimateControl.nextBoolean();

        SmartClimateControl ClimateControlParameters = new SmartClimateControl(initialTemperature, initialHeatingState, initialCoolingState);

        System.out.println("Temperatura: " + control.getTemperature());
        System.out.println("Incalzirea este pornita: " + control.isHeatingOn());
        System.out.println("Racirea este pornita: " + control.isCoolingOn());

        // Other tests can go here

        ClimateControl.close();

    }
}
