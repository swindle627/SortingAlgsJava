package com.company;
import java.util.Stack;
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
public class Quicksort {

    // counts comparisons
    private int comparisonCount;
    private int[] Unsorted;

    // Calls Sort() and returns comparison count
    public int SortArray(int[] unsorted)
    {
        comparisonCount = 0;
        Unsorted = unsorted;
        Sort(unsorted);
        return comparisonCount;
    }
    // Sorts array using quicksort
    private int[] Sort(int[] unsorted)
    {
        int low = 0; // first index of the array
        int high = Unsorted.length - 1; // last index of the array
        Stack<Integer> indexes = new Stack<Integer>(); // stack containing low and high indexes

        indexes.push(low);
        indexes.push(high);


        while (indexes.size() > 0)
        {
            high = indexes.pop();
            low = indexes.pop();

            int pIndex = Partition(low, high); // gets the partition index

            // adds the low and high indexes for the left partition to the stack
            if (pIndex - 1 > low)
            {
                indexes.push(low);
                indexes.push(pIndex - 1);
            }

            // adds the low and high indexes for the right partition to the stack
            if (pIndex + 1 < high)
            {
                indexes.push(pIndex + 1);
                indexes.push(high);
            }
        }

        return unsorted;
    }
    private int Partition(int low, int high)
    {
        int pivot = Unsorted[high]; // sets pivot value to farthest right value
        int pIndex = low - 1; // partition index
        int temp; // used for swapping

        // puts values lower than or equal to the pivot value to the left of it and values higher than the pivot value to the right of it
        // loop stops before it reaches the pivot value's index
        for (int i = low; i < high; i++)
        {
            if (Unsorted[i] <= pivot)
            {
                pIndex++;
                temp = Unsorted[i];
                Unsorted[i] = Unsorted[pIndex];
                Unsorted[pIndex] = temp;
            }
            comparisonCount++;
        }

        // this will set pIndex to the index the pivot value is supposed to be at
        pIndex++;

        // puts the pivot value into its correct place
        temp = Unsorted[high];
        Unsorted[high] = Unsorted[pIndex];
        Unsorted[pIndex] = temp;

        return pIndex;
    }
}
