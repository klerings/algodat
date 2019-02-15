import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
	 //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    
    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double [] a = {};
    	assertEquals("Checking insertionSort for empty array", a, SortComparison.insertionSort(a));
    	assertEquals("Checking quickSort for empty array", a, SortComparison.quickSort(a));
    	assertEquals("Checking mergeSortIterative for empty array", a, SortComparison.mergeSortIterative(a));
    	assertEquals("Checking mergeSortRecursive for empty array", a, SortComparison.mergeSortRecursive(a));
    	assertEquals("Checking selectionSort for empty array", a, SortComparison.selectionSort(a));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    @Test
	public void testInsertionSort() {
    	
    	double [] a = {4.0,3.0,2.0,10.0,12.0, 1.0,5.0,6.0};
    	
    	double [] aSortedExpeded = {1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
    	double [] aSorted = SortComparison.insertionSort(a);
    	
    	assertTrue("Checking insertionSort for unsorted array",Arrays.equals(aSortedExpeded, aSorted));

	}
    
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

/*

	

	@Test
	public void testQuickSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecursiveQuick() {
		fail("Not yet implemented");
	}

	@Test
	public void testPartition() {
		fail("Not yet implemented");
	}

	@Test
	public void testShuffleMyArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testMergeSortIterative() {
		fail("Not yet implemented");
	}

	@Test
	public void testMergeSortRecursive() {
		fail("Not yet implemented");
	}

	@Test
	public void testMergeRecursive() {
		fail("Not yet implemented");
	}

	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectionSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}
*/

