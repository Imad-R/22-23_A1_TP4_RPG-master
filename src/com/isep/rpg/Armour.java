package com.isep.rpg;

public class Armour extends Item{

    private int shield;

    public Armour(String name, int Shield) {
        super(name);
        this.shield = Shield;
    }

    public int getShield() {
        return shield;
    }

}
