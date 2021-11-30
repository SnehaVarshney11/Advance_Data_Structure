package Stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class stack{
    private ListNode top;
    private int length;

    private class ListNode{
        private int data; //can be a generic type
        private ListNode next; // reference to next ListNode in list

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public stack(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public static void main(String[] args){
        Stack st = new Stack();
        st.push(10);
        st.push(15);
        st.push(20);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
    }
}