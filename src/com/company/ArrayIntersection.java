package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * CS350 - Digging Around In Arrays
 * Problem 2.4
 * <p>
 * A short program that implements the algorithm written (Problem 2.1)
 * for creating an array from the intersection between two given arrays.
 *
 * @author Kathleen Tran
 */
public class ArrayIntersection {

    private long starting;

    /**
     * Takes two arrays and creates a new array consisting of their intersection
     *
     * @param args Not utilized for this program
     */
    public static void main(String[] args) {

        ArrayIntersection problem = new ArrayIntersection();
        Scanner in = new Scanner(System.in);

        System.out.print("How many items would you like in your first array?\n");
        ArrayList arrayA = problem.buildArray(problem.userArray());

        System.out.print("How many items would you like in your second array?\n");
        ArrayList arrayB = problem.buildArray(problem.userArray());

        problem.startTime();

        Collections.sort(arrayA);
        Collections.sort(arrayB);

        System.out.println("ARRAY a: " + arrayA);
        System.out.println("ARRAY b: " + arrayB);

        ArrayList c = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        int k = 0;
        int lastAdded = 0;
        while (i <= (arrayA.size() - 1) && j <= (arrayB.size() - 1)) {
            if (arrayA.get(i).equals(arrayB.get(j)) && !arrayA.get(i).equals(lastAdded)) {
                c.add(k, arrayA.get(i));
                lastAdded = (int) c.get(k);
                k = k + 1;
                i = i + 1;
                j = j + 1;
                continue;
            }
            if (problem.compare(arrayA.get(i), arrayB.get(j)))
                i = i + 1;
            else
                j = j + 1;
        }

        System.out.print("\nARRAY c: " + c);

        System.out.println("\n\nTotal running time: " + problem.endTimer());
    }

    /**
     * Creates an array of integers from user-supplied input
     *
     * @return An array of integers
     */
    public int[] userArray() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter a positive integer: ");
            int arraySize = in.nextInt();
            in.nextLine();

            Random random = new Random();
            int[] array = new int[arraySize];
            int toAdd;
            int i = 0;
            int j = 0;
            while (i < array.length) {
//                System.out.print("Enter your array value: ");
//                toAdd = in.nextInt();
//                in.nextLine();
                toAdd = random.nextInt(30000);
                array[i] = toAdd;
                j = j + 1;
                i = i + 1;
            }
            return array;
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Invalid index");
            System.exit(1);
        }
        return null;
    }

    /**
     * Creates an ArrayList object from some array of integers
     *
     * @param input An array of integers
     * @return An ArrayList of Integers
     */
    public ArrayList buildArray(int[] input) {
        ArrayList array = new ArrayList<Integer>();
        for (int element : input)
            array.add(element);
        return array;
    }

    /**
     * Compares the value between two objects
     *
     * @param arrayA some index of array a
     * @param arrayB some index of array b
     * @return true if the value in array a is less than the value in array b, else false
     */
    public boolean compare(Object arrayA, Object arrayB) {
        int a = (int) arrayA;
        int b = (int) arrayB;
        return a < b;
    }

    /**
     * Starts the counter
     *
     * @return starting time
     */
    public long startTime() {
        starting = System.currentTimeMillis();
        return starting;
    }

    /**
     * Calculates the time between when the counter was started and ended
     *
     * @return A time representative of the duration between the call to the
     * startTime method and the call to this method
     */
    public double endTimer() {
        long ending = System.currentTimeMillis();
        return ((ending - starting)/1000.0);
    }
}
