package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private InputParser inputParser;

    private List<Hero> heros;
    private List<Ennemy> enemies;


    public Game(InputParser inputParser) {

        this.inputParser = inputParser;

        // Il faut normalement 5 héros de types différents...
        heros = new ArrayList<>();
        enemies = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int nbrHero;
        do {
            System.out.println("Avec combien de héros voulez vous partir a l'aventure? : ");
            nbrHero = sc.nextInt();
            // Si l'utilisateur a choisi un nombre qui n'est pas entre 1 et 4,
            // on affiche un message d'erreur et on recommence la boucle
            if (nbrHero < 1 || nbrHero > 4) {
                System.out.println("Vous ne pouvez avoir qu'1 a 4 héros maximum !");
            }
        } while (nbrHero < 1 || nbrHero > 4);

        Scanner sc2 = new Scanner(System.in);

        for (int i = 0; i < nbrHero; i++) {//cette boucle de test va juste nous permettre de donner un nom et des pv aux guerriers
            System.out.println("Hero n°" + (i + 1) + " - Quel Héros souhaitez vous ajouter a votre équipe? :\n- Warrior\n- Hunter\n- Mage\n- Healer\n");
            String typeHero = sc2.nextLine();
            switch (typeHero.toLowerCase()) {
                case "warrior":

                    System.out.println("Quelle est son nom ? : ");
                    String name = sc2.nextLine();

                    Warrior combatant_Warrior = new Warrior(name, 100, 85, 55);
                    Weapon arme_warrior = new Weapon("Sword", 25);
                    Armour protection_warrior = new Armour("Silver Chest", 30);

                    // On équipe le warrior
                    combatant_Warrior.take_wp(arme_warrior);
                    combatant_Warrior.wear_armure(protection_warrior);

                    System.out.println(combatant_Warrior.getName() + " rejoint l'aventure\n Son arme fait "
                            + arme_warrior.getDamagePoints() + " DMG" +
                            "\nEt son armure possèe " + protection_warrior.getShield() + " DEF\n");
                    heros.add(combatant_Warrior);
                    break;

                case "hunter":
                    System.out.println("Quelle est son nom ? : ");
                    name = sc2.nextLine();

                    Hunter combatant_Hunter = new Hunter(name, 125, 60, 50);
                    Weapon arme_hunter = new Weapon("Arc", 15);
                    Armour protection_hunter = new Armour("Copper Chest", 25);

                    combatant_Hunter.take_wp(arme_hunter);
                    combatant_Hunter.wear_armure(protection_hunter);

                    System.out.println(combatant_Hunter.getName() + " rejoint l'aventure\nSon arme fait "
                            + arme_hunter.getDamagePoints() + " DMG" +
                            "\nEt son armure possède " + protection_hunter.getShield() + " DEF\n");
                    heros.add(combatant_Hunter);
                    break;

                case "mage":
                    System.out.println("Quelle est son nom ? : ");
                    name = sc2.nextLine();

                    Mage combatant_mage = new Mage(name, 150, 35, 40, 40);
                    Weapon arme_mage = new Weapon("Sceptre", 15);
                    Armour protection_mage = new Armour("Magic Chest", 20);

                    combatant_mage.take_wp(arme_mage);
                    combatant_mage.wear_armure(protection_mage);

                    System.out.println(combatant_mage.getName() + " rejoint l'aventure\n Son arme fait "
                             + arme_mage.getDamagePoints() + " DMG" +
                            "\nEt son armure a " + protection_mage.getShield() + " DEF\n");
                    heros.add(combatant_mage);

                    break;
                case "healer":
                    System.out.println("Quelles est son nom? : ");
                    name = sc2.nextLine();

                    Healer combatant_healer = new Healer(name, 200, 35, 30, 90);
                    Weapon arme_healer = new Weapon("Regenartion Scepter", 15);
                    Armour protection_healer = new Armour("Magic Chest", 20);

                    combatant_healer.take_wp(arme_healer);
                    combatant_healer.wear_armure(protection_healer);

                    System.out.println(combatant_healer.getName() + " rejoint l'aventure\nSon arme fait "
                            + arme_healer.getDamagePoints() + " DMG" +
                            "\nEt son armure a " + protection_healer.getShield() + " DEF\n");
                    heros.add(combatant_healer);
                    break;

                default:
                    System.out.println("Ce n'est pas un type de héros ");
                    i -= 1;//on recommence l'itérarion de la boucle.
            }


            Ennemy orochi = new Ennemy("Orochie le roi des monstres", 290, 170, 0, 80);
            Ennemy psychos = new Ennemy("Psychos le telekinésiste suprême", 250, 130, 0, 60);
            Ennemy platinium = new Ennemy("Platinium Sperme", 235, 150, 0, 70);
            Ennemy rex = new Ennemy("Rex le chien des enfers", 210, 110, 0, 75);
            Ennemy nyan = new Ennemy("Nyan le chat démoniaque", 200, 100, 0, 45);

            enemies.add(nyan);
            enemies.add(rex);
            enemies.add(platinium);
            enemies.add(psychos);
            enemies.add(orochi);

        }}


        public void start () {

            int ixHero = 0;
            int tour = 0;

            // Boucle de jeu
            while (true) {

                Hero goodOne = heros.get(ixHero);

                Ennemy badOne = enemies.get(0);

                goodOne.Status();
                badOne.Status();
                badOne.fight(goodOne);
                goodOne.Status();

                if (goodOne.getHealthPoint() <= 0) {
                    displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");
                    heros.remove(ixHero);
                    ixHero--;
                } else {
                    //displayStatus(heros, enemies);

                    // Attaque de l'ennemi

                    //-----------------------------------------
                    if (goodOne instanceof Warrior) {
                        int action_warrior = goodOne.Action();

                        ArrayList<Food> nourriture_hero = goodOne.inventaire_nourriture;
                        Food pain = new Food("Pain");
                        Food steak = new Food("Steak");
                        Food gigot = new Food("Gigot");

                        nourriture_hero.add(pain);
                        nourriture_hero.add(steak);
                        nourriture_hero.add(gigot);

                        if (action_warrior == 1) {
                            // Riposte du warrior
                            displayMessage("Le guerrier " + goodOne.getName() + " attaque l'ennemie " + badOne.getName() + "...");
                            goodOne.fight(badOne);
                            badOne.Status();
                        } else if (action_warrior == 2) {
                            if (tour == 2) {
                                // Riposte du warrior avec son attaque ultime
                                displayMessage("Le guerrier " + goodOne.getName() + " lance son attaque spéciale sur " + badOne.getName() + "...");
                                goodOne.ultime(badOne);
                                badOne.Status();
                            }else {
                                displayMessage("Les conditions ne sont pas rempli pour faire l'attaque spéciale. Il faut que 2 tours soit passé !");
                                goodOne.Action();
                            }
                        } else if (action_warrior == 3) {
                            if (nourriture_hero.size() == 0) {
                                System.out.println("Vous n'avez plus de nourriture");
                                goodOne.Action();
                            } else {
                                System.out.println("Voulez vous du pain, un steak ou un gigot ?");
                                Scanner choix_nourriture = new Scanner(System.in);
                                String nom_food = choix_nourriture.nextLine();
                                if (nom_food.toLowerCase() == "pain") {
                                    pain.usePain(goodOne);
                                    goodOne.Status();
                                    nourriture_hero.remove(pain);
                                } else if (nom_food.toLowerCase() == "steak") {
                                    steak.useSteak(goodOne);
                                    goodOne.Status();
                                    nourriture_hero.remove(steak);
                                } else if (nom_food.toLowerCase() == "gigot") {
                                    gigot.useGigot(goodOne);
                                    goodOne.Status();
                                    nourriture_hero.remove(gigot);
                                }

                            }
                        }
                    }
                    //-----------
                    else if (goodOne instanceof Hunter) {
                        int action_hunter = goodOne.Action();
                        goodOne.Status();
                        ArrayList<Food> nourriture_hunter = goodOne.inventaire_nourriture;


                        Food pain = new Food("Pain");
                        Food steak = new Food("Steak");
                        Food gigot = new Food("Gigot");

                        nourriture_hunter.add(pain);
                        nourriture_hunter.add(steak);
                        nourriture_hunter.add(gigot);

                        if (action_hunter == 1) {
                            // Riposte du warrior
                            displayMessage("Le hunter " + goodOne.getName() + " attaque l'ennemie " + badOne.getName() + "...");
                            goodOne.fight(badOne);
                            badOne.Status();
                        } else if (action_hunter == 2) {

                            if ( tour == 2){
                            // Riposte du warrior avec son attaque ultime
                            displayMessage("Le hunter " + goodOne.getName() + " lance son attaque spéciale sur " + badOne.getName() + "...");
                            goodOne.ultime(badOne);
                            badOne.Status();
                            }
                            else {
                                displayMessage("Les conditions ne sont pas rempli pour faire l'attaque spéciale. Il faut que 2 tours soit passé !");
                                goodOne.Action();
                            }
                        } else if (action_hunter == 3) {
                            if (nourriture_hunter.size() == 0) {
                                System.out.println("Vous n'avez plus de nourriture");
                                goodOne.Action();
                            } else {
                                System.out.println("Voulez vous du pain, un steak ou un gigot ?");
                                Scanner choix_nourriture = new Scanner(System.in);
                                String nom_food = choix_nourriture.nextLine();
                                if (nom_food.toLowerCase() == "pain") {
                                    pain.usePain(goodOne);
                                    goodOne.Status();
                                    nourriture_hunter.remove(pain);
                                } else if (nom_food.toLowerCase() == "steak") {
                                    steak.useSteak(goodOne);
                                    goodOne.Status();
                                    nourriture_hunter.remove(steak);
                                } else if (nom_food.toLowerCase() == "gigot") {
                                    gigot.useGigot(goodOne);
                                    goodOne.Status();
                                    nourriture_hunter.remove(gigot);
                                }

                            }
                        } else if (action_hunter == 4) {
                            displayMessage(goodOne.getName()+ " recharge ses flêches.");
                            ((Hunter) goodOne).gain_arrow(10);
                        }
                    }
                    else if (goodOne instanceof Mage) {

                        int action_mage = goodOne.Action();
                        //-----------
                        goodOne.Status();

                        ArrayList<Food> nourriture_mage = goodOne.inventaire_nourriture;

                        Food pain = new Food("Pain");
                        Food steak = new Food("Steak");
                        Food gigot = new Food("Gigot");

                        nourriture_mage.add(pain);
                        nourriture_mage.add(steak);
                        nourriture_mage.add(gigot);

                        ArrayList<Potion> potions_mage = goodOne.inventaire_potion;

                        Potion mini_potion = new Potion("Mini potion");
                        Potion potion = new Potion("Potion");
                        Potion maxi_potion = new Potion("Maxi potion");

                        potions_mage.add(mini_potion);
                        potions_mage.add(potion);
                        potions_mage.add(maxi_potion);

                        if (action_mage == 1) {
                            // Riposte du warrior
                            displayMessage("Le mage " + goodOne.getName() + " attaque l'ennemie " + badOne.getName() + "...");
                            goodOne.fight(badOne);
                            badOne.Status();
                        } else if (action_mage == 2) {
                            // Riposte du warrior avec son attaque ultime
                            if (tour == 2){
                                displayMessage("Le mage " + goodOne.getName() + " lance son attaque spéciale sur " + badOne.getName() + "...");
                                goodOne.ultime(badOne);
                                badOne.Status();
                            } else {
                                displayMessage("Les conditions ne sont pas rempli");
                                goodOne.Action();
                            }

                        } else if (action_mage == 3) {
                            if (nourriture_mage.size() == 0) {
                                System.out.println("Vous n'avez plus de nourriture");
                            } else {
                                System.out.println("Voulez vous du pain, un steak ou un gigot ?");
                                Scanner choix_nourriture = new Scanner(System.in);
                                String nom_food = choix_nourriture.nextLine();
                                if (nom_food.toLowerCase() == "pain") {
                                    pain.usePain(goodOne);
                                    goodOne.Status();
                                    nourriture_mage.remove(pain);
                                } else if (nom_food.toLowerCase() == "steak") {
                                    steak.useSteak(goodOne);
                                    goodOne.Status();
                                    nourriture_mage.remove(steak);
                                } else if (nom_food.toLowerCase() == "gigot") {
                                    gigot.useGigot(goodOne);
                                    goodOne.Status();
                                    nourriture_mage.remove(gigot);
                                }

                            }
                        } else if (action_mage == 4) {
                            if (potions_mage.size() == 0) {
                                System.out.println("Vous n'avez plus de potion");
                            } else {
                                System.out.println("Voulez vous une mini potion, une potion ou une maxi potion ?");
                                Scanner choix_potion = new Scanner(System.in);
                                String nom_potion = choix_potion.nextLine();
                                if (nom_potion.toLowerCase() == "mini potion") {
                                    mini_potion.useMiniPotion((SpellCaster) goodOne);
                                    goodOne.Status();
                                    potions_mage.remove(mini_potion);
                                } else if (nom_potion.toLowerCase() == "potion") {
                                    potion.usePotion((SpellCaster) goodOne);
                                    goodOne.Status();
                                    potions_mage.remove(potion);
                                } else if (nom_potion.toLowerCase() == "maxi potion") {
                                    maxi_potion.useMaxiPotion((SpellCaster) goodOne);
                                    goodOne.Status();
                                    potions_mage.remove(maxi_potion);
                                }

                            }
                        } else if (action_mage == 5) {
                            System.out.println("""
                                    Quelle sort voulez faire ? Tapez :\s
                                    1 - Sort de rage\s
                                    2 - Sort de défense
                                    """);

                            Scanner choix_sort = new Scanner(System.in);
                            int sort = choix_sort.nextInt();
                            if (sort == 1)
                            {
                                for(int i=0;i<heros.size();i++)
                                {
                                    if(i != ixHero)
                                        ((Mage) goodOne).Rage(heros.get(i));
                                        heros.get(i).Status();
                                }

                            } else if (sort == 2)
                            {
                                for(int i=0;i<heros.size();i++)
                                {
                                    if(i != ixHero)
                                        ((Mage) goodOne).Shield(heros.get(i));
                                        heros.get(i).Status();
                                }
                            }
                        }
                        else if(action_mage==6){
                            System.out.println(goodOne.getName()+" recharge son mana.");
                            ((SpellCaster) goodOne).gain_mana(15);
                            goodOne.Status();
                        }

                    }
                    else if (goodOne instanceof Healer) {
                        int action_healer = goodOne.Action();
                        //-----------
                        goodOne.Status();

                        ArrayList<Food> nourriture_healer = goodOne.inventaire_nourriture;

                        Food pain = new Food("Pain");
                        Food steak = new Food("Steak");
                        Food gigot = new Food("Gigot");

                        nourriture_healer.add(pain);
                        nourriture_healer.add(steak);
                        nourriture_healer.add(gigot);

                        ArrayList<Potion> potions_healer = goodOne.inventaire_potion;

                        Potion mini_potion = new Potion("Mini potion");
                        Potion potion = new Potion("Potion");
                        Potion maxi_potion = new Potion("Maxi potion");

                        potions_healer.add(mini_potion);
                        potions_healer.add(potion);
                        potions_healer.add(maxi_potion);

                        if (action_healer == 1) {
                            // Riposte du warrior
                            displayMessage("Le healer " + goodOne.getName() + " attaque l'ennemie " + badOne.getName() + "...");
                            goodOne.fight(badOne);

                        } else if (action_healer == 2 & tour == 3) {
                            // Riposte du warrior avec son attaque ultime
                            displayMessage("Le healer " + goodOne.getName() + " utilise son sort ultime de soins sur toute l'équipe ");
                            if(tour == 2){
                            for(int i=0;i<heros.size();i++)
                            {
                                if(i != ixHero)
                                    goodOne.ultime(heros.get(i));
                            }
                            }else {
                                    displayMessage("Les conditions ne sont pas rempli pour faire l'attaque spéciale. Il faut que 2 tours soit passé !");
                                    goodOne.Action();
                            }
                        } else if (action_healer == 3) {
                            if (nourriture_healer.size() == 0) {
                                System.out.println("Vous n'avez plus de nourriture");
                            } else {
                                System.out.println("Voulez vous du pain, un steak ou un gigot ?");
                                Scanner choix_nourriture = new Scanner(System.in);
                                String nom_food = choix_nourriture.nextLine();
                                if (nom_food.toLowerCase() == "pain") {
                                    pain.usePain(goodOne);
                                    nourriture_healer.remove(pain);
                                } else if (nom_food.toLowerCase() == "steak") {
                                    steak.useSteak(goodOne);
                                    nourriture_healer.remove(steak);
                                } else if (nom_food.toLowerCase() == "gigot") {
                                    gigot.useGigot(goodOne);
                                    nourriture_healer.remove(gigot);
                                }

                            }
                        } else if (action_healer == 4) {
                            if (potions_healer.size() == 0) {
                                System.out.println("Vous n'avez plus de potion");
                            } else {
                                System.out.println("Voulez vous une mini potion, une potion ou une maxi potion ?");
                                Scanner choix_potion = new Scanner(System.in);
                                String nom_potion = choix_potion.nextLine();
                                if (nom_potion.toLowerCase() == "mini potion") {
                                    mini_potion.useMiniPotion((SpellCaster) goodOne);
                                    potions_healer.remove(mini_potion);
                                } else if (nom_potion.toLowerCase() == "potion") {
                                    potion.usePotion((SpellCaster) goodOne);
                                    potions_healer.remove(potion);
                                } else if (nom_potion.toLowerCase() == "maxi potion") {
                                    maxi_potion.useMaxiPotion((SpellCaster) goodOne);
                                    potions_healer.remove(maxi_potion);
                                }

                            }
                        } else if (action_healer == 5) {
                            System.out.println("""
                                    Quelle sort voulez faire ? Tapez :\s
                                    1 - Sort de soins\s
                                    2 - Sort de défense
                                    """);

                            Scanner choix_sort = new Scanner(System.in);
                            int sort;
                            sort = choix_sort.nextInt();
                            if (sort == 1) {
                                for(int i=0;i<heros.size();i++)
                                {
                                    if(i != ixHero)
                                        ((Healer) goodOne).health(heros.get(i));
                                        heros.get(i).Status();
                                }
                                System.out.println("Le healer à lancé sont sort de soins sur tout les alliés !");
                            }
                            else if (sort == 2) {
                                for(int i=0;i<heros.size();i++)
                                {
                                    if(i != ixHero)
                                        ((Healer) goodOne).Shield(heros.get(i));
                                        heros.get(i).Status();
                                }
                            System.out.println("Le healer à lancé sont sort de défense sur tout les alliés !");
                            }
                        }
                        else if(action_healer==6){
                            System.out.println(goodOne.getName()+" recharge son mana.");
                            ((SpellCaster) goodOne).gain_mana(15);
                            goodOne.Status();
                        }


                    }
                }

                if (badOne.getHealthPoint() <= 0) {
                    displayMessage("Bravo, " + goodOne.getName() + " a vaincu " + badOne.getName() + " !!!");
                    enemies.remove(0);
                    for (Hero h : heros){
                        h.CapacityUp();
                        h.Status();
                    }
                }


                // Tests de fin du jeu
                if (heros.size() == 0) {
                    displayMessage("Les héros ont perdu, c'est la fin du monde...");
                    break;
                }
                if (enemies.size() == 0) {
                    displayMessage("BRAVO, les héros ont gagné, le monde est sauvé !!!");
                    break;
                }

                // Au tour du héro suivant
                ixHero = (ixHero + 1) % heros.size();

            }
            tour += 1;
        }

        // Méthodes d'affichage
        // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
        //
        // => pourraient éventuellement être déplacées dans le package
        //    "com.isep.utils", en s'inspirant de "InputParser" (méthodes de saisie)

        public static void displayStatus (List<Hero> heros, List<Ennemy> enemies){
            System.out.println("#########################");
            for (Hero c : heros) {
                c.Status();
            }
            System.out.println();
            for (Ennemy e : enemies) {
                e.Status();
            }
        }


    private void displayMessage(String s) {
        System.out.println(s);
    }

}
