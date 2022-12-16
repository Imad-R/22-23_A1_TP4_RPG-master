package com.isep.rpg;

import java.util.Scanner;

public class Potion extends Consumable {
    private int ptmana_MiniPotion = 10;
    private int ptmana_Potion = 15;
    private int ptmana_MaxiPotion = 20;

    //private String nom_potion = getName();
    public Potion(String name) {
        super(name);
    }


    public void useMiniPotion(SpellCaster mage) {
        System.out.println(mage.getName() + " utilise une mini Potion et récupère 10 de mana");
        mage.gain_mana(ptmana_MiniPotion);
    }

    public void usePotion(SpellCaster mage) {
        System.out.println(mage.getName() + " utilise une Potion et récupère 15 de mana");
        mage.gain_mana(ptmana_Potion);
    }

    public void useMaxiPotion(SpellCaster mage) {
        System.out.println(mage.getName() + " utilise une maxi Potion et récupère 20 mana");
        mage.gain_mana(ptmana_MaxiPotion);
    }



}