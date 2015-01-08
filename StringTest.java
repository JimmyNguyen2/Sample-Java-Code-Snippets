/*
 * StringTest: This java programs contains five little static methods that manipulate strings
 */

import java.util.*;
import java.io.*;// for reading a line 

public class StringTest
{

    public static void main(String[] args)
    {
    String a;// for shuffle
    String b;// for shuffle
    Scanner input = new Scanner(System.in);
    
    String S;// for how many
    String little = "nana";
    String big = "banananana";
    String d;// for number of occurrence
    char   c;// for number of occurrence
    String original;// for reverse
            
   // Return the number of times the character c appears in the String s
    System.out.print("Please enter a string of characters: ");
    S = input.nextLine();
    System.out.println("You entered: " + S);
    System.out.println("Enter a character you want to look for in the string: ");
    d = input.next(); //can only read in a string
    input.nextLine();
    c = d.charAt(0);// need to convert to char       

    System.out.println("The number of char: " + c + " in the string: " + S + " is: " + howMany( c, S) );

    //Return the String obtained by reversing the order of the chars in s
    System.out.print("Enter a string to reverse: ");
    original = input.nextLine();
    System.out.println("Reverse of " +  original + " is: " + reverse(original ));

    
    //Return the String obtained by taking a char of a, then a char of b, then the next char of a, 
    // then the next char of b, continuing until both Strings have run out.
    System.out.println("Enter a string to shuffle: ");
    a = input.next();
    System.out.println("Enter another string to shuffle: ");
    b = input.next();
    System.out.println("The shuffle string is: "+ Shuffle(a,b));
    
    
    //Return the number of times the little String appears in the big String
    System.out.println("Number of occurences of 'nana' in 'banananana' is: " + howMany(little,  big));

    
    //Output the words of the sentence one per line
    System.out.print("Enter a sentence to have the words splited: ");
    //  open up standard input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// need this to read a sentence with space between words.

    try {
        S = br.readLine();
    } catch (IOException ioe) {
        System.out.println("IO error trying to read input line!");
        System.exit(1);
    }

    System.out.println("Spliting the words in: " + S);
    showWords(S);
    

}//end main

 /**
  * howMany returns the number of times the character c appears in the String    
  * @param c
  * @param S
  * @return
  */
public static int howMany( char c, String S)
{
int result = 0;
    for (int i = 0; i < S.length(); i++) {
        if (S.charAt(i) == c) {
            result++;
        }//if
    }//for
    return result;
}// end howMany

/**
 * reverse returns the String obtained by reversing the order of the chars in S
 * For example, reverse( “Pineapple cake” ) returns “ekac elppaeniP”.
 * This method doesn’t output anything, it just returns the backwards String to the caller.
 * @param S
 * @return
 */
public static String reverse( String S )
{

  String reverse = "";
  for ( int i = S.length() - 1 ; i >= 0 ; i-- )
  {
        reverse = reverse + S.charAt(i);
  }

  return reverse;
}

/**
 * The Sentence String is expected to be a bunch of words separated by spaces, e.g. “Now is the time”.
 * showWords job is to output the words of the sentence one per line, e.g.
 * Now
 * is
 * the
 * time
 * Assume that S simply contains English words separated by single space and no punctuation.
 * @param S
 */

public static void showWords( String Sentence )
{

    String[] words = Sentence.split(" ");
    for (String word : words) {
    System.out.println(word);
    }

}//end showWords


/**
 * howMany(String little, String big) returns the number of times the little String appears in the big String
 * For instance, howMany( “nana”, “banananana” ) returns 3.
 * (Note that the occurrences of “nana” overlap, which is fine.)
 * @param little
 * @param big
 * @return
 */
public static int howMany(String little, String big)
{

    int count = 0;
    for(int pos = 0; pos<= big.length()-little.length(); pos++)
    {
        if(big.substring(pos,pos+little.length()).equals(little))
            count++;
    }
    return count;
}//howmany


/**
 * Shuffle returns the String obtained by taking a char of a, then a char of b, then the next char of a,
 * then the next char of b, continuing until both Strings have run out.
 * For instance, shuffle( “pineapple”, “cake” )  returns “pciankeeapple”.
 * @param a
 * @param b
 * @return
 */
public static String Shuffle(String a, String b)
{
    String answer = "";//must initialize it
    for (int i = 0, j = 0; i <a.length() || j < b.length();)
    {
       answer += j == b.length() || i < a.length() && i == j ? a.charAt(i++) : b.charAt(j++);
  
    }
    return answer;
}//Shuffle


}//StringTest