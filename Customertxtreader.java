/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextReaders;

import Data.Orders;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Crimson
 */
public class Customertxtreader {

    private String filename;
    private ArrayList<Orders> ordersarr;

    public Customertxtreader(String filename) {
        this.filename = filename;
        ordersarr = new ArrayList<>();
        extract(filename);
    }

    public void extract(String file) {
        String[] info;
        String text = "";
        
        try {
            Scanner s = new Scanner(new FileInputStream(filename));
            while (s.hasNextLine()) {
                text = text + s.nextLine() + ";";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
//        System.out.println("Extracted string: " + text);
        
        info = text.split(";");
        for (int i = 0; i < info.length; i+=4) {
            Orders newOrder = new Orders(Integer.parseInt(info[i]), info[i+1], info[i+2]);
            ordersarr.add(newOrder);
        }
    }

    public ArrayList<Orders> getOrdersarr() {
        return ordersarr;
    }

    
    public void displayorders(){
        for (int i = 0; i < ordersarr.size(); i++) {
            System.out.println(ordersarr.get(i).toString(i));
        }
    }
}
