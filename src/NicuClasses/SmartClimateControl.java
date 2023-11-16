package NicuClasses;

import HomeEntertainmentSystem.HomeEntertainmentSystem;

public class  SmartClimateControl extends HomeEntertainmentSystem {
    private int temperature;
    private boolean isHeatingOn;
    private boolean isCoolingOn;

    public SmartClimateControl() {
        this.temperature = 20; // Setam valoare initiala cu 20 grade C
        this.isHeatingOn = false; // Incalzirea este off by default
        this.isCoolingOn = false; // Racirea este off by default
    }

    public SmartClimateControl(int initialTemperature, boolean initialHeatingState, boolean initialCoolingState) {
        this.temperature = initialTemperature;
        this.isHeatingOn = initialHeatingState;
        this.isCoolingOn = initialCoolingState;
    }

    public void increaseTemperature() {
        if (temperature < 30) {
            temperature++;
            System.out.println("Temperatura a crescut cu " + temperature + " grade Celsius.");
        } else {
            System.out.println("Temperatura maxima atinsa (30 grade Celsius).");
        }
    }

    public void decreaseTemperature() {
        if (temperature > 10) {
            temperature--;
            System.out.println("Temperatura a scazut la " + temperature + " grade Celsius.");
        } else {
            System.out.println("Temperatura minima atinsa (10 grade Celsius).");
        }
    }

    public void turnOnHeating() {
        isHeatingOn = true;
        System.out.println("Incalzirea este pornita");
    }

    public void turnOffHeating() {
        isHeatingOn = false;
        System.out.println("Incalzirea este oprita");
    }

    public void turnOnCooling() {
        isCoolingOn = true;
        System.out.println("Racirea este pornita");
    }

    public void turnOffCooling() {
        isCoolingOn = false;
        System.out.println("Racirea este oprita");
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isHeatingOn() {
        return isHeatingOn;
    }

    public boolean isCoolingOn() {
        return isCoolingOn;
    }
}
