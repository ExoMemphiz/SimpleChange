/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.country.*;
import model.drug.*;
import model.event.*;
import model.*;
import view.MafiaGameWindow;
import control.*;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 * 
 * 
 * @author CHRIS
 */
public class MafiaGame {
 
    private Player player;
    private CountryInterface currentCountry;
    private ArrayList<CountryInterface> countries;
    private ArrayList<EventInterface> events;
    
    public static void main(String[] args) {
        MafiaGame main = new MafiaGame();
    }

    public MafiaGame() {
        initCountries();
        player = new Player("Peter the Gangster", 5000);
        CountryInterface denmark = getCountry("Denmark");
        setCountry(denmark);
        MafiaGameWindow mafiaGameGui = new MafiaGameWindow(this);
    }
    
    public void setCountry(CountryInterface country) {
        currentCountry = country;
        country.setPlayer(player);
    }
    
    public CountryInterface getCurrentCountry() {
        return currentCountry;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public ArrayList<CountryInterface> getCountries() {
        return countries;
    }
    
    public ArrayList<EventInterface> getEvents() {
        return events;
    }
    
    public CountryInterface getCountry(String name) {
        for (CountryInterface c : countries) {
            String countryName = c.getClass().toString().replaceAll("class model.country.", "");
            if (countryName.equals(name)) {
                return c;
            }
        }
        return null;
    }

    public DefaultComboBoxModel getBuyDrugListAsComboBoxModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.removeAllElements();
        CountryInterface country = getCurrentCountry();
        ArrayList<DrugInterface> drugs = country.getDrugs();
        for (int i = 0; i < drugs.size(); i++) {
            DrugInterface d = drugs.get(i);
            if (d.getAmount() > 0) {
                model.addElement(d.getName() + " - " + d.getPrice());
            }
        }
        return model;
    }

    public void initCountries() {
        countries = new ArrayList<>();
        countries.add(new Afghanistan());
        countries.add(new Colombia());
        countries.add(new Denmark());
        countries.add(new France());
        countries.add(new Germany());
        countries.add(new USA());
    }

    public DefaultComboBoxModel getSellDrugListAsComboBoxModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.removeAllElements();
        Player player = getPlayer();
        ArrayList<DrugInterface> playerDrugs = player.getDrugs();
        CountryInterface country = getCurrentCountry();
        ArrayList<DrugInterface> countryDrugs = country.getDrugs();
        for (int i = 0; i < playerDrugs.size(); i++) {
            DrugInterface d = playerDrugs.get(i);
            for (DrugInterface cDrug : countryDrugs) {
                if (d.getName().equals(cDrug.getName())) {
                    if (d.getAmount() > 0) {
                        model.addElement(d.getName() + " - " + cDrug.getPrice());
                    }
                }
            }
        }
        return model;
    }
    
}