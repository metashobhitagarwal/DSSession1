package DoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedList{
	
    public static void main(String[] args){             
        Scanner scan = new Scanner(System.in);
        Operations operations = new Operations(); 
        int location, val, choice;
        char ch;
        
        //  Performing Linked list operations
        try{
        	do{
                System.out.println("Doubly Linked List Operations:");
                System.out.println("1. Insert at Location");
                System.out.println("2. Remove based on Location");
                System.out.println("3. Remove based on value");
                System.out.println("4. Get value by location");
                System.out.println("5. Reverse LinkedList");
                System.out.println("6. Sort LinkedList in Ascending order");
                System.out.println("7. Check empty");
                System.out.println("Enter your choice");
                choice = scan.nextInt();            
                
                switch (choice){                   
                case 1 : 
                    System.out.print("Enter integer value to insert: ");
                    val = Integer.parseInt(scan.next()) ;
                    System.out.print("Enter location: ");
                    location = scan.nextInt() ;
                    if (location < 1 || location > operations.getSize()+1)
                        System.out.println("Invalid location\n");
                    else
                        operations.insertAtLoc(val, location);
                    break;  
                    
                case 2 : 
                    System.out.print("Enter location: ");
                    location = scan.nextInt() ;
                    if (location < 1 || location > operations.getSize() )
                        System.out.println("Invalid location");
                    else
                        operations.deleteAtLoc(location);
                    break;
                    
                case 3 : 
                	System.out.print("Enter integer value:");
                    val = scan.nextInt() ;
                    if(operations.getSize() == 0){
                    	System.out.println("No value to delete");
                    }else{
                        operations.deleteByValue(val);
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
                    break;   
                }
                //  Display List
                operations.display();
                System.out.println("\nDo you want to continue (Enter y or n): ");
                ch = scan.next().charAt(0);                        
            } while (ch == 'Y'|| ch == 'y');               
        }
        catch(Exception e){
        	System.out.println("Something is wrong");
        	main(args);
        }
        scan.close();
    }
}