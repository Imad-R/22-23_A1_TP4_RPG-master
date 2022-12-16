package com.isep.rpg;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Combatant {


    public Hero(String n, int h, int p, int df) {
        super(n, h, p, df);
    }


    // Abstrait car n'importe quel hero peut prendre un objet mais son
    // utilisation dépend du type du héro (une arme n'est pas utile à un mage)

    public void wear_armure(Armour protection) {
        System.out.println(getName()+ " à porté un "+protection.getName()+ " sa défense a donc augmenter");
        gain_def(protection.getShield());
    }

    public void take_food(Food food) {}
    public void take_wp(Weapon arme) {
        System.out.println(getName()+" choisi comme arme un "+ arme.getName());
        degat_tot += arme.getDamagePoints();
    }
    public void take_potion(Potion potion) {}


    public abstract void CapacityUp();
    public abstract int Action();

    public abstract void ultime(Combatant combatant);


    public static void Delay() {
        System.out.println("\n" +
                "v       PRESS ENTER TO SKIP");
        Scanner scan = new Scanner(System.in);
        String delay = scan.nextLine();
    }

    private int defance = getDef();
    private int def_tot;
    protected ArrayList<Food> inventaire_nourriture = new ArrayList<>();
    protected ArrayList<Potion> inventaire_potion = new ArrayList<>();

    protected Food food;
    protected Potion potion;
    protected Armour protection;
    protected int degat=getPower();
    protected int degat_tot = degat;

}
