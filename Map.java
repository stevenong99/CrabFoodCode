/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

/**
 *
 * @author Crimson
 */
public class Map {
    private int[][] array;
    private int length, width;

    public Map() {
        this.length = 5;
        this.width = 5;
        this.array = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
    }
    
    
}
