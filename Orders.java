package Data;

public class Orders {

    private String resname, dishname;
    private int arrivaltime, finishedcookingtime, timetakentocook, deliverytime, totaltime, timedeliveredtocustomer, customerlocationX, customerlocationY;

    public Orders(int arrivaltime, String resname, String dishname, int timetakentocook, int deliverytime, int customerlocationX, int customerlocationY) {
        this.arrivaltime = arrivaltime;
        this.resname = resname;
        this.dishname = dishname;
        this.customerlocationX = customerlocationX;
        this.customerlocationY = customerlocationY;
        this.timetakentocook = timetakentocook;
        this.finishedcookingtime = arrivaltime + timetakentocook;
        this.deliverytime = deliverytime;
        this.totaltime = deliverytime + timetakentocook;
        this.timedeliveredtocustomer = totaltime + arrivaltime;
    }

    public int getArrivaltime() {
        return arrivaltime;
    }

    public int getFinishedcookingtime() {
        return finishedcookingtime;
    }

    public int getTimetakentocook() {
        return timetakentocook;
    }

    public int getDeliverytime() {
        return deliverytime;
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
