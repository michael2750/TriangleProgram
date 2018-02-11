/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleprogram;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author micha
 */
public class TriangleProgram {

    private static int[] arr;
    private static String triangle;
    private static boolean isRunning = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Input();
    }

    private static void Input() throws IOException {

        arr = new int[3];
        Scanner scan = new Scanner(System.in);
        while (isRunning) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Please enter a value for your triangle");
                try {
                    arr[i] = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input, please try again");
                    i = 3;
                    isRunning = false;
                }
            }
            if (isRunning) {
                CalcTriangle();
            }
        }
    }

    private static void CalcTriangle() {
        if (arr[0] == arr[1] && arr[0] == arr[2] && arr[1] == arr[2]) {
            triangle = "equilateral triangle";
        } else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
            triangle = "isosceles triangle";
        } else {
            triangle = "scalene triangle";
        }
        System.out.println("Your triangle is " + triangle);
    }
}
