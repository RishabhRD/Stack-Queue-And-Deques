package queue;

public class Josephus {
     public static <E> E remove(CircularQueue<E> queue, int k) {
    	 
		if(queue.isEmpty())return null;
		while(queue.size()>1) {
			for(int i=0; i<k-1;i++) {
				queue.rotate();
			}
			E e = queue.dequeue();
			System.out.println("    "+ e + "is Out");
			
		}
		return queue.dequeue();
    	 
     }
     public static <E> CircularQueue<E> buildQueue(E[] a){
    	 CircularQueue<E> q = new LinkedCircularQueue<E>();
    	 for(int i=0; i<a.length;i++) {
    		 q.enqueue(a[i]);
    	 }
    	 return q;
     }
}
