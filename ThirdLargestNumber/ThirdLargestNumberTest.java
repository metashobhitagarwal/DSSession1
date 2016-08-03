package ThirdLargestNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThirdLargestNumberTest {

	@Test
	public void testThirdLargest() {
		int[] array= new int[]{1, 4, 3, 7, 0, 5, 6};
		LargestNumber large= new LargestNumber();
		assertEquals(5, large.getThirdLargestNumber(array));
	}

} 