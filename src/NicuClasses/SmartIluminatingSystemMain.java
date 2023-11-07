package NicuClasses;

import java.util.Scanner;

public class SmartIluminatingSystemMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu intensitatea inițială a luminii (0-100): ");
        int initialIntensity = scanner.nextInt();

        System.out.print("Este sistemul pornit? (true/false): ");
        boolean initialOnState = scanner.nextBoolean();

        SmartIluminatingSystem system = new SmartIluminatingSystem(initialIntensity, initialOnState);

        System.out.println("Intensitatea luminii: " + system.getIntensity());
        System.out.println("Este pornit: " + system.isTurnedOn());

        // Testează metodele turnOn și turnOff
        system.turnOn();
        System.out.println("Este pornit: " + system.isTurnedOn());
        system.turnOff();
        System.out.println("Este pornit: " + system.isTurnedOn());

        // Testează metoda setIntensity
        system.turnOn(); // Asigură-te că sistemul este pornit

        System.out.print("Introdu noua intensitate a luminii (0-100): ");
        int newIntensity = scanner.nextInt();
        system.setIntensity(newIntensity);
        System.out.println("Intensitatea luminii: " + system.getIntensity());

        scanner.close();
    }
}
