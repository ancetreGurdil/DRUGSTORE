package com.vpoesmann.drugstore.area;

import com.vpoesmann.drugstore.BadChoiceException;

public class TownArea extends Area {
    @Override
    public void update() throws BadChoiceException {
        System.out.println("1. Boutique");
        System.out.println("2. Inventaire");
        System.out.println("3. Passer le tour");
        System.out.println("4. Quitter l'application");

        int choix;
        choix = askForNumber(1,4);

        switch (choix){
            case 1:
                moveTo(Area.SHOP_AREA);
                break;

        }

    }
}
