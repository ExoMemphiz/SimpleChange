/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CHRIS
 */
public interface EventInterface {
 
    /**
     * 
     */
    public abstract void effect(Player player);
    public abstract boolean shouldFire(Player player);
    
}