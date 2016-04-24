/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.BaseCountry;
import model.BaseDrug;
import java.util.ArrayList;
import model.country.*;
import model.drug.*;
import model.event.*;
import model.*;
import view.MafiaGameWindow;
import control.*;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * 
 * 
 * @author CHRIS
 */
public class MafiaGame {
    
    private Player player;
    private int currentTurn = 0;
    private BaseCountry currentCountry;
    private ArrayList<BaseCountry> countries;
    private ArrayList<CountryEvent> events;
    private ArrayList<Highscore> highscore;
    
    public static void main(String[] args) throws IOException {
        MafiaGame main = new MafiaGame();
    }

    public MafiaGame() {
        readHighscoresFromDatabase();
        printHighscore();
        initCountries();
        initEvents();
        String playerName = JOptionPane.showInputDialog("Please type your name", "firstname lastname");
        player = new Player(playerName, 5000);
        BaseCountry denmark = getCountry("Denmark");
        setCountry(denmark);
        MafiaGameWindow mafiaGameGui = new MafiaGameWindow(this);
    }
    
    public void readHighscoresFromDatabase() {
        try {
            highscore = DatabaseHandler.read();
        } catch (IOException ex) {
            Logger.getLogger(MafiaGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EndGame() throws IOException {
        DatabaseHandler.write(player.getName(), "" + player.getMoney());
    }
    
    public void printHighscore() {
        for (Highscore h : highscore) {
            System.out.println(h.toString());
        }
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
    
    public void initEvents() {
        events = new ArrayList<>();
        events.add( new CustomsAuthorityEvent() );
    }
    
    public void Travel(BaseCountry country) {     //TODO! Missing calling all events and other triggers upon travel!
        advanceTurn();                  //Important to do in this order, or Countries will not update their stock and prices
        setCountry(country);
        for (BaseCountry c : countries) {
            c.setPlayer(player);
            c.init();
        }
        for (CountryEvent e : events) {
            if (e.shouldFire(player)) {
                e.effect(player);
            }
        }
    }
    
    public void setCountry(BaseCountry country) {
        currentCountry = country;
        country.setPlayer(player);
    }
    
    public BaseCountry getCurrentCountry() {
        return currentCountry;
    }
    
    public int getTurn() {
        return currentTurn;
    }
    
    public void advanceTurn() {
        currentTurn++;
        player.advanceTurn();
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public ArrayList<BaseCountry> getCountries() {
        return countries;
    }
    
    public ArrayList<CountryEvent> getEvents() {
        return events;
    }
    
    public BaseCountry getCountry(String name) {
        for (BaseCountry c : countries) {
            String countryName = c.getClass().toString().replaceAll("class model.country.", "");
            if (countryName.equals(name)) {
                return c;
            }
        }
        return null;
    }

    public int getPlayerCurrentDrugAmount(String selectedSellingDrugName) {
        BaseDrug drug = getPlayer().getDrug(selectedSellingDrugName);
        if (drug != null) {
            int amount = drug.getAmount();
            return amount;
        }
        return 0;
    }

    public int getCountryCurrentDrugAmount(String selectedBuyingDrugName) {
        BaseCountry country = getCurrentCountry();
        BaseDrug drug = country.getDrug( selectedBuyingDrugName );
        int amount = drug.getAmount();
        return amount;
    }

    /**
     * Buys the drug from the country to the player, if the player can afford it.
     * @param selectedBuyingDrugName
     * @param selectedBuyingDrugAmount
     * @return String status of buying result
     */
    public void buyDrug(String drugName, int drugAmount, int price) throws Exception {
        currentCountry.buyDrug(drugName, drugAmount, player.getMoney());
        BaseDrug newPlayerDrug = new BaseDrug(0, drugAmount).getNewBaseDrug(drugName);
        player.buyDrug(newPlayerDrug, price);
    }
    
    public void sellDrug(String drugName, int drugAmount) throws Exception {
        int price = currentCountry.sellStock(drugName, drugAmount);
        BaseDrug newPlayerDrug = new BaseDrug(0, drugAmount).getNewBaseDrug(drugName);
        player.sellDrug(newPlayerDrug, drugAmount, price);
    }

    /**
     * For 
     * @return 
     */
    public ArrayList<Highscore> getHighscores() {
        Collections.sort(highscore);
        return highscore;
    }

    /**
     * To do Life HP change with exceptions for not enough money.
     * 
     * @param lifeBought 
     */
    public boolean buyLife(int lifeBought) {
        int lifeCost = lifeBought * getCurrentCountry().getHealthPrice();   //check afford
        if (player.getMoney() >= lifeCost) { //if afford - do buying
            player.removeMoney(lifeCost);
            player.healDamage(lifeBought);
            return true;
        }
        return false;
    }
    
}
