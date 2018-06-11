package deque;

public class DoublyLinkedList<E> {
	
	
	//Nested Node Class
     private static class Node<E>{
    	 private Node<E> next;
    	 private Node<E> prev;
    	 private E element;
    	 
    	 public Node(E e, Node<E> p, Node<E> n) {
    		 next =n;
    		 prev = p;
    		 element = e;
    	 }
    	 public Node<E> getNext(){
    		 return next;
    	 }
    	 public Node<E> getPrev(){
    		 return prev;
    	 }
    	 public E getElement() {
    		 return element;
    	 }
    	 public void setNext(Node<E> n) {
    		 next = n;
    	 }
    	 public void setPrev(Node<E> p) {
    		 prev = p;
    	 }
     }
     //End of nested node class.
     
     
     private Node<E> header = null;
     private Node<E> trailer = null;
     int size =0;
     public DoublyLinkedList() {
    	 header = new Node<E>(null,null,null);
    	 trailer = new Node<E>(null,header,null);
    	 header.setNext(trailer);
     }
     public int size() {
    	 return size;
     }
     public boolean isEmpty() {
    	 return size==0;
     }
     public E first() {
    	 if(isEmpty())
    		 return null;
    	 return header.getNext().getElement();
     }
     public E last() {
    	 if(isEmpty())
    		 return null;
    	 return trailer.getPrev().getElement();
    				 
     }
     private void addBetween(E e, Node<E> prev, Node<E> next) {
    	 Node<E> node = new Node<E>(e,prev,next);
    	 prev.setNext(node);
    	 next.setPrev(node);
    	 size++;
     }
     private E removeNode(Node<E> node) {
    	 Node<E> next = node.getNext();
    	 Node<E> prev = node.getPrev();
    	 prev.setNext(next);
    	 next.setPrev(prev);
    	 size--;
    	 return node.getElement();
     }
     public void addFirst(E e) {
    	 addBetween(e,header,header.getNext());
     }
     public void addLast(E e) {
    	 addBetween(e,trailer.getPrev(),trailer);
     }
     public E removeFirst() {
    	 if(isEmpty())
    		 return null;
    	 return removeNode(header.getNext());
     }
     public E removeLast() {
    	 if(isEmpty())
    		 return null;
    	 return removeNode(trailer.getPrev());
     }
     
     
     //These codes will change in next version. As it will use a better algorithm for a constant time function.
     
     private Node<E> getNode(int index) {
    	 if(isEmpty())
    		 return null;
    	 Node<E> node = header;
    	 for(int i=-1; i<index;i++) {
    		 node = node.getNext();
    	 }
    	 return node;
    	 
     }
     public E get(int index) {
    	 return getNode(index).getElement();
     }
     public E remove(int index) {
    	 if(isEmpty())
    		 return null;
    	 if(index<0||index>=size)
    		 throw new IndexOutOfBoundsException();
    	 return removeNode(getNode(index));
     }
     public void add(E e ,int index) {
    	 if(index<0||index>size){
    		 throw new IndexOutOfBoundsException();
    	 }
    	 addBetween(e,getNode(index).getPrev(),getNode(index).getNext());
     }
     public E[] toArray() {
   	  E[] array = (E[]) new Object[size];
   	  for(int i=0;i<size;i++) {
   		  array[i] = get(i);
   	  }
   	  return array;
   	  
     }
     
     //Deprecated codes end here.
     
}
