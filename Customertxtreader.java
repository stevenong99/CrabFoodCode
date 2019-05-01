package TextReaders;

import Data.Orders;
import Data.Queue;
import Map.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customertxtreader {

    private String customerfilename, inputfilename;
    private ArrayList<Orders> ordersarr;
    private Queue<String> queue;
    private Inputtxtreader input;
    private Map newMap;

    public Customertxtreader(String customerfilename, String inputfilename) {
        this.input = new Inputtxtreader(inputfilename);
        this.customerfilename = customerfilename;
        this.ordersarr = new ArrayList<>();
        extract(customerfilename);
        displayorders();
        this.newMap = new Map(input.getRestlist());
        this.queue = new Queue<>();
    }

    public void extract(String file) {
        String[] info;
        String text = "";

        try {
            Scanner s = new Scanner(new FileInputStream(customerfilename));
            while (s.hasNextLine()) {
                text = text + s.nextLine() + ";";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
//        System.out.println("Extracted string: " + text);

        info = text.split(";");
        for (int i = 0; i < info.length; i += 4) {
            String resname = info[i + 1], dishname = info[i + 2];
            int customerlocationX = 0, customerlocationY = 0;
            int arrivaltime = Integer.parseInt(info[i]);
            int timetakentocook = input.getDishPrepTime(resname, dishname);
            int deliverytime = input.getShortestDeliveryTime(customerlocationX, customerlocationY, resname);
            Orders newOrder = new Orders(arrivaltime, resname, dishname, timetakentocook, deliverytime, customerlocationX, customerlocationY);
            ordersarr.add(newOrder);
        }
    }

    public ArrayList<Orders> getOrdersarr() {
        return ordersarr;
    }

    public void displayorders() {
        for (int i = 0; i < ordersarr.size(); i++) {
            System.out.println(ordersarr.get(i).toString(i) + "\n");
        }
    }
}
