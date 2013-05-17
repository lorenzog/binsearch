// export CLASSPATH=/usr/share/java/junit.jar
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Random;

class TestBinSearch {
	static int[] testArray;

	@Test
		public void smokeTest() {
			System.out.println("smoketest");
			testArray = new int[] { 1, 2, 3, 4 };
			assertEquals(1, b.binsearch(testArray, 2));
			assertEquals(-1, b.binsearch(testArray, 9));
		}

	@Test
		public void emptyArray() {
			System.out.println("emptyarray");
			testArray = new int[] {};
			assertEquals(-1, b.binsearch(testArray, 42));
		}

	@Test
		public void arraySizeOne() {
			System.out.println("array size one");
			testArray = new int[] { 42 };
			assertEquals(0, b.binsearch(testArray, 42));
			assertEquals(-1, b.binsearch(testArray, 43));
		}

	@Test
		public void splitting() {
			System.out.println("calculating midpoint");
			assertEquals(0, b.calculateHalf(0,1));
			assertEquals(1, b.calculateHalf(0,2));
			assertEquals(0, b.calculateHalf(0,0));
			assertEquals(Integer.MAX_VALUE-2, 
					b.calculateHalf(Integer.MAX_VALUE-2, 
						Integer.MAX_VALUE-1));
			assertEquals(Integer.MAX_VALUE-1, 
					b.calculateHalf(Integer.MAX_VALUE-2, 
						Integer.MAX_VALUE));
		}

	@Test
		public void negatives() {
			System.out.println("with negative numbers");
			testArray = new int[] { -42, -2, 0, 3, 5, 42 };
			assertEquals(0, b.binsearch(testArray, -42));
			assertEquals(2, b.binsearch(testArray, 0));
		}

	@Test
		public void negativeBoundary() {
			System.out.println("Negative and boundary conditions");
			testArray = new int[] { -42 };
			assertEquals(0, b.binsearch(testArray, -42));
		}

	public int[] generateRandomArray() {
		long arraySize = rand.nextInt();
		System.out.println("array size: " + arraySize);
		long[] testArray = new long[arraySize];
		int lastMax = rand.nextInt();
		for ( int i = testArray.length-1 ; i >= 0 ; i-- )
		{
			testArray[i] = rand.nextInt(lastMax);
			System.out.print("testArray[" + i + "]: " + testArray[i]);
		}
		return testArray;
	}


	Binsearch b;
	Random rand;
	TestBinSearch() {
		b = new Binsearch();
		rand = new Random();

		emptyArray();
		arraySizeOne();
		smokeTest();
		splitting();
		negatives();
		negativeBoundary();

		testArray = generateRandomArray();
	}

	public static void main(String[] args) {
		new TestBinSearch();
	}
}
