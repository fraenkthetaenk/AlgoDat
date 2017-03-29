package uebung3;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uebung3.ArraySequence;

public class ArraySequenceTest {

	
	/**	subject under test */
	private ArraySequence sut;
	
	@Before
	public void init() {
		sut = new ArraySequence();
	}
	
	@Test
	public void testInitialState() {
		Assert.assertEquals(0, sut.size());
	}
	
	@Test
	public void testSingleAddition() {
		sut.addLast("A");
		Assert.assertEquals(1, sut.size());
		Assert.assertEquals("A", sut.get(0));
	}
	
	@Test
	public void testMultipleAddition() {
		sut.addLast("A");
		sut.addLast("B");
		sut.addLast("C");		
		Assert.assertEquals(3, sut.size());
		Assert.assertEquals("A", sut.get(0));
		Assert.assertEquals("B", sut.get(1));
		Assert.assertEquals("C", sut.get(2));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testIllegalAccess() {
		sut.addLast("A");
		sut.addLast("B");
		sut.addLast("C");		
		sut.get(3);
	}
	
	@Test
	public void testInsert() {
		sut.addLast("A");
		sut.addLast("B");
		sut.insert(1,"AC");
		sut.insert(1,"AB");
		sut.insert(1,"AA");
		Assert.assertEquals(5, sut.size());
		Assert.assertEquals("A", sut.get(0));
		Assert.assertEquals("AA", sut.get(1));
		Assert.assertEquals("AB", sut.get(2));
		Assert.assertEquals("AC", sut.get(3));
		Assert.assertEquals("B", sut.get(4));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testIllegalInsert() {
		sut.addLast("A");
		sut.addLast("B");
		sut.insert(3, "X");
	}

	@Test
	public void testDelete() {
		sut.addLast("A");
		sut.addLast("B");
		sut.addLast("C");
		sut.addLast("D");
		sut.addLast("E");
		sut.delete(2);
		Assert.assertEquals(4, sut.size());
		Assert.assertEquals("A", sut.get(0));
		Assert.assertEquals("B", sut.get(1));
		Assert.assertEquals("D", sut.get(2));
		Assert.assertEquals("E", sut.get(3));
	}

	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testIllegalDelete() {
		sut.addLast("A");
		sut.addLast("B");
		sut.delete(3);
	}

	
}
