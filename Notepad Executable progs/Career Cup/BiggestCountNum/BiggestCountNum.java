public class BiggestCountNum{
	public static void main(String[] args){
		int [] a ={1,2,2,3,3,3,3,5,6,6,6,6,6,6,6,7,8,8,8};
		int currentEle =a[0];
		int currentCount =0;
		int maxFreqEle =a[0];
		int maxFreqCount =0;
		for (int i =0;i<a.length-2;i++)
		{
			currentEle = a[i];
			if(currentEle ==a[i+1]){
			currentCount ++;
			}else
				{
				if(currentCount >maxFreqCount){
					maxFreqEle=currentEle;
					maxFreqCount =currentCount;
				}
			currentCount=0;
			}
		}
		System.out.println("Max freq Element : "+ maxFreqEle +" and its freq : " +(maxFreqCount+1));
	}
}