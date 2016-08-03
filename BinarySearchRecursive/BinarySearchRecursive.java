package BinarySearchRecursive;
/*
 * This class contains the method
 * that uses binary search to search 
 * for an element in the array
 */
class BinarySearch{
	
	/**
	 * this method implements binary searching 
	 * for searching for an element in an array
	 * this method makes use of recursion
	 * @param arr
	 * @param first
	 * @param last
	 * @param target
	 * @return mid : int type : position of searched element
	 */
	public int binarySearchMethod(int arr[], int first, int last, int target){
		int mid=(first+last)/2; 	//to find median position of array
		if(first>last){				//target not found condition
			return -1;
		}
		else if(target<arr[mid]){		//when target is lesser then a[mid]
			return binarySearchMethod(arr, first, mid-1, target);
		}
		else if(target>arr[mid]){		//when target is greater then a[mid]
			return binarySearchMethod(arr, mid+1, last, target);
		}
		else{
			return mid;		//target found condition
		}
	} //End of binaryFunction
	
	
}

public class BinarySearchRecursive {

	public static void main(String[] args) {
				System.out.println(new BinarySearch().binarySearchMethod(new int[]{1,2,3,4,5},0,5,4));
	}

}