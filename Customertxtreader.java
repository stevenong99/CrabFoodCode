/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TxtReaders;

import Data.Orders;
import Data.Queue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author TAN JIA QIN (WIF180073)
 */
public class Customertxtreader {

    private String filename;
    Queue<Orders> orderList = new Queue<>();

    public Customertxtreader(String filename) {
        this.filename = filename;
        read();
    }

    public void read() {
        try {
            Scanner s = new Scanner(new FileInputStream(filename));
            Orders newOrder;
            while (s.hasNext()) {
                int orderTime = s.nextInt();
                s.nextLine();
                String restName = s.nextLine();
                String dishOrdered = s.nextLine();
                newOrder = new Orders(orderTime, restName, dishOrdered);
                orderList.enqueue(newOrder);
                if (s.hasNextLine()) {
                    s.nextLine();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File is not found in the folder!");
        }

    }

    public void displayExtractedInformation() {
        int counter = 1;
        for (int i = 0; i < orderList.getSize(); i++) {
            System.out.println("Order " + counter + " : \n" + orderList.getElement(i).toString());
            counter++;
        }
    }

}
