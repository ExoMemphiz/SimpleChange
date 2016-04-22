/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.drug.BaseDrug;

/**
 *
 * @author CHRIS
 */
public class Player {
 
    private int currentTurn = 0;
    private final String name;
    private int money, health;
    private ArrayList<BaseDrug> drugs;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        drugs = new ArrayList<>();
        health = 100;
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
    
    public BaseDrug getDrug(String drugName) {
        for (BaseDrug d : drugs) {
            if (d.getName().equals(drugName)) {
                return d;
            }
        }
        return null;
    }
    
    public ArrayList<BaseDrug> getDrugs() {
        return drugs;
    }
    
    public void buyDrug(BaseDrug drug, int price) {
        addDrug(drug);
        money -= price * drug.getAmount();
    }
    
    public void addDrug(BaseDrug drug) {
        for (BaseDrug d : drugs) {
            if (d.getName().equals(drug.getName())) {
                d.add(drug.getAmount());
                return;
            } else {
                System.out.println("[Player.addDrug()]: " + d.getName() + " != " + drug);
            }
        }
        drugs.add(drug);
    }
    
    public void removeDrug(BaseDrug drug, int amount) {
        for (BaseDrug d : drugs) {
            if (d.getName().equals(drug.getName())) {
                d.remove(amount);
            }
        }
    }
    
    public void sellDrug(BaseDrug drug, int amountSold, int moneyEarned) {
        money += moneyEarned;
        removeDrug(drug, amountSold);
    }
    
    public void advanceTurn() {
        currentTurn++;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void takeDamage(int amount) {
        health -= amount;
    }
    
    public void healDamage(int amount) {
        health += amount;
        if (health > 100) {
            health = 100;
        }
    }
    
}