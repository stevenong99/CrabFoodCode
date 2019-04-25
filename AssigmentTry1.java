/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigmenttry1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class AssigmentTry1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        start();

    }

    public static void start() {
        try {
            Scanner scan = new Scanner(new FileInputStream("C:\\Users\\User\\Desktop\\DSAssignment\\Input.txt"));
            Restaurant[] list = new Restaurant[3];
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
                    Dish[] dishes = new Dish[3];
                    for (int i = 0; i < 3; i++) {
                        dishes[i] = new Dish(scan.nextLine(), scan.nextInt());
                        if (scan.hasNextLine()) {
                            scan.nextLine();
                        }
                    }
                    list[counter] = new Restaurant(name, branches, dishes);
                    counter++;
                }
                if (scan.hasNextLine()) {
                    scan.nextLine();
                }
            }
            System.out.println("Welcome to CrabFood. We have the following restaurants:");
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }

            char[][] map = {{'0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int k=0;
                        while(k < 3) {
                            if (map[i][j]!='0')
                                break;
                            map[i][j] = list[k].compareLocation(i, j);
                            k++;
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be found.");
        }
    }
}
