package com.isep.rpg;

public abstract class Combatant {

    public Combatant(String n, int h, int p, int df) {
        name = n;
        healthPoint = h;
        power = p;
        defence = df;
    }

    // Methode get
    public int getPower(){
        return power;
    }
    public String getName() {return name;}
    public int getHealthPoint() {
        return healthPoint;
    }
    public int getDef(){return defence;}
    //---------------------------------------------------------------------------------------------------------
    // Fonction set
    public int setPower(int pow){return power = pow;}
    public int setHealth(int hp){return healthPoint = hp;}
    public int setDefence(int df){return defence = df;}

    //---------------------------------------------------------------------------------------------------------
    // Fonctions loose
    public void loose_hp(int hp) {healthPoint -= hp;}
    public void loose_power(int pow){
        power-=pow;
    }
    public void loose_def(int def) { defence -= def;}

    // Fonction gain
    public void gain_hp(int hp) {healthPoint += hp;}
    public void gain_power(int pow){
        power+=pow;
    }
    public void gain_def(int df){ defence+=df;}
//------------------------------------------------------------------------------------------------------------------------
    // Chaque "vrai" combatant (non "abstract") implémente un code différent
    // pour la méthode "fight"

    public abstract void fight(Combatant combatant);
    public abstract void Status();


    // Initialisation de variable

    private String name;
    private int healthPoint;
    private int power;

    private int defence;

    public void displayMessage(String s) {
    }
}
