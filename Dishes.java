/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author TAN JIA QIN (WIF180073)
 */
public class Dishes {

    private String name;
    private int prepTime;

    public Dishes(String name, int prepTime) {
        this.name = name;
        this.prepTime = prepTime;
    }

    public String getName() {
        return name;
    }

    public int getPrepTime() {
        return prepTime;
    }
    
    @Override
    public String toString() {
        return name + "\tPrep. Time : " + prepTime + " minute(s)";
    }

}
