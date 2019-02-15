import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    	
    	double [] a = {4.0,3.0,2.0,10.0,12.0,1.0,1.0,1.0,5.0,6.0};
    	
    	double [] aSortedExpected = {1.0,1.0,1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
    	double [] aSorted = SortComparison.insertionSort(a);
    	
    	assertTrue("Checking insertionSort for unsorted array",Arrays.equals(aSortedExpected, aSorted));

	}
    
    @Test
	public void testquickSort() {
    	
    	double [] a = {4.0,3.0,2.0,10.0,12.0,1.0,1.0,1.0,5.0,6.0};
    	
    	double [] aSortedExpected = {1.0,1.0,1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
    	double [] aSorted = SortComparison.quickSort(a);
    	
    	assertTrue("Checking quickSort for unsorted array",Arrays.equals(aSortedExpected, aSorted));

	}
    
    @Test
	public void testRecursiveQuick() {
    	double [] a = {3.0,7.0,5.0,4.0,1.0};
		double [] aAfterRecursion = {1.0,3.0,4.0,5.0,7.0};
		
		SortComparison.recursiveQuick(a,0,a.length-1);
		assertTrue("Checking recursive quick for unsorted array",Arrays.equals(aAfterRecursion, a));
   
	}
    
    @Test
	public void testPartition() {
		//TODO
	}
    
    @Test
	public void testShuffleMyArray() {
		double [] a = {1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
		double [] aOld = {1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
		
		SortComparison.shuffleMyArray(a);
		assertFalse("Checking shuffleMyArray for sorted array",Arrays.equals(aOld, a));
	}
    
    @Test
	public void testSwap() {
		double [] a = {1.0,2.0,3.0,4.0};
		double [] aSwappedExpected = {1.0,4.0,3.0,2.0};
		
		SortComparison.swap(a,1,3);
		assertTrue("Checking swap for elements at index 1 and 3",Arrays.equals(aSwappedExpected, a));
	}
    
    @Test
	public void testMergeSortIterative() {
    	
    	double [] a = {4.0,3.0,2.0,10.0,12.0,1.0,1.0,1.0,5.0,6.0};
    	
    	double [] aSortedExpected = {1.0,1.0,1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
    	double [] aSorted = SortComparison.mergeSortIterative(a);
    	
    	assertTrue("Checking mergeSortIterative for unsorted array",Arrays.equals(aSortedExpected, aSorted));

	}
    
    @Test
	public void testMergeSortRecursive() {

    	double [] a = {4.0,3.0,2.0,10.0,12.0,1.0,1.0,1.0,5.0,6.0};
    	
    	double [] aSortedExpected = {1.0,1.0,1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
    	double [] aSorted = SortComparison.mergeSortRecursive(a);
    	
    	assertTrue("Checking mergeSortRecursive for unsorted array",Arrays.equals(aSortedExpected, aSorted));
	}
    
    @Test
	public void testMergeRecursive() {
 
    	double [] a = {3.0,7.0,5.0,4.0,1.0};
		double [] aux = new double [a.length];
		double [] aAfterRecursion = {1.0,3.0,4.0,5.0,7.0};
		
		SortComparison.mergeRecursive(a,aux,0,a.length-1);
		assertTrue("Checking recursive merge for unsorted array",Arrays.equals(aAfterRecursion, a));
    	}
    

	@Test
	public void testMerge() {
		
		double [] a = {4.0,3.0};
		double [] aux = new double [a.length];
		double [] aMergedExpected = {3.0,4.0};
		
		double [] b = {3.0,4.0,5.0,1.0,2.0};
		double [] bux = new double [b.length];
		double [] bMergedExpected = {1.0,2.0,3.0,4.0,5.0};
		
		SortComparison.merge(a, aux, 0, 0, a.length-1);
		SortComparison.merge(b, bux, 0, 2, b.length-1);
		
		assertTrue("Checking merge for unsorted array",Arrays.equals(aMergedExpected, a));
		assertTrue("Checking merge for unsorted array",Arrays.equals(bMergedExpected, b));
		
	}
    
	@Test
	public void testSelectionSort() {
    	double [] a = {4.0,3.0,2.0,10.0,12.0,1.0,1.0,1.0,5.0,6.0};
    	
    	double [] aSortedExpected = {1.0,1.0,1.0,2.0,3.0,4.0,5.0,6.0,10.0,12.0};
    	double [] aSorted = SortComparison.selectionSort(a);
    	
    	assertTrue("Checking selectionSort for unsorted array",Arrays.equals(aSortedExpected, aSorted));
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


