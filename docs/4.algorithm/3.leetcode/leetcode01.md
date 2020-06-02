# LeetCode01 两数比较

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

方法一：暴力法不介绍了

方法二：HashMap方法

主要思路：就是看看另外一个值存在不存在：

1. 如果不存在，那么直接把第一个值放入
2. 如果存在，那么将两个数据放入到一个数组中

![avatar](/4.algorithm/3.leetcode/gif/leetcode01.gif)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums==null||nums.length<2) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            int val=target-num;
            if (map.containsKey(val)){
                res[0]=i;
                res[1]=map.get(val);
                return res;
            }else{
                map.put(num,i);
            }
        }
            return res;
    }
}
```