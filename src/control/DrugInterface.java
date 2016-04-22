/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author CHRIS
 */
public interface DrugInterface {
 
    public abstract String getName();
    public abstract int getPrice();
    public abstract int getAmount();
    public abstract void setPrice(int price);
    public abstract void remove(int amount);
    public abstract void add(int amount);
    public abstract void setAmount(int i);
    
}