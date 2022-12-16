package com.isep.rpg;

import java.util.Scanner;

public class Mage extends SpellCaster{

    public Mage(String n, int h, int p,int df,int m) {
        super(n, h, p, df, m);
    }

    public void Rage(Hero combatant){
        if(getMana()<coutSort_rage){
            System.out.println(getName() + " n'a plus assez de mana pour faire ce sort, " + getName() + ". Recharge ton mana !!!");
            Action();
        }else {
            System.out.println(getName()+ " utilise son sort de rage sur "+ combatant.getName() + "et ainsi ils obtiennent 20 DMG en plus !!!");
            combatant.gain_power(20);
            loose_mana(coutSort_rage);
        }
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
            System.out.println(getName() + " n'a plus assez de mana pour faire ce sort, " + getName() + " retourne médité pendant ce tour et reçoit +5 Mana");
            gain_mana(5);
            Action();
        }else{
            System.out.println(getName() + " lance son sort ultime le kamehameha!");
            degatSpecial = degat_total_mage*2;
            System.out.println(getName() + " inflige " + degatSpecial + " points de dégât à " + combatant.getName());
            combatant.loose_hp(degatSpecial-combatant.getDef());
            loose_mana(coutSort_ult);
            System.out.println("Il reste " + getMana() + " Mana à " + getName());
        }

    }







}

