/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore;

import com.vpoesmann.drugstore.consumable.Consumable;
import com.vpoesmann.drugstore.effect.Effect;
import com.vpoesmann.drugstore.effect.NegativeEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author sogeking
 */
public class Customer {
    
    private List<Consumable> inventory;
    private int gold;

    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int hunger;
    private int maxHunger;
    private List<Effect> effects;
    
    public Customer() {
        gold = 500;
        inventory = new ArrayList<>();
        effects = new ArrayList<>();

        maxHunger = 100;
        maxHp = 100;
        maxMp = 100;
        hp = maxHp;
        mp = maxMp;
        hunger = maxHunger;
    }
    
    public int getGold() {
        return gold;
    }

    public boolean hasFullHP() {
        return hp == maxHp;
    }
    
    public boolean hasFullMP() {
        return mp == maxMp;
    }

    public boolean hasFullHunger() {
        return hunger == maxHunger;
    }
    
    public boolean hasEffect(String effectName) {
    	return getEffect(effectName)!= null;
    }

    public boolean hasEffectOfType(Class<? extends Effect> effectType){
        return getEffectByType(effectType)!=null;
    }

    public Effect getEffect(String EffectName){
        for(Effect effect : effects) {
            if (effect.getName().equals(EffectName)){
                return effect;
            }
        }
        return null;
    }

    public Effect getEffectByType(Class<? extends Effect> effectType) {
        for (Effect effect : effects) {
            if (effectType.isInstance(effect)){
                return effect;
            }
        }
        return null;
    }
    public void removeEffectByType(Class<? extends Effect> effectType){
        Effect effect = getEffectByType(effectType);
        if (effect!=null){
            effects.remove(effect);
        }
    }
    public void removeEffect(String NameEffect) {
        Effect effect = getEffect(NameEffect);
        if (effect != null) {
            effects.remove(effect);
        }
    }

    public void reduceHunger(int amount){
        hunger+=amount;
        if (hunger>maxHunger){
            hunger=maxHunger;
        }
    }
    
    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public void hurt(int amount) {
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
        }
    }
    public int getMP() {
    	return maxMp;
    }
    public void removeMp() {
    	mp=0;
    }
    public void addMp() {
    	mp+=50;
    }
    
    public boolean isDead() {
        return hp <= 0;
    }
    
    public void pay(int amount) {
        gold -= amount;
    }
    
    public void addToInventory(Consumable c) {
        inventory.add(c);
    }
    
    public List<Consumable> getInventory() {
        return inventory;
    }
    
    public int getInventorySize() {
        return inventory.size();
    }
    
    public void useItem(int itemId) {
        Consumable c = inventory.get(itemId);
        
        try {
            c.use(this);
            inventory.remove(itemId);
        } catch (CannotConsumeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String toString() {
        String result = String.format(Locale.FRANCE, "HP : %d/%d\n", hp, maxHp);
        result += String.format(Locale.FRANCE, "MP : %d/%d\n", mp, maxMp);
        result += String.format(Locale.FRANCE, "HUNGER : %d/%d\n", hunger,maxHunger);
        
        for (Effect e : effects) {
            result += e;
            result += "\n";
        }
        
        return result;
    }

    public void nextTurn() {   
        mp += 5;
        hunger-=5;
        if(hunger<=0){
            hunger=0;
            hurt(5);
        }
        if(hunger>=80){
            heal(2);
        }
        if (mp > maxMp) {
            mp = maxMp;
        }
        
        int i = 0;
        while (i < effects.size()) {
            Effect e = effects.get(i);
            e.apply(this);
            if (!e.isStillRunning()) {
                effects.remove(e);
            } else {
                i++;
            }
        }
    }

    public void addEffect(Effect e) {
        effects.add(e);
    }
}
