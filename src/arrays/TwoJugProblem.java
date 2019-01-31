package arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoJugProblem {

	public static void main(String[] args) {
		System.out.println(canMeasureWater(3,5,4));
		System.out.println(canMeasureWaterII(3,5,4));
	}
	
    public static boolean canMeasureWater(int x, int y, int z) {
    	return z == 0 || (z <= x + y && z % gcd(x, y) == 0);
    }

    private static int gcd(int x, int y) {
    	if(y!=0)
    		System.out.println(x % y);
        return y == 0 ? x : gcd(y, x % y);
    }
	
    public static boolean canMeasureWaterII(int x, int y, int z) {
        if (z < 0 || z > x + y) {
           return false;
       }
       Queue<Integer> q = new LinkedList<>();
       Set<Integer> set = new HashSet<>();
       q.add(0);
       while (!q.isEmpty()) {
           int n = q.poll();
           //System.out.println("n+x = "+(n+x) + " n+y = "+(n+y)+" n-x = "+(n-x) + " n-y = "+(n-y));
           if (n + x <= x + y && set.add(n + x)) q.add(n + x);
           if (n + y <= x + y && set.add(n + y)) q.add(n + y);
           if (n - x >= 0 && set.add(n - x)) q.add(n - x);
           if (n - y >= 0 && set.add(n - y)) q.add(n - y);
           if (set.contains(z)) return true;
       }
       return false;
   }
    
}
