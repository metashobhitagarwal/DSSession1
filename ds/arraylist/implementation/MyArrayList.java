package ds.arraylist.implementation;

/**
 * This class creates and initializes an object array with dynamic size as well
 * as consists of all the required operational methods on list
 * size gets increased when the arraylist gets full 
 * @author shobhit agarwal
 * */
public class MyArrayList {
	private static final int SIZE_FACTOR = 5;
	private Object[] data;
	private int index;
	public int size;

	public MyArrayList() {
		this.data = new Object[SIZE_FACTOR];
		this.size = SIZE_FACTOR;
	}

	// This method adds object at the end
	public void add(Object obj) {
		if (this.index == this.size-1) {
		/*	System.out.println("List is full...");
			System.out.println("Resizing the array!!!");*/
			// Need to increase the size of data[]
			increaseSizeAndReallocate();
		}
		data[this.index]=obj;
		this.index++;
	}

	// This method adds object at the given position
	public void add(Object obj, int pos) throws Exception {
		// System.out.println("Index : " + this.index + "  Current Size : " +
		// this.size + "  Data Size : " + this.data.length);
		if (pos <= 0 || pos > this.size) {
			throw new Exception("PositionOutOfBond");
		}
		if (this.index == this.size - 1) {
			// Need to increase the size of data[]
			increaseSizeAndReallocate();
		}
		if(pos == this.index) {
			this.data[index] = obj;
			index++;
		} else {
			for (int i = this.index; i >= pos; i--)
				this.data[i] = this.data[i - 1];
		}
		this.data[pos - 1] = obj;
		this.index++;
	}


	//it adds list to calling list
	public void addAll(MyArrayList list) throws Exception{
		for(int arrIndex = 0; arrIndex < list.index; arrIndex++){
			this.add(list.getFirstIndex(arrIndex));
		}
	}
	
	//This method extends the size of the arraylist
	private void increaseSizeAndReallocate() {
		this.size = this.size + SIZE_FACTOR;
		Object newData[] = new Object[this.size];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		this.data = newData;
	}

	// This method returns the object present at the given position
	public Object get(int i) throws Exception {
		if (i > this.index-1) {
			throw new Exception("ArrayIndexOutOfBond");
		}
		if (i < 0) {
			throw new Exception("Negative Value");
		}
		return this.data[i];
	}

	// This method returns the position of the object present after the given
	// position
	public int getIndexBased(Object obj, int pos) throws Exception {
		if (pos > this.index - 1) {
			throw new Exception("ArrayIndexOutOfBond");
		}
		if (pos < 0) {
			throw new Exception("Negative Value");
		}
		for (int i = pos - 1; i < this.data.length - 1; i++) {
			if (this.data[i] == obj)
				return i+1;
		}
		throw new Exception("Element not found!!!");
	}

	// This method returns the index of the given object
	public int getFirstIndex(Object obj) throws Exception {
		for (int i = 0; i < this.data.length - 1; i++) {
			if (this.data[i] == obj)
				return i + 1;
		}
		throw new Exception("Element not found!!!");
	}

	// This method deletes the object at the given index
	public void removeAt(int i) throws Exception {
		if (i > this.index - 1) {
			throw new Exception("ArrayIndexOutOfBond");
		}
		if (i < 0) {
			throw new Exception("Negative Value");
		}
		if (this.index == 0) {
			throw new Exception("Empty List");
		} else {
			System.out.println("Element getting removed : " + this.data[i]);
			for (int x = i; x < this.data.length - 1; x++) {
				data[x] = data[x + 1];
			}
			this.index--;
		}
	}

	// This method removes the given object from the list
	public void remove(Object obj) throws Exception {
		//int count = 0;
		if (this.index == 0) {
			throw new Exception("Empty List");
		}
		else{
			for (int row= 0; row < this.index; row++) {
			if (this.data[row] == obj) {
					removeAt(row+1);
				}
			}
		}
	}

	// This method clears the whole list
	public void clear() {
		index = 0;
	}

	Object[] getObjectArray(){
		return this.data;
	}
	
	//This method reverses the list
	public MyArrayList reverse() throws Exception {
		if (this.index == 0) {
			throw new Exception("Empty List!!!");
		} else {
			MyArrayList reverseArray = new MyArrayList();
			for(int arrIndex = this.index - 1; arrIndex >= 0; arrIndex--) {
				reverseArray.add(this.data[arrIndex]);
			}
			return reverseArray;
		}
	}

	//this method sorts the list
	public MyArrayList sort() throws Exception {
		if(this.size() == 0){
			System.out.println("Empty List");
			return null;
		}else{
			Object temp;
			
			for (int row= 0; row < this.index-1; row++){
		        for (int col= row+1; col < this.index; col++){
		            if ((Integer)this.data[row] > (Integer)this.data[col]){
		                temp =  this.data[row];
		                this.data[row] = this.data[col];
		                this.data[col] = temp;
		            }
		        }
		    }
			return this;
		}
	}
	
	public int size(){
		return index;
	}
	public Object[] getArray(){
		return this.data;
	}

	public String toString() {
		if (this.index == -1) {
			return "{}";
		}
		String string = "";
		for (int i = 0; i < this.index; i++) {
			string += data[i];
			if (!(i == this.index-1))
				string += ",";
		}
		return string; 
		
	}
}
