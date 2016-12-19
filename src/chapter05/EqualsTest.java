package chapter05;

import java.util.*;

/**
 * This program demostrtes the equals method.
 * @version 0.01
 * @author Smalltao
 *
 */
public class EqualsTest {
    public static void main(String[] args) {
    	Employee1 alice1 = new Employee1("Alice Adams", 75000, 1987, 12, 15);
    	Employee1 alice2 = alice1;
    	Employee1 alice3 = new Employee1("Alice Adams", 75000, 1987, 12, 15);
    	Employee1 bob = new Employee1("Bob Brandson", 50000, 1989, 10, 1);
    	
    	System.out.println("alice1 == alice2: " + (alice1 == alice2));
        System.out.println("alice1 == alice3: " + (alice1 == alice3));
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));
        System.out.println("bob.toString(): " + bob);

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        
        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
    }
}

class Employee1 {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee1(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public Date getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public boolean equals(Object otherObject) {
		// a quick test to see if the objects are identical.
		if (this == otherObject) return true;
		
		// must return false if the explicit parameter is null.
		if (otherObject == null) return false;
		
		Employee1 other = (Employee1) otherObject;
		
		// test whether the fiels have identical values.
		return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
	}
	
	public int hashCode() {
		return 7 * name.hashCode() + 11 * new Double(salary).hashCode() + 13 * hireDay.hashCode();
	}
	
	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
	}
}

class Manager extends Employee1 {
	private double bonus;
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		bonus = 0;
	}
	
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double b) {
		bonus = b;
	}
	
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) return false;
		Manager other = (Manager) otherObject;
		return bonus == other.bonus;
	}
	
	public int hashCode() {
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}
	
	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]";
	}
}

















