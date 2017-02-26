package chapter13;

import java.util.*;

/**
 * This program demostrates how to extend the collections framework.
 * @version 1.00
 * @author Smalltao
 *
 */
public class CircularArrayQueueTest {
    public static void main(String[] args) {
    	Queue<String> q = new CircularArrayQueue<String>(5);
    	q.add("Amy");
    	q.add("Bob");
    	q.add("Carl");
    	q.add("Deedee");
    	q.add("Emile");
    	q.remove();
    	q.add("Fifi");
    	q.remove();
    	for (String s : q) {
    		System.out.println(s);
    	}
    }
}


/**
 * A frist-in, first-out bounded collection.
 */
class CircularArrayQueue<E> extends AbstractQueue<E> {
	private Object[] elements;
	private int head;
	private int tail;
	private int count;
	private int modcount;
	
	/**
	 * Constracts ana empty queue.
	 */
	public CircularArrayQueue(int capacity) {
		elements = new Object[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}
	
	public boolean offer(E newElement) {
		assert newElement != null;
		if (count < elements.length) {
			elements[tail] = newElement;
			tail = (tail + 1) % elements.length;
			count++;
			modcount++;
			return true;
		}
		else return false;
	}
	
	public E poll() {
		if (count == 0) return null;
		E r = peek();
		head = (head + 1) % elements.length;
		count--;
		modcount++;
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if (count == 0) return null;
		return (E) elements[head];
	}
	
	public int size() {
		return count;
	}
	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E> {
	    private int offset;
	    private int modcountAtConstruction;
	    
		public QueueIterator() {
			modcountAtConstruction = modcount;
		}
		
		@SuppressWarnings("unchecked")
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E r = (E) elements[(head + offset) % elements.length];
			offset++;
			return r;
		}
		
		public boolean hasNext() { 
	         if (modcount != modcountAtConstruction) 
	             throw new ConcurrentModificationException();
	         return offset < count;
	    }

	    public void remove() { 
	         throw new UnsupportedOperationException(); 
	    }
	}
}



























