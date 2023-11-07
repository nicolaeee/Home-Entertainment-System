package NicuClasses;

import java.util.Scanner;

public class SmartIluminatingSystemMain {

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
