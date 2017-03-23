package uebung2;

public class Main {

	public static void main(String[] args) {
		System.out.println(SetIntersection.countIntersectionUnsorted(new int[]{2,9,5,6,17,11}, new int[] {17,1,100,5}));
		
		System.out.println(SetIntersection.countIntersectionOneInputOrdered(new int[]{2,9,6,5,1,11}, new int[]{1,5,6,12,13}));
		
		System.out.println(SetIntersection.countIntersectionOrdered(new int[] {1,2,5,6,9,11}, new int[]{1,5,6,12,13}));

	}

}
