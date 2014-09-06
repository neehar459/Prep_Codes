import java.util.*;
public class MaxSumSubArray {

static int maxSumSubArr(ArrayList<Integer> list) {
int ret = 0;
int cur = 0;
int max = Integer.MIN_VALUE;

for (int i = 0; i < list.size(); i++) {
if (list.get(i) > max) {
max = list.get(i);
}
cur = max(0, cur + list.get(i));
ret = max(cur, ret);
}
return ret;
}

private static int max(int i, int j) {
return (i < j ? j : i);

}

public static void main(String[] args) {
ArrayList<Integer> num = new ArrayList<Integer>();
num.add(-3);
num.add(-4);
num.add(5);
num.add(6);
num.add(-1);
num.add(-2);
num.add(-9);
num.add(-2);

int result = maxSumSubArr(num);
System.out.println("The result is::" + result);
}

}