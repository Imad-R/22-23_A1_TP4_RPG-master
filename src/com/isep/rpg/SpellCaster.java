package com.isep.rpg;

import java.util.Scanner;

public abstract class SpellCaster extends Hero{

    private int mana;

    public SpellCaster(String n, int h, int p, int df, int m) {
        super(n, h, p, df);
        mana = m;
    }
    public int Action(){
        System.out.println(
                """
                Mage quelles type d'actions voulez vous faire ? :\s
                1- Attaque\s
                2- Ultime\s
                3- Manger de la nourriture\s
                4- Boire une potion\s
                5- Faire un sort\s
                6- Recharger son mana""");

        Scanner choix_action = new Scanner(System.in);
        int action = choix_action.nextInt();
        return action;
    }
    public void Shield(Hero combatant){
        if(getMana()<coutSort_shield){
            System.out.println(getName() + " n'a plus assez de mana pour faire ce sort, ");
            combatant.Action();
        }else {
            System.out.println(getName()+ " fais gagner 15 points de défenses aux alliés à l'aide de son sort Shield.");
            combatant.gain_def(15);
            loose_mana(coutSort_shield);
        }
    }
    @Override
    public void take_wp(Weapon wp) {
        System.out.println(getName()+" choisi comme arme un "+ wp.getName());
        degat_total_mage += wp.getDamagePoints();
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
                        
                        A : Pour augmenter le mana\s
                        B : Pour augmenter la défence\s
                        C : Pour avoir plus de nourriture\s
                        D : Pour avoir plus de potions\s
                        E : Réduire le cout en mana de tes sorts\s
                        """);

        choix1 = new Scanner(System.in);
        String choixdef = choix1.nextLine();
        if(choixdef == "A") {
            System.out.println("Le mana de " + getName() + " augmente.\n");
            degat_mage *= 1.15;
        } else if (choixdef == "B") {
            defence *=1.25;
            System.out.println("La defence de " + getName() + " à augmenter");
        }
        else if (choixdef == "C"){
            System.out.println("Voulez vous du pain, un steak, ou un gigot ?");
            Scanner choix2 = new Scanner(System.in);
            String nom_nourriture = choix2.nextLine();
            Food food1 = new Food(nom_nourriture);
            inventaire_nourriture.add(food1);
        }
        else if (choixdef == "D"){
            System.out.println("Voulez vous une mini potion, une potion, ou une maxi potion ?");
            Scanner choix3 = new Scanner(System.in);
            String nom_potion = choix3.nextLine();
            Potion potions1 = new Potion(nom_potion);
            inventaire_potion.add(potions1);
        }
        else if (choixdef == "E"){
            coutSort_shield-=2;
            coutSort_rage-=2;
            coutSort_ult-=4;
            System.out.println("Les sorts sont moins chères en mana dèsormais.");
        }


    }

    @Override
    public void Status() {
        System.out.println(getName() + " : " + getHealthPoint() + " PV  ,  " + degat_total_mage + " ATK  ,  " + getDef() + " DEF ,"+ getMana() + " MANA ");
    }
    public void loose_mana(int mn){
        mana -= mn;
    }

    public int getMana(){return mana;}

    public void gain_mana(int mn) {mana += mn;}

    public int setMana(int magi) {return mana = magi;}

    protected int degat_mage = getPower();
    protected int degat_total_mage = degat_mage;
    protected int degatSpecial;


    protected Weapon weapon;

    protected  int defence = getDef();
    public int coutSort_ult = 28;
    public int coutSort_rage = 12;
    public int coutSort_shield = 12;
    public int coutSort_soins = 12;

}
