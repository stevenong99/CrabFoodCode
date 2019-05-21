/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import crabfood.Handler;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Crimson
 */
public class WaitLine {

    private Queue<Orders> line;
    private ArrayList<Orders> ordersarr;
    private int numberOfArrivals;
    private int numberServed;
    private int totalTimeWaited;
    private Handler handler;
    private ArrayList<Restaurants> restlist;

    public WaitLine(Handler handler) {
        this.handler = handler;
        this.ordersarr = handler.getOrdersarr();
        this.restlist = handler.getRestlist();
        simulate(ordersarr);
        System.out.println("");
        generateSales(restlist);
        //reset();
    }

    public void simulate(ArrayList<Orders> ordersarr) {
        System.out.println("");
        int workingHour = ordersarr.get(0).getTimedeliveredtocustomer();
        boolean complete = false;

        for (int i = 0; i < ordersarr.size(); i++) {
            if (ordersarr.get(i).getTimedeliveredtocustomer() > workingHour) {
                workingHour = ordersarr.get(i).getTimedeliveredtocustomer();
            }
        }
        workingHour++;
        for (int clock = 0; clock < workingHour; clock++) {
            if (clock == 0) {
                System.out.println("0: A new day has start !");
            }
            for (int i = 0; i < ordersarr.size(); i++) {
                if (ordersarr.get(i).getArrivaltime() == clock) {
                    if (ordersarr.get(i).getSpecialreq() != null) {
                        System.out.println(clock + ": Customer " + (ordersarr.indexOf(ordersarr.get(i)) + 1) + " wants to order " + ordersarr.get(i).getDishname() + " (" + ordersarr.get(i).getSpecialreq() + ") from " + ordersarr.get(i).getResname() + ".");
                    } else {
                        System.out.println(clock + ": Customer " + (ordersarr.indexOf(ordersarr.get(i)) + 1) + " wants to order " + ordersarr.get(i).getDishname() + " from " + ordersarr.get(i).getResname() + ".");
                    }

                    System.out.println(clock + ": Branch of " + ordersarr.get(i).getResname() + " at " + ordersarr.get(i).getBranchTakeOrder().getLocation() + " takes the order.");
                    //System.out.println("Number of orders to be processed : " + ordersarr.get(i).getBranchTakeOrder().getTotalOrder());
                } else if (ordersarr.get(i).getFinishedcookingtime() == clock) {
                    System.out.println(clock + ": Branch of " + ordersarr.get(i).getResname() + " at " + ordersarr.get(i).getBranchTakeOrder().getLocation() + " finished the order and starts delivering the food to customer.");
                } else if (ordersarr.get(i).getTimedeliveredtocustomer() == clock) {
                    System.out.println(clock + ": The food have been delivered to customer " + (ordersarr.indexOf(ordersarr.get(i)) + 1) + ".");
                    ordersarr.get(i).getBranchTakeOrder().completeOrder(ordersarr.get(i));
                    //System.out.println("Number of orders to be processed : " + ordersarr.get(i).getBranchTakeOrder().getTotalOrder());
                }
            }
            for (int j = 0; j < ordersarr.size(); j++) {
                if (ordersarr.get(j).getBranchTakeOrder().getProcessTimeLeft() == 0) {
                    complete = true;
                } else {
                    complete = false;
                }
            }
            if (clock == workingHour - 1 && complete == true) {
                System.out.println(clock + ": All customers are served and shops are closed.");
            }
        }
        generateLogFile(ordersarr);
    }

    public void generateSales(ArrayList<Restaurants> restlist) {
        for (int i = 0; i < restlist.size(); i++) {
            for (int j = 0; j < restlist.get(i).getBranches().size(); j++) {
                System.out.println("Branch at " + restlist.get(i).getBranches().get(j).getLocation() + " earns RM " + restlist.get(i).getBranches().get(j).getTotalProfit());
            }
            System.out.println("--------------------------------------------------------------------------");
            System.out.println(restlist.get(i).getName() + " earns total of RM " + restlist.get(i).getTotalIncome());
            System.out.println("--------------------------------------------------------------------------\n");
        }
    }

    public void generateLogFile(ArrayList<Orders> ordersarr) {
        PrintWriter print = null;
        try {
            print = new PrintWriter(new FileOutputStream("Log.txt"));
            print.printf("%-9s|%-8s|%-11s|%-22s|%-14s|%-11s", "Customer", "Arrival", "Order Time", "Finished Cooking Time", "Delivery Time", "Total Time");
            print.println();
            for (int i = 0; i < ordersarr.size(); i++) {
                print.printf("%-16d|%-10d|%-19d|%-37d|%-23d|%-11d", ordersarr.get(i).getOrderNo(), ordersarr.get(i).getArrivaltime(), ordersarr.get(i).getArrivaltime(), ordersarr.get(i).getFinishedcookingtime(), ordersarr.get(i).getDeliverytime(), ordersarr.get(i).getTotaltime());
                print.println();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found!");
        } finally {
            print.close();
        }
    }

    /**
     * Displays summary results of the simulation.
     */
    public void displayResults() {
        System.out.println();
        System.out.println("Number served = " + numberServed);
        System.out.println("Total time waited = " + totalTimeWaited);
        double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
        System.out.println("Average time waited = " + averageTimeWaited);
        int leftInLine = numberOfArrivals - numberServed;
        System.out.println("Number left in line = " + leftInLine);
    } // end displayResults

    /**
     * Initializes the simulation.
     */
    public final void reset() {
        line.clear();
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
    } // end reset

}
