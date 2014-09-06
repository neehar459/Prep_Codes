import java.util.Stack;
public class ValidateBraces{
	public static void main(String[] args){
		String seq = "()(()[()])";
		System.out.println("is Sequence Valid : "+isValidBrace(seq));
	}
	public static boolean isValidBrace(String seq){
		if(seq == null || seq.length() == 0){
			return false;
		} else{
			if(seq.length() == 1){
				return false;
			} else{
				Stack<Character> myStack = new Stack<Character>();
				char[] seqArray = seq.toCharArray();
				for(int i=0; i< seq.length(); i++){
					if(seqArray[i] == '(' || seqArray[i] == '[' || seqArray[i] == '{'){
						myStack.push(seqArray[i]);
					} else if(seqArray[i] == ')' || seqArray[i] == ']' || seqArray[i] == '}'){
						if(myStack.isEmpty()){
							return false;
						} else if(seqArray[i] ==')' && myStack.pop() != '('){
							return false;
						} else if(seqArray[i] =='}' && myStack.pop() != '{'){
							return false;
						} else if(seqArray[i] ==']' && myStack.pop() != '['){
							return false;
						}
					}
				}
				if(!myStack.isEmpty()){
					return false;
				}
			}
			return true;
		}
	}
}
