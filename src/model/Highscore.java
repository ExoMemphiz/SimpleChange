/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Chris
 */
public class Highscore {

    private final String name;
    private final int points;
    
    public Highscore(String parseLine) {
        int index = parseLine.indexOf(",");
        name = parseLine.substring(0, index).replaceAll("_", " ");
        points = Integer.parseInt(parseLine.substring(index + 1));
    }
    
    public Highscore(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + ": " + points;
    }
    
}