/*****************************************************
 * class RunMed
 * Calculates the running media of an input stream of Integers.
 *
 * Algorithm for finding the median:
 *	1.	Split the inputs by adding them into 2 heaps, 1 max and 1 min heap
 *	2.	Balance heaps by removing and adding if necessary so both heaps' sizes differ by 1 or less
 *	3.	If the two heaps' sizes are the same take the arithmetic mean of the roots of the two
 *		Else take the root of the larger heap
 *****************************************************/
 
import java.util.NoSuchElementException;

public class RunMed
{
	
	//instance vars
	private ALHeapMax lilVals;	
	
	private ALHeapMin bigVals;
	
	/*****************************************************
	 * default constructor  ---  inits empty heaps
	 *****************************************************/
	public RunMed()
	{
		lilVals = new ALHeapMax();
		bigVals = new ALHeapMin();
	}
	
	
	
	/*****************************************************
	 * double getMedian() 
	 * returns median or throws NoSuchElementException()
	 *****************************************************/
	public double getMedian()
	{
		if ( lilVals.size() == 0 ) {
			if ( bigVals.size() == 0 );//both heaps empty
				throw new NoSuchElementException()
			return bigVals.peekMin();//only lower heap empty
		}
		if ( bigVals.size() == 0 )//only higher heap empty
			return lilVals.peekMax();
		if ( lilVals.size() == bigVals.size() )//both heaps not empty and same size
			return ((double) lilVals.peekMax() + bigVals.peekMin()) / 2;//mean of 2 roots is median
		if ( lilVals.size() > bigVals.size() )//lower heap bigger
			return lilVals.peekMax();
		return bigVals.peekMin();//higher heap bigger
	}
	
	
	/*****************************************************
	 * add(int) 
	 * Adds value to approprite heap
	 * Balances if necessary
	 *****************************************************/
	public void add( int newVal )
	{
		if ( lilVals.size() == 0 && bigVals.size() == 0 )//both heaps empty
			lilVals.add( newVal );
		else if ( newVal > getMedian() )
			bigVals.add( newVal );
		else
			lilVals.add( newVal );
		if ( bigVals.size() - lilVals.size() > 1 )
			lilVals.add( bigVals.removeMin() );
		else if ( lilVals.size() - bigVals.size() > 1 )
			bigVals.add( lilVals.removeMax() );
	}
	
	
	
	//main method for testing
	public static void main( String[] args )
	{
		RunMed nunu = new RunMed();
		
		nunu.add( 2 );
		System.out.println( nunu.getMedian() );//2
		nunu.add( 4 );
		System.out.println( nunu.getMedian() );//3
		nunu.add( 6 );
		System.out.println( nunu.getMedian() );//4
		nunu.add( 8 );
		System.out.println( nunu.getMedian() );//5
		nunu.add( 10 );
		System.out.println( nunu.getMedian() );//6
		nunu.add( 1 );
		System.out.println( nunu.getMedian() );//5
		nunu.add( 3);
		System.out.println( nunu.getMedian() );//4
		nunu.add( 5 );
		System.out.println( nunu.getMedian() );//4.5
		nunu.add( 7 );
		System.out.println( nunu.getMedian() );//5
		nunu.add( 9 );
		System.out.println( nunu.getMedian() );//5.5
	}
}