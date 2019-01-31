package arrays;


/*
 Objec­tive:  Given an array of integer write an algorithm to find the local minima.

Local Minima: An element is considered as local minima if it is less than both of its neighbors (if neighbors exist).

Example:

int [] arrA = {11, 4, 2, 5, 11, 13, 5};
Output: Local Minima is: 2

int []arrA = {1,2,3,4};
Output: 1

int []arrA = {3};
Output: 3

int []arrA = {6,4};
Output: 4

NOTE: There could be many local minima’s, we need to find any one.

Naïve: Use for loop and compare every element with its neighbor.

Time Complexity – O(n)

Binary Search Approach:

Check if mid element is smaller than its left and right neighbors.
If left neighbor is less than the mid element then make a recursive call to the left half of the array. 
(There will be at least one local minima in the left half, take few examples to check)
If right neighbor is less than the mid element then make a recursive call to the right half of the array.
Time Complexity – O(logn)
 */
public class LocalMinimalBinary {

    public int find(int [] arrA, int start, int end){

        //find the mid
        int mid = start + (end-start)/2;
        int size = arrA.length;

        //check the local minima (element is smaller than its left and right neighbors)
        //first check if left and right neighbor exists
        if((mid==0 || arrA[mid-1]>arrA[mid]) &&
                (mid==size-1 || arrA[mid+1]>arrA[mid]))
            return arrA[mid];
        //check if left neighbor is less than mid element, if yes go left
        else if(mid>0 && arrA[mid]>arrA[mid-1]){
            return find(arrA, start, mid);
        }else { //if(mid<size-1 && arrA[mid]>arrA[mid+1])
            return find(arrA, mid+1, end);
        }
    }

    public static void main(String[] args) {
        LocalMinimalBinary l = new LocalMinimalBinary();
        int [] arrA = {11, 4, 2, 5, 11, 13, 5};
        System.out.println("Local Minima is: " + l.find(arrA,0,arrA.length));
    }
}