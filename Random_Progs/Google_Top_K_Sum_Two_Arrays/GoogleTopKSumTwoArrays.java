import java.util.Arrays;
public class GoogleTopKSumTwoArrays{
	public static void main(String[] args){
		int[] a = {2,3,4}; int[] b = {-1,2,4};
		int[] c = giveTopK(a,b, 3);
		for(int i : c){
			System.out.println(i);
		}
	}
	public static int[] giveTopK(int[] a, int[] b, int k){
		int[] toReturnArray = new int[k];
		int counter = 0;
		if(a == null || a.length == 0 && (b!= null && b.length !=0)){
			Arrays.sort(b);
			for(int j = b.length-1; j > 0; j--){
				toReturnArray[counter] = b[j];
				counter++;
				if(counter == k){
					break;
				}
			}
			return toReturnArray;
		} else if(b == null || b.length == 0 && (a!= null && a.length !=0)){
			Arrays.sort(a);
			for(int d = a.length-1; d > 0; d--){
				toReturnArray[counter] = a[d];
				counter++;
				if(counter == k){
					break;
				}
			}
			return toReturnArray;
		}  else {
			Arrays.sort(a);
			Arrays.sort(b);
			int p = a.length-1;
			int q = b.length-1;
			while(counter < k){
				if(a[p] > b[q]) {
					toReturnArray[counter] = a[p] + b[q];
					q--;
				} else if (a[p] < b[q]) {
					toReturnArray[counter] = a[p] + b[q];
					p--;
				}  else { // assuming that next elements are not equal
					if(a[p-1] != -1 && b[q-1] != -1 ) {
						if(a[p-1] > b[q-1]) {
							toReturnArray[counter] = a[p] + b[q];
							p--;
						} else if (a[p-1] < b[q-1]) {
							toReturnArray[counter] = a[p] + b[q];
							q--;
						} else {
							continue;
						}
					}
				} 
				counter++;
			}
			return toReturnArray;
		}
	}
}