/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleprogram;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import sun.rmi.runtime.Log;

/**
 *
 * @author micha
 */
public class TriangleProgram {

    private int[] arr;
    private String triangle;
    private boolean isRunning = true;
    private int i;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        TriangleProgram TP = new TriangleProgram();
        TP.input();
    }

    private void input() throws IOException {
        Scanner scan = new Scanner(System.in);
        arr = new int[3];
        while (isRunning) {
            System.out.println("To enter values to you triangle type 1");
            System.out.println("To exit the program type 2");
            try {
                arr[0] = scan.nextInt();
                if (arr[0] == 1) {
                    for (i = 0; i < arr.length; i++) {
                        System.out.println("Please enter a value for your triangle");
                        arr[i] = scan.nextInt();
                    }
                    calcTriangle();
                } 
                else if (arr[0] == 2) {
                    System.out.println("Closing the program, goodbye");
                    isRunning = false;
                }
                else if (arr[0] > 2) {
                    System.out.println("!Invalid value please try again");
                }
            } catch (InputMismatchException ex) {
                System.out.println("!Invalid error detected. You got a " + ex);
                scan = new Scanner(System.in);
            }
        }
    }

    private void calcTriangle() {
        if (arr[0] == arr[1] && arr[0] == arr[2]) {
            triangle = "equilateral triangle";
        } else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
            triangle = "isosceles triangle";
        } else {
            triangle = "scalene triangle";
        }
        System.out.println("--> Your triangle is: " + triangle);
        arr[0] = 0;
    }
}
