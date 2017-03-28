package uebung2;

import java.util.Random;

public class SetIntersection {

	public static int countIntersectionUnsorted(int[] unsorted, int[] unsorted2) {
		int countSame = 0;
		for (int value1 : unsorted) {
			for (int value2 : unsorted2) {
				if (value1 == value2) {
					countSame++;
				}
			}
		}
		return countSame;
	}

	public static int countIntersectionOneInputOrdered(int[] unsorted, int[] sorted) {
		int count = 0;

		for (int value1 : unsorted) {
			if (sorted[0] == value1) {
				count++;
				continue;
			}
			if (sorted[sorted.length - 1] == value1) {
				count++;
				continue;
			}
			if (sorted[0] > value1) {
				continue;
			}
			if (sorted[sorted.length - 1] < value1) {
				continue;
			}

			int lo = 0;
			int hi = sorted.length - 1;
			boolean found = false;
			while (lo <= hi && !found) {
				int middle = (lo + hi) / 2;
				if (sorted[middle] == value1) {
					count++;
					found = true;
					continue;
				}
				if (sorted[middle] > value1) {
					hi = middle - 1;
					continue;
				}
				if (sorted[middle] < value1) {
					lo = middle + 1;
					continue;
				}
			}
		}
		return count;
	}

	public static int countIntersectionOrdered(int[] sorted, int[] sorted2) {
		int count = 0;

		int pos1 = 0;
		int pos2 = 0;

		while (pos1 < sorted.length && pos2 < sorted2.length) {
			if (sorted[pos1] == sorted2[pos2]) {
				count++;
				pos1++;
				pos2++;
			} else if (sorted[pos1] > sorted2[pos2]) {
				pos2++;

			} else {
				pos1++;
			}
		}

		return count;

	}

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

	public static void meassureRuntime(int teilaufgabe, int size) {

		int[] unsorted = randomUnsorted(size);
		int[] unsorted2 = randomUnsorted(size);
		int[] unsorted3 = randomUnsorted(size);
		int[] sorted = randomSorted(size);
		int[] sorted2 = randomSorted(size);
		int[] sorted3 = randomSorted(size);

		if (teilaufgabe == 0) {
			long start = System.currentTimeMillis();
			countIntersectionUnsorted(unsorted, unsorted2);
			long end = System.currentTimeMillis();
			double runtime = (end - start) / 1000.0;
			System.out.println("Laufzeit: " + runtime + "s.");
		} else if (teilaufgabe == 1) {
			long start = System.currentTimeMillis();
			countIntersectionOneInputOrdered(unsorted3, sorted3);
			long end = System.currentTimeMillis();
			double runtime = (end - start) / 1000.0;
			System.out.println("Laufzeit: " + runtime + "s.");
		} else if (teilaufgabe == 2) {
			long start = System.currentTimeMillis();
			countIntersectionOrdered(sorted, sorted2);
			long end = System.currentTimeMillis();
			double runtime = (end - start) / 1000.0;
			System.out.println("Laufzeit: " + runtime + "s.");
		} else {
			System.out.println("Bitte geben Sie eine gültige Teilaufgabe an!");
		}
	}
}
