/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Crimson
 */
public class Dishes extends Restaurants{
    private String name;
    private int preptime;

    public Dishes(String name, int preptime, String resname, int[][] branchesarr) {
        super(resname, branchesarr);
        this.name = name;
        this.preptime = preptime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }
    
    
}
