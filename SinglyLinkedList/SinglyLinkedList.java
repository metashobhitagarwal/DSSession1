package SinglyLinkedList;

import java.util.Scanner;

public class SinglyLinkedList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		MyLinkList<Integer> operations = new MyLinkList<Integer>();
		int location, value, userChoice;
		char ch;
		
		try{
				do{
					System.out.println("Singly Linked List Operations : ");
					System.out.println("1. Insert at Location");
					System.out.println("2. Remove based on Location");
	                System.out.println("3. Remove based on value");
	                System.out.println("4. Get value by location");
	                System.out.println("5. Reverse LinkedList");
	                System.out.println("6. Sort LinkedList in Ascending order");
	                System.out.println("7. Check empty"); 
	                System.out.println("Enter your choice : ");
	                userChoice = scan.nextInt();
	
	                switch(userChoice){
	                case 1 :
	                		System.out.print("Enter Integer Value to insert : ");
	                		value = scan.nextInt();
	                		System.out.print("Enter Location : ");
	                		location = scan.nextInt();
	                		if( location<1 || location>operations.getSize()+1 ){
	                			System.out.println("Invalid Location");
	                		}
	                		else{
	                			operations.insertAtLoc(value,location);
	                		}
	                		break;
	                case 2 : 
	                		System.out.println("Enter Location : ");
	                		location=scan.nextInt();
	                		if(location<1||location>operations.getSize()){
	                			System.out.println("Invalid Location");
	                		}
	                		else{
	                			operations.deleteAtLoc(location);
	                		}
	                		break;
	                case 3 :
	                		System.out.println("Enter value : ");
	                		value=scan.nextInt();
	                		if(operations.getSize()==0){
	                			System.out.println("No value to delete");
	                        }else{
	                            operations.deleteByValue(value);
	                        }
	                        break;
	                    case 4 : 
	                        System.out.print("Enter location: ");
	                        location = scan.nextInt() ;
	                        if (location < 1 || location > operations.getSize() )
	                            System.out.println("Invalid location");
	                        else
	                            operations.getAtLoc(location);
	                        break;
	                    case 5:
	                    	System.out.println("Reversing LinkedList");
	                    	operations.reverseLinkedList();
	                    	break;
	                    case 6:
	                    	System.out.println("Sorting LinkedList");
	                    	operations.sortLinkedList();
	                    	break;
	                    case 7 : 
	                    	System.out.println("Empty status = "+ operations.isEmpty());
	                        break;                    
	                     default : 
	                    	System.out.println("Wrong Entry \n ");
							System.out.println("Wrong insertion!!!");
							main(args);
							break;
	                    }
	                    //  Display List
	                    operations.display();
	                    System.out.println("\nDo you want to continue (Enter y or n): ");
	                    ch = scan.next().charAt(0);                        
	                } while (ch == 'Y'|| ch == 'y');               
	                
	            }
	            catch(Exception e){
	            	System.out.println("Wrong insertion!!!");	            	
	            	main(args);
	            }
	            scan.close();
	        }
}
