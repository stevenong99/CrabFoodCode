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
        this.newMap = new Map(restlist);
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
            System.out.println("Welcome to CrabFood. We have the following restaurants:");
            for (int i = 0; i < restlist.length; i++) {
                System.out.println(restlist[i]);
            }
        }catch (FileNotFoundException e) {
            System.out.println("The file cannot be found.");
        }
    }

    public Restaurants[] getRestlist() {
        return restlist;
    }
    
    
}
