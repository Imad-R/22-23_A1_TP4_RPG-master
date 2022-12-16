package com.isep.rpg;

import java.util.Scanner;

public class Warrior extends Hero {


    public Warrior(String n, int h, int p, int df) {
            super(n, h, p, df);
    }

    @Override
    public void take_wp(Weapon wp) {
        System.out.println(getName()+" choisi comme arme un "+ wp.getName());
        degat_tot += wp.getDamagePoints();
    }


    @Override
    public void ultime(Combatant combatant) {
        if (combatant instanceof Ennemy) {
            degat_spe = (int) (degat * 1.5) + weapon.getDamagePoints();
            System.out.println(getName() + " lance son attaque spéciale PLUS ULTRAAAAA !!!");
            System.out.println(getName() + " inflige " + degat_spe + " points de dégât à " + combatant.getName());
            combatant.loose_hp(degat_spe - combatant.getDef());
        }
        else{
            System.out.println("Vous attaquez un allié !!!");
        }
    }

    // Implémentation de la méthode abstraite "fight" par le guerrier
    @Override
    public void fight(Combatant combatant) {

        if (combatant instanceof Ennemy) {
            System.out.println(getName() + " lance une attaque !");
            System.out.println(getName() + " inflige " + degat_tot + " de points de dégât à " + combatant.getName());
            combatant.loose_hp(degat_tot -combatant.getDef());
        }
        else {
            System.out.println("Vous attaquez un allié");
            Action();
        }
    }

    @Override
    public int Action() {
        System.out.println(
                """
                Choisissez une action Guerrier :\s
                1- Attaque\s
                2- Ultime\s
                3- Manger de la nourriture""");

        Scanner choix_action = new Scanner(System.in);
        int action = choix_action.nextInt();
        return action;

    }


    @Override
    public void Status() {
        System.out.println(getName() + " : " + getHealthPoint() + " PV  ,  " + degat_tot + " ATK  ,  " + getDef() + " DEF");
    }
    @Override
    public void CapacityUp() {
        System.out.println("Maintenant que le combat est gagné veuillez choisir la récompense de "+ getName());
        Delay();
        Status();
        Scanner choix1;
        System.out.println(
                """
                        Veuillez saisir :\s
                        
                        A : Pour augmenter les dégats\s
                        B : Pour augmenter la défence\s
                        C : Pour avoir plus de nourriture\s
                        """);

        choix1 = new Scanner(System.in);
        String choixdef = choix1.nextLine();
            if(choixdef == "A") {
                System.out.println("La puissance de " + getName() + " ne cesse de croîre.\n");
                degat *= 1.15;
                System.out.println("La puissance de " + getName() + " explose.");
            } else if (choixdef == "B") {
                defance *=1.25;
                System.out.println("La defence de " + getName() + " à augmenter");
            }
            else if (choixdef == "C"){
                System.out.println("Voulez vous du pain, un steak, ou un gigot ?");
                Scanner choix2 = new Scanner(System.in);
                String nom_nourriture = choix2.nextLine();
                Food food_bonus = new Food(nom_nourriture);
                inventaire_nourriture.add(food_bonus);
        }
    }

    private int defance = getDef();
    private Weapon weapon;
    private int degat_spe;


}
