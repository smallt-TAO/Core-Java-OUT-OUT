package chapter04;

import java.util.*;

/**
 * This program demostrates object construction.
 * @author Smalltao
 *
 */
public class ConstructorTest {
    public static void main(String[] args) {
    	// fill the staff arrray with three Employee objects
    	Employee[] staff = new Employee[3];
    	
    	staff[0] = new Employee("Harry", 40000);
    	staff[1] = new Employee(60000);
    	staff[2] = new Employee();
    	
    	for (Employee e : staff) {
    		System.out.println("name=" + e.getName() 
    		+ ", id=" + e.getId() + ", salary=" + e.getSalary());
    	}
    }
}

class Employee {
	private static int nextId;
	private int id;
	private String name = "";
	private double salary;
	static {
		Random generator = new Random();
		// set nextId to a random number between 0 and 9999
		nextId = generator.nextInt(10000);
	}
	
	// object initalization block
	{
		id = nextId;
		nextId++;
	}
	
	// three overloaded constructors
	public Employee(String n, double s) {
		name = n;
		salary = s;
	}
	
	public Employee(double s) {
		// calls the Employee(String, double) constructor
		this("Employee #" + nextId, s);
	}
	
	// the default constructor
	public Employee() {
		// name initalized to ""--see below
		// salary not explicity set -- initalized to 0
		// id initialized in initialization block
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getId() {
		return id;
	}
}



















