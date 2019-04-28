/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author TAN JIA QIN (WIF180073)
 */
public class Restaurants {

    private String name;
    private int[][] branchlocation;
    private Dishes[] dishes;

    public Restaurants(String name, int[][] branchlocation, Dishes[] dishes) {
        this.name = name;
        this.branchlocation = branchlocation;
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        String locations = "";
        String dish = "";
        for (int i = 0; i < 3; i++) {
            locations = locations + branchlocation[i][0] + "," + branchlocation[i][1] + "\n";
        }
        for (int i = 0; i < 3; i++) {
            dish = dish + dishes[i] + "\n";
        }
        return "Restaurant's Name : " + name + "\nBranch Location   :\n" + locations + "Dishes            : \n" + dish;
    }

    public char compareLocation(int x, int y) {
        boolean exist = false;
        for (int a = 0; a < branchlocation.length; a++) {
            if (branchlocation[a][0] == x) {
                if (branchlocation[a][1] == y) {
                    exist = true;
                }
            }
        }
        if (exist == true) {
            return name.charAt(0);
        } else {
            return '0';
        }
    }

}
