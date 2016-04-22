/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.drug;

import model.DrugInterface;

/**
 *
 * @author scheldejonas
 */
public class BaseDrug implements DrugInterface {
    
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
    
    
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public int getAmount() {
        return amount;
    }
        
    @Override
    public void remove(int amount) {
        this.amount -= amount;
    }
        
    @Override
    public void add(int amount) {
        this.amount += amount;
    }
    
    @Override
    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    @Override
    public String getName() {
        return "null";
    }
    
}
