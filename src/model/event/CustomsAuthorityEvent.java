/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event;

import java.util.Random;
import model.DrugInterface;
import model.EventInterface;
import model.Player;

/**
 *
 * @author CHRIS
 */
public class CustomsAuthorityEvent extends CountryEvent {

    @Override
    public void effect(Player player) {
        for (DrugInterface d : player.getDrugs()) {
            if (d.getAmount() > 0) {
                int confiscated = d.getAmount() / 2;
                if (d.getAmount() % 2 == 1) {
                    confiscated++;
                }
                d.remove(confiscated);
            }
        }
    }

    @Override
    public boolean shouldFire(Player player) {
        return super.shouldFire(player);
    }
    
}