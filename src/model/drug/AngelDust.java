/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.drug;

import control.DrugInterface;

/**
 *
 * @author CHRIS
 */
public class AngelDust implements DrugInterface {

    int price;
    int amount;

    public AngelDust(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }
    
    @Override
    public String getName() {
        return "Angel Dust";
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
    
}