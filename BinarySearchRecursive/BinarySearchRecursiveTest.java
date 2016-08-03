package BinarySearchRecursive;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchRecursiveTest {

	@Test
	public void test() {
		assertEquals( 3, new BinarySearch().binarySearchMethod(new int[]{1,2,3,4,5},0,5,4));
	}

}