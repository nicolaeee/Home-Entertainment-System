package BogdanClasses;

public class SoundBarBox {
    private int Volume;
    private int Bass=30;
    private boolean isPoweredOn=false;
    private int Balance=50;

    public SoundBarBox() {
        this.Volume = 10; // setez volumul initial la 10
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

    //Metoda pentru a ajusta volumul soundbar-ului//
public void AdjustVolume(int Volume){
        if(Volume>=0&&Volume<=100) {
            this.Volume = Volume;
            System.out.println("Volumul soundbar-ului a fost setat la:" + Volume + ".");
        }
        else {
            System.out.println("Volumul soundbar-ului trebuie sa fie intre 0 si 100.");
        }
}

    //Metoda pentru a ajusta nivelul bass-ului//
    public void AdjustBass(int Bass){
        if(Bass>=0&&Bass<=100) {
            this.Bass = Bass;
            System.out.println("Volumul bass-ului a fost setat la:" + Bass + ".");
        }
        else {
            System.out.println("Volumul bass-ului trebuie sa fie intre 0 si 100.");
        }
    }

//Metoda pentru a ajusta echilibrul//
public void AdjustBalance(int Balance){
    if(Balance>=0&&Balance<=100) {
        this.Balance = Balance;
        System.out.println("Balanta a fost setata la:" + Bass + ".");
    }
    else {
        System.out.println("Balanta trebuie sa fie intre 0 si 100.");
    }
}

//Metoda pentru redarea audio//
    public void playAudio(String audio) {
        if (isPoweredOn) {
            System.out.println("SoundBar: Redare audio - " + audio);
        } else {
            System.out.println("SoundBar: Soundbar-ul este oprit. Nu se poate reda audio.");
        }
    }

//Metoda pentru mute//
    public void mute() {
        if (isPoweredOn) {
            this.Volume = 0;
            System.out.println("SoundBar: Sunetul este oprit.");
        } else {
            System.out.println("SoundBar: Nu poți opri sunetul când soundbar-ul este oprit.");
        }
    }

    //Metoda pentru a obtine volumul curent//
    public int getVolume() {
        return Volume;
    }

    //Metoda pentru a verifica daca soundbar-ul este pornit/oprit//
    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    //Metoda pentru a obtine echilibrul//
    public int getBalance() {
        return Balance;
    }

    //Metoda pentru a obtine bass-ul//
    public int getBass() {
        return Bass;
    }

    //Metoda pentru a afisa informatiile despre soundbar//
    public void infoSoundBar(){
        System.out.println("Info soundbar:");
        System.out.println("Pornit/Oprit:"+(isPoweredOn ? "Pornit":"Oprit"));
        System.out.println("Volum:"+Volume);
        System.out.println("Bass:"+Bass);
        System.out.println("Balanta:"+Balance);
    }
}
