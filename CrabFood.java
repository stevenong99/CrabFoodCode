package crabfood;

import TextReaders.Customertxtreader;
import TextReaders.Inputtxtreader;

/**
 *
 * @author Ong Teng Kheng, Tan Jia Qin, Yeoh Kai Bin
 */
public class CrabFood {

    public static void main(String[] args) {
        Customertxtreader customer = new Customertxtreader("Customer.txt");
        System.out.println("");
        Inputtxtreader input = new Inputtxtreader("Input.txt");
    }
    
}
