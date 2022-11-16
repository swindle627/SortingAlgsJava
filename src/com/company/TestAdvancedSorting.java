package com.company;
import java.util.Random;
import java.util.Scanner;
// Name: JaDante Hendrick
// Class: CS 4306/4
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 3
// IDE: Intellij
// Algorithm Design Block

/* Mergesort:
 * O(n log n) for best, worst and average cases
 * Counts comparisons made when merging the arrays
 * The mergesort comparison count for increasing and decreasing arrays is lower than the count for random arrays
 * This is due to less comparisons being needed when merging because the arrays are already sorted
 * All of the comparison counts for mergesort are well below O(n log n)
 * This might be due to where I chose to count comparisons at
 * Mergesort is also by far the most efficient of the 3 sorts
 */

/* Quicksort:
 * O(n log n) for best and average cases. O(n^2) for worst case
 * Counts comparisons when comparing left and right values to the pivot value
 * Causes a stack overflow error for large increasing and decreasing arrays
 * This is due to them already being ordered which causes there to be a partition made for every value in the array
 * All increasing and decreasing arrays have an exact comparison count of n(n-1)/2
 * This lines up with the worst case running time of O(n^2)
 * Overall quicksort seems to be the worst performer out of the 3 sorts
 */

/* Heapsort:
 * O(n log n) for best, worst and average cases
 * Counts comparisons made when re-heaping
 * The comparison counts for heapsort are all close to O(n log n)
 * They are also all pretty close to each other (by array size) regardless of the array type
 * This is likely due to me not counting comparisons when converting the arrays to the initial max heap
 * The comparisons for increasing and decreasing are similar due to those arrays having the same values as each other and each value is unique...
 * ...which is unlike the random arrays that can have duplicate values. This is likely why the comparison counts for the random arrays are slightly higher
 * Heapsort seems slightly faster on increasing arrays than decreasing because the max heap for increasing has bigger values in its leaf nodes than decreasing
 * Comparisons are being counted during re-heapification so the small values having to be moved all the way back down the heap for the decreasing arrays adds up
 */
// Code Section
public class TestAdvancedSorting {
    public static void main(String[] args) {

        int option = 0;
        Scanner scan = new Scanner(System.in);

        // Sort objects
        Mergesort mergeSort = new Mergesort();
        Quicksort quickSort = new Quicksort();
        Heapsort heapSort = new Heapsort();

        int oneK = 1000, tenK = 10000, hundredK = 100000, oneMil = 1000000;

        int[] rnd1k = new int[oneK], rnd10k = new int[tenK], rnd100k = new int[hundredK], rnd1mil = new int[oneMil]; // arrays of random generated ints
        int[] inc1k = new int[oneK], inc10k = new int[tenK], inc100k = new int[hundredK], inc1mil = new int[oneMil]; // arrays of increasing ints
        int[] dec1k = new int[oneK], dec10k = new int[tenK], dec100k = new int[hundredK], dec1mil = new int[oneMil]; // arrays of decreasing ints

        // arrays that store comparison counts for each sort
        // indexes: mergesort = (0-3), quicksort = (4-7), heapsort = (8-11)
        int[] randomComparisons = new int[12];
        int[] increasingComparisons = new int[12];
        int[] decreasingComparisons = new int[12];

        // Controls the main menu
        while(option != 4) {
            System.out.println("Main Menu");
            System.out.println("1. Populate Arrays");
            System.out.println("2. Run Algorithms");
            System.out.println("3. Display Outputs");
            System.out.println("4. Exit program");
            System.out.println("\nEnter option number:");

            option = scan.nextInt();

            if (option == 1) {
                // populating arrays
                rnd1k = RandomIntegers(oneK);
                rnd10k = RandomIntegers(tenK);
                rnd100k = RandomIntegers(hundredK);
                rnd1mil = RandomIntegers(oneMil);

                inc1k = IncreasingIntegers(oneK);
                inc10k = IncreasingIntegers(tenK);
                inc100k = IncreasingIntegers(hundredK);
                inc1mil = IncreasingIntegers(oneMil);

                dec1k = DecreasingIntegers(oneK);
                dec10k = DecreasingIntegers(tenK);
                dec100k = DecreasingIntegers(hundredK);
                dec1mil = DecreasingIntegers(oneMil);

                System.out.println("\nArrays populated");
            } else if (option == 2) {
                // Random array sorts
                randomComparisons[0] = mergeSort.SortArray(rnd1k);
                System.out.println("mergesort rnd1k done");
                randomComparisons[1] = mergeSort.SortArray(rnd10k);
                System.out.println("mergesort rnd10k done");
                randomComparisons[2] = mergeSort.SortArray(rnd100k);
                System.out.println("mergesort rnd100k done");
                randomComparisons[3] = mergeSort.SortArray(rnd1mil);
                System.out.println("mergesort rnd1mil done");
                randomComparisons[4] = quickSort.SortArray(rnd1k);
                System.out.println("quicksort rnd1k done");
                randomComparisons[5] = quickSort.SortArray(rnd10k);
                System.out.println("quicksort rnd10k done");
                randomComparisons[6] = quickSort.SortArray(rnd100k);
                System.out.println("quicksort rnd100k done");
                randomComparisons[7] = quickSort.SortArray(rnd1mil);
                System.out.println("quicksort rnd1mil done");
                randomComparisons[8] = heapSort.SortArray(rnd1k);
                System.out.println("heapsort rnd1k done");
                randomComparisons[9] = heapSort.SortArray(rnd10k);
                System.out.println("heapsort rnd10k done");
                randomComparisons[10] = heapSort.SortArray(rnd100k);
                System.out.println("heapsort rnd100k done");
                randomComparisons[11] = heapSort.SortArray(rnd1mil);
                System.out.println("heapsort rnd1mil done");

                // Increasing array sorts
                increasingComparisons[0] = mergeSort.SortArray(inc1k);
                System.out.println("mergesort inc1k done");
                increasingComparisons[1] = mergeSort.SortArray(inc10k);
                System.out.println("mergesort inc10k done");
                increasingComparisons[2] = mergeSort.SortArray(inc100k);
                System.out.println("mergesort inc100k done");
                increasingComparisons[3] = mergeSort.SortArray(inc1mil);
                System.out.println("mergesort inc1mil done");
                increasingComparisons[4] = quickSort.SortArray(inc1k);
                System.out.println("quicksort inc1k done");
                increasingComparisons[5] = quickSort.SortArray(inc10k);
                System.out.println("quicksort inc10k done");
                increasingComparisons[6] = -1;
                System.out.println("quicksort inc100k done");
                increasingComparisons[7] = -1;
                System.out.println("quicksort inc1mil done");
                increasingComparisons[8] = heapSort.SortArray(inc1k);
                System.out.println("heapsort inc1k done");
                increasingComparisons[9] = heapSort.SortArray(inc10k);
                System.out.println("heapsort inc10k done");
                increasingComparisons[10] = heapSort.SortArray(inc100k);
                System.out.println("heapsort inc100k done");
                increasingComparisons[11] = heapSort.SortArray(inc1mil);
                System.out.println("heapsort inc1mil done");

                // Decreasing array sorts
                decreasingComparisons[0] = mergeSort.SortArray(dec1k);
                System.out.println("mergesort dec1k done");
                decreasingComparisons[1] = mergeSort.SortArray(dec10k);
                System.out.println("mergesort dec10k done");
                decreasingComparisons[2] = mergeSort.SortArray(dec100k);
                System.out.println("mergesort dec100k done");
                decreasingComparisons[3] = mergeSort.SortArray(dec1mil);
                System.out.println("mergesort dec1mil done");
                decreasingComparisons[4] = quickSort.SortArray(dec1k);
                System.out.println("quicksort dec1k done");
                decreasingComparisons[5] = quickSort.SortArray(dec10k);
                System.out.println("quicksort dec10k done");
                decreasingComparisons[6] = -1;
                System.out.println("quicksort dec100k done");
                decreasingComparisons[7] = -1;
                System.out.println("quicksort dec1mil done");
                decreasingComparisons[8] = heapSort.SortArray(dec1k);
                System.out.println("heapsort dec1k done");
                decreasingComparisons[9] = heapSort.SortArray(dec10k);
                System.out.println("heapsort dec10k done");
                decreasingComparisons[10] = heapSort.SortArray(dec100k);
                System.out.println("heapsort dec100k done");
                decreasingComparisons[11] = heapSort.SortArray(dec1mil);
                System.out.println("heapsort dec1mil done");

                System.out.println("\nAlgorithms Complete");
            } else if (option == 3) {

                // strings used to display the data for each array type
                String randomData = String.format("%-9s", "Mergesort\t");
                String increasingData = String.format("%-9s", "Mergesort\t");
                String decreasingData = String.format("%-9s", "Mergesort\t");

                for(int i = 0; i < 12; i++)
                {
                    // starts quicksort row because quicksort comparison data starts at index 4
                    if(i == 4)
                    {
                        randomData += String.format("%-9s", "\nQuicksort\t");
                        increasingData += String.format("%-9s", "\nQuicksort\t");
                        decreasingData += String.format("%-9s", "\nQuicksort\t");
                    }
                    // starts heapsort row because heapsort comparison data starts at index 8
                    else if (i == 8)
                    {
                        randomData += String.format("%-9s", "\nHeapsort\t");
                        increasingData += String.format("%-9s", "\nHeapsort\t");
                        decreasingData += String.format("%-9s", "\nHeapsort\t");
                    }

                    if(randomComparisons[i] == -1)
                    {
                        randomData += String.format("%-9s", "Overflow");
                    }
                    else
                    {
                        randomData += String.format("%-9s", randomComparisons[i]);
                    }

                    if (increasingComparisons[i] == -1)
                    {
                        increasingData += String.format("%-9s", "Overflow");
                    }
                    else
                    {
                        increasingData += String.format("%-9s", increasingComparisons[i]);
                    }

                    if(decreasingComparisons[i] == -1)
                    {
                        decreasingData += String.format("%-9s", "Overflow");
                    }
                    else
                    {
                        decreasingData += String.format("%-9s", decreasingComparisons[i]);
                    }
                }

                // displaying comparisons from random array
                String rndHeader = String.format("%-9s%-9s%-9s%-9s%-9s", "Algorithm\t", "n=1000", "n=10000", "n=100000", "n=1000000");
                System.out.println("Array Type: Random\n" + rndHeader + "\n---------------------------------------------------------------");
                System.out.println(randomData);

                // displaying comparisons from increasing array sorts
                String incHeader = String.format("%-9s%-9s%-9s%-9s%-9s", "Algorithm\t", "n=1000", "n=10000", "n=100000", "n=1000000");
                System.out.println("\nArray Type: Increasing\n" + incHeader + "\n---------------------------------------------------------------");
                System.out.println(increasingData);

                // displaying comparisons from decreasing array sorts
                String decHeader = String.format("%-9s%-9s%-9s%-9s%-9s", "Algorithm\t", "n=1000", "n=10000", "n=100000", "n=1000000");
                System.out.println("\nArray Type: Decreasing\n" + decHeader + "\n---------------------------------------------------------------");
                System.out.println(decreasingData);
            }

            System.out.println("\n");
        }
    }
    // Returns an array of random integers
    // n determines array size
    public static int[] RandomIntegers(int n)
    {
        Random rnd = new Random();
        int[] randomInts = new int[n];

        for(int i = 0; i < n; i++)
        {
            randomInts[i] = rnd.nextInt(n+1);
        }

        return randomInts;
    }
    // Returns an array of increasing integers from 1 to n
    // n determines array size
    public static int[] IncreasingIntegers(int n)
    {
        int[] increasingInts = new int[n];

        for(int i = 0; i < n; i++)
        {
            increasingInts[i] = i + 1;
        }

        return increasingInts;
    }
    // Returns an array of decreasing integers from n to 1
    // n determines array size
    public static int[] DecreasingIntegers(int n)
    {
        int[] decreasingInts = new int[n];

        for (int i = 0; i < decreasingInts.length; i++)
        {
            decreasingInts[i] = n;
            n--;
        }

        return decreasingInts;
    }
}
