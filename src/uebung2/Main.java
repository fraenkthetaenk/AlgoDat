package uebung2;

public class Main {

	public static void main(String[] args) {
		System.out.println("Kontrolle der Ergebnisse:\n");
		System.out.println("Teilaufgabe A: " + SetIntersection
				.countIntersectionUnsorted(new int[] { 2, 9, 5, 6, 17, 11 }, new int[] { 17, 1, 100, 5 }));

		System.out.println("Teilaufgabe B: " + SetIntersection
				.countIntersectionOneInputOrdered(new int[] { 2, 9, 6, 5, 1, 11 }, new int[] { 1, 5, 6, 12, 13 }));

		System.out.println("Teilaufgabe C: " + SetIntersection.countIntersectionOrdered(new int[] { 1, 2, 5, 6, 9, 11 },
				new int[] { 1, 5, 6, 12, 13 }));

		System.out.println("\nLaufzeiten:\n");
		
		System.out.println("\nTeilaufgabe A: 10.000:");		
		SetIntersection.meassureRuntime(0,10000);		
		System.out.println("\nTeilaufgabe A: 100.000:");		
		SetIntersection.meassureRuntime(0,100000);
		System.out.println("\nTeilaufgabe A: 1.000.000:");		
		System.out.println("hochgerechnet eine Stunde.");
		//SetIntersection.meassureRuntime(0,1000000);
		
		System.out.println("\nTeilaufgabe B: 10.000:");		
		SetIntersection.meassureRuntime(1, 10000);		
		System.out.println("\nTeilaufgabe B: 100.000:");		
		SetIntersection.meassureRuntime(1, 100000);		
		System.out.println("\nTeilaufgabe B: 1.000.000:");		
		SetIntersection.meassureRuntime(1, 1000000);		
		System.out.println("\nTeilaufgabe B: 10.000.000:");		
		SetIntersection.meassureRuntime(1, 10000000);
		
		System.out.println("\nTeilaufgabe C: 10.000:");		
		SetIntersection.meassureRuntime(2, 10000);
		System.out.println("\nTeilaufgabe C: 100.000:");
		SetIntersection.meassureRuntime(2, 100000);
		System.out.println("\nTeilaufgabe C: 1.000.000:");
		SetIntersection.meassureRuntime(2, 1000000);
		System.out.println("\nTeilaufgabe C: 10.000.000:");
		SetIntersection.meassureRuntime(2, 10000000);
	}

}
