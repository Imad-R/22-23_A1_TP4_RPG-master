package com.isep.rpg;

public class Ennemy extends Combatant {

    public Ennemy(String n, int h, int p, int r, int df) {
        super(n, h, p, df);
        rage = r;
    }



    // Les points de dégats sont intégrés aux ennemis (ils n'ont pas d'arme)
    @Override
    public void fight(Combatant combatant) {
            System.out.println(getName() + " lance son attaque !");
            System.out.println(getName() + " inflige " + degat_tot + " de points de dégât à " + combatant.getName());
            combatant.loose_hp(degat_tot -combatant.getDef());

    }

    @Override
    public void Status() {
        System.out.println(getName() + " : " + getHealthPoint() + " PV  ,  " + degat_tot + " ATK  ,  " + getDef() + " DEF");
    }

    public int getRage(){return rage;}
    public void gain_rage(int r){
        rage+=r;

    }


    private int degat = getPower() ;
    private int degat_tot = degat + getRage();
    private int rage = 0;




}
