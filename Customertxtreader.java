package TextReaders;

import Data.Branch;
import Data.Dishes;
import Data.Orders;
import Data.Queue;
import Data.Restaurants;
import Map.Map;
import crabfood.Handler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customertxtreader {
    
    private String customerfilename, inputfilename;
    private ArrayList<Orders> ordersarr;
    private Queue<String> queue;
    private Map newMap;
    private Restaurants restaurant;
    private String filename;
    private Restaurants[] restlist;
    private Branch[] branchList;
    
    public Customertxtreader(String customerfilename, String inputfilename) {
        this.customerfilename = customerfilename;
        this.ordersarr = new ArrayList<>();
        extractInput(inputfilename);
        extractCustomer(customerfilename);
        displayorders();
        this.queue = new Queue<>();
    }
    
    public void extractInput(String filename) {
        try {
            Scanner scan = new Scanner(new FileInputStream(filename));
            restlist = new Restaurants[3];
            //branchList = new Branch [3];
            int counter = 0;
            while (scan.hasNext()) {
                {
                    String name = scan.nextLine();
                    int[][] branches = new int[3][2];
                    branchList = new Branch [3];
                    for (int i = 0; i < branches.length; i++) {
                        branches[i][0] = scan.nextInt();
                        branches[i][1] = scan.nextInt();
                        branchList[i] = new Branch (branches[i][0],branches[i][1]);
                        scan.nextLine();
                    }
                    Dishes[] dishes = new Dishes[3];
                    for (int i = 0; i < 3; i++) {
                        dishes[i] = new Dishes(scan.nextLine(), scan.nextInt());
                        if (scan.hasNextLine()) {
                            scan.nextLine();
                        }
                    }
                    restlist[counter] = new Restaurants(name, branchList, dishes);
                    //System.out.println(restlist[counter].toString());
                    counter++;
                }
                if (scan.hasNextLine()) {
                    scan.nextLine();
                }
            }
            display();

        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be found.");
        }
    }
    
    public void extractCustomer(String file) {
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
        
        info = text.split(";");
        for (int i = 0; i < info.length; i += 4) {
            String resname = info[i + 1], dishname = info[i + 2];
            int customerlocationX = 0, customerlocationY = 0;
            int arrivaltime = Integer.parseInt(info[i]);
            takeOrder(resname, dishname, arrivaltime, customerlocationX, customerlocationY);
        }
    }
    
    public void takeOrder(String restName, String dishName, int arrivalTime, int customerLocationX, int customerLocationY) {
        Orders newOrder = new Orders(restName, dishName, arrivalTime, customerLocationX, customerLocationY, restlist);
        Branch branchTakeOrder = newOrder.determine(restName, dishName, customerLocationX, customerLocationY);
        ordersarr.add(newOrder);
        branchTakeOrder.acceptOrder(newOrder);
    }
    
    public ArrayList<Orders> getOrdersarr() {
        return ordersarr;
    }
    
    public void displayorders() {
        for (int i = 0; i < ordersarr.size(); i++) {
            System.out.println(ordersarr.get(i).toString(i) + "\n");
        }
    }
    
    public int getDishPrepTime(String resname, String dishname) {
        int i = 0;
        while (i < restlist.length) {
            if (resname.equals(restlist[i].getName())) {
                break;
            }
            i++;
        }
        return restlist[i].getTime(dishname);
    }

    public int getShortestDeliveryTime(int customerlocationX, int customerlocationY, String resname) {
        int i = 0;
        while (i < restlist.length) {
            if (resname.equals(restlist[i].getName())) {
                break;
            }
            i++;
        }
        return restlist[i].closestBranch(customerlocationX, customerlocationY);
    }

    public void display() {
        System.out.println("Welcome to CrabFood. We have the following restaurants:");
        for (int i = 0; i < restlist.length; i++) {
            System.out.println(restlist[i]);
        }
    }
    
    public String getFilename() {
        return filename;
    }


    public Restaurants[] getRestlist() {
        return restlist;
    }

    public Branch[] getBranchList() {
        return branchList;
    }
    
}
