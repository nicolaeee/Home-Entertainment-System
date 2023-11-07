package NicuClasses;

public class SmartIluminatingSystem {
    private int lightIntensity;
    private boolean isTurnedOn;

    public SmartIluminatingSystem() {
        this.lightIntensity = 50; // setează intensitatea luminoasă inițială la 50
        this.isTurnedOn = false; // sistemul de iluminat este oprit când este creat
    }

    public SmartIluminatingSystem(int initialIntensity, boolean initialOnState) {
        if (initialIntensity >= 0 && initialIntensity <= 100) {
            this.lightIntensity = initialIntensity;
        } else {
            System.out.println("Intensitatea luminoasă trebuie să fie între 0 și 100. Setată la 50 implicit.");
            this.lightIntensity = 50;
        }

        this.isTurnedOn = initialOnState;
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Sistemul de iluminat: Pornit");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Sistemul de iluminat: Oprit");
    }

    public void setIntensity(int intensity) {
        if (isTurnedOn) {
            if (intensity >= 0 && intensity <= 100) {
                this.lightIntensity = intensity;
                System.out.println("Sistemul de iluminat: Intensitate setată la " + intensity);
            } else {
                System.out.println("Intensitatea luminoasă trebuie să fie între 0 și 100");
            }
        } else {
            System.out.println("Nu poți seta intensitatea când sistemul de iluminat este oprit");
        }
    }

    public void setState(boolean state){

    }

    // Alte metode specifice funcționalităților sistemului de iluminat inteligent

    public int getIntensity() {
        return lightIntensity;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }
}
