package ds.arraylist.implementation;

import java.util.Scanner;
/**
 * The methods inside this class will call MyArrayList Class operations
 */
public class MyArrayListOperation {
	MyArrayList myList;
	
	MyArrayListOperation(){
		myList = new MyArrayList();
	}
	
	public void addItem() throws Exception{
		System.out.println("Enter item");
		myList.add(getValue());
		System.out.println(myList);
		showOperation();
	}
	
	public void addItemLocation() throws Exception{
		System.out.println("Enter Item");
		int item= getValue();
		System.out.println("Enter Location");
		int position= getValue();
		myList.add(item, position);
		System.out.println(myList);
		showOperation();
	}
	
	public void getItemOccur() throws Exception{
		System.out.println("Enter Item");
		int item= getValue();
		System.out.println("Enter Location");
		int position= getValue();
		System.out.println("from position "+position+", item:"+item+" first occurred at "+myList.getIndexBased(item, position));
		showOperation();
	}
	
	public void getItemIndex() throws Exception{
		System.out.println("Enter Item");
		int item= getValue();
		System.out.println("item:"+item+" first occurred at "+myList.getFirstIndex(item));
		showOperation();
	}
	
	public void getItem() throws Exception{
		System.out.println("Enter Location");
		int position= getValue();
		System.out.println("Item found="+myList.get(position));
		showOperation();
	}
	
	public void removeItemByIndex() throws Exception{
		System.out.println("Enter Location");
		int position= getValue();
		myList.removeAt(position);
		System.out.println(myList);
		showOperation();
	}
	
	public void removeItem() throws Exception{
		System.out.println("Enter Item");
		int item= getValue();
		myList.remove(item);
		System.out.println(myList);
		showOperation();
	}
	
	public void clear() throws Exception{
		myList.clear();
		System.out.println(myList);
		showOperation();
	}
	
	public void reverse() throws Exception{
		System.out.println(myList.reverse());
		showOperation();
	}
	
	public void sort() throws Exception{
		System.out.println(myList.sort());
		showOperation();
	}
	
	public void addAll() throws Exception{
		MyArrayList list= new MyArrayList();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number of list items=");
		int num= sc.nextInt();
		if(num<=0){
			System.out.println("Enter correct number of items");
			addAll();
		}
		System.out.println("Enter items=");
		for(int i= 0; i< num ; i++ ){
			list.add(sc.nextInt());
		}
		
		myList.addAll(list);
		System.out.println(myList);
		showOperation();
		sc.close();
	}
	public int getValue(){
		Scanner scan= new Scanner(System.in);
		int item= 0;
		try{
			item= Integer.parseInt(scan.next());
		}catch(Exception e){
			System.out.println("Invalid Choice");
			getValue();
		}
		
		return item;
	}
	
	void showOperation() throws Exception{
		
		String opr[] = {"Add Item","Add item by location","Retriev first occurrence of an item at location",
				"Retriev index of item","Retrive item","Removing item by location","Remove item","Clear List","Reverse List","Sort List","Add Two lists"};
		int counter= 0;
		for(String opration : opr){
			System.out.println(++counter+"."+opration);	
		}
		System.out.println(++counter+".Exit");
		int choice= 0;
		do{
			System.out.println("Choose Operation : ");
			choice = getChoice();
		}while(choice < 1 || choice > opr.length);
		 
		switch(choice){
			case 1 : addItem(); break;
			case 2 : addItemLocation(); break;
			case 3 : getItemOccur(); break;
			case 4 : getItemIndex(); break;
			case 5 : getItem(); break;
			case 6 : removeItemByIndex(); break;
			case 7 : removeItem(); break;
			case 8 : clear(); break;
			case 9 : reverse(); break;
			case 10 : sort(); break;
			case 11 : addAll(); break;
			case 12 : System.exit(0); break;
		}
	}
	
	 int getChoice(){
		Scanner scan= new Scanner(System.in);
		int choice=0;
		
		try{
			choice= Integer.parseInt(scan.next());
		}
		catch(Exception e){
			System.out.println("Invalid Choice");
			getChoice();
		}
		
		
		return choice;
	}
}