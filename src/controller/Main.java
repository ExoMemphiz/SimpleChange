/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import model.drug.*;

/**
 * Denne klasser styrer spillets gang.
 * @author CHRIS
 */
public class Main {
 
    public static void main(String[] args) {
        Player player = new Player("Peter the Gangster", 5000);
        Drug acid = new Acid(180, 2);
        player.addDrug(acid);
        
    }
    
}