/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.drug.Acid;
import model.drug.Amphetamine;
import model.drug.AngelDust;
import model.drug.Cocaine;
import model.drug.CrystalMeth;
import model.drug.Heroin;

/**
 *
 * @author scheldejonas
 */
public class BaseDrug {
    
    int price;
    int amount;

    public BaseDrug(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }
    
    public BaseDrug getNewBaseDrug(String drugName) {
        switch (drugName) {
            case "Acid": 
                return new Acid(price, amount);
            case "Amphetamine": 
                return new Amphetamine(price, amount);
            case "Angel Dust": 
                return new AngelDust(price, amount);
            case "Cocaine": 
                return new Cocaine(price, amount);
            case "Crystal Meth": 
                return new CrystalMeth(price, amount);
            case "Heroin": 
                return new Heroin(price, amount);
        }
        return null;
    }
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getAmount() {
        return amount;
    }
        
    public void remove(int amount) {
        this.amount -= amount;
    }
        
    public void add(int amount) {
        this.amount += amount;
    }
    
    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public String getName() {
        return "null";
    }
    
}
