package NicuClasses;


public class SmartIluminatingSystem {
    private int brightness;
    private boolean isOn;

    // Constructor implicit
    public SmartIluminatingSystem() {
        this.brightness = 50; // seteaza luminozitatea initiala la 50
        this.isOn = false; // sistemul de iluminat este oprit cand este creat
    }

    // Constructor cu parametri
    public SmartIluminatingSystem(int initialBrightness, boolean initialOnState) {
        if (initialBrightness >= 0 && initialBrightness <= 100) {
            this.brightness = initialBrightness;
        } else {
            System.out.println("Luminozitatea trebuie sa fie intre 0 si 100. Setata la 50 implicit.");
            this.brightness = 50;
        }

        this.isOn = initialOnState;
    }

    // Metoda pentru a porni sistemul de iluminat
    public void turnOn() {
        isOn = true;
        System.out.println("Sistemul de iluminat: Pornit");
    }

    // Metoda pentru a opri sistemul de iluminat
    public void turnOff() {
        isOn = false;
        System.out.println("Sistemul de iluminat: Oprit");
    }

    // Metoda pentru a seta nivelul de luminozitate
    public void setBrightness(int brightness) {
        if (isOn) {
            if (brightness >= 0 && brightness <= 100) {
                this.brightness = brightness;
                System.out.println("Sistemul de iluminat: Luminozitate setata la " + brightness);
            } else {
                System.out.println("Luminozitatea trebuie sa fie intre 0 si 100");
            }
        } else {
            System.out.println("Nu poti seta luminozitatea cand sistemul de iluminat este oprit");
        }
    }

    // Alte metode specifice functionalitatilor sistemului de iluminat inteligent

    public int getBrightness() {
        return brightness;
    }

    public boolean isOn() {
        return isOn;
    }
}

