package Data;

import TextReaders.Inputtxtreader;
import crabfood.Handler;
import crabfood.Launcher;

public class Orders {
    private Restaurants[] restlist;
    private String resname, dishname;
    private int arrivaltime, finishedcookingtime, timetakentocook, deliverytime, totaltime, timedeliveredtocustomer, customerlocationX, customerlocationY;

    public Orders(String resname, String dishname, int arrivaltime, int customerlocationX, int customerlocationY, Restaurants[] restlist) {//Restlist, dishpreptime
        this.restlist = restlist;
        this.resname = resname;
        this.dishname = dishname;
        this.arrivaltime = arrivaltime;
        this.customerlocationX = customerlocationX;
        this.customerlocationY = customerlocationY;
        this.timetakentocook = getTimeTakenToCook();
        this.finishedcookingtime = timetakentocook + arrivaltime;
        this.deliverytime = getDeliverytime(resname,dishname,customerlocationX,customerlocationY);
        this.totaltime = this.timetakentocook + this.deliverytime;
        this.timedeliveredtocustomer = this.arrivaltime + this.totaltime;
    }

    public int getTimeTakenToCook() {
        Dishes[] dishesList;
        int preparationTime = 0;
        for (int i = 0; i < restlist.length; i++) {
            if (restlist[i].getName().equals(resname)) {
                dishesList = restlist[i].getDishes();
                for (int j = 0; j < dishesList.length; j++) {
                    if (dishesList[j].getDishName().equals(dishname)) {
                        preparationTime = dishesList[j].getPreparationTime();
                    }
                }
            }
        }
        return preparationTime;
    }

    public Branch determine(String resname, String dishname, int customerLocationX, int customerLocationY) {
        Branch[] branchList;
        int totalTimeProcessInc;            // Branch's total time left to process all orders including newOrder
        Branch branchTakeOrder = null;
        int minimum;

        for (int i = 0; i < restlist.length; i++) {
            if (restlist[i].getName().equals(resname)) {
                branchList = restlist[i].getBranches();

                branchTakeOrder = branchList[0];
                totalTimeProcessInc = getDishPrepTime(resname, dishname) + branchList[0].getProcessTimeLeft() + branchTakeOrder.getDistance(customerlocationX, customerlocationY);
                minimum = totalTimeProcessInc;

                for (int j = 1; j < branchList.length; j++) {
                    totalTimeProcessInc = getDishPrepTime(resname, dishname) + branchList[j].getProcessTimeLeft() + branchList[j].getDistance(customerlocationX, customerlocationY);
                    if (totalTimeProcessInc < minimum) {
                        branchTakeOrder = branchList[j];
                        minimum = totalTimeProcessInc;
                    }
                }

            }
        }
        return branchTakeOrder;
    }

    public int getDeliverytime(String resname, String dishname, int customerLocationX, int customerLocationY) {
        int deliveryTime = 0;
        deliveryTime = determine(resname, dishname, customerLocationX, customerLocationY).getDistance(customerLocationX, customerLocationY);
        return deliveryTime;
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

    //Getters and Setters
    public int getArrivaltime() {
        return arrivaltime;
    }

    public int getFinishedcookingtime() {
        return finishedcookingtime;
    }
    
    public int getTimedeliveredtocustomer() {
        return timedeliveredtocustomer;
    }

    public int getCustomerlocationX() {
        return customerlocationX;
    }

    public int getCustomerlocationY() {
        return customerlocationY;
    }

    public void setArrivaltime(int arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public int getTotaltime() {
        return totaltime;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String toString(int i) {
        return "Order " + (i + 1) + "\nRestaurant name = " + resname + "\nDish name = " + dishname + "\nArrival time = " + arrivaltime
                + "\nFinished cooking at = " + finishedcookingtime + "\nDelivered at = " + timedeliveredtocustomer;

    }

}
