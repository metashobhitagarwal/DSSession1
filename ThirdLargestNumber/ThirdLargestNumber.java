package ThirdLargestNumber;
/**
 * This class consist of a method
 * that evaluates the third largest element
 * from an integer array
 * @author shobhit agarwal
 *
 */
class LargestNumber{
	/**
	 * this method evaluates the third largest element
	 * from an integer array
	 * @param array : int type
	 * @return third : int type : third largest element
	 */
	public int getThirdLargestNumber(int[] array){
		int first, second, third;
		first = second = third = array[0];
		for(int index= 1; index < array.length; index++){
			if(first < array[index]){
				second= first;
				first= array[index];
			}
			if(second < array[index] && array[index] < first){
				third= second;
				second= array[index];
			}
			if(third < array[index] && array[index] < second){
				third= array[index];
			}
		}
		return third;
	}
}

public class ThirdLargestNumber {

	public static void main(String[] args) {
		int[] array= new int[]{1, 4, 3, 7, 0, 5, 6};
		LargestNumber large = new LargestNumber();
		int thirdLargest = large.getThirdLargestNumber(array);
		System.out.println("Third Largest number is : " + thirdLargest);
	}

}