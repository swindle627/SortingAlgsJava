package com.company;
import java.util.Arrays;
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
public class Mergesort {
    // counts comparisons
    private int comparisonCount;

    // Calls Sort() and returns comparison count
    public int SortArray(int[] unsorted)
    {
        comparisonCount = 0;
        Sort(unsorted);
        return comparisonCount;
    }
    // Sorts array using mergesort
    private int[] Sort(int[] unsorted)
    {
        if (unsorted.length == 1)
        {
            return unsorted;
        }

        // set arrOne size to half the size of unsorted
        int arrOneSize = unsorted.length / 2;
        // set arrTwo size to half the size of unsorted
        // if size of unsorted is odd arrTwo will have the extra value
        int arrTwoSize = unsorted.length - arrOneSize;

        int[] arrOne = new int[arrOneSize];
        int[] arrTwo = new int[arrTwoSize];

        System.arraycopy(unsorted, 0, arrOne, 0, arrOneSize);
        System.arraycopy(unsorted, arrOneSize, arrTwo, 0, arrTwoSize);

        arrOne = Sort(arrOne);
        arrTwo = Sort(arrTwo);

        return Merge(arrOne, arrTwo);
    }
    private int[] Merge(int[] arrOne, int[] arrTwo)
    {
        int[] mergedArray = new int[arrOne.length + arrTwo.length];

        int arrOneIndex = 0; // increments every time value from arrOne is added to mergedArray
        int arrTwoIndex = 0; // increments every time value from arrTwo is added to mergedArray
        int mergeIndex = 0; // index of mergedArray that values will be added to when merging. increments every time value is added to mergedArray

        // runs until all the values in arrOne OR arrTwo have been added to mergedArray
        // the lowest value is added to mergedArray which will order the array from least to greatest
        while (arrOneIndex < arrOne.length && arrTwoIndex < arrTwo.length)
        {
            if (arrOne[arrOneIndex] > arrTwo[arrTwoIndex])
            {
                mergedArray[mergeIndex] = arrTwo[arrTwoIndex];
                arrTwoIndex++;
            }
            else
            {
                mergedArray[mergeIndex] = arrOne[arrOneIndex];
                arrOneIndex++;
            }

            comparisonCount++;
            mergeIndex++;
        }

        // add any remaining values from arrOne or arrTwo to the end of the mergedArray
        // only one of these loops will run because one of the arrays will already have all its values added
        while (arrOneIndex < arrOne.length)
        {
            mergedArray[mergeIndex] = arrOne[arrOneIndex];
            arrOneIndex++;
            mergeIndex++;
        }
        while (arrTwoIndex < arrTwo.length)
        {
            mergedArray[mergeIndex] = arrTwo[arrTwoIndex];
            arrTwoIndex++;
            mergeIndex++;
        }

        return mergedArray;
    }
}
