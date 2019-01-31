package trees;

public class CountBSTs {
	
	public static void main(String[] args) {
		
		int result = numOfBSTs(5);
		System.out.println(result);
	}
	
    public static int numOfBSTs(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
