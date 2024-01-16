package NicuClasses;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

import HomeEntertainmentSystem.HomeEntertainmentSystem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        return "SmartClimateControl [Temperatura=" + temperature + ", Incalzirea=" + isHeatingOn + ", Racirea=" + isCoolingOn+ "]";
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
            System.out.println("8: Scrie instantele in fișier");
            System.out.println("9: Citeste instantele in fișier");
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
                case 8:
                    writeToFile("instances.txt", SmartClimateControlInstances());
                    System.out.println("Instantele au fost scrise in fisier");
                    break;
                case 9:
                    SmartClimateControl[] readInstances = readFromFile("instances.txt");
                    if (readInstances != null) {
                        System.out.println("Instantele citite din fisier sunt:");
                        for (SmartClimateControl instance : readInstances) {
                            System.out.println(instance.toString());
                        }
                    } else {
                        System.out.println("Nu s-au putut citi instantele din fisier");
                    }
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
                    writeToFile("instances.txt", SmartClimateControlInstances());
                    System.out.println("Instantele au fost scrise in fisier");
                    break;
                case "10":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }

        } while (!choice.equals("10"));
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

            boolean condition1 = !instance.isCoolingOn;

            // conditie aleatoare
            boolean randomCondition = random.nextBoolean();

            if (condition1 && randomCondition) {
                System.out.println(instance.toString());
            }
        }

    }



    public SmartClimateControl(String strValue1, String strValue2, String strValue3) {
        // Conversii de la String la tipurile corecte
        this.temperature = Integer.parseInt(strValue1);
        this.isHeatingOn = Boolean.parseBoolean(strValue2);
        this.isCoolingOn = Boolean.parseBoolean(strValue3);
    }

    public static void writeToFile(String fileName, SmartClimateControl[] instances) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (SmartClimateControl instance : instances) {
                writer.println(instance.toString());
            }
            System.out.println("Datele au fost scrise in fisier ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda pentru a citi instanțe dintr-un fișier
    public static SmartClimateControl[] readFromFile(String fileName) {
        List<SmartClimateControl> instancesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read line: " + line); // Adaugă acest mesaj
                SmartClimateControl instance = constructInstanceFromLine(line);
                if (instance != null) {
                    instancesList.add(instance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converteste lista de instante in array si returneaza
        return instancesList.toArray(new SmartClimateControl[0]);
    }

    private static SmartClimateControl constructInstanceFromLine(String line) {
        // Implementeaza logica pentru a construi un obiect dintr-o linie
        // Exemplu: separa valorile din linie si construieste un obiect

        // Exemplu simplu pentru linii de forma "param1:param2:param3"
        String[] values = line.split(":");
        if (values.length == 3) {
            // Construieste obiectul SmartIluminatingSystem cu valorile respective
            return new SmartClimateControl(values[0], values[1], values[2]);
        } else {
            // In caz contrar, nu se poate construi un obiect valid
            return null;
        }
    }






}

