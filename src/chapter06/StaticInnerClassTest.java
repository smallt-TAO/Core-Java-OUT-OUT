package chapter06;

/**
 * This program demonstrates the use of static inner classes.
 * @author Smalltao
 *
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
    	double[] d = new double[20];
    	for (int i = 0; i < d.length; i++) {
    		d[i] = 1000 * Math.random();
    	}
    	ArrayAlg.Pair p = ArrayAlg.minmax(d);
    	System.out.println("min = " + p.getFirst());
    	System.out.println("Max = " + p.getSecond());
    }
}

class ArrayAlg {
	/**
	 * A pair of floating-point numbers.
	 */
	public static class Pair {
		private double first;
		private double second;
		/**
		 * Constructs a pair from two floating-point numbers
		 * @param f the first number.
		 * @param s the second number.
		 */
		public Pair(double f, double s) {
			first = f;
			second = s;
		}
		
		/**
		 * Return the first number of the pair
		 * @return the fisrt number
		 */
		public double getFirst() {
			return first;
		}
		
		public double getSecond() {
			return second;
		}
	}
	
	/**
	 * Computes both the minimum and the maximum of an array
	 * @param values an array of floating-point numbers.
	 * @return a pair whose first elements is the minimum and whose second element.
	 */
	public static Pair minmax(double[] values) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (double v : values) {
			if (min > v) min = v;
			if (max < v) max = v;
		}
		
		return new Pair(min, max);
	}
}
