package chapter05;

import java.lang.reflect.*;

/**
 * This program demostrates the use of reflection for manipulating arrays.
 * @author Smalltao
 *
 */
public class ArrayGrowTest {
    public static void main(String[] args) {
    	int [] a = {1, 2, 3};
    	a = (int[]) goodArrayGrow(a);
    	arrayPrint(a);
    	
    	String[] b = {"Tom", "Dick", "Harry" };
    	b = (String[]) goodArrayGrow(b);
    	arrayPrint(b);
    	
    	System.out.println("The following call will generate an exception. ");
    	b = (String[]) badArrayGrow(b);
    }
    /**
     * This method grows an array by allocation a new array
     * of the same type and copying all elements.
     * @param a the array to grow.
     */
    static Object[] badArrayGrow(Object[] a) {
    	int newLength = a.length + 11 / 10 + 10;
    	Object[] newArray = new Object[newLength];
    	System.arraycopy(a,  0,  newArray,  0,  a.length);
    	return newArray;
    }
    
    /**
     * This method grows an arrray by allocating a new array of the same
     * type and type and copying all elements.
     * @param a the array to grow. This can be an object array or a primitive.
     */
    static Object goodArrayGrow(Object a) {
    	Class<? extends Object> cl = a.getClass();
    	if (!cl.isArray()) return null;
    	Class componentType = cl.getComponentType();
    	int length = Array.getLength(a);
    	int newLength = length * 11 / 10 + 10;
    	
    	Object newArray = Array.newInstance(componentType, newLength);
    	System.arraycopy(a, 0, newArray, 0, length);
    	return newArray;
    }
    
    /**
     * A convenience method to print all elements in an array.
     * @param a the array to print.
     * It can be an object array or a print primitive type array.
     */
    static void arrayPrint(Object a) {
    	Class<? extends Object> cl = a.getClass();
    	if (!cl.isArray()) return;
    	Class componentType = cl.getComponentType();
    	int length = Array.getLength(a);
    	System.out.print(componentType.getName() + "[" + length + "] = { ");
    	for (int i = 0; i < Array.getLength(a); i++) {
    		System.out.print(Array.get(a, i) + " ");
    	}
    	System.out.println("}");
    }
}
