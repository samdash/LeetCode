package arrays;

public class PowerOfTwo {

	public static void main(String[] args) {
		int n = 512;
		powerOf2LogMethod(n);
		powerOf2RemainderMethod(n);
	}

	public static void powerOf2LogMethod(int n){
        double x = Math.ceil(Math.log(n)/Math.log(2));
        double y = Math.floor(Math.log(n)/Math.log(2));
        if(x==y)
            System.out.println("Given number " + n + " is power of 2");
        else
            System.out.println("Given number " + n + " is not power of 2");
    }
	
	public static void powerOf2RemainderMethod(int n){
        boolean isPowOfTwo = true;
        int num = n;
        while(n>1){
            if(n%2!=0)
                isPowOfTwo = false;
            n=n/2;
        }
        if(isPowOfTwo)
            System.out.println("Given number " + num + " is power of 2");
        else
            System.out.println("Given number " + num + " is not power of 2");
    }

	
}
