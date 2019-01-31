package arrays;

/*
 Objective: Given two sorted arrays, Find intersection point between them.

Examples:

int[] a = { 1, 2, 3, 6, 8, 10 };
int[] b = { 4, 5, 6, 11, 15, 20 };
Output: Intersection point is : 6
Approach:

Naive Approach: Use 2 loops and compare each elements in both array and as soon as you find the intersection point, return it. Time Complexity – O(n2).

Better Approach: Time Complexity – O(n)

Say Arrays are arrA[] and arrB[] and indexes for navigation are x and y respectively.
Since arrays are sorted, compare the first element of both the arrays.(x=0, y=0)
If both elements are same, we have our intersection point, return it.
Else if element of arrA[x] > element of arrB[y], increase the arrB[] index, y++.
Else if element of arrA[x] < element of arrB[y], increase the arrA[] index, x++.
If any of the array gets over that means you have not found the intersection point. return -1.

 */
public class IntersectionPoint2Arrays {

	int intersectionPoint = -1;
	int x = 0;
	int y = 0;

	public int intersection(int[] arrA, int[] arrB) {
		while (x < arrA.length && y < arrB.length) {
			if (arrA[x] > arrB[y])
				y++;
			else if (arrA[x] < arrB[y])
				x++;
			else {
				intersectionPoint = arrA[x];
				return intersectionPoint;
			}
		}
		return intersectionPoint;
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] a = { 1, 2, 3, 6, 8, 10 };
		int[] b = { 4, 5, 6, 11, 15, 20 };
		IntersectionPoint2Arrays i = new IntersectionPoint2Arrays();
		System.out.println("Intersection point is : " + i.intersection(a, b));

	}
}
