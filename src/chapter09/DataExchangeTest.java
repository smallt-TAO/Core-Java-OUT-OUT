<<<<<<< HEAD
package chapter09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class DataExchangeTest {
    public void main(String[] args) {
    	
    }
}


/**
 * A user has a name and password. For security reasons, the password is stored as
 * char[], not a String.
 */
class User {
	private String name;
	private char[] password;
	
	public User(String aName, char[] aPassword) {
		name = aName;
		password = aPassword;
	}
	
	public String getName() {
		return name;
	}
	
	public char[] getPassword() {
		return password;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public void setPassword(char[] aPassword) {
		password = aPassword;
	}
}
=======
package chapter09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class DataExchangeTest {

}


/**
 * A user has a name and password. For security reasons, the password is stored as
 * char[], not a String.
 */
class User {
	private String name;
	private char[] password;
	
	public User(String aName, char[] aPassword) {
		name = aName;
		password = aPassword;
	}
	
	public String getName() {
		return name;
	}
	
	public char[] getPassword() {
		return password;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public void setPassword(char[] aPassword) {
		password = aPassword;
	}
}
>>>>>>> origin/master
