/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.CountryInterface;
import model.EventInterface;
import model.Player;

/**
 *
 * @author scheldejonas
 */
public interface MafiaGameInterface {
       
    /**
     * 
     */
    public abstract void initCountries();
    
    /**
     * 
     * @param country 
     */
    public abstract void setCountry(CountryInterface country);
    
    /**
     * 
     * @return 
     */
    public abstract CountryInterface getCurrentCountry();
    
    /**
     * 
     * @return 
     */
    public abstract Player getPlayer();
    
    /**
     * 
     * @return 
     */
    public abstract ArrayList<CountryInterface> getCountries();
    
    /**
     * 
     * @return 
     */
    public abstract ArrayList<EventInterface> getEvents();
    
    /**
     * 
     * @param name
     * @return 
     */
    public abstract CountryInterface getCountry(String name);

    /**
     * 
     * @return 
     */
    public abstract DefaultComboBoxModel getBuyDrugListAsComboBoxModel();
    
}
