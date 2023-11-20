package MarianClasses;
import java.util.ArrayList;
import java.util.List;
import HomeEntertainmentSystem.HomeEntertainmentSystem;
import java.util.Scanner;

public class SmartFridge {
    private boolean isPoweredOn=false;//Daca e pornit
    private float temperature;//Temperature pe care o setam
    private int numberOfDrinks;//Nr de bauturi
    private List<String> drinks;//Lista de bauturi
    private int foodQuantity;//Cantitatea de mancare
    private static final int restockThreshold = 10;//Folosit pentru a detecta cand avem nevoie sa realimentam
    //Constructor fara argumente
    public SmartFridge(){
        isPoweredOn=false;
        temperature=-4.0f;
        numberOfDrinks=0;
        drinks= new ArrayList<>();
        foodQuantity=0;
    }
    //Constructor cu argumente
    public SmartFridge(boolean Power, float temp, int nrDrinks,List<String> drinks, int foodQuant ){
        isPoweredOn = Power;
        temperature = temp;
        numberOfDrinks = nrDrinks;
        this.drinks = new ArrayList<>(drinks);
        foodQuantity = foodQuant;
    }
    //Constructor de copiere
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
    //Metoda prin care setam temperatura
    public void setTemperature(float newTemp) {
        if (isPoweredOn) {
            temperature = newTemp;
            System.out.println("Temperatura setata la " + temperature + " grade Celsius.");
        } else {
            System.out.println("Nu putem seta temperatura. Frigiderul nu este pornit.");
        }
    }
    //Metoda prin care adugam bauturi
    public void addDrinks(List<String> newDrinks) {
        if (isPoweredOn) {
            drinks.addAll(newDrinks);
            numberOfDrinks = drinks.size();
            System.out.println(newDrinks.size() + " de bauturi. Bauturi totale: " + numberOfDrinks);
        } else {
            System.out.println("Nu putem adauga bauturi. Frigiderul nu este pornit.");
        }
    }
    //Metoda prin care ce bauturi avem
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
    //Metoda prin care adaugam mancare
    public void addFood(int quantity) {
        if (isPoweredOn) {
            foodQuantity += quantity;
            System.out.println(quantity + " de alimente au fost introduse. Cantitate totala: " + foodQuantity);
        } else {
            System.out.println("Nu putem adauga mancare. Frigiderul nu este pornit.");
        }
    }
    //Metoda prin care aflam temperatura
    public float getTemperature() {
        return temperature;
    }

    // Metoda de a afla nr de bauturi
    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }
    //Metoda prin care verifica cantitatea de mancare
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
