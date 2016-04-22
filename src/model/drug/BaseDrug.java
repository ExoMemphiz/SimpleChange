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

    public BaseDrug(int price, int amount, String drugName) {
        this.price = price;
        this.amount = amount;
        switch (drugName) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
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
