package arrays;

import java.util.Comparator;

public class Points {
	public final double x;
	public final double y;
	public static final Comparator<Points> sortX = new compareX();
	public static final Comparator<Points> sortY = new compareY();

	public Points(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	

	private static class compareX implements Comparator<Points>{
		//comparator for comparing x-coordinates
		public int compare(Points o1, Points o2) {
			if (o1.x < o2.x) return -1;
			if (o1.x > o2.x) return +1;
			return 0;
		}
	}
	
	private static class compareY implements Comparator<Points>{
		//comparator for comparing y-coordinates
		public int compare(Points o1, Points o2) {
			if (o1.y < o2.y) return -1;
			if (o1.y > o2.y) return +1;
			return 0;
		}
	}

}