import java.util.Scanner;


public class letterOnly {

	/**
	 * @param args
	 * lettersOnly’s job is to return a String that is the result of removing all the chars from the 
	 * arg1 String except for the 26 English upper-case letters and the 26 English lower-case letters.
	 * For example:
	 * ""					returns ""
	 * "Beeblebrox"				returns "Beeblebrox"
	 * "123 + 456 = 579"			returns ""
	 * "5 Cats and 13 Dogs !@#$%^&*() "	returns "CatsandDogs"
	 */
	public static final Scanner in = new Scanner( System.in );
	public static void main( String[] arg ){
	String[] arg1 = {"", "Beeblebrox", "123 + 456 = 579",
	"5 Cats and 13 Dogs !@#$%^&*()"};
	String[] expected = {"", "Beeblebrox", "", "CatsandDogs"};
	
	//After removing non upper-case and lower-case letters from arg1, compare it with the "expected".
	for( int i = 0; i < arg1.length; i++ )
	if( expected[i].equals(lettersOnly(arg1[i])) ){
		System.out.println("Matched");
	}
	else{
		die( "lettersOnly bad" );
	}
	
	} // main
	
	
	public static String lettersOnly( String line ){
	String ret = "";
	for( int i = 0; i < line.length(); i++ ){
	char c = line.charAt(i);
	if( 'a'<=c && c<='z' || 'A'<=c && c<='Z' )
	ret += c;
	} // for
	return ret;
	}
	
	public static int die( String msg ){
		System.err.println( "\nFatal error: " + msg );
		System.exit( 1 );
		return 0; // fat chance
		} // die

}
