import java.util.Arrays;
import java.util.Random;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Alina Klerings
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

    	for(int i = 1;i < a.length;i++) {
    		double current = a[i];
    		
    		for (int j = i;j > 0;j--) {
        		if (current < a[j-1]) {
    				a[j] = a[j-1];
    				a[j-1] = current;
    			}
    		}
    	}
    	return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
    	int n = a.length;
    	if (n <= 1) {
    		return a;
    	}
    	shuffleMyArray(a);
    	recursiveQuick(a,0,n-1);
    	return a;

    }
    
    /**
     * Sorts an array of doubles by partitioning it recursively and solving subarrays.
     * @param a: array of doubles
     * @param low: index of first array element
     * @param high: index of last array element
     */
    static void recursiveQuick (double a[], int low, int high) {
    	if(low<high) {
    		int pivotDepth = partition(a,low,high);
    		recursiveQuick(a,low,pivotDepth-1);	//sort array part left of pivot
    		recursiveQuick(a,pivotDepth+1,high); //sort array part right of pivot
    	}
    }
    
    
    /**
     * Chooses a pivot as separator and puts all elements
     * smaller than pivot on the left side of it and all
     * elements bigger than pivot on its right side.
     * @param a: array of doubles
     * @param low: index of first array element
     * @param high: index of last array element
     * @return index of new pivot for next partition
     */
    static int partition (double a[],int low, int high) {
    	int i=low;
    	int j=high+1;
    	double pivot = a[low];	//set pivot as first element of shuffled array
    	while(true) {			//unlimited loop, break when markers cross or reach beginning/end of array
    		
    		// move marker i from first element towards end of array
    		// until you reach an element that is bigger than pivot
    		while(Double.compare(a[++i], pivot)<0) {	
    			
    			// break when reaching end of array
    			if(i==high) {
    				break;
    			}
    		}
    		
    		// move marker j from last element towards beginning of array
    		// until you reach an element that is smaller than pivot
    		while(Double.compare(pivot,a[--j])<0) {
    			
    			// break when reaching beginning of array
    			if(j==low) {
    				break;
    			}
    		}
    		
    		// in case markers cross, swap pivot with j
    		if (i >= j) {
    			break;
    		}
    		
    		// swap small element with big element
    		swap(a,i,j);
    	}
    	// move pivot to its position
    	a[low]= a[j];
    	a[j]=pivot;
    	return j;
    	
    }
    
    /**
     * Shuffles an array of doubles randomly.
     * This method is static, thus it can be called as Sort.Comparison.shuffleMyArray(a)
     * @param a: A possibly (partially) sorted array of doubles.
     * @return array randomly shuffled.
     */
    static void shuffleMyArray(double[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a,i,change);
        }
    }
    
    /**
     * Takes an array of doubles and two indexes and swaps respective elements in array.
     * @param a: array of doubles
     * @param i: index of element to swap
     * @param j: index of element to swap
     */
    private static void swap(double [] a, int i, int j) {
    	double temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }


    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		 //todo: implement the sort
    	return a;
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[],int low, int high) {
    	

    	//todo: implement the sort
    	
    	//recursively separating the array in halves until it cannot be separated anymore
    	if (low < high) {
    		int mid = (low+(high-low))/2;
    	
    		mergeSortRecursive(a,low,mid);
    		mergeSortRecursive(a,mid+1,high);
    	
    		recursiveMerge(a,low,mid,high);
    	}
    	
    	return a;
	
   }
    
   static void recursiveMerge(double a[], int low, int mid, int high) {
	   
	   // copy array part of interest into auxiliary array
	   //for (int position = low; position <= high; position++) {
		   //aux[position] = a[position];
	   //}
   }
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

    	int n = a.length;
    	for (int i=0;i<n;i++) {
    		double smallest = a[i];
    		int smallestIndex = i;
    		for (int j=i+1;j<n;j++) {
    			if (a[j]<smallest) {
    				smallest = a[j];
    				smallestIndex = j;
    			}
    		}
    		swap(a,i,smallestIndex);
    	}
    	return a;

    }

   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    	double [] a = {4.0,3.0, 2.0, 10.0, 12.0, 1.0, 5.0,6.0};
    	double [] aSorted = SortComparison.selectionSort(a);
    	System.out.println(Arrays.toString(aSorted));
    }

 }

