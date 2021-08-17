package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;
import com.vpoesmann.drugstore.effect.NegativeEffect;

public class MiraclePotion extends Consumable {
    public MiraclePotion() {
        super(100, "Eau de vie");
    }

    @Override
    public void use(Customer c) throws CannotConsumeException {
        if (!c.hasEffectOfType(NegativeEffect.class)){
            throw new CannotConsumeException("tu es hypocondriaque !");
        }
        while (c.hasEffectOfType(NegativeEffect.class)){
            c.removeEffectByType(NegativeEffect.class);
        }
    }
}
