package Map;

import Data.Restaurants;

public class Map {

    private char[][] map;
    private int length, width;
    private Restaurants[] list;

    public Map(Restaurants[] list) {
        this.length = 5;
        this.width = 5;
        this.map = new char[length][width];
        this.list = list;
        createMap();
        display();
    }
    
    public void display(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void createMap(){
        System.out.println("");
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j] = '0';
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int k = 0;
                while (k < 3) {
                    if (map[i][j] != '0') {
                        break;
                    }
                    map[i][j] = list[k].compareLocation(i, j);
                    k++;
                }
            }
        }
    }

}

