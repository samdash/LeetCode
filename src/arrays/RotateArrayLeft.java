package arrays;

public class RotateArrayLeft { 

    // Driver program to test above functions 
    public static void main(String[] args) 
    { 
    	RotateArrayLeft rotate = new RotateArrayLeft(); 
        int arr[] = { 1, 2, 3, 4, 5 }; 
        rotate.leftRotate(arr, 2); 
        rotate.leftRotateII(arr, 2);
        rotate.printArray(arr); 
    } 
    
    //Print left rotation of array in O(n) time and O(1) space
    public void leftRotate(int arr[],int k) 
	{ 
    	int n = arr.length;
		/* To get the starting point of  
		rotated array */
		int mod = k % n; 
		
		// Prints the rotated array from  
		// start position 
		for(int i = 0; i < n; ++i) 
		System.out.print(arr[(i + mod) % n] + " ");  
		System.out.println(); 
	} 
    
    /*Function to left rotate arr[] of size n by d*/
    void leftRotateII(int arr[], int d) 
    { 
        for (int i = 0; i < d; i++) 
            leftRotatebyOne(arr); 
    } 
  
    void leftRotatebyOne(int arr[]) 
    { 
    	int n = arr.length;
        int i, temp; 
        temp = arr[0]; 
        for (i = 0; i < n - 1; i++) 
            arr[i] = arr[i + 1]; 
        arr[i] = temp; 
    } 
  
    /* utility function to print an array */
    void printArray(int arr[]) 
    { 
    	int n = arr.length;
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
} 