public class CircularArray<T>{
	private T[] items;
	private int head =0;
	
	public static void main(String[] args){
		CircularArray<Integer> cArray = new CircularArray(6);
		
	}
	
	public CircularArray(int size){
		items = (T[]) new Object[size];
	}
	
	private int convert(int index){
		if(index < 0){
			index += items.length;
		}
		return (head+index) % items.length;
	}
	
	public void rotate (int shiftRight){
		head = convert(shiftRight);
	}
	public T get(int index){
		if(i <0 || i>= items.length){
			throw new java.lang.IndexOutOfBoundsException(".....");
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item){
		items[convert(i)] = item;
	}
}