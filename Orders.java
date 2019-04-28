/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import TxtReaders.Inputtxtreader;

/**
 *
 * @author TAN JIA QIN (WIF180073)
 */
public class Orders {

    private int orderTime;
    private int cookTime;
    private int deliveryTime;
    private int totalTime;
    private String restaurantName;
    private String dishOrdered;
    private Inputtxtreader input = new Inputtxtreader ("Input.txt");

    public Orders(int orderTime, String restaurantName, String dishOrdered) {
        this.orderTime = orderTime;
        this.restaurantName = restaurantName;
        this.dishOrdered = dishOrdered;
        this.cookTime = this.orderTime + input.getPrepTime(dishOrdered);
        
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDishOrdered() {
        return dishOrdered;
    }

    public void setDishOrdered(String dishOrdered) {
        this.dishOrdered = dishOrdered;
    }

    @Override
    public String toString() {
        return "Order Time      : " + orderTime + "\nCook Time       : " + cookTime + "\nDelivery Time   : " + deliveryTime + "\nTotal Time      : " + totalTime + "\nRestaurant Name : " + restaurantName + "\nDish Ordered    : " + dishOrdered + "\n";
    }

}
