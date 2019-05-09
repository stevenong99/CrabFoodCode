/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import crabfood.Handler;
import java.util.ArrayList;

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

    public WaitLine(Handler handler) {
        this.handler = handler;
        this.ordersarr = handler.getOrdersarr();
        simulate(60, ordersarr);
        //reset();
    }

//    public void simulate(int duration, double arrivalProbability, int maxTransactionTime) {
//        int transactionTimeLeft = 0;
//        for (int clock = 0; clock < duration; clock++)  {
//            if (Math.random() < arrivalProbability) {
//                numberOfArrivals++;
//                int transactionTime = (int)(Math.random()* maxTransactionTime + 1);
//                Orders nextArrival = new Orders(clock, transactionTime,numberOfArrivals);
//                line.enqueue(nextArrival);
//                System.out.println("Customer " + numberOfArrivals + " enters line at time " + clock + ". Transaction time is " + transactionTime);
//            } // end if
//
//            if (transactionTimeLeft > 0)
//                transactionTimeLeft--;
//            else if (!line.isEmpty())   {
//                Orders nextCustomer = line.dequeue();
//                transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
//                int timeWaited = clock - nextCustomer.getArrivalTime();
//                totalTimeWaited = totalTimeWaited + timeWaited;
//                numberServed++;
//                System.out.println("Customer " + nextCustomer.getCustomerNumber() + " begins service at time " + clock + ". Time waited is " + timeWaited);
//            } // end if
//        } // end for
//    } // end simulate
    public void simulate(int workingHour, ArrayList<Orders> ordersarr) {
        for (int clock = 0; clock < workingHour; clock++) {
            for (int i = 0; i < ordersarr.size(); i++) {
                if (ordersarr.get(i).getArrivaltime() == clock) {
                    System.out.println(clock + ": Customer " + (ordersarr.indexOf(ordersarr.get(i)) + 1) + " wants to order " + ordersarr.get(i).getDishname() + " from " + ordersarr.get(i).getResname() + ".");
                    System.out.println(clock + ": Branch of " + ordersarr.get(i).getResname() + " at " + ordersarr.get(i).getBranchTakeOrder().getLocation() + " takes the order.");
                    System.out.println("Number of orders to be processed : " + ordersarr.get(i).getBranchTakeOrder().getTotalOrder());
                } else if (ordersarr.get(i).getFinishedcookingtime() == clock) {
                    System.out.println(clock + ": Branch of " + ordersarr.get(i).getResname() + " at " + ordersarr.get(i).getBranchTakeOrder().getLocation() + " finished the order and starts delivering the food to customer.");
                } else if (ordersarr.get(i).getTimedeliveredtocustomer() == clock) {
                    System.out.println(clock + ": The food have been delivered to customer " + (ordersarr.indexOf(ordersarr.get(i)) + 1) + ".");
                    ordersarr.get(i).getBranchTakeOrder().completeOrder(ordersarr.get(i));
                    System.out.println("Number of orders to be processed : " + ordersarr.get(i).getBranchTakeOrder().getTotalOrder());
                }
            }
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
