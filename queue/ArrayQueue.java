package queue;
//Rounded removal algorithm
//O(1)
public class ArrayQueue<E> implements Queue<E> {
	private static final int Capacity = 1000;
    private E[] data;
    private int f = 0;
    private int sz =0;
    public ArrayQueue() {
    	this(Capacity);
    }
    public ArrayQueue(int Capacity) {
    	data = (E[])new Object[Capacity];
    }
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return sz==0;
	}

	@Override
	public void enqueue(E e) throws IllegalStateException{
		// TODO Auto-generated method stub
		if(sz==data.length) throw new IllegalStateException("Queue is full.");
		int avail = (f+sz)%data.length;
		data[avail] = e;
		sz++;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return data[f];
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		E answer = data[f];
		data[f] = null;
		f = (f+1)%data.length;
		sz--;
		return answer;
	}

}
