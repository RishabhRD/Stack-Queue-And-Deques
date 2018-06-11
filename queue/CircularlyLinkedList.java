package queue;


public class CircularlyLinkedList<E> {
	//This is a Node. That is required in singly linked list.
    private static class Node<E>{
  	  private E element;
  	  private Node<E> next;
  	  public Node(E e,Node n) {
  		  this.element = e;
  		  this.next = n;
  	  }
  	  public E getElement() {
  		  return element;
  	  }
  	  public Node<E> getNext(){
  		  return next;
  	  }
  	  public void setNext(Node<E> node) {
  		  next=node;
  	  }
    }
    //End of Node.
    private Node<E> tail = null;
    private int size= 0;
    public CircularlyLinkedList() {};//Creates an Empty Circularly linked List.
    public int size() {
    	return size;
    }
    public boolean isEmpty() {
    	return size==0;
    }
    public E first() {
    	if(isEmpty()){
    		return null;
    	}
    	return tail.getNext().getElement();
    }
    public E last() {
    	if(isEmpty()) {
    		return null;
    	}
    	return tail.getElement();
    }
    public void rotate() {
    	if(!isEmpty()) {
    		tail=tail.getNext();
    	}
    }
    public void addFirst(E e) {
    	if(isEmpty()) {
    		tail = new Node<E>(e,null);
    		tail.setNext(tail);
    	}
    	else {
    		Node<E> newest = new Node<E>(e,tail.getNext());
    		tail.setNext(newest);
    	}
    	size++;
    		
    }
    public void addLast(E e) {
    	addFirst(e);
    	tail = tail.getNext();
    	size++;
    }
    public E removeFirst() {
    	if(isEmpty()) {
    		return null;
    	}
    	Node<E> head= tail.getNext();
    	if(tail==head) {
    		tail=null;
    	}
    	else
    	tail.setNext(head.getNext());
    	size--;
    	return head.getElement();
    }
    public E removeLast() {
    	for(int i=1; i<size;i++) {
    		tail = tail.getNext();
    	}
    	return removeFirst();
    }
}
