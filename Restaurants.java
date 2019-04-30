package Data;

public class Restaurants {
    private String name;
    private int[][] branch;
    private Dishes[] dishes;
    private int numberofbranches;
    
    public Restaurants(String name,int[][] branch, Dishes[] dishes){
        this.name=name;
        this.branch=branch;
        this.dishes=dishes;
        this.numberofbranches = 3;
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
    
    public int getTime(String dishname){
        int i=0;
        while (i<dishes.length){
            if (dishname.equals(dishes[i].getDishName())) 
               break;
            i++;
        }
        return dishes[i].getPreparationTime();
    }

    public void setBranch(int[][] branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public int closestBranch(double customerlocationX, double customerlocationY){
        int restX = branch[0][0];
        int restY = branch[0][1];
        int closestX = 0;
        int closestY = 0;
        int time = (int) Math.pow(customerlocationX - restX, 2) + (int) Math.pow(customerlocationY - restY, 2);
        for (int i = 1; i < numberofbranches; i++) {
            restX = branch[i][0];
            restY = branch[i][1];
            int newTime = (int) Math.pow(customerlocationX - restX, 2) + (int) Math.pow(customerlocationY - restY, 2);
            if (newTime< time){
                time = newTime;
                closestX = restX;
                closestY = restY;
            }
        }
        int deliverytime = (int)(Math.abs(customerlocationX - closestX) + Math.abs(customerlocationY - closestY));
        return deliverytime;
    }
    
}
