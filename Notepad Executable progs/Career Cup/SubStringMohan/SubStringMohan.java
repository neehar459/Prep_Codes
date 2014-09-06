public class SubStringMohan{
	public static void main(String[] args){
		String s1 = "hello worlfworld";
		String s2 = "world";
		System.out.println("common index :" +isSubString(s1.toCharArray(),s2.toCharArray()));
	}

public static int isSubString(char[] str1,char[] str2){
    if(str1 == null && str2 == null)
        return 0;
    else if(str1 == null || str2 == null )
        return -1;
    else if(str1.length == 0 && str2.length ==0)
        return 0;
    else if(str1.length == 0 || str2.length==0)
        return -1;
    else {
        boolean stringFound = false;
		boolean iIncremented = false;
        int returnIndex=0;
        for(int i =0,j=0;i<str1.length;){
			iIncremented = false;
            returnIndex = i;
           while(i<str1.length && j<str2.length && str1[i]==str2[j]){
			iIncremented = true;
               i++;
               j++;
           }
           if(j==str2.length){
				stringFound = true;
               break;
			}
           else
               j=0;
			if(!iIncremented)
				i++;
        
        }
		if(!stringFound)
			return -1;
        return returnIndex;
    
    }
    
 }



}