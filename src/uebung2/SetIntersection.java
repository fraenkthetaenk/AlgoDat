package uebung2;


/**
 * This Class is used to count the appearance of the same integer in 2 different
 * integer Arrays depending on whether the input arrays are sorted or not
 * 
 * @author frank
 *
 */



public class SetIntersection {

	/**
	 * This Method determines the number of the same elements within 2 unsorted
	 * arrays Important: Each Value is only allowed once in each array
	 * 
	 * @param unsorted
	 *            the first unsorted integer array
	 * @param unsorted2
	 *            the second unsorted integer array
	 * @return the count of the same integer value in both arrays
	 */
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

	/**
	 * The number of the same integer elements within 2 integer Arrays where the
	 * first array is unsorted and the second on is sorted ascending Important:
	 * Each Value is only allowed once in each array
	 * 
	 * @param unsorted
	 *            the unsorted integer array
	 * @param sorted
	 *            the sorted integer array
	 * @return the count of the same integer value in both arrays
	 */
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

	/**
	 * Determines the amount of same integer values in 2 ascending sorted integer arrays
	 * Important: Each Value is only allowed once in each array
	 * 
	 * @param sorted
	 *            The first ascending sorted integer Array
	 * @param sorted2
	 *            The second ascending sorted integer Array
	 * @return the count of the same integer value in both arrays
	 */
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
}
