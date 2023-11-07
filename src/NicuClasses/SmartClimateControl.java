package NicuClasses;

public class SmartClimateControl {
    private int temperature;
    private boolean isHeatingOn;
    private boolean isCoolingOn;

    public SmartClimateControl() {
        this.temperature = 20; // Set default temperature to 20 degrees Celsius
        this.isHeatingOn = false; // Heating is off by default
        this.isCoolingOn = false; // Cooling is off by default
    }

    public SmartClimateControl(int initialTemperature, boolean initialHeatingState, boolean initialCoolingState) {
        this.temperature = initialTemperature;
        this.isHeatingOn = initialHeatingState;
        this.isCoolingOn = initialCoolingState;
    }

    public void increaseTemperature() {
        if (temperature < 30) {
            temperature++;
            System.out.println("Temperature increased to " + temperature + " degrees Celsius.");
        } else {
            System.out.println("Maximum temperature reached (30 degrees Celsius).");
        }
    }

    public void decreaseTemperature() {
        if (temperature > 10) {
            temperature--;
            System.out.println("Temperature decreased to " + temperature + " degrees Celsius.");
        } else {
            System.out.println("Minimum temperature reached (10 degrees Celsius).");
        }
    }

    public void turnOnHeating() {
        isHeatingOn = true;
        System.out.println("Heating turned on.");
    }

    public void turnOffHeating() {
        isHeatingOn = false;
        System.out.println("Heating turned off.");
    }

    public void turnOnCooling() {
        isCoolingOn = true;
        System.out.println("Cooling turned on.");
    }

    public void turnOffCooling() {
        isCoolingOn = false;
        System.out.println("Cooling turned off.");
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
