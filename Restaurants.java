package Data;

public class Restaurants {

    private String name;
    private Branch[] branches;
    private Dishes[] dishes;
    private int numberofbranches;

//    public Restaurants(String name, int[][] branch, Dishes[] dishes) {
//        this.name = name;
//        this.branch = branch;
//        this.dishes = dishes;
//        this.numberofbranches = 3;
//        for (int i = 0; i < 3; i++) {
//            newBranch = new Branch(branch[i][0], branch[i][1]);
//            System.out.println(newBranch.toString());
//        }
//    }

    public Restaurants(String name, Branch[] branches, Dishes[] dishes) {
        this.name = name;
        this.branches = branches;
        this.dishes = dishes;
        this.numberofbranches = 3;
    }
    
    @Override
    public String toString() {
        String branches = "";
        for (int i = 0; i < this.branches.length; i++) {
            if (i!=this.branches.length-1)
                branches = branches + this.branches[i].getLocation() + ",";
            else
                branches = branches + this.branches[i].getLocation() + ".";
        }
        return name + " located at " + branches + "\n"+ "It provides the following meals:\n" + DishesServed();
    }

    public String DishesServed() {
        String output = "";
        for (int i = 0; i < this.dishes.length; i++) {
            output = output + this.dishes[i] + "\n";
        }
        return output;
    }

    public Dishes[] getDishes() {
        return dishes;
    }

    public char compareLocation(int x, int y) {
        boolean exist = false;
        for (int a = 0; a < this.branches.length; a++) {
            if (this.branches[a].getCoordinateX() == x) {
                if (this.branches[a].getCoordinateY() == y) {
                    exist = true;
                }
            }
        }
        if (exist == true) {
            return name.charAt(0);
        } else {
            return '0';
        }
    }

    public int getTime(String dishname) {
        int i = 0;
        while (i < dishes.length) {
            if (dishname.equals(dishes[i].getDishName())) {
                break;
            }
            i++;
        }
        return dishes[i].getPreparationTime();
    }

//    public void setBranch(int[][] branch) {
//        this.branch = branch;
//    }

    public String getName() {
        return name;
    }

    public int closestBranch(int customerlocationX, int customerlocationY) {
        int restX = this.branches[0].getCoordinateX();
        int restY = this.branches[0].getCoordinateY();
        int closestX = 0;
        int closestY = 0;
        int time = (int) Math.pow(customerlocationX - restX, 2) + (int) Math.pow(customerlocationY - restY, 2);
          for (int i=1;i<this.branches.length;i++)
          {
              restX = this.branches[i].getCoordinateX();
              restY = this.branches[i].getCoordinateY();
              int newTime = (int) Math.pow(customerlocationX - restX, 2) + (int) Math.pow(customerlocationY - restY, 2);
              if (newTime<time)
              {
                  time = newTime;
                  closestX = restX;
                  closestY = restY;
              }
          }
        int deliverytime = (int) (Math.abs(customerlocationX - closestX) + Math.abs(customerlocationY - closestY));
        return deliverytime;
    }

    public Branch[] getBranches() {
        return branches;
    }
    
    

}
