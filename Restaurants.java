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
public class Restaurants {
    private String resname;
    private int[][] branchesarr;

    public Restaurants(String resname, int[][] branchesarr) {
        this.resname = resname;
        this.branchesarr = branchesarr;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public int[][] getBranchesarr() {
        return branchesarr;
    }

    public void setBranchesarr(int[][] branchesarr) {
        this.branchesarr = branchesarr;
    }
    
    
}
