package MarianClasses;
import java.util.ArrayList;
import java.util.List;
import HomeEntertainmentSystem.HomeEntertainmentSystem;
import java.util.Scanner;
public class Consola extends HomeEntertainmentSystem {
    private boolean isPoweredOn=false; //Pornire Consola
    private boolean isControllerConnected=false; //Connectare Controller
    private boolean isControllerOn=false; //Pornire Controller
    private boolean isConsoleConnected=false;//Daca consola este connectata sau nu
    private List<String> games;;//O consola poate sa aiba mai multe jocuri.

    public Consola() {
        isPoweredOn = false;
        isControllerConnected = false;
        isControllerOn = false;
        isConsoleConnected = false;
        games = new ArrayList<>();
    }

    public Consola(boolean power, boolean contConnect, boolean contOn, boolean consConnect, List<String> games) {
        this.isPoweredOn = power;
        this.isControllerConnected = contConnect;
        this.isControllerOn = contOn;
        this.isConsoleConnected = consConnect;
        this.games = new ArrayList<>(games);
    }

    public Consola(Consola other) {
        this.isPoweredOn = other.isPoweredOn;
        this.isConsoleConnected = other.isConsoleConnected;
        this.isControllerConnected = other.isControllerConnected;
        this.isControllerOn = other.isControllerOn;
        this.games = new ArrayList<>(other.games);
    }

    public void consoleConnect(){
        isConsoleConnected=true;
        System.out.println("Consola a fost conectata");
    }
    public void consoleDisconnect(){
        isConsoleConnected=false;
        System.out.println("Consola a fost deconectata");
    }
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("Consola a fost pornita!");
    }
    public void powerOff() {
        isPoweredOn=false;
        System.out.println("Consola a fost oprita");
    }
    public void controllerConectat() {
        isControllerConnected=true;
        System.out.println("Controller-ul a fost conectat");
    }
    public void controllerDeconectat(){
        isControllerConnected=false;
        System.out.println("Controller-ul a fost deconectat");
    }
    public void controllerOn(){
        isControllerOn=true;
        System.out.println("Controller-ul a fost pornit");
    }
    public void controllerOff(){
        isControllerOn=false;
        System.out.println("Controller-ul a fost oprit");
    }
    public List<String> getGame(){
        return games;
    }
    //Metoda prin care adaugam jocuri
    public void addGame(String gameName) {
        games.add(gameName);
        System.out.println("Joc adăugat: " + gameName);
    }
    //Metoda prin care stergem jocul

    public void removeGame(String gameName) {
        if (games.remove(gameName)) {
            System.out.println("Joc sters: " + gameName);
        } else {
            System.out.println("Jocul " + gameName + " nu a fost gasit.");
        }
    }

    public List<String> getGames() {
        return games;
    }

    //Metoda prin care vedem lista de jocuri
    public void displayGames() {
        System.out.println("Lista de jocuri:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }
    // Metoda pentru a opri jocul
    public void quitGame() {
        this.games = null;
        System.out.println("Joc oprit. Nu este niciun joc în execuție.");
    }

    //Redefinirea metodei toString pentru afisarea datelor
    @Override
    public String toString() {
        return "Consola{" +
                "connected" + isConsoleConnected +
                ", isPoweredOn=" + isPoweredOn +
                ", isControllerConnected=" + isControllerConnected +
                "isControllerOn" + isControllerOn +
                "games=" + games +
                '}';
    }

    //Redefinirea metodei de control pentru Consola
    {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Alege o opțiune pentru Consola:");
            System.out.println("1. Pornire Consola");
            System.out.println("2. Oprire Consola");
            System.out.println("3. Conectare consola");
            System.out.println("4. Deconectare consola");
            System.out.println("5. Conectare Controller");
            System.out.println("6. Deconectare Controller");
            System.out.println("7. Pornire Controller");
            System.out.println("8. Oprire Controller");
            System.out.println("9. Adaugare Joc");
            System.out.println("10. Stergere Joc");
            System.out.println("11. Afisare Jocuri");
            System.out.println("12. Iesire Joc");
            System.out.println("13. Iesire");

            System.out.print("Introdu opțiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    powerOn();
                    break;
                case "2":
                    powerOff();
                    break;
                case "3":
                    consoleConnect();
                    break;
                case "4":
                    consoleDisconnect();
                    break;
                case "5":
                    controllerConectat();
                    break;
                case "6":
                    controllerDeconectat();
                    break;
                case "7":
                   controllerOn();
                    break;
                case "8":
                   controllerOff();
                    break;
                case "9":
                    addGame();
                    break;
                case "10":
                    removeGame();
                    break;
                case "11":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Opțiunea nu este valida");
            }

        } while (!choice.equals("11"));
    }
}