package DoublyLinkedList;

public class Operations {
	
	    Node start;
	    Node end ;
	    int size ;
	 
	    public Operations(){
	        start = null;
	        end = null;
	        size = 0;
	    }
	    
	    public boolean isEmpty(){
	        return start == null;
	    }
	    
	    public int getSize(){
	        return size;
	    }    
	    
	    /**
	     * This method will insert an item at specific location
	     * @param val
	     * @param loc
	     */
	    public void insertAtLoc(int val , int loc){
	    	 Node nptr = new Node(val, null, null);    
	        
	    	 if (loc == 1){     
	             if(start == null){
	                 start = nptr;
	                 end = start;
	             }else{
	                 start.setLinkPrev(nptr);
	                 nptr.setLinkNext(start);
	                 start = nptr;
	             }
	         }  
	         else{
	        	 Node ptr = start;
		         for (int i = 2; i <= size+1; i++){
		             if (i == loc){
		                 Node temp = ptr.getLinkNext();
		                 ptr.setLinkNext(nptr);
		                 nptr.setLinkPrev(ptr);
		                 nptr.setLinkNext(temp);
		                 
		                 if(loc==(size+1)){
		                	 end= nptr;
		                 }
		                 
		                 break;
		             }
		             ptr = ptr.getLinkNext();            
		         }
	         }
	         size++ ;
	    }
	    
	    public void deleteAtLoc(int loc){        
	        if (loc == 1) {
	            if (size == 1){
	                start = null;
	                end = null;
	                size = 0;
	                return; 
	            }
	            start = start.getLinkNext();
	            start.setLinkPrev(null);
	            size--; 
	            return ;
	        }
	        if (loc == size){
	            end = end.getLinkPrev();
	            end.setLinkNext(null);
	            size--;
	        }
	        Node ptr = start.getLinkNext();
	        for (int i= 2; i < size; i++){
	            if (i == loc){
	                Node p = ptr.getLinkPrev();
	                Node n = ptr.getLinkNext();
	 
	                p.setLinkNext(n);
	                n.setLinkPrev(p);
	                
	                if(loc == size){
	                	end = n;
	                }
	                size-- ;
	                return;
	            }
	            ptr = ptr.getLinkNext();
	        }        
	    } 
	    
	    public void deleteByValue(int val){
	    	if(start.getData() == val){
	    		if(start.getLinkNext() == null){
	    			start = null;
	    		}else{
		    		start= start.getLinkNext();
	    		}
	    		System.out.println("deleted "+val);
	    		size--;
	    	}
	    	else{
	    		Node nextptr = start;
		    	Node prevptr = new Node();
		    	boolean flag= false;
		    	 for (int i = 1; i <= size ; i++) {
			            if (val == nextptr.getData()){
			                prevptr.setLinkNext(nextptr.getLinkNext());
			                flag= true;
			                break;
			            }
			            prevptr= nextptr;
			            nextptr = nextptr.getLinkNext();
			        }
		    	 if(flag){
		    		 size-- ;
		    		 System.out.println("deleted "+val);
		    	 }
		    	 else
		    		 System.out.println("Value Not Found");	
	    	}
	    }
	    
	    
	    public void getAtLoc(int location){
	    	Node ptr = start;
	        for (int i = 1; i <= size ; i++){
	            if (i == location) {
	                System.out.println("Value on "+location+" is "+ptr.getData());
	                break;
	            }
	            ptr = ptr.getLinkNext();
	        }
	    }
	    
	    public void reverseLinkedList(){
	    	Node reversedPart = null;
	    	Node current = start;
	    	while (current != null) {
	    	    Node next = current.getLinkNext();
	    	    current.setLinkNext(reversedPart);
	    	    reversedPart = current;
	    	    current = next;
	    	}
	    	start = reversedPart;
	    }
	    
	    public void sortLinkedList(){
	    	if(size == 0){
	    		System.out.println("No elements to sort");
	    	}else{
	    		Node currentNode= start;
		    	Node nextNode= start.getLinkNext();
	    		for(int i= 0; i < size; i++){
		    		while(nextNode != null){
			    		if(currentNode.getData() > nextNode.getData()){
			    			int temp= currentNode.getData();
			    			currentNode.setData(nextNode.getData());
			    			nextNode.setData(temp);
			    		}
			    		
			    		currentNode= nextNode;
			    		nextNode= nextNode.getLinkNext();
			    	}
		    		currentNode= start;
		    		nextNode= start.getLinkNext();
		    	}
	    	}
	    }
	    
	    /*
	     *  Method to display status of list
	     */
	    public void display(){
	        System.out.print("\nDoubly Linked List = ");
	        if (size == 0) {
	            System.out.print("empty\n");
	            return;
	        }
	        if (start.getLinkNext() == null) {
	            System.out.println(start.getData() );
	            return;
	        }
	        Node ptr = start;
	        System.out.print(start.getData()+ " <-> ");
	        ptr = start.getLinkNext();
	        while (ptr.getLinkNext() != null){
	            System.out.print(ptr.getData()+ " <-> ");
	            ptr = ptr.getLinkNext();
	        }
	        System.out.print(ptr.getData()+ "\n");
	    }
	}