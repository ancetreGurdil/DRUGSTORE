/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.CannotConsumeException;
import com.vpoesmann.drugstore.Customer;
import java.util.Locale;

/**
 *
 * @author sogeking
 */
public abstract class Consumable {
    protected int price;
    protected String name;
    
    public Consumable(int price, String name) {
        this.price = price;
        this.name = name;
    }
    
    public abstract void use(Customer c) throws CannotConsumeException;
    
    public int getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return String.format(Locale.FRANCE, "%dg. %s", price, name);
    }
}
