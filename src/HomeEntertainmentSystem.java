//Importarea claselor
import NicuClasses.SoundBar;

public class HomeEntertainmentSystem {
    public static void main(String[] args) {
        // Creaza un obiect SoundBar folosind constructorul implicit
        SoundBar soundBarImplicit = new SoundBar();

        // Porneste soundbar-ul
        soundBarImplicit.powerOn();

        // Seteaza volumul
        soundBarImplicit.setVolume(70);

        // Redă un audio
        soundBarImplicit.playAudio("Melodie preferată");

        // Opreșe soundbar-ul
        soundBarImplicit.powerOff();
    }
}
