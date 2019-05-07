/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crabfood;

import Data.Branch;
import Data.Orders;
import Data.Restaurants;
import Data.WaitLine;
import Map.Map;
import TextReaders.Customertxtreader;
import TextReaders.Inputtxtreader;
import java.util.ArrayList;

/**
 *
 * @author Crimson
 */
public class Handler {
    private Launcher launcher;

    public Handler(Launcher launcher) {
        this.launcher = launcher;
    }
    
    public ArrayList<Orders> getOrdersarr() {
        return launcher.getOrdersarr();
    }

    public Restaurants[] getRestlist() {
        return launcher.getRestlist();
    }

    public Branch[] getBranchList() {
        return launcher.getBranchList();
    }

    public Map getNewMap() {
        return launcher.getNewMap();
    }

    public WaitLine getWaitLine() {
        return launcher.getWaitLine();
    }

    public Customertxtreader getCustomerTR() {
        return launcher.getCustomerTR();
    }

    public Inputtxtreader getInputTR() {
        return launcher.getInputTR();
    }
}
