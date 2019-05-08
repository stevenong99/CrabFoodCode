package Map;

import Data.Restaurants;
import java.util.ArrayList;

public class Map {

    private char[][] map;
    private int length, width;
    private ArrayList<Restaurants> list;

    public Map(ArrayList<Restaurants> list) {
        this.length = 14;
        this.width = 25;
        this.map = new char[length][width];
        this.list = list;
        createMap();
        display();
    }
    
    public void display(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void createMap(){
        System.out.println("");
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '0';
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int k = 0;
                while (k < list.size()) {
                    if (map[i][j] != '0') {
                        break;
                    }
                    map[i][j] = list.get(k).compareLocation(i, j);
                    k++;
                }
            }
        }
    }

}

