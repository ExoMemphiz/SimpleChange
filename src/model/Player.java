/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.*;
import model.country.Denmark;

/**
 *
 * @author CHRIS
 */
public class Player {
 
    private int currentTurn = 0;
    private String name;
    private int money;
    private ArrayList<Drug> drugs;
    private Country currentCountry;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        drugs = new ArrayList<>();
        currentCountry = new Denmark();
    }
    
    public int getMoney() {
        return money;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTurn() {
        return currentTurn;
    }
    
    public ArrayList<Drug> getDrugs() {
        return drugs;
    }
    
    public void addDrug(Drug drug) {
        drugs.add(drug);
    }
    
    public void sellDrug(Drug drug) {
        
    }
    
}