package NicuClasses;
import java.util.Scanner;
public class SmartClimateControlMain {
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
