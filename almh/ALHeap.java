/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString()
  {
      return _heap.toString();
  }//O(n)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
      return _heap.size() == 0;
  }//O(1)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMin()
  {
      if(isEmpty()){
	  return null;
      }
      else{
	  return _heap.get(0);
      }
  }//O(1)


  /*****************************************************
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   *
   * Algorithm:
   * 1.	Insert element as right most node on bottom level
   * 2.	While the element's parent is greater than it, swap its position with its parent
   *****************************************************/
  public void add( Integer addVal )
  {
	  int index = _heap.size();
	  _heap.add( addVal );
	  while( _heap.get( index ).compareTo( _heap.get( (index - 1) / 2 ) ) < 0 ) {
		  swap( index, (index - 1) / 2 );
		  index = (index - 1) / 2;
	  }	  
  }//O(logn)


  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * 
   * Algorithm:
   *	1.	Swap root of tree with rightmost node on bottom level
   *	2.	Remove node from tree
   *	3.	While new root element's smallest child is smaller than it,
   *		swap it with that child
   *****************************************************/
  public Integer removeMin()
  {
	  if ( isEmpty() )
		  throw new NoSuchElementException();
	  swap( 0, _heap.size() - 1 );
	  int retVal = _heap.remove( _heap.size() - 1 );
	  int root = 0;
	  int child = 0;
	  while( minChildPos( root ) > -1 && _heap.get( root ).compareTo( _heap.get( minChildPos( root ) ) ) > 0 ) {
		  child = minChildPos( root );
	      swap( root, child );
		  root = child;
	  }
	  return retVal;
  }//O(logn)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
	  int p = pos * 2 + 1;
	  if ( p >= _heap.size() )
		  return -1;
	  if ( p + 1 >= _heap.size() )
		  return p;
	  return _heap.indexOf( minOf( _heap.get( p ), _heap.get( p + 1 ) ) );
  }//O(1)


  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);
	  
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
