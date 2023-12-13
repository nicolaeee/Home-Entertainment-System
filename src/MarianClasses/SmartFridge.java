package MarianClasses;
import java.util.ArrayList;
import java.util.List;


import HomeEntertainmentSystem.HomeEntertainmentSystem;

import java.util.Random;
import java.util.Scanner;

public class SmartFridge extends HomeEntertainmentSystem {
    private boolean isPoweredOn;//Daca e pornit
    private float temperature;//Temperature pe care o setam
    private int numberOfDrinks;//Nr de bauturi
    private List<String> drinks;//Lista de bauturi
    private int foodQuantity;//Cantitatea de mancare
    private static final int restockThreshold = 10;//Folosit pentru a detecta cand avem nevoie sa realimentam
    //Constructor fara argumente
    public SmartFridge(){
        this.isPoweredOn=false;
        this.temperature=-4.0f;
        this.numberOfDrinks=0;
        this.drinks= new ArrayList<>();
        this.foodQuantity=0;
    }
    //Constructor cu argumente
    public SmartFridge(boolean isPoweredOn, float temp, int nrDrinks,List<String> drinks, int foodQuant ){
        this.isPoweredOn = isPoweredOn;
        this.temperature = temp;
        this.numberOfDrinks = nrDrinks;
        this.drinks = new ArrayList<>(drinks);
        this.foodQuantity = foodQuant;
    }
    //Constructor de copiere
    public SmartFridge(SmartFridge other) {
        this.isPoweredOn = other.isPoweredOn;
        this.temperature = other.temperature;
        this.numberOfDrinks = other.numberOfDrinks;
        this.drinks = new ArrayList<>(other.drinks);
        this.foodQuantity = other.foodQuantity;
    }
    public void powerOn()
    {
        isPoweredOn=true;
        System.out.println("Frigiderul a fost pornit");
    }
    public void powerOff(){
        isPoweredOn=false;
        System.out.println("Frigiderul a fost oprit");
    }

    //Metoda prin care setam temperatura
    public void setTemperature(float newTemp) {
        if (isPoweredOn==true) {
            temperature = newTemp;
            System.out.println("Temperatura setata la " + temperature + " grade Celsius.");
        } else {
            System.out.println("Nu putem seta temperatura. Frigiderul nu este pornit.");
        }
    }
    //Metoda prin care adugam bauturi
    public void addDrinks(List<String> newDrinks) {

        drinks.addAll(newDrinks);
        numberOfDrinks = drinks.size();
        System.out.println(newDrinks.size() + " drinks added. Total drinks: " + numberOfDrinks);

    }
    // Metoda pentru eliminarea băuturilor din frigider
    public void removeDrinks(int quantity) {
        if (isPoweredOn==true) {
            if (numberOfDrinks >= quantity) {
                numberOfDrinks -= quantity;
                System.out.println(quantity + " bauturi luate din frigider. Bauturi ramase: " + numberOfDrinks);
            } else {
                System.out.println("Nr insuficient de bauturi.Nu mai sunt bauturi in frigider");
            }
        } else {
            System.out.println("Frigiderul este oprit. Nu putem lua bauturi");
        }
    }
    //Metoda prin care vedem ce bauturi avem
    public void displayDrinks() {
        if (isPoweredOn==true) {
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
        if (isPoweredOn==true) {
            foodQuantity += quantity;
            System.out.println(quantity + " de alimente au fost introduse. Cantitate totala: " + foodQuantity);
        } else {
            System.out.println("Nu putem adauga mancare. Frigiderul nu este pornit.");
        }
    }
    // Metoda pentru eliminarea alimentelor din frigider
    public void removeFood(int quantity) {
        if (isPoweredOn==true) {
            if (foodQuantity >= quantity) {
                foodQuantity -= quantity;
                System.out.println(quantity + " unitati de mancare luate. Cantitate de mancare ramasa: " + foodQuantity);
            } else {
                System.out.println("Mancare insuficienta.Frigiderul este gol");
            }
        } else {
            System.out.println("Nu putem lua mancare. Frigiderul nu este pornit.");
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

    public int getFoodQuantity() {
        return foodQuantity;
    }

    @Override
    public String toString() {
        return String.format("Smart Fridge [Power: %b, Temp: %.1f°C, Bauturi: %d, Mancare: %d units]",
                isPoweredOn, temperature, numberOfDrinks, foodQuantity);
    }
    //Redefinirea metodei de control pentr SmartFridge
    @Override
    public void ControlSpecifiedDevice() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Alege o opțiune pentru Frigider:");
            System.out.println("1. Pornire Frigider");
            System.out.println("2. Oprire Frigider");
            System.out.println("3. Setare Temperatura");
            System.out.println("4. Adaugare Bauturi");
            System.out.println("5. Stergere Bauturi");
            System.out.println("6. Afisare Bauturi");
            System.out.println("7. Adaugare Mancare");
            System.out.println("8. Stergere Mancare");
            System.out.println("9. Verificare Stare Re-alimentare");
            System.out.println("10. Afisare Instante");
            System.out.println("11. Afisare Instante filtrate");
            System.out.println("12. Iesire");

            System.out.print("Introdu opțiunea: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    super.powerOn();
                    powerOn();
                    break;
                case "2":
                    super.powerOff();
                    powerOff();
                    break;
                case "3":
                    System.out.print("Introdu temperatura dorită: ");
                    float newTemp = scanner.nextFloat();
                    setTemperature(newTemp);
                    break;
                case "4":
                    System.out.print("Introdu numărul de băuturi noi: ");
                    int quantity = scanner.nextInt();
                    List<String> newDrinks = new ArrayList<>();
                    if(isPoweredOn==true) {// Verifica daca frigiderul este pornit
                        for (int i = 0; i < quantity; i++) {
                            System.out.print("Introdu băutura #" + (i + 1) + ": ");
                            newDrinks.add(scanner.next());
                        }
                        addDrinks(newDrinks);
                    }else System.out.println("Frigiderul este oprit, nu se pot adauga bauturi");
                    break;
                case "5":
                    System.out.print("Introdu cantitatea de băuturi de eliminat: ");
                    int quantityToRemove = scanner.nextInt();
                    removeDrinks(quantityToRemove);
                    break;
                case "6":
                    displayDrinks();
                    break;
                case "7":
                    System.out.print("Introdu cantitatea de mancare de adăugat: ");
                    int foodQuantityToAdd = scanner.nextInt();
                    addFood(foodQuantityToAdd);
                    break;
                case "8":
                    System.out.print("Introdu cantitatea de mancare de eliminat: ");
                    int foodQuantityToRemove = scanner.nextInt();
                    removeFood(foodQuantityToRemove);
                    break;
                case "9":
                    checkRestockStatus();
                    break;
                case "10":
                    displayInstances(SmartFridge.SmartFridgeInstances());
                    break;
                case"11":
                    SmartFridge.displayFilteredInstances();
                    break;
                case "12":
                    System.out.println("Iesire");
                    break;
                default:
                    System.out.println("Optiunea nu este valida");
            }

        } while (!choice.equals("12"));
    }

    public static SmartFridge[] SmartFridgeInstances() {
        SmartFridge[] fridgeInst = new SmartFridge[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            boolean power = random.nextBoolean();
            float temp = random.nextFloat() * 10 + 1;
            int nrDrinks = random.nextInt(20);
            List<String> drinks = new ArrayList<>(List.of("Coca-Cola", "Pepsi", "Sprite"));
            int foodQuant = random.nextInt(50);

            fridgeInst[i] = new SmartFridge(power, temp, nrDrinks, drinks, foodQuant);
        }

        return fridgeInst;
    }

    public static void displayFilteredInstances() {
        SmartFridge[] fridgeInstances = SmartFridgeInstances();

        System.out.println("Instantele clasei SmartFridge filtrate");
        for (SmartFridge instance : fridgeInstances) {
            if (!instance.isPoweredOn && instance.foodQuantity <= SmartFridge.restockThreshold) {
                System.out.println(instance.toString());
            }
        }
    }
}
