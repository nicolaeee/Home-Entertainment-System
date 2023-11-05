package BogdanClasses;

public class SoundBarBox {
    private int volume;
    private boolean isOn;

    public SoundBarBox() {
        this.volume = 50; // setează volumul inițial la 50
        this.isOn = false; // soundbar-ul este oprit când este creat
    }

    // Constructor cu parametri
    public SoundBarBox(int initialVolume, boolean initialOnState) {
        if (initialVolume >= 0 && initialVolume <= 100) {
            this.volume = initialVolume;
        } else {
            System.out.println("Volumul trebuie să fie între 0 și 100. Setat la 50 implicit.");
            this.volume = 50;
        }

        this.isOn = initialOnState;
    }

    public void powerOn() {
        isOn = true;
        System.out.println("SoundBar: Pornit");
    }

    public void powerOff() {
        isOn = false;
        System.out.println("SoundBar: Oprit");
    }

    public void setVolume(int volume) {
        if (isOn) {
            if (volume >= 0 && volume <= 100) {
                this.volume = volume;
                System.out.println("SoundBar: Volumul setat la " + volume);
            } else {
                System.out.println("SoundBar: Volumul trebuie să fie între 0 și 100");
            }
        } else {
            System.out.println("SoundBar: Nu poți seta volumul când soundbar-ul este oprit");
        }
    }

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
