/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.country.*;
import model.DrugInterface;

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
    
    public void addDrug(String name, int amount) {
        
    }
    
    public void addDrug(DrugInterface drug) {
        for (DrugInterface d : drugs) {
            if (d.getName().equals(drug)) {
                d.add(drug.getAmount());
                return;
            }
        }
        drugs.add(drug);
    }
    
    public void removeDrug(DrugInterface drug, int amount) {
        for (DrugInterface d : drugs) {
            if (d.getName().equals(drug.getName())) {
                d.remove(amount);
            }
        }
    }
    
    public void sellDrug(DrugInterface drug, int amountSold, int moneyEarned) {
        money += moneyEarned;
        removeDrug(drug, amountSold);
    }
    
    public void advanceTurn() {
        currentTurn++;
    }
    
}