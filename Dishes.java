package Data;

public class Dishes {
    private String dishName;
    private int preparationTime;
    
    public Dishes(String dishName, int preparationTime){
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
