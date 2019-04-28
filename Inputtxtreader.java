/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TxtReaders;

import Data.Dishes;
import Data.Restaurants;
import Map.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TAN JIA QIN (WIF180073)
 */
public class Inputtxtreader {

    private String filename;
    private Restaurants[] restList = new Restaurants[3];
    private ArrayList<Dishes> listofDishes;
    private Map map;

    public Inputtxtreader(String filename) {
        this.filename = filename;
        this.listofDishes = new ArrayList<>();
        read();
    }

    public void read() {
        try {
            Scanner s = new Scanner(new FileInputStream(filename));
            Dishes[] dishServed = new Dishes[3];
            int counter = 0;

            while (s.hasNextLine()) {
                String restName = s.nextLine();
                int[][] branchLocation = new int[3][2];
                for (int i = 0; i < 3; i++) {
                    branchLocation[i][0] = s.nextInt();
                    branchLocation[i][1] = s.nextInt();
                    s.nextLine();
                }

                for (int i = 0; i < 3; i++) {
                    Dishes dishes = new Dishes(s.nextLine(), s.nextInt());
                    dishServed[i] = dishes;
                    listofDishes.add(dishes);
                    if (s.hasNext()) {
                        s.nextLine();
                    }
                }
                restList[counter] = new Restaurants(restName, branchLocation, dishServed);
                counter++;
                if (s.hasNextLine()) {
                    s.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found in the folder.");
        }

    }

    public void displayExtractedInformation() {
        for (int i = 0; i < restList.length; i++) {
            System.out.println(restList[i].toString());
        }
    }

    public int getPrepTime(String name) {
        for (int i = 0; i < listofDishes.size(); i++) {
            if (listofDishes.get(i).getName().equals(name)) {
                return listofDishes.get(i).getPrepTime();
            }
        }
        return 0;
    }

    public void createMap() {
        map = new Map(restList);
    }
}
