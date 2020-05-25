<!--
 * @Author: 孙浩然
 * @Date: 2020-05-25 09:29:00
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-05-25 11:15:29
 * @FilePath: \docs\4.algorithm\3.leetcode\leetcode01.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/JavaScholar/#/)
--> 
# LeetCode01 两数比较

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

方法一：暴力法不介绍了

方法二：HashMap方法

主要思路：首先把数据放入到hashmap中，但不是遍历放入，而是看看map中有没有比较的数值：

1. 如果没有，那么直接放入
2. 如果有，那么将两个数据放入到一个数组中

![avatar](/4.algorithm/3.leetcode/gif/leetcode01.gif)