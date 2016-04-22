/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author CHRIS
 */
public interface CountryInterface {
    
    public abstract void init();
    public abstract String getName();
    public abstract void setPlayer(Player player);
    public abstract ArrayList<DrugInterface> getDrugs();
    public abstract DrugInterface getDrug(String drugName);
    public abstract int getPrice(String drugName, int amount);
    public abstract boolean buyDrug(String drugName, int amount, int playerMoney) throws Exception;
    public abstract int sellStock(String drugName, int amount);
    public abstract void rollPrices();
    public abstract void rollStock();
    
}
