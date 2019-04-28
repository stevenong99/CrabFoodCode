/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bryancrabfood;

import TxtReaders.Customertxtreader;
import TxtReaders.Inputtxtreader;

/**
 *
 * @author TAN JIA QIN (WIF180073)
 */
public class BryanCrabFood {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inputtxtreader input = new Inputtxtreader("Input.txt");
        input.displayExtractedInformation();
        input.createMap();
        System.out.println("");

        Customertxtreader Cinput = new Customertxtreader("Customer.txt");
        Cinput.displayExtractedInformation();

        System.out.println("");

    }

}
