import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Alina Klerings
 *  @version HT 2019
 *  
 *  3) Algorithm performance comparison
 *  (times in milliseconds)
 *  
 *  f/	INSERT/	QUICK/	MERGE RECURSIVE/	MERGE ITERATIVE/	SELECTION
 *  ----------------------------------------------------------------------
 *  10 random/0.35/0.21/0.13/0.15/0.13
 *  100 random/0.46/0.20/0.08/0.05/0.11
 *  1000 random/9.90/0.81/0.21/0.33/7.39
 *  1000 few unique/2.30/0.36/0.19/0.20/2.74
 *  1000 nearly ordered/0.44/0.35/0.11/0.24/1.00
 *  1000 reverse order/0.8/0.25/0.11/0.23/0.38
 *  1000 sorted/0.38/0.19/0.10/0.14/0.34
 *  
 *  a) 
 *  -> insertionSort & selectionSort 
 *  -> both have a quadratic average running time, so the size of n carries 
 *  weight really quickly for randomly ordered arrays
 *  
 *  b)
 *  -> insertionSort (0.38 milliseconds for sorted, 9.90 for random)
 *  -> insertionSort minimizes the number of comparisons, so that the best running
 *  time is linear (for sorted arrays) whereas the worst case ends up being quadratic
 *  
 *  c)
 *  -> best: mergeSortRecursive (n lg n guarantee)
 *  -> worst: insertionSort (linear in best case and quadratic in worst)
 *  
 *  d) -
 *  -> I did not really notice a difference between recursive and iterative
 *  mergeSort. Maybe the recursive one was slightly faster but this might also
 *  be due to a too small test series.
 *  
 *  e)
 *  10 random: mergeRecusive (0.13) & selection (0.13)
 *  100 random: mergeIterative (0.05)
 *  1000 random: mergeRecursive (0.21)
 *  1000 few unique: mergeRecursive (0.19)
 *  1000 nearly ordered: mergeRecursive (0.11)
 *  1000 reverse: mergeRecursive (0.11)
 *  1000 sorted: mergeRecursive (0.10)

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
    	double [] a = {5.0,8.0,11.0,4.0,9.0,2.0,3.0,1.0};
    	assertEquals(4,SortComparison.partition(a, 0, a.length-1));

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
        String [] sortingAlgorithms = {"insertionSort","quickSort","mergeSortRecursive","mergeSortIterative","selectionSort"};
        int s = 0;
    	int [] inputSize = {10,100,1000,1000,1000,1000,1000};
    	String [] inputName = {"numbers10","numbers100","numbers1000","numbers1000Duplicates","numbersNearlyOrdered1000","numbersReverse1000","numbersSorted1000"};
    	
		//read in file and create array of doubles
    	for (int i=0;i<7;i++) {
    	
    		double [] doubles = new double [inputSize[i]];
    		int counter = 0;
    		Scanner scan;
    	    File file = new File(String.format("./files_to_sort/%s.txt", inputName[i]));
    	    try {
    	        scan = new Scanner(file);
    	        while(scan.hasNext())
    	        {
    	            doubles[counter] = Double.parseDouble(scan.next());
    	            counter++;
    	        }

    	    } catch (FileNotFoundException e1) {
    	            e1.printStackTrace();
    	    }
    	    
    	    //sort array and stop time
    	    double duration = 0;
    	   	for (int j=0;j<3;j++) {
    	   		long startTime = System.nanoTime();
    	   		double [] aSorted = SortComparison.insertionSort(doubles);
    	       	long endTime = System.nanoTime();
            	duration += (endTime - startTime)/1e6;  //in milliseconds
   	    	}
    	   	duration = duration/3;
        	System.out.println(String.format("Duration for %s for %d entries in %s is %e milliseconds",sortingAlgorithms[s],inputSize[i],inputName[i],duration));
    	   	
   	    }

    	
    }
    
    

}


