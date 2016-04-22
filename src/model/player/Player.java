/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import java.util.ArrayList;
import model.country.*;
import control.DrugInterface;

/**
 *
 * @author CHRIS
 */
public class Player {
 
    private int currentTurn = 0;
    private String name;
    private int money;
    private ArrayList<DrugInterface> drugs;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        drugs = new ArrayList<>();
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
    
    public DrugInterface getDrug(String drugName) {
        for (DrugInterface d : drugs) {
            if (d.getName().equals(drugName)) {
                return d;
            }
        }
        return null;
    }
    
    public ArrayList<DrugInterface> getDrugs() {
        return drugs;
    }
    
    public void addDrug(DrugInterface drug) {
        drugs.add(drug);
    }
    
    public void sellDrug(DrugInterface drug) {
        
    }
    
    public void advanceTurn() {
        currentTurn++;
    }
    
}