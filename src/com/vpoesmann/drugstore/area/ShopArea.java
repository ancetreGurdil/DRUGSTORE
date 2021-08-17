package com.vpoesmann.drugstore.area;

import com.vpoesmann.drugstore.BadChoiceException;

public class ShopArea extends Area {
    @Override
    public void update() throws BadChoiceException {
        System.out.println("Tu es dans la boutique");
    }
}
