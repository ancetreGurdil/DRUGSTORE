package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;

public class Antidote extends Consumable{
    public Antidote (){super(50,"antidote");}

    @Override
    public void use(Customer c) throws CannotConsumeException {
        if (!c.hasEffect("Poison")){
            throw new CannotConsumeException("pas empoisonné(e)");
        }
        while(c.hasEffect("Poison")){
            c.removeEffect("Poison");
        }

    }
}

