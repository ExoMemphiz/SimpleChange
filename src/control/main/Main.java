/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.main;

import model.player.Player;
import java.util.ArrayList;
import model.country.Afghanistan;
import model.country.Colombia;
import model.country.Denmark;
import model.country.France;
import model.country.Germany;
import model.country.USA;
import view.MafiaGameWindow;
import control.CountryInterface;
import control.EventInterface;

/**
 * 
 * 
 * @author CHRIS
 */
public class Main {
 
    private Player player;
    private CountryInterface currentCountry;
    private ArrayList<CountryInterface> countries;
    private ArrayList<EventInterface> events;

    public Main() {
        initCountries();
        player = new Player("Peter the Gangster", 5000);
        CountryInterface denmark = getCountry("Denmark");
        setCountry(denmark);
        MafiaGameWindow gui = new MafiaGameWindow(this);
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
    
    public static void main(String[] args) {
        Main main = new Main();
    }
    
}