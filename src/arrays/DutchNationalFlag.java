
package arrays;

public class DutchNationalFlag {
	public static int[] dutchNationalFlag(int[] A) {
        int mid = 0;   		//tracks 1
        int left = 0;     		//tracks 0
        int right = A.length;  	//tracks 2
        while(left < right){
            if(A[left] == 0){
                int temp = A[left];
                A[left] = A[mid];
                A[mid] = temp;
                // left move forward as well. 
                
            	mid++;
                left++; 

            }else if(A[left] == 2){
                right--;
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }else
                left++;
        }
        return A;
	}    
	
	
	
	public static void main(String [] args){
		int[] A = {2,1,0,2,2,1,1,0,0,0};
		A = dutchNationalFlag(A);
		for(int i =0;i<A.length;i++){
			System.out.print("   " + A[i]);
		}
	}
}
