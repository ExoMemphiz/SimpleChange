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
public interface CountryInterface {
    
    public abstract void init();
    public abstract String getName();
    public abstract void setPlayer(Player player);
    public abstract ArrayList<BaseDrug> getDrugs();
    public abstract BaseDrug getDrug(String drugName);
    public abstract int getPrice(String drugName, int amount);
    public abstract boolean buyDrug(String drugName, int amount, int playerMoney) throws Exception;
    public abstract int sellStock(String drugName, int amount);
    public abstract void rollPrices();
    public abstract void rollStock();
    
}