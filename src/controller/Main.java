/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.*;
import model.country.Afghanistan;
import model.country.Colombia;
import model.country.Denmark;
import model.country.France;
import model.country.Germany;
import model.country.USA;
import view.TestGUI;

/**
 * 
 * 
 * @author CHRIS
 */
public class Main {
 
    private Player player;
    private Country currentCountry;
    private ArrayList<Country> countries;
    private ArrayList<Event> events;

    public Main() {
        initCountries();
        player = new Player("Peter the Gangster", 5000);
        Country denmark = getCountry("Denmark");
        setCountry(denmark);
        TestGUI gui = new TestGUI(this);
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
    
    public void setCountry(Country country) {
        currentCountry = country;
        country.setPlayer(player);
    }
    
    public Country getCurrentCountry() {
        return currentCountry;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public ArrayList<Country> getCountries() {
        return countries;
    }
    
    public ArrayList<Event> getEvents() {
        return events;
    }
    
    public Country getCountry(String name) {
        for (Country c : countries) {
            String countryName = c.getClass().toString().replaceAll("class model.country.", "");
            if (countryName.equals(name)) {
                return c;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
    
}