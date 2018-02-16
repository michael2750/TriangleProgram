/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleprogram;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author micha
 */
public class TriangleProgram {

    private int[] arr;
    private String triangle;
    private boolean isRunning;
    private static final Logger LOGGER = Logger.getLogger(TriangleProgram.class.getName());
    private final FileHandler fileHandle;
    private final SimpleFormatter simpleFormat;
    private String errorMessage;

    /**
     * @param simpleFor
     * @param fileHandler
     * @param logger
     */
    public TriangleProgram(SimpleFormatter simpleFor, FileHandler fileHandler, Logger logger) {
        isRunning = true;
        this.fileHandle = fileHandler;
        this.simpleFormat = simpleFor;
        logger.addHandler(fileHandle);
        fileHandler.setFormatter(simpleFormat);
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //Path to the log file
        String path = TriangleProgram.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1);
        path = path.substring(0, path.length() - 14);

        /*Settinng up a logger, formatter and a filehandler with the given path so it can log errors
        to the file called "Log.txt"*/
        FileHandler fileHandler = new FileHandler(path + "\\Log.txt");
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        TriangleProgram triangleProgram = new TriangleProgram(simpleFormatter, fileHandler, LOGGER);
        triangleProgram.inputHandler();
    }

    private void inputHandler() throws IOException {
        Scanner scan = new Scanner(System.in);
        arr = new int[3];
        while (isRunning) {
            System.out.println("To enter values to you triangle type 1");
            System.out.println("To exit the program type 2");
            try {
                arr[0] = scan.nextInt();
                if (arr[0] == 1) {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println("Please enter a value for your triangle");
                        arr[i] = scan.nextInt();
                    }
                    calcTriangle();
                } else if (arr[0] == 2) {
                    System.out.println("Closing the program, goodbye");
                    isRunning = false;
                } else if (arr[0] > 2) {
                    System.out.println("!Invalid value please try again");
                }
            } catch (InputMismatchException ex) {
                errorMessage = "!Invalid error detected. You got a ";
                System.out.println(errorMessage + ex);
                LOGGER.log(Level.INFO, "{0}{1}", new Object[]{errorMessage, ex});
                System.out.println("Please try again");
                scan = new Scanner(System.in);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exc) {
                    LOGGER.log(Level.INFO, "{0}{1}", new Object[]{errorMessage, exc});
                }
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
