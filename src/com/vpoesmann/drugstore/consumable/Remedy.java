package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;

public class Remedy extends Consumable {
    public Remedy(){super(20,"remède");}

    @Override
    public void use(Customer c) throws CannotConsumeException {
        if (!c.hasEffect("Silence")) {
            throw new CannotConsumeException("tu n'es pas réduit au silence");
        }
        while (c.hasEffect("Silence")) {
            c.removeEffect("Silence");
        }
    }
}
