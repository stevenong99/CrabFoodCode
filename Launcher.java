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
public class Launcher {
    protected ArrayList<Orders> ordersarr;
    protected Restaurants[] restlist;
    protected Branch[] branchList;
    protected Map newMap;
    protected WaitLine waitLine;
    protected Customertxtreader customerTR;
    protected Inputtxtreader inputTR;

    public Launcher() {
        
        this.customerTR = new Customertxtreader("Customer.txt", "Input.txt");
        this.ordersarr = customerTR.getOrdersarr();
        this.restlist = customerTR.getRestlist();
        this.newMap = new Map(restlist);
        this.waitLine = new WaitLine();
        Handler handler = new Handler(this);
        
    }
    
    
    
    
    
    //Getters

    public ArrayList<Orders> getOrdersarr() {
        return ordersarr;
    }

    public Restaurants[] getRestlist() {
        return restlist;
    }

    public Branch[] getBranchList() {
        return branchList;
    }

    public Map getNewMap() {
        return newMap;
    }

    public WaitLine getWaitLine() {
        return waitLine;
    }

    public Customertxtreader getCustomerTR() {
        return customerTR;
    }

    public Inputtxtreader getInputTR() {
        return inputTR;
    }
    
    
    
    
}
