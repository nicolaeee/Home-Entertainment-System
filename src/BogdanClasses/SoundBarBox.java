package BogdanClasses;

public class SoundBarBox {
    private int Volume;
    private int BassLevel=30;
    private boolean isPoweredOn=false;
    private int balance=50;

    public SoundBarBox() {
        this.volume = 10; // setez volumul initial la 10
        this.isPoweredOn = false; // soundbar-ul este oprit atunci cand este creat
    }

    //Metoda pentru a porni soundbar-ul//
    public void PowerOn() {
        isPoweredOn = true;
        System.out.println("SoundBar-ul a fost pornit!");
    }

    //Metoda pentru a opri soundbar-ul//
    public void PowerOff() {
        isPoweredOn = false;
        System.out.println("SoundBar-ul a fost oprit!");
    }

    //Metoda pentru a adjusta volumul soundbar-ului//

    public void playAudio(String audio) {
        if (isOn) {
            System.out.println("SoundBar: Redare audio - " + audio);
        } else {
            System.out.println("SoundBar: Soundbar-ul este oprit. Nu se poate reda audio.");
        }
    }

    public void mute() {
        if (isOn) {
            this.volume = 0;
            System.out.println("SoundBar: Sunetul este mutat");
        } else {
            System.out.println("SoundBar: Nu poți opri sunetul când soundbar-ul este oprit");
        }
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }
}
