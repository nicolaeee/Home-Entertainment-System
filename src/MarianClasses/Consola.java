package MarianClasses;
import java.util.ArrayList;
import java.util.List;


import HomeEntertainmentSystem.HomeEntertainmentSystem;
import java.util.Scanner;
public class Consola extends HomeEntertainmentSystem {
    private boolean isPoweredOn; //Pornire Consola
    private boolean isControllerConnected; //Connectare Controller
    private boolean isControllerOn=false; //Pornire Controller
    private boolean isConsoleConnected=false;//Daca consola este connectata sau nu
    private boolean isPlaying;//Verifica daca un joc ruleaza
    private List<String> games;//O consola poate sa aiba mai multe jocuri.
    private int numberOfGames;//Nr de jocuri

    public Consola() {
        isPoweredOn = false;
        isControllerConnected = false;
        isControllerOn = false;
        isConsoleConnected = false;
        games = new ArrayList<>();
        numberOfGames=0;
        isPlaying=false;
    }

    public Consola(boolean power, boolean contConnect, boolean contOn, boolean consConnect, boolean isplay, List<String> games, int nrGames) {
        this.isPoweredOn = power;
        this.isControllerConnected = contConnect;
        this.isControllerOn = contOn;
        this.isConsoleConnected = consConnect;
        this.games = new ArrayList<>(games);
        this.numberOfGames=nrGames;
        this.isPlaying=isplay;
    }

    public Consola(Consola other) {
        this.isPoweredOn = other.isPoweredOn;
        this.isConsoleConnected = other.isConsoleConnected;
        this.isControllerConnected = other.isControllerConnected;
        this.isControllerOn = other.isControllerOn;
        this.games = new ArrayList<>(other.games);
        this.numberOfGames=other.numberOfGames;
        this.isPlaying=other.isPlaying;
    }


    public void powerOn() {
        isPoweredOn=true;
        System.out.println("Consola a fost pornita");
    }

    public void powerOff(){
        isPoweredOn=false;
        System.out.println("Consola a fost oprita");
    }

    public void consoleConnect(){
        isConsoleConnected=true;
        System.out.println("Consola a fost conectata");
    }
    public void consoleDisconnect(){
        isConsoleConnected=false;
        System.out.println("Consola a fost deconectata");
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

    //Metoda prin care adaugam jocuri
    public void addGames(List<String> newGames) {
        if (isPoweredOn) {
            games.addAll(newGames);
            numberOfGames = games.size();
            System.out.println(newGames.size() + " games added. Total games: " + numberOfGames);
        } else {
            System.out.println("Cannot add games. Console is powered off.");
        }
    }
    //Metoda prin care stergem jocul

    public void removeGame(String gameName) {
        if (games.remove(gameName)) {
            System.out.println("Joc sters: " + gameName);
        } else {
            System.out.println("Jocul " + gameName + " nu a fost gasit.");
        }
    }

    //Metoda prin care vedem lista de jocuri
    public void displayGames() {
        System.out.println("Lista de jocuri:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }
    //Metoda pentru a porni jocul
    public void startGame(String gameName) {
        if (games.contains(gameName)) {
            isPlaying=true;
            System.out.println("Jocul " + gameName + " a început pe consolă.");
        } else {
            System.out.println("Jocul " + gameName + " nu există în lista de jocuri.");
        }
    }
    // Metoda pentru a opri jocul
    public void quitGame() {
        if(isPlaying==true) {
            this.games = null;
            System.out.println("Joc oprit. Nu este niciun joc în execuție.");
        } else System.out.print("Nu este niciun joc in executie sau consola este oprita ");
    }
    //Redefinirea metodei toString pentru afisarea datelor
    @Override
    public String toString() {
        return "Consola{" +
                "connected" + isConsoleConnected +
                ", isPoweredOn=" + isPoweredOn +
                ", isControllerConnected=" + isControllerConnected +
                "isControllerOn" + isControllerOn +
                ", numberOfGames=" + numberOfGames +
                ", isPlaying=" + isPlaying +
                "games=" + games +
                '}';
    }

    //Redefinirea metodei de control pentru Consola
    @Override
    public void ControlSpecifiedDevice(){
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
            System.out.println("12. Pornire joc");
            System.out.println("13. Iesire Joc");
            System.out.println("14. Iesire");

            System.out.print("Introdu opțiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    super.powerOn();
                    powerOn();
                    break;
                case "2":
                    super.powerOff();
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
                    System.out.println("Introdu jocul pe care vrei sa il instalezi");
                    List<String> newGame= new ArrayList<>();
                    newGame.add(scanner.next());
                    addGames(newGame);
                    break;
                case "10":
                    System.out.println("Alege jocul pe care vrei sa il dezinstalezi");
                    String gameRemover=scanner.next();
                    removeGame(gameRemover);
                    break;
                case "11":
                   displayGames();
                    break;
                case "12":
                    System.out.print("Introdu numele jocului de început: ");
                    String gameToStart = scanner.next();
                    startGame(gameToStart);
                    break;
                case "13":
                    quitGame();
                case "14":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Opțiunea nu este valida");
            }

        } while (!choice.equals("14"));
    }
    public static Consola[] ConsolaInstances() {
        Consola[] consolaInst = new Consola[10];
        for (int i = 0; i < 10; i++) {
            consolaInst[i] = new Consola();
        }
        return consolaInst;
    }
}
