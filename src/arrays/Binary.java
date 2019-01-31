package arrays;

public class Binary {

	public static void main(String[] args) {
		Binary b = new Binary();
		b.printBinary(5);
	}
	
	public void printBinary(int num) {
		int[] binary = new int[25];
		int index =0;
		while(num > 0 ) {
			binary[index++] = num % 2;
			num = num /2;
		}
		
		for(int i = index -1;i>=0;i--) {
			System.out.print(binary[i]+" ");
		}
	}

}
