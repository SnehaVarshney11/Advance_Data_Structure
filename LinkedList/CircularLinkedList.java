package LinkedList;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
	private int length;

	private class ListNode{
		private ListNode next;
		private int data;
		
		public ListNode(int data){
			this.data = data;
        }
    }
        public void CircularLinkedList(){
            last = null;
            length = 0;
        }

        public boolean isEmpty()
	    {
		    if(length == 0 || last == null){
                return true;
            }
            else{
                return false;
            }
	    }
        public void createCLL() {
            ListNode first = new ListNode(1);
            ListNode second = new ListNode(5);
            ListNode third = new ListNode(10);
            ListNode fourth = new ListNode(15);
        
            first.next = second;
            second.next = third;
            third.next = fourth;
            fourth.next = first;
        
            last = fourth;
        }

        // print elemets
        public void display(){
            if(last == null){
                return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);
        }

        

        // insert at first 
        public void insertFirst(int data){
            ListNode temp = new ListNode(data);
            if(last == null){
                last = temp;
            } 
            else{
                temp.next = last.next;
            }
            last.next = temp;
            length++;
        }
        
        // insert at last 
        public void insertLast(int data){
            ListNode temp = new ListNode(data);
            if(last == null){
                last = temp;
                last.next = last;
            } 
            else{
                temp.next = last.next;
                last.next = temp;
                last = temp;
            }
            length++;
        }
        
        // remove node from start 
        public ListNode removeFirst(){
            if(isEmpty()){
                   throw new NoSuchElementException("circular Singly Linked List is already empty");
            }
            ListNode temp = last.next;
            if(last.next == last){
                       last = null;
            }else{
                    last.next = temp.next;
            }
             temp.next = null;
             length--;
             return temp;
        }

        public static void main(String[] args){
            CircularLinkedList cll = new CircularLinkedList();
            cll.createCLL();
            cll.display();
            cll.insertFirst(1);
            cll.insertFirst(5);
        }
         
    
    
}

    

    



