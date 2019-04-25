/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigmenttry1;

/**
 *
 * @author User
 */
public class Dish {
    private String dishName;
    private int preparationTime;
    
    public Dish(String dishName,int preparationTime){
        this.dishName=dishName;
        this.preparationTime=preparationTime;
    }
    
    public String toString(){
        return dishName+"\nPreparation Time: "+preparationTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public String getDishName() {
        return dishName;
    }
    
    
}
