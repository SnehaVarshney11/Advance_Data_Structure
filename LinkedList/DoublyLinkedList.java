package LinkedList;

public class DoublyLinkedList {
    private ListNode head;
	private ListNode tail;
	private int length;
	private class ListNode{
		private int data;
		private ListNode next;
		private ListNode previous;
		
		
		public ListNode(int data){
			this.data=data;
			
			
		} 
	}
	public DoublyLinkedList()
	{
		this.head=null;
		this.tail=null;
		this.length=0;
	}
	public boolean isEmpty()
	{
		if(length == 0 || head == null){
            return true;
        }
        else{
            return false;
        }
	}

	public void insertFirst(int value)
	{
		ListNode newNode=new ListNode(value);
		if(isEmpty())
		{
			tail=newNode;
			
		}else {
			head.previous=newNode;
			
		}
		newNode.next=head;
		head=newNode;
		length++;
		
	}

	public void insertEnd(int value)
	{
	    ListNode newNode=new ListNode(value);
	    if(isEmpty())
	    {
		    head=newNode;
	    }else {
		    tail.next=newNode;
		    newNode.previous=tail;
	    }
	    tail=newNode;
	    length++;
	}
	public void displayForward() {
		if(head==null) {
			return;
        }
		ListNode temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	
	public void displayBackward() {
		if(head==null) {
			return;
        }
		ListNode  temp = tail;
		while(temp!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.previous;
		}
		System.out.println("null");
	}
	
	public ListNode deleteFirst()
	{
		if(isEmpty()) {
			return null;
			
		}
		ListNode temp=head;
		if(head==tail)
		{
			tail=null;
		}else {
			head.next.previous=null;
		}
		head=head.next;
		temp.next=null;
		length--;
		return temp;
		
	}

	public static void main(String[]args)
	{
		DoublyLinkedList dll=new DoublyLinkedList();
		dll.insertFirst(10);
        dll.insertFirst(20);
		dll.insertFirst(30);
        dll.deleteFirst();
	}
}
