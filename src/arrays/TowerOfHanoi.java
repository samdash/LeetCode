package arrays;

public class TowerOfHanoi {

	public static void towerOfHanoi(int n, char startPole, char endPole, char intermidiatePole) 
    { 
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  startPole + " to rod " + endPole); 
            return; 
        } 
        //function is called in recursion for swapping the n-1 disc from the startPole to the intermediatePole
        towerOfHanoi(n-1, startPole, endPole, intermidiatePole); 
        System.out.println("Move disk " + n + " from rod " +  startPole + " to rod " + endPole); 
        //function is called in recursion for swapping the n-1 disc from the intermediatePole to the endPole
        towerOfHanoi(n-1, intermidiatePole, startPole, endPole); 
    } 
      
    //  Driver method 
    public static void main(String args[]) 
    { 
        int n = 4; // Number of disks 
        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods 
    } 

}
