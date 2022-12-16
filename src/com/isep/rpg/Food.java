package com.isep.rpg;

public class Food extends Consumable{

    private int hp_pain = 10;
    private int hp_steak = 20;
    private int hp_gigot = 30;

    private String name_food = getName();

    public Food(String name) {
        super(name);
    }
        public void usePain (Hero combatant){
        System.out.println(combatant.getName() + " mange du pain  et récupère " + hp_pain + " PV. Sahite");
        combatant.gain_hp(hp_pain);
        System.out.println(combatant.getName()+" à mangé du pain");
    }

        public void useSteak (Hero combattant){
            System.out.print(combattant.getName() + " mange du pain  et récupère " + hp_steak + " PV. Sahite");
            combattant.gain_hp(hp_steak);
            System.out.println(combattant.getName()+" à mangé du steak");
        }

        public void useGigot (Hero combattant){

            System.out.println(combattant.getName() + " mange du pain  et récupère " + hp_gigot + " PV. Sahite");
            combattant.gain_hp(hp_gigot);
            System.out.println(combattant.getName()+" à mangé un gigot");

        }


}

