package stanford;

public class Binary {

	public static void main(String[] args) {
		Binary b = new Binary();
		b.printBinary(10);

	}
	
	public void printBinary(int n) {
		
		if(n < 2) {
			System.out.print(n);
		}else {
			int lastDigit = n % 2;
			int restOfDigits = n / 2;
			printBinary(restOfDigits);
			System.out.print(lastDigit);
			
		}
	}
}
