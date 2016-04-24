/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.BaseDrug;
import model.Player;
import java.util.ArrayList;
import java.util.Random;
import model.drug.*;
import model.*;

/**
 *
 * @author scheldejonas
 */
public abstract class BaseCountry {
    
    Player player;
    ArrayList<BaseDrug> drugs;
    Random r;
    private int healthPrice = 5000;
    
    public void init() {
        r = new Random();
        if (drugs == null) {
            drugs = new ArrayList<>();
            Cocaine cocaine = new Cocaine(1200, 30);
            Heroin heroin = new Heroin(1600, 15);
            Amphetamine amphetamine = new Amphetamine(200, 50);
            Acid acid = new Acid(550, 33);
            AngelDust angelDust = new AngelDust(400, 60);
            CrystalMeth crystalMeth = new CrystalMeth(800, 38);
            drugs.add(cocaine);
            drugs.add(heroin);
            drugs.add(amphetamine);
            drugs.add(acid);
            drugs.add(angelDust);
            drugs.add(crystalMeth);
        }
        if (player != null && player.getTurn() != 0) {
            rollPrices();
            rollStock();
        }
    }

    public int getHealthPrice() {
        return healthPrice;
    }

    public void setHealthPrice(int healthPrice) {
        this.healthPrice = healthPrice;
    }
    
    public abstract String getName();
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public ArrayList<BaseDrug> getDrugs() {
        return drugs;
    }
    
    public BaseDrug getDrug(String drugName) {
        for (BaseDrug d : drugs) {
            if (d.getName().equals(drugName)) {
                return d;
            }
        }
        return null;
    }
    
    public int getPrice(String drugName, int amount) {
        BaseDrug d = getDrug(drugName);
        if (d != null) {
            return d.getPrice() * amount;
        }
        return -1;
    }
    
    /**
     * This is only removing the drug amount from the country, if the player has enough money for it at the runtime.
     * @param drugName
     * @param amount
     * @param playerMoney
     * @return true as done or throws an exception of why buying was not possible.
     * @throws Exception 
     */
    public boolean buyDrug(String drugName, int amount, int playerMoney) throws Exception {
        if (playerMoney >= getPrice(drugName, amount)) {
            BaseDrug d = getDrug(drugName);
            if (d != null) {
                if (d.getAmount() >= amount) {
                    d.remove(amount);
                    return true;
                } else {
                    throw new Exception("Not enough drugs in stock!");
                }
            } else {
                throw new Exception("No drug with the name " + drugName + " found!");
            }
        } else {
            throw new Exception("Not enough money to buy this amount!");
        }
    }
    
    public int sellStock(String drugName, int amount) {
        BaseDrug d = getDrug(drugName);
        if (d != null) {
            d.add(amount);
            return d.getPrice() * amount;
        }
        return 0;
    }
    
    public void rollHealthPrice() {
        int randomNumber = r.nextInt(100);
        if (randomNumber <= 65) { //There is a 65% chance to change the price of the health
            boolean increasePrice = r.nextBoolean();
            int priceChange = r.nextInt(85) + 1; 
            int currentPrice = getHealthPrice();
            int priceDifference = (currentPrice * priceChange) / 100;   //Find price difference
            int newPrice = currentPrice + (increasePrice ? priceDifference : -priceDifference);
            setHealthPrice(newPrice);
        }
    }
    
    public void rollPrices() {
        for (int i = 0; i < drugs.size(); i++) {
            BaseDrug d = drugs.get(i);
            int randomNumber = r.nextInt(100);
            if (randomNumber <= 65) { //There is a 65% chance to change price for this drug
                boolean increasePrice = r.nextBoolean(); //Random if it should increase or decrease price
                int priceChange = r.nextInt(85) + 1;     //Amount (percentage) to increase/decrease price
                int currentPrice = d.getPrice();         //Get current price
                int priceDifference = (currentPrice * priceChange) / 100;   //Find price difference
                int newPrice = currentPrice + (increasePrice ? priceDifference : -priceDifference);
                d.setPrice(newPrice);
                /*
                System.out.println((increasePrice ? "Increasing " : "Decreasing ") + d.getName() + " with " 
                                 + priceChange + "%, currentPrice: " + currentPrice + ", Price difference: " + 
                                   priceDifference + ", totaling: " + newPrice);
                */
            }
        }
        rollHealthPrice();
    }
    
    public void rollStock() {
        for (int i = 0; i < drugs.size(); i++) {
            BaseDrug d = drugs.get(i);
            if (r.nextInt(100) <= 65) { //There is a 65% chance to change stock for this drug
                boolean increaseStock = r.nextBoolean(); //Random if it should increase or decrease stock
                int stockChange = r.nextInt(41) + 15;     //Amount (percentage) to increase/decrease stock
                int currentStock = d.getAmount();         //Get current stock
                int stockDifference = (currentStock * stockChange) / 100;   //Find price difference
                d.setAmount(currentStock + (increaseStock ? stockDifference : -stockDifference));
            }
        }
    }
}
