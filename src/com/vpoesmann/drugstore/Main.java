/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore;

import com.vpoesmann.drugstore.consumable.Consumable;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author sogeking
 */
public class Main {
    
    private static final String menuMsg = "Tapez un nombre pour choisir une option";
    private static final String shopMsg = "Tapez un nombre pour acheter un item";
    private static final String inventoryMsg = "Tapez un nombre pour consommer un item";
    private static final String turnMsg = "Fin d'une dure journée de travail";

    public static Scanner sc;
    
    public static void main(String[] args) {
        Customer c = new Customer();
        Shop s = new Shop();
        
        sc = new Scanner(System.in);
        
        boolean left = false;
        
        while(!left && !c.isDead()) {
            
            printStatus(c);
            printMenu();
            
            int choix;
            
            try {
                choix = askForNumber(1, 4);
            } catch (BadChoiceException e) {
                System.out.println("Choix non reconnu");
                continue;
            }
            
            switch(choix) {
                case 1:
                    printShop(s, c);
                    try {
                        choix = askForNumber(1, s.getItemsSize());
                    } catch (BadChoiceException e) {
                        System.out.println("Choix non reconnu");
                        continue;
                    }
                    s.buy(choix - 1, c);
                    break;
                case 2:
                    printInventory(c);
                    try {
                        choix = askForNumber(1, c.getInventorySize());
                    } catch (BadChoiceException e) {
                        System.out.println("Choix non reconnu");
                        continue;
                    }
                    c.useItem(choix - 1);
                    break;
                case 3:
                    c.nextTurn();
                    break;
                case 4:
                    left = true;
            }
        }
        
        if (c.isDead()) {
            System.out.println("Le client est mort, fin de la simulation !");
        }
    }
    
    public static void printMenu() {
        System.out.println(menuMsg);
        System.out.println("1. Boutique");
        System.out.println("2. Inventaire");
        System.out.println("3. Passer le tour");
        System.out.println("4. Quitter l'application");
        
    }
    
    public static void printShop(Shop s, Customer c) {
        System.out.println(String.format(Locale.FRANCE, "%s (Vous avez %dg.)", shopMsg, c.getGold()));
        int i = 1;
        for(Consumable co : s.getItems()) {
            System.out.println(String.format(Locale.FRANCE, "%d. %s", i, co.toString()));
            i++;
        }
    }
    
    public static void printStatus(Customer c) {
        System.out.println(c.toString());
    }
    
    public static void printInventory(Customer c) {
        System.out.println(inventoryMsg);
        int i = 1;
        for(Consumable co : c.getInventory()) {
            System.out.println(String.format(Locale.FRANCE, "%d. %s", i, co.getName()));
            i++;
        }
    }
    
    public static int askForNumber(int min, int max) throws BadChoiceException {
        int choix;
        
        try {
            String choixStr = sc.nextLine();
            choix = Integer.parseInt(choixStr);
        } catch (NumberFormatException e) {
            throw new BadChoiceException(String.format(""), e);
        }
        
        if (choix < min || choix > max) {
            throw new BadChoiceException("");
        }
        
        return choix;
    }
}
