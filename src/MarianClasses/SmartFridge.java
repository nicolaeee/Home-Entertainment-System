package MarianClasses;
import java.util.ArrayList;
import java.util.List;
import HomeEntertainmentSystem.HomeEntertainmentSystem;
import java.util.Scanner;

public class SmartFridge {
    private boolean isPoweredOn=false;
    private float temperature;
    private int numberOfDrinks;
    private List<String> drinks;
    private int foodQuantity;
    private static final int restockThreshold = 10;
    public SmartFridge(){
        isPoweredOn=false;
        temperature=-4.0f;
        numberOfDrinks=0;
        drinks= new ArrayList<>();
        foodQuantity=0;
    }
    public SmartFridge(boolean Power, float temp, int nrDrinks,List<String> drinks, int foodQuant ){
        isPoweredOn = Power;
        temperature = temp;
        numberOfDrinks = nrDrinks;
        this.drinks = new ArrayList<>(drinks);
        foodQuantity = foodQuant;
    }
    public SmartFridge(SmartFridge other) {
        this.isPoweredOn = other.isPoweredOn;
        this.temperature = other.temperature;
        this.numberOfDrinks = other.numberOfDrinks;
        this.drinks = new ArrayList<>(other.drinks);
        this.foodQuantity = other.foodQuantity;
    }
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("Frigiderul inteligent a fost pornit.");
    }
    public void powerOff() {
        isPoweredOn = false;
        System.out.println("Frigiderul inteligent a fost oprit.");
    }
    public void setTemperature(float newTemp) {
        if (isPoweredOn) {
            temperature = newTemp;
            System.out.println("Temperatura setata la " + temperature + " grade Celsius.");
        } else {
            System.out.println("Nu putem seta temperatura. Frigiderul nu este pornit.");
        }
    }
    public void addDrinks(List<String> newDrinks) {
        if (isPoweredOn) {
            drinks.addAll(newDrinks);
            numberOfDrinks = drinks.size();
            System.out.println(newDrinks.size() + " de bauturi. Bauturi totale: " + numberOfDrinks);
        } else {
            System.out.println("Nu putem adauga bauturi. Frigiderul nu este pornit.");
        }
    }
    public void displayDrinks() {
        if (isPoweredOn) {
            System.out.println("Bauturi valabile:");
            for (String drink : drinks) {
                System.out.println("- " + drink);
            }
        } else {
            System.out.println("Nu putem afisa bauturi.Frigiderul este oprit");
        }
    }
    public void addFood(int quantity) {
        if (isPoweredOn) {
            foodQuantity += quantity;
            System.out.println(quantity + " de alimente au fost introduse. Cantitate totala: " + foodQuantity);
        } else {
            System.out.println("Nu putem adauga mancare. Frigiderul nu este pornit.");
        }
    }
    public float getTemperature() {
        return temperature;
    }

    // Method to get the number of drinks in the fridge
    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }
    public void checkRestockStatus() {
        if (foodQuantity <= restockThreshold) {
            System.out.println("Atentie: Re-alimenta-ti frigiderul cu mancare!");
        } else {
            System.out.println("Cantitate suficienta de mancare");
        }
    }
    @Override
    public String toString() {
        return String.format("Smart Fridge [Power: %b, Temp: %.1f°C, Bauturi: %d, Mancare: %d units]",
                isPoweredOn, temperature, numberOfDrinks, foodQuantity);
    }

}
