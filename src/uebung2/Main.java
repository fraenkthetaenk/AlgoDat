package uebung2;

import java.util.Random;

/**
 * The Main class used to run the runtime measurement, also provides the test
 * arrays
 * 
 * @author frank
 *
 */
public class Main {

	/**
	 * the Main function running the runtime measurements
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		meassureRuntime(10000);
		meassureRuntime(100000);
		meassureRuntime(1000000);
		meassureRuntime(10000000);

	}

	/**
	 * Used to generate an ascending sorted integer Array of a fixed size with
	 * unique integer values
	 * 
	 * @param size
	 *            the size for the array
	 * @return the sorted array
	 */
	public static int[] randomSorted(int size) {
		Random r = new Random();
		int[] result = new int[size];
		int randomValue = 0;
		for (int i = 0; i < size; i++) {
			randomValue += 1 + r.nextInt(10);
			result[i] = randomValue;
		}
		return result;
	}

	/**
	 * used to generate a unsorted integer array of a fixed size, with unique
	 * integer values
	 * 
	 * @param size
	 *            the size of the array
	 * @return the unsorted array
	 */
	public static int[] randomUnsorted(int size) {
		Random r = new Random();
		int[] result = randomSorted(size);
		for (int i = 0; i < size; i++) {
			int randomIndex = i + r.nextInt(size - i);
			int swap = result[i];
			result[i] = result[randomIndex];
			result[randomIndex] = swap;
		}
		return result;
	}

	/**
	 * Used to Measure the runtime based on the array size
	 * 
	 * @param size
	 *            the size of the arrays that should be used in the runtime
	 *            measurements
	 */
	public static void meassureRuntime(int size) {

		System.out.println("Zeitmessungen für Arrays mit " + size + " Elementen");

		long start;
		long end;
		double runtime;
		if (size <= 1000000) {
			start = System.currentTimeMillis();
			SetIntersection.countIntersectionUnsorted(randomUnsorted(size), randomUnsorted(size));
			end = System.currentTimeMillis();
			runtime = (end - start) / 1000.0;
			System.out.println("Laufzeit für 2 unsotierte Arrays: " + runtime + "s.");
		} else {
			System.out.println("Überspringe Laufzeitmessung für für 2 unsotierte Arrays aus zeitgründen");
		}

		start = System.currentTimeMillis();
		SetIntersection.countIntersectionOneInputOrdered(randomUnsorted(size), randomSorted(size));
		end = System.currentTimeMillis();
		runtime = (end - start) / 1000.0;
		System.out.println("Laufzeit fur 1 sotiertes und 1 unsortiertes Array: " + runtime + "s.");

		start = System.currentTimeMillis();
		SetIntersection.countIntersectionOrdered(randomSorted(size), randomSorted(size));
		end = System.currentTimeMillis();
		runtime = (end - start) / 1000.0;
		System.out.println("Laufzeit für 2 sotierte Arrrays: " + runtime + "s.");
	}

}
