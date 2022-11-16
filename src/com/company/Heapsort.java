package com.company;
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
public class Heapsort {

    // counts comparisons
    private int comparisonCount;

    // Calls Sort() and returns comparison count
    public int SortArray(int[] unsorted)
    {
        comparisonCount = 0;
        Sort(unsorted);
        return comparisonCount;
    }
    // Sorts array using heapsort
    private int[] Sort(int[] unsorted)
    {
        int size = unsorted.length;
        int[] sorted = new int[size];

        // builds initial heap
        int[] heap = CreateHeap(unsorted, size);

        // sorting heap
        for (int i = 0; i < sorted.length; i++)
        {
            sorted[i] = heap[0];

            // swap the first and last element of the heap
            // this plus reheaping is reversing the actual heap. returning heap instead of sorted will show that
            int temp = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = temp;

            // decrease size of heap
            size--;

            // re-heapification
            heap = ReHeap(heap, size, 0);
        }

        return sorted;
    }
    private int[] ReHeap(int[] heap, int size, int root)
    {
        int largest = root; // index of tree/sub-tree root
        int leftChild = 2 * root + 1; // left child index
        int rightChild = 2 * root + 2; // right child index

        // if left child value is larger than root value set its index to largest
        if (leftChild < size && heap[largest] < heap[leftChild])
        {
            largest = leftChild;
            comparisonCount++;
        }

        // if right child is larger than root or left child value set its index to largest
        if (rightChild < size && heap[largest] < heap[rightChild])
        {
            largest = rightChild;
            comparisonCount++;
        }

        // if the root value isnt larger than its children's values swap the largest child value with root value
        // recursive call with the new root set to the index the old root was just swapped to
        if (largest != root)
        {
            int temp = heap[root];
            heap[root] = heap[largest];
            heap[largest] = temp;

            heap = ReHeap(heap, size, largest);
        }

        return heap;
    }
    private int[] CreateHeap(int [] arr, int size)
    {
        int[] heap = new int[size];

        // building heap
        for (int i = 0; i < heap.length; i++)
        {
            heap[i] = arr[i];

            int curr = i; // current index
            int parent = (curr - 1) / 2; // parent of current index

            // up re-heapification
            while (curr > 0 && heap[curr] > heap[parent])
            {
                int temp = heap[curr];
                heap[curr] = heap[parent];
                heap[parent] = temp;

                curr = parent;
                parent = (curr - 1) / 2;
            }
        }

        return heap;
    }
}
