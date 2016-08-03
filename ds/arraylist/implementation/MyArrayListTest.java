package ds.arraylist.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyArrayListTest {
	
	@Test
	public void testReverse() throws Exception{
		MyArrayList myList= new MyArrayList();
		myList.add(11);
		myList.add(55);
		myList.add(4);
		
		MyArrayList expected= new MyArrayList();
		expected.add(4);
		expected.add(55);
		expected.add(11);
		assertArrayEquals(expected.getObjectArray(), myList.reverse().getObjectArray());
	}
	
	@Test
	public void testSort() throws Exception{
		MyArrayList myList= new MyArrayList();
		myList.add(11);
		myList.add(55);
		myList.add(4);
		
		MyArrayList expected= new MyArrayList();
		expected.add(4);
		expected.add(11);
		expected.add(55);
		assertArrayEquals(expected.getArray(), myList.sort().getArray());
	}
}
