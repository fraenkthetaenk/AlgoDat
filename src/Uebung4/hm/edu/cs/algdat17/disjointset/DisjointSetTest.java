package Uebung4.hm.edu.cs.algdat17.disjointset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DisjointSetTest {

	private static final int TEST_SIZE = 5;

	private DisjointSet sut;

	@Before
	public void init() {
		sut = new DisjointSet(TEST_SIZE);
	}

	/**
	 * Testet, dass initial alle Zahlen einzelne Gruppen bilden, d.h. jede Zahl
	 * sein eigener Repräsentant ist.
	 */
	@Test
	public void testInitialState() {
		for (int i = 0; i < TEST_SIZE; i++) {
			Assert.assertEquals(i, sut.find(i));
		}
	}

	/**
	 * Testet die Ermittlung der Repräsentanten nach teilweisem Verschmelzen.
	 */
	@Test
	public void testPartiallyMerged() {
		sut.union(4, 2);
		sut.union(1, 4);
		sut.union(3, 0);
		Assert.assertEquals(1, sut.find(2));
		Assert.assertEquals(0, sut.find(0));
		Assert.assertEquals(0, sut.find(3));
	}

	/**
	 * Testet die Ermittlung der Repräsentanten nach vollständigem Verschmelzen.
	 */
	@Test
	public void testMergedAll() {
		sut.union(0, 3);
		sut.union(1, 4);
		sut.union(2, 0);
		sut.union(3, 4);
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(0, sut.find(i));
		}
	}

}
