package chapter13;

import java.util.*;

/**
 * This program demonstrates the use of a priority queue.
 * @version 1.00
 * @author Smalltao
 *
 */
public class PoriorityQueueTest {
    public static void main(String[] args) {
    	PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
    	pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
    	pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
    	pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
    	pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22));
    	
    	System.out.println("Iterating over elements...");
    	for (GregorianCalendar data : pq) 
    		System.out.println(data.get(Calendar.YEAR));
    	System.out.println("Removing elements...");
    	while (!pq.isEmpty())
    		System.out.println(pq.remove().get(Calendar.YEAR));
    }
}
