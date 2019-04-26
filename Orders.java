package Data;

public class Orders {
    private String resname, dishname;
    private int arrivaltime;
    public Orders(int arrivaltime, String resname, String dishname) {
        this.arrivaltime = arrivaltime;
        this.resname = resname;
        this.dishname = dishname;
    }

    public int getArrivaltime() {
        return arrivaltime;
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

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String toString(int i) {
        return "Order " + i +  "\nRestaurant name = " + resname + "\nDish name = " + dishname + "\nArrival time = " + arrivaltime;
    }
    
    
}
