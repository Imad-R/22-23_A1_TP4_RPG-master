package com.isep.rpg;

import java.util.Scanner;

public class Hunter extends Hero {

        public Hunter(String n, int h, int p, int df) {
                super(n, h, p, df);
                this.nb_fleche = 15;
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
                                D : Pour récupérer plein de fleche\s
                                """);

                choix1 = new Scanner(System.in);
                String choixdef = choix1.nextLine();
                if(choixdef == "A") {
                        System.out.println("La puissance de " + getName() + " ne cesse de croîre.\n");
                        degat *= 1.15;
                        System.out.println("La puissance de " + getName() + " explose.");
                } else if (choixdef == "B") {
                         defance*=1.25;
                        System.out.println("La defence de " + getName() + " à augmenter");
                }
                else if (choixdef == "C"){
                        System.out.println("Voulez vous du pain, un steak, ou un gigot ?");
                        Scanner choix2 = new Scanner(System.in);
                        String nom_nourriture = choix2.nextLine();
                        Food food1 = new Food(nom_nourriture);
                        inventaire_nourriture.add(food1);
                } else if (choixdef == "D") {
                        nb_fleche+=25;
                        System.out.println(getName()+" se voit confier 25 flêches.");
                }

        }

        @Override
        public int Action() {
                System.out.println(
                        """
                        Chasseur quelles type d'actions voulez vous faire ? :\s
                        1- Attaque\s
                        2- Ultime\s
                        3- Manger de la nourriture\s
                        4- Recharge tes fleches""");
                Scanner choix_action = new Scanner(System.in);
                int action = choix_action.nextInt();
                return action;
        }

        @Override
        public void take_wp(Weapon wp) {
                        System.out.println(getName()+" choisi comme arme "+ wp.getName());
                        degat_tot = degat + wp.getDamagePoints();
        }

        @Override
        public void fight(Combatant combatant) {
                if (nb_fleche > 0) {
                        if (combatant instanceof Ennemy) {
                                System.out.println(getName() + " lance une flêche !");
                                System.out.println(getName() + " inflige " + degat_tot + " de points de dégât à " + combatant.getName());
                                combatant.loose_hp(degat_tot-combatant.getDef());
                                loose_arrow(1);
                        } else {
                                System.out.println("Vous attaquez un allié");
                        }
                }else {
                        System.out.println("Tu n'as plus de fleche, il faut que tu recharge !!!");
                        Action();
                }
        }
        @Override
        public void Status() {
                System.out.println(getName() + " : " + getHealthPoint() + " PV  ,  " + degat_tot + " ATK  ,  " + getDef() + " DEF et a "+ nb_fleche+ " fleches");
        }

        @Override
        public void ultime(Combatant combatant) {
                if (nb_fleche<coutarr_ult){
                        System.out.println(getName()+" n'a pas assez de flêche pour l'ultime recharge tes flêche");
                        Action();
                } else {
                        System.out.println(getName() + " lance son ultime : Gatling Arrow !");
                        System.out.println(getName() + " inflige " + degat_tot*coutarr_ult + " de points de dégât à " + combatant.getName());
                        combatant.loose_hp((degat_tot*coutarr_ult)-combatant.getDef());
                        loose_arrow(coutarr_ult);
                }
        }

        public  int getNombre_flêche(){return nb_fleche;}
        public void loose_arrow(int nb_fleche){ this.nb_fleche -= nb_fleche;}

        public void gain_arrow(int nb_fleche){ this.nb_fleche +=nb_fleche;}
        private int defance = getDef();
        private int nb_fleche;
        private int coutarr_ult = 10;


}