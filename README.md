# leetCode 题解

## 双指针

### 1. 两数之和

> 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
>
> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
>
> 你可以按任意顺序返回答案。

```java
private int[] getIndexs(int[] arrary, int target) {

        Map<Integer, Integer> renmenbrence = new HashMap<>();
        for (int i = 0; i < arrary.length; i++) {

            if (renmenbrence.containsKey(target - arrary[i])) {

                return new int[]{renmenbrence.get(target - arrary[i]), i};
            }
            renmenbrence.put(arrary[i], i);

        }

        return null;
    }
```



### 4. 寻找两个正序数组的中位数

> 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
>
>
>
> 示例 1：
>
> 输入：nums1 = [1,3], nums2 = [2]
> 输出：2.00000
> 解释：合并数组 = [1,2,3] ，中位数 2
> 示例 2：
>
> 输入：nums1 = [1,2], nums2 = [3,4]
> 输出：2.50000
> 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
> 示例 3：
>
> 输入：nums1 = [0,0], nums2 = [0,0]
> 输出：0.00000
> 示例 4：
>
> 输入：nums1 = [], nums2 = [1]
> 输出：1.00000
> 示例 5：
>
> 输入：nums1 = [2], nums2 = []
> 输出：2.00000



## 滑动窗口

### 3. 无重复字符的最长子串

> 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
>
>
> 示例 1:
>
> 输入: s = "abcabcbb"
> 输出: 3 
> 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
> 示例 2:
>
> 输入: s = "bbbbb"
> 输出: 1
> 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
> 示例 3:
>
> 输入: s = "pwwkew"
> 输出: 3
> 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
>   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
> 示例 4:
>
> 输入: s = ""
> 输出: 0

``` java
public int lengthOfLongestSubstring(String s) {
if (s == null || s.length() == 0 || s.trim().length() == 0) {
return 0;
}
return getMaxLen(s);
}

    public int getMaxLen(String s) {
    
        int maxLen = 0;
        int p = 0, q = 0;
        Map<Character, Integer> res = new HashMap<>();
        while (q < s.length()) {
            if (res.containsKey(s.charAt(q))) {
                p = max(res.get(s.charAt(q)) + 1, p);
            }
            res.put(s.charAt(q), q);
            maxLen = max(maxLen, q - p + 1);
            ++q;
        }
        return maxLen;
    }

```



串联所有单词的子串

最小覆盖子串

至多包含两个不同字符的最长子串

长度最小的子数组

滑动窗口最大值

字符串的排列

最小区间

最小窗口子序列

