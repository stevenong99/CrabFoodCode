package Data;

public class Restaurants {
    private String name;
    private int[][] branch;
    private Dishes[] dishes;
    
    public Restaurants(String name,int[][] branch, Dishes[] dishes){
        this.name=name;
        this.branch=branch;
        this.dishes=dishes;
    }
    
    @Override
    public String toString(){
        String branches="";
        for (int i=0;i<branch.length;i++){
            branches=branches+branch[i][0]+" "+branch[i][1]+"\n";
        }
        return name+" provides the following meals:\n"+getDishes();
    }
    
    public String getDishes(){
        String output="";
        for (int i=0;i<this.dishes.length;i++){
            output=output+this.dishes[i]+"\n";
        }
        return output;
    }
    
    public char compareLocation(int x,int y){
        boolean exist=false;
        for (int a=0;a<branch.length;a++){
            if (branch[a][0]==x){
                    if (branch[a][1]==y)
                        exist=true;
            }
        }
        if (exist==true){
            return name.charAt(0);
        }else return'0';
    }
    
    public int getTime(Dishes dish){
        int i=0;
        while (i<dishes.length){
            if (dish.getDishName().equals(dishes[i].getDishName())) 
               break;
            i++;
        }
        return dishes[i].getPreparationTime();
    }
}
