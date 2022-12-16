package com.isep.rpg;

import java.util.Scanner;

public class Healer extends SpellCaster{

    public Healer(String n, int h, int p, int m, int df) {
        super(n, h, p, m, df);
    }



    public void health(Hero combatant){
        if(getMana()<coutSort_soins){
            System.out.println(getName() + " n'a plus assez de mana pour faire ce sort, " + getName() + " retourne recharger ton mana \n");
            Action();
        }else {
            combatant.gain_hp(20);
        }
        loose_mana(coutSort_soins);
    }

    @Override
    public void fight(Combatant combatant) {
        if (combatant instanceof Ennemy){
            System.out.println(getName() + " lance une attaque !");
            System.out.println(getName() + " inflige " + degat_total_mage + " points de dégât à " + combatant.getName());
            combatant.loose_hp(degat_total_mage-combatant.getDef());
        }
        else if (combatant instanceof Hero){
            System.out.println("Tu t'attaque à ta propre race mon frère ???");
            Action();
        }
    }

    @Override
    public void ultime(Combatant combatant) {
        if (getMana() < coutSort_ult){
            System.out.println(getName() + " n'a plus assez de mana pour faire ce sort, " + getName() + " retourne recharger ton mana");
            Action();
        }else{
            System.out.println(getName() + " lance son sort ultime de soin!");
            if (combatant instanceof Ennemy){
                System.out.println("On ne soigne pas l'ennemi !!");
            } else {
                System.out.println(getName() + " soigne " + 25 + " HP à " + combatant.getName());
                combatant.gain_hp(25);
                loose_mana(coutSort_ult);
                System.out.println("Il reste " + getMana() + " Mana à " + getName());
            }
        }
    }




}
