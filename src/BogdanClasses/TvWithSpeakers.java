package BogdanClasses;

public class TvWithSpeakers {
    private boolean isPoweredOn = false;
    private int Volume = 50;
    private int Channel = 1;
    private boolean isSpeakersOn = false;

    public TvWithSpeakers() {
        // Setez stare initiala Tv/Boxe
        isPoweredOn = false;
        isSpeakersOn = false;
    }

    // Metoda pentru a porni televizorul
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("Televizorul a fost pornit.");
    }

    // Metoda pentru a opri televizorul
    public void powerOff() {
        isPoweredOn = false;
        System.out.println("Televizorul a fost oprit.");
    }

    // Metoda pentru a ajusta volumul televizorului
    public void adjustVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.Volume = volume;
            System.out.println("Volumul televizorului a fost setat la " + volume + ".");
        } else {
            System.out.println("Volumul trebuie sa fie intre 0 si 100.");
        }
    }

    // Metoda pentru a schimba canalul televizorului
    public void changeChannel(int channel) {
        if (channel > 0) {
            this.Channel = channel;
            System.out.println("Canalul a fost schimbat la " + channel + ".");
        } else {
            System.out.println("Canalul trebuie sa fie mai mare decat 0.");
        }
    }

    // Metoda pentru a porni sau opri sistemul de boxe
    public void toggleSpeakers() {
        if (isSpeakersOn) {
            isSpeakersOn = false;
            System.out.println("Sistemul de boxe a fost oprit.");
        } else {
            isSpeakersOn = true;
            System.out.println("Sistemul de boxe a fost pornit.");
        }
    }

    // Metoda pentru a verifica daca televizorul este pornit/oprit
    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    // Metoda pentru a obține volumul televizorului
    public int getVolume() {
        return Volume;
    }

    // Metoda pentru a obtine canalul televizorului
    public int getChannel() {
        return Channel;
    }

    // Metoda pentru a verifica daca boxele sunt pornite/oprite
    public boolean areSpeakersOn() {
        return isSpeakersOn;
    }

    // Metoda pentru a afisa informatiile despre TvWithSpeakers
    public void displayTVInfo() {
        System.out.println("Info Televizor:");
        System.out.println("Pornit/Oprit: " + (isPoweredOn ? "Pornit" : "Oprit"));
        System.out.println("Volum: " + Volume);
        System.out.println("Canal: " + Channel);
        System.out.println("Stare Sistem de Boxe: " + (isSpeakersOn ? "Pornit" : "Oprit"));
    }
}
