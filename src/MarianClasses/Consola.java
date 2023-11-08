package MarianClasses;

public class Consola {
    private boolean isPoweredOn=false; //Pornire Consola
    private boolean isControllerConnected=false; //Connectare Controller
    private boolean isControllerOn=false; //Pornire Controller
    private boolean isConsoleConnected=false;//Daca consola este connectata sau nu
    private String game;//O consola poate sa aiba mai multe jocuri.
    public Consola(){         //Constructor fara parametri
        isPoweredOn=false;
        isControllerConnected=false;
        isControllerOn=false;
        isConsoleConnected=false;
        game="Necunoscut";
    }
    public Consola(boolean power,boolean contConnect,boolean contOn,boolean consConnect, String game){
      this.isPoweredOn=power;
      this.isControllerConnected=contConnect;
      this.isControllerOn=contOn;
      this.isConsoleConnected=consConnect;
      this.game=game;
    }
    public Consola(Consola other){
        this.isPoweredOn=other.isPoweredOn;
        this.isConsoleConnected=other.isConsoleConnected;
        this.isControllerConnected=other.isControllerConnected;
        this.isControllerOn=other.isControllerOn;
        this.game=other.game;
    }

    public void ConsoleConnect(){
        isConsoleConnected=true;
        System.out.println("Consola a fost conectata");
    }
    public void ConsoleDisconnect(){
        isConsoleConnected=false;
        System.out.println("Consola a fost deconectata");
    }
    public void PowerOn() {
        isPoweredOn = true;
        System.out.println("Consola a fost pornita!");
    }
    public void PowerOff() {
        isPoweredOn=false;
        System.out.println("Consola a fost oprita");
    }
    public void ControllerConectat() {
        isControllerConnected=true;
        System.out.println("Controller-ul a fost conectat");
    }
    public void ControllerDeconectat(){
        isControllerConnected=false;
        System.out.println("Controller-ul a fost deconectat");
    }
    public void ControllerOn(){
        isControllerOn=true;
        System.out.println("Controller-ul a fost pornit");
    }
    public void ControllerOff(){
        isControllerOn=false;
        System.out.println("Controller-ul a fost oprit");
    }
    public String getGame(){
        return game;
    }
    public void setGame(String game){
        this.game = game;
    }
}
