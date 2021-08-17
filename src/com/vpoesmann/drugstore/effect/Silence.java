/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.effect;

import com.vpoesmann.drugstore.Customer;

/**
 *
 * @author sogeking
 */
public class Silence extends NegativeEffect {
	public Silence(int nbTurns) {
		super("Silence",nbTurns);
	}
	
	@Override
	public void apply(Customer c) {
		  if (nbTurns > 0) {
			 c.removeMp();
			 nbTurns--;
		  }
	}
}