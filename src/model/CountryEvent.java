/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import model.Player;

/**
 *
 * @author scheldejonas
 */
public class CountryEvent {

    public void effect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Default chance is 5%, override if other percentage is needed
     * @return 
     */
    public boolean shouldFire(Player player) {
        Random r = new Random();
        int random = r.nextInt(100);
        return random <= 5;
    }
    
}
