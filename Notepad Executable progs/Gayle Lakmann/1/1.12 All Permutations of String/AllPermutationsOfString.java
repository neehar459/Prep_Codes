import java.util.*;
public class AllPermutationsOfString{
	public static void main(String[] args){
		String toPermute = "abc";
		permutate(toPermute);
		System.out.println("---------------------");
		//permute1(toPermute);
	}
	public static void permutate(String inputString){
		permute("",inputString);
	}
	private static void permute(String start, String end){
		if (end.isEmpty()) {
            System.out.println(start);
        } else {
            Map<Character, Boolean> visited = new HashMap<Character, Boolean>();
            for (int i = 0; i < end.length(); i++) {
                if (!visited.containsKey(end.charAt(i))) {
                    visited.put(end.charAt(i), true);
                    permute(start + end.charAt(i), end.substring(0, i) + end.substring(i + 1, end.length()));
                }
            }
        }
	}
	
	// other site code 
	static void permute1( String input){
	  int inputLength = input.length();
	  boolean[ ] used = new boolean[ inputLength ];
	  StringBuffer outputString = new StringBuffer();
	  char[ ] in = input.toCharArray( );
	  doPermute ( in, outputString, used, inputLength, 0 );
	}

	static void doPermute ( char[ ] in, StringBuffer outputString, 
                    boolean[ ] used, int inputLength, int level){
		if( level == inputLength) {
		System.out.println ( outputString.toString()); 
		return;
		}
		for( int i = 0; i < inputLength; ++i ){       
		   if( used[i] ) continue;
		   outputString.append( in[i] );      
		   used[i] = true;       
		   doPermute( in,   outputString, used, inputLength, level + 1 );       
		   used[i] = false;       
		   outputString.setLength(   outputString.length() - 1 );   
		}
	}
}