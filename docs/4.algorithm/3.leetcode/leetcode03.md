# LeetCode03 无重复字符的最长子串

思路：

设置两个指针：left与right

1. 移动right，通过每一位的boolean值判断是否重复，重复了，就开始判断最大值
2. 开始移动left，并且把之前的left排除出去，直到left和right相同，判断最大值（这样就没有重复了，就可以判断最大值了）

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
       if (s==null ||s.length()<2) return 0;

       int left=0;
       int right=0;
        boolean[] b = new boolean[128];
        int n=s.length();
        int max=0;

        while(right<n){
            if (b[s.charAt(right)]==false){
                b[s.charAt(right)]=true;
                right++;
            }else{
                max=Math.max(max,right-left);
                while (left<right && s.charAt(left)!=s.charAt(right)){
                    b[s.charAt(left)]=false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max=Math.max(max,right-left);
        return max;
    }
}
```






