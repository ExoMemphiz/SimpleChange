/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author CHRIS
 */
public class Player {
 
    private String name;
    private int money;
    private ArrayList<Drug> drugs;

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
    
    public ArrayList<Drug> getDrugs() {
        return drugs;
    }
    
    public void addDrug(Drug drug) {
        drugs.add(drug);
    }
    
    public void sellDrug(Drug drug) {
        
    }
    
}