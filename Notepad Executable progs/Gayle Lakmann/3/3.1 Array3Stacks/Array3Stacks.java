public class Array3Stacks{
	
	int capacity = 9;
	int[] topOfStack={-1,-1,-1};
	int[] iArray = new int[capacity];
	
	public static void main(String[] args){
		Array3Stacks a3Stacks = new Array3Stacks();
		a3Stacks.push(1,1);
		a3Stacks.push(1,2);
		a3Stacks.push(1,3);
		a3Stacks.push(1,4);
		a3Stacks.displayExactStack(1);
		a3Stacks.push(2,5);
		a3Stacks.push(2,6);
		a3Stacks.push(2,7);
		a3Stacks.push(2,8);
		a3Stacks.push(2,13);
		a3Stacks.push(2,15);
		a3Stacks.push(2,16);
		a3Stacks.displayExactStack(2);
		a3Stacks.push(3,9);
		a3Stacks.push(3,10);
		a3Stacks.push(3,11);
		a3Stacks.push(3,12);
		a3Stacks.push(3,14);
		a3Stacks.displayExactStack(3);
		a3Stacks.displayAllStacks();
		System.out.println("Popped Element from stack 1 : "+a3Stacks.pop(1));
		a3Stacks.displayExactStack(1);
		System.out.println("Popped Element from stack 2 : "+a3Stacks.pop(2));
		a3Stacks.displayExactStack(2);
		System.out.println("Popped Element from stack 3 : "+a3Stacks.pop(3));
		a3Stacks.displayExactStack(3);
		a3Stacks.displayAllStacks();
		System.out.println("Peeked Element from stack 1 : "+a3Stacks.peek(1));
		a3Stacks.displayExactStack(1);
		System.out.println("Peeked Element from stack 2 : "+a3Stacks.peek(2));
		a3Stacks.displayExactStack(2);
		System.out.println("Peeked Element from stack 3 : "+a3Stacks.peek(3));
		a3Stacks.displayExactStack(3);
		a3Stacks.displayAllStacks();
	}
	
	// This method pushes elements in to the corresponding stack and dynamically increase the size of the array when any stack goes beyond size
	public int push(int stackNumber, int element){
		if(stackNumber!=1 && stackNumber!=2 && stackNumber!=3){
			throw new IllegalArgumentException(" Stack numbers can be 1,2 0r 3");
		}
		int topOfStackPos = topOfStack[stackNumber-1];
		int posToInsert = ((stackNumber-1)*iArray.length/3)+topOfStackPos+1;
		if(topOfStackPos==-1){
			iArray[posToInsert] = element;
			topOfStack[stackNumber-1]++;
			return element;
		}else{
			if(topOfStackPos == ((iArray.length/3)-1)){
				doubleArraySize();
				posToInsert=((stackNumber-1)*iArray.length/3)+topOfStackPos+1; // recalculate position as array length changed
				iArray[posToInsert]=element;
				topOfStack[stackNumber-1]++;
				return element;
			}else{
				iArray[posToInsert]=element;
				topOfStack[stackNumber-1]++;
				return element;
			}
		}
	}
	
	// This method removes the element from the stack
	public int pop(int stackNumber){
		int topOfStackPos = topOfStack[stackNumber-1];
		if(stackNumber!=1 && stackNumber!=2 && stackNumber!=3){
			throw new IllegalArgumentException(" Stack numbers can be 1,2 0r 3");
		}else if(topOfStack[stackNumber-1]==-1){
			return -123456789;
		}else{
			int positionToDelete = ((stackNumber-1)*iArray.length/3)+topOfStackPos;
			int elementToDelete = iArray[positionToDelete];
			iArray[positionToDelete]=0;
			topOfStack[stackNumber-1]--;
			return elementToDelete;
		}
	}
	
	// This method returns the topOfStack element of corresponding stackNumber
	public int peek(int stackNumber){
		int topOfStackPos = topOfStack[stackNumber-1];
		if(stackNumber!=1 && stackNumber!=2 && stackNumber!=3){
			throw new IllegalArgumentException(" Stack numbers can be 1,2 0r 3");
		}else if(topOfStack[stackNumber-1]==-1){
			return -123456789;
		}else{
			int positionToDelete = ((stackNumber-1)*iArray.length/3)+topOfStackPos;
			int elementToDelete = iArray[positionToDelete];
			return elementToDelete;
		}
	}
	
	
	// This method doubles the array size and returns a new Array after copying elements in to new Array
	public void doubleArraySize(){
		int[] newArray = new int[2*iArray.length];
		int stackNumber=0;
		int loopCounter2=0,loopCounter3=0;
		for( int i=0; i < iArray.length; i++){
			if(i<(iArray.length/3)){ // Copying first sub array
				newArray[i] = iArray[i];
			}else if(i>=iArray.length/3 && i<2*iArray.length/3){ // copying second sub array
				stackNumber =2;
				int posToInsert = (stackNumber-1)*newArray.length/3+loopCounter2; 
				newArray[posToInsert] = iArray[i];
				loopCounter2++;
			}else if(i>=2*iArray.length/3 && i<iArray.length){
				stackNumber =3;
				int posToInsert1 = (stackNumber-1)*newArray.length/3+loopCounter3;
				newArray[posToInsert1] = iArray[i];
				loopCounter3++;
			}
		}
		iArray = newArray;
	}
	
	// this method displays only the corresponding stack
	public void displayExactStack(int stackNumber){
		if(stackNumber!=1 && stackNumber!=2 && stackNumber!=3){
			throw new IllegalArgumentException(" Stack numbers can be 1,2 0r 3");
		}else{
			int fromPosition = ((stackNumber-1)*iArray.length/3)+topOfStack[stackNumber-1];
			for(int i= fromPosition ; i>=(stackNumber-1)*iArray.length/3; i--){
				System.out.print("---> "+iArray[i]);
			}
			System.out.println(" ");
		}
	}
	
	// this method displays all stacks
	public void displayAllStacks(){
		if(topOfStack[0]== -1 && topOfStack[1]== -1 && topOfStack[2]==-1){
			throw new IllegalArgumentException("No elements are present in all stacks");
		}else{
			for(int i= 0; i<iArray.length; i++){
				System.out.print("---> "+iArray[i]);
			}
			System.out.println(" ");
		}
	}
	
}