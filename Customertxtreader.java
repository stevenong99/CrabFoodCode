package TextReaders;

import Data.Branch;
import Data.Orders;
import Data.Queue;
import Data.Restaurants;
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
    
    private Restaurants restaurant;
    
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
        
        info = text.split(";");
        for (int i = 0; i < info.length; i += 4) {
            String resname = info[i + 1], dishname = info[i + 2];
            int customerlocationX = 0, customerlocationY = 0;
            int arrivaltime = Integer.parseInt(info[i]);
            int timetakentocook = input.getDishPrepTime(resname, dishname);
            int deliverytime = getDeliveryTime(resname, dishname, customerlocationX, customerlocationY);
            Orders newOrder = new Orders(arrivaltime, resname, dishname, timetakentocook, deliverytime, customerlocationX, customerlocationY);
            takeOrder(newOrder);
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

//    public void takeOrder(String resname, Orders newOrder, int customerlocationX, int customerlocationY) {
//        Restaurants[] restlist = input.getRestlist();
//        Branch[] branchlist;
//        ArrayList<Branch> zeroOrderBranch = new ArrayList<>();
//        Branch branchTakeOrder = null;
//        int distance;
//        int minDistance;
//
//        for (int i = 0; i < restlist.length; i++) {
//            if (restlist[i].getName().equals(resname)) {
//                branchlist = restlist[i].getBranches();
//
//                for (int j = 0; j < branchlist.length; j++) {
//                    if (branchlist[j].getTotalOrder() == 0) {
//                        zeroOrderBranch.add(branchlist[j]);
//                    }
//                }
//
//                if (zeroOrderBranch.isEmpty() == true) {
//                    branchTakeOrder = branchlist[0];
//                    distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
//                    minDistance = distance;
//                    for (int j = 1; j < branchlist.length; j++) {
//                        distance = branchlist[j].getDistance(customerlocationX, customerlocationY);
//                        if (distance < minDistance && branchlist[j].getProcessTimeLeft() <= branchTakeOrder.getProcessTimeLeft()) {
//                            branchTakeOrder = branchlist[j];
//                            minDistance = distance;
//                        }
//                    }
//                } else if (zeroOrderBranch.isEmpty() != true) {
//                    branchTakeOrder = zeroOrderBranch.get(0);
//                    distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
//                    minDistance = distance;
//                    if (zeroOrderBranch.size() == 1) {
//                        branchTakeOrder = zeroOrderBranch.get(0);
//                        distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
//                        minDistance = distance;
//                    } else {
//                        for (int j = 1; j < zeroOrderBranch.size(); j++) {
//                            distance = zeroOrderBranch.get(j).getDistance(customerlocationX, customerlocationY);
//                            if (distance < minDistance && zeroOrderBranch.get(j).getProcessTimeLeft() <= branchTakeOrder.getProcessTimeLeft()) {
//                                branchTakeOrder = zeroOrderBranch.get(j);
//                                minDistance = distance;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(resname + " @ " + branchTakeOrder.getLocation() + " takes the order : " + newOrder.getDishname());
//        branchTakeOrder.acceptOrder(newOrder);
//    }
//    public int getDeliveryTime(String resname, int customerlocationX, int customerlocationY) {      // DETERMINE WHICH BRANCH TO TAKE ORDER
//        Restaurants[] restlist = input.getRestlist();
//        Branch[] branchlist;
//        ArrayList<Branch> zeroOrderBranch = new ArrayList<>();
//        Branch branchTakeOrder = null;
//        int distance;
//        int minDistance;
//        int deliveryTime = 0;
//
//        for (int i = 0; i < restlist.length; i++) {
//            if (restlist[i].getName().equals(resname)) {
//                branchlist = restlist[i].getBranches();
//
//                for (int j = 0; j < branchlist.length; j++) {
//                    if (branchlist[j].getTotalOrder() == 0) {
//                        zeroOrderBranch.add(branchlist[j]);
//                    }
//                }
//
//                if (zeroOrderBranch.isEmpty() == true) {
//                    branchTakeOrder = branchlist[0];
//                    distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
//                    minDistance = distance;
//                    deliveryTime = distance;
//                    for (int j = 1; j < branchlist.length; j++) {
//                        distance = branchlist[j].getDistance(customerlocationX, customerlocationY);
//                        if (distance < minDistance && branchlist[j].getProcessTimeLeft() <= branchTakeOrder.getProcessTimeLeft()) {
//                            branchTakeOrder = branchlist[j];
//                            minDistance = distance;
//                            deliveryTime = branchTakeOrder.getCoordinateX() + branchTakeOrder.getCoordinateY();
//                        }
//                    }
//                } else if (zeroOrderBranch.isEmpty() != true) {
//                    branchTakeOrder = zeroOrderBranch.get(0);
//                    distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
//                    minDistance = distance;
//                    deliveryTime = distance;
//                    if (zeroOrderBranch.size() == 1) {
//                        branchTakeOrder = zeroOrderBranch.get(0);
//                        distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
//                        minDistance = distance;
//                        deliveryTime = distance;
//                    } else {
//                        for (int j = 1; j < zeroOrderBranch.size(); j++) {
//                            distance = zeroOrderBranch.get(j).getDistance(customerlocationX, customerlocationY);
//                            if (distance < minDistance && zeroOrderBranch.get(j).getProcessTimeLeft() <= branchTakeOrder.getProcessTimeLeft()) {
//                                branchTakeOrder = zeroOrderBranch.get(j);
//                                minDistance = distance;
//                                deliveryTime = distance;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return deliveryTime;
//    }
    public Branch determine(String resname, String dishname, int customerlocationX, int customerlocationY) {
        int deliveryTime = 0;
        Restaurants[] restList = input.getRestlist();
        Branch[] branchList;
        int totalTimeProcessInc;            // Branch's total time left to process all orders including newOrder
        Branch branchTakeOrder = null;
        ArrayList<Branch> zeroOrderBranch = new ArrayList<>();;
        int minimum;
        int distance = 0;
        int MinDistance = 0;
        
        for (int i = 0; i < restList.length; i++) {
            if (restList[i].getName().equals(resname)) {
                branchList = restList[i].getBranches();
                for (int j = 0; j < branchList.length; j++) {
                    if (branchList[j].getTotalOrder() == 0) {
                        zeroOrderBranch.add(branchList[j]);
                    }
                }
                
                branchTakeOrder = branchList[0];
                totalTimeProcessInc = input.getDishPrepTime(resname, dishname) + branchList[0].getProcessTimeLeft();
                minimum = totalTimeProcessInc;
                
                if (zeroOrderBranch.size() == 3) {
                    // GET SHORTEST DISTANCE
                    distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
                    MinDistance = distance;
                    
                    for (int j = 1; j < branchList.length; j++) {
                        distance = branchList[j].getDistance(customerlocationX, customerlocationY);
                        if (distance < MinDistance) {
                            branchTakeOrder = branchList[j];
                            MinDistance = distance;
                        }
                    }
                    
                } else if (zeroOrderBranch.size() == 2) {
                    // CHOOSE SHORTEST BETWEEN 2 
                    branchTakeOrder = zeroOrderBranch.get(0);
                    distance = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
                    MinDistance = distance;
                    
                    if (zeroOrderBranch.get(1).getDistance(customerlocationX, customerlocationY) < MinDistance) {
                        branchTakeOrder = zeroOrderBranch.get(1);
                        MinDistance = distance;
                    }
                    
                } else {
                    
                    for (int j = 1; j < branchList.length; j++) {
                        totalTimeProcessInc = input.getDishPrepTime(resname, dishname) + branchList[j].getProcessTimeLeft();
                        if (totalTimeProcessInc < minimum) {
                            branchTakeOrder = branchList[j];
                            minimum = totalTimeProcessInc;
                        }
                    }
                }
                
                deliveryTime = branchTakeOrder.getDistance(customerlocationX, customerlocationY);
            }
        }
        return branchTakeOrder;
    }
    
    public void takeOrder(Orders newOrder) {
        Branch branchTakeOrder = determine(newOrder.getResname(), newOrder.getDishname(), newOrder.getCustomerlocationX(), newOrder.getCustomerlocationY());
        branchTakeOrder.acceptOrder(newOrder);
        System.out.println(newOrder.getResname() + " @ " + branchTakeOrder.getLocation() + " takes order : " + newOrder.getDishname());
    }
    
    public int getDeliveryTime(String resname, String dishname, int customerLocationX, int customerLocationY) {
        Branch branchTakeOrder = determine(resname, dishname, customerLocationX, customerLocationY);
        int distance = branchTakeOrder.getDistance(customerLocationX, customerLocationY);
        return distance;
    }
    
}
