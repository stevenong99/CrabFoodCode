/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crabfood;

import Data.Orders;
import Map.Map;
import TextReaders.Customertxtreader;
import TextReaders.Inputtxtreader;
import java.util.ArrayList;

/**
 *
 * @author Crimson
 */
public class CrabFood {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map map = new Map();
        Customertxtreader customer = new Customertxtreader("Customer.txt");
        Inputtxtreader input = new Inputtxtreader("Input.txt");
    }
    
}
