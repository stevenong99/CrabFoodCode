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
    protected Map newMap;
    protected WaitLine waitLine;
    protected Customertxtreader customerTR;

    public Launcher() {
        this.customerTR = new Customertxtreader("Customer.txt", "Input.txt");
        this.ordersarr = customerTR.getOrdersarr();
        this.restlist = customerTR.getRestlist();
        this.newMap = new Map(restlist);
        Handler handler = new Handler(this);
        this.waitLine = new WaitLine(handler);
    }
    
    //Getters

    public ArrayList<Orders> getOrdersarr() {
        return ordersarr;
    }

    public Restaurants[] getRestlist() {
        return restlist;
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

    
}
