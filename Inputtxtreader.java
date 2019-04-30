package TextReaders;

import Data.Dishes;
import Data.Restaurants;
import Map.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inputtxtreader {

    private String filename;
    private Restaurants[] restlist;
    private Map newMap;

    public Inputtxtreader(String filename) {
        this.filename = filename;
        extract(filename);
    }

    public void extract(String filename) {
        try {
            Scanner scan = new Scanner(new FileInputStream(filename));
            restlist = new Restaurants[3];
            int counter = 0;
            while (scan.hasNext()) {
                {
                    String name = scan.nextLine();
                    int[][] branches = new int[3][2];
                    for (int i = 0; i < branches.length; i++) {
                        branches[i][0] = scan.nextInt();
                        branches[i][1] = scan.nextInt();
                        scan.nextLine();
                    }
                    Dishes[] dishes = new Dishes[3];
                    for (int i = 0; i < 3; i++) {
                        dishes[i] = new Dishes(scan.nextLine(), scan.nextInt());
                        if (scan.hasNextLine()) {
                            scan.nextLine();
                        }
                    }
                    restlist[counter] = new Restaurants(name, branches, dishes);
                    counter++;
                }
                if (scan.hasNextLine()) {
                    scan.nextLine();
                }
            }
            display();

        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be found.");
        }
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

    public int getShortestDeliveryTime(int customerlocationX, int customerlocationY, String resname) {
        int i = 0;
        while (i < restlist.length) {
            if (resname.equals(restlist[i].getName())) {
                break;
            }
            i++;
        }
        return restlist[i].closestBranch(customerlocationX, customerlocationY);
    }

    public void display() {
        System.out.println("Welcome to CrabFood. We have the following restaurants:");
        for (int i = 0; i < restlist.length; i++) {
            System.out.println(restlist[i]);
        }
    }

    //Getters
    public String getFilename() {
        return filename;
    }

    public Map getNewMap() {
        return newMap;
    }

    public Restaurants[] getRestlist() {
        return restlist;
    }

}
