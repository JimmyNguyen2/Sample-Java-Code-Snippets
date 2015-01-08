import java.util.Scanner;
/**
 * 
 * This program has a main function, together with following 3 little static functions 
 * that manipulate 1-dimensional arrays. Assume array is not null.
 * 
 */

public class Array {

	public static final Scanner in = new Scanner( System.in );
	public static void main( String[] arg ){
	show( new int[]{2, 3, 5, 1} ); // 4-element array
	show( new int[]{} ); // 0-element array
	show( merge( new int[]{2, 3, 3, 6}, new int[]{2, 5, 8, 9, 10, 100} ) );
	System.out.print("Smallest odd number is: ");
	System.out.println(f( new int[]{-2,-3,-4,-5,-6,1,2,3,4} ));
	f( new int[]{2, 4, 6, 8} );
	/**/
	} // main
	
	/**
	 * show’s job is to output each value in the array a. The list of values is surrounded by [], 
	 * the values are separated by commas, and there is no comma before the first value or after the last value.
	 * For example, if main is
	 * public static void main( String[] arg ){
	 *   show( new int[]{2, 3, 5, 1} ); // 4-element array
	 *   show( new int[]{} ); // 0-element array
	 * } // main
     *then the program outputs
	 *[2, 3, 5, 1]
	 *[]
	 * @param a
	 */
	public static void show( int[] a ){
	System.out.print( "[" );
	for( int i = 0; i < a.length; i++ )
	System.out.print( (i==0?"":", ") + a[i] );
	System.out.println( "]" );
	} // show
	
	
	/**
	 * merge function assumes without checking that each arg array has been sorted into increasing order. 
	 * The arg arrays might have duplicate elements, and they might have size 0. merge does not change 
	 * either of the 2 arg arrays. Its job is to create and return an array that is the result of merging 
	 * the elements of a and b together in such a way that the merged array is also sorted. 
	 * (So, the length of the returned array is always the sum of the lengths of the 2 arg arrays.)
	 *For example,
	 *	merge( new int[]{2, 3, 3, 6}, new int[]{2, 5, 8, 9, 10, 100} ) would create and return
	 *	the 10-element array {2, 2, 3, 3, 5, 6, 8, 9, 10, 100}

	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] merge( int[] a, int[] b ){
	int[] ret = new int[ a.length + b.length ];
	for( int ai = 0, bi = 0, ci = 0; ci < a.length+b.length; )
	ret[ci++] = bi==b.length || ai<a.length && a[ai] <= b[bi] ? a[ai++]
	: b[bi++];
	return ret;
	} // merge
	
	/**
	 * f functions does not change the arg array. If the arg array doesn't have any odd numbers, c&d.
     * Otherwise, return the smallest odd number.
     *For example:
	 *f( new int[]{ -2, -3, -4, -5, -6, 1, 2, 3, 4} )  returns -5

	 * @param a
	 * @return
	 */
	public static int f( int[] a ){
	boolean seenOdd = false;
	int smallestOdd = 0; // initialization prevents compiler warning
	for( int odd: a )
	if( odd%2 != 0 && (!seenOdd || odd < smallestOdd) ){
	seenOdd = true;
	smallestOdd = odd;
	}
	if( !seenOdd ) die( "no odd numbers found" );
	return smallestOdd;
	} // f
	
	/**
	 * die function prints an error message.
	 * @param msg
	 * @return
	 */
	public static int die( String msg ){
	System.err.println( "\nFatal error: " + msg );
	System.exit( 1 );
	return 0; // fat chance
	} // die
}
