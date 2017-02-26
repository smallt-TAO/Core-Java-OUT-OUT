package chapter06;

import java.util.*;

/**
 * This program demonstrtes cloning.
 * @author Smalltao
 *
 */
public class CloneTest {
    public static void main(String[] args) {
    	try {
    		Employee2 original = new Employee2("John Q.Public", 50000);
    		original.setHireDay(2016, 12, 25);
    		Employee2 copy = original.clone();
    		copy.raiseSalary(10);
    		copy.setHireDay(2016, 12, 12);
    		System.out.println("original=" + original);
    		System.out.println("copy=" + copy);
    	}
    	catch (CloneNotSupportedException e) {
    		e.printStackTrace();
    	}
    }
}

class Employee2 implements Cloneable {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee2(String n, double s) {
		name = n;
		salary = s;
		hireDay = new Date();
	}
	
	public Employee2 clone() throws CloneNotSupportedException {
		// call Object.clone()
		Employee2 cloned = (Employee2) super.clone();
		
		// clone mutable fields
		cloned.hireDay = (Date) hireDay.clone();
		
		return cloned;
	}
	
	/**
	 * Set the hire day to a given data.
	 */
	public void setHireDay(int year, int month, int day) {
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public String toString() {
		return "Employee[name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}
}
