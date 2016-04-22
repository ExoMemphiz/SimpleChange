/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.drug;

import model.DrugInterface;

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

    
}