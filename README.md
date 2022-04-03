# leetCode 题解


- 8 字符串转换整数 (atoi)

> 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
> 函数 myAtoi(string s) 的算法如下：
>
>读入字符串并丢弃无用的前导空格 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。 返回整数作为最终结果。
>
> 注意：
>
>本题中的空白字符只包括空格字符 ' ' 。 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。

```java
    public int myAtoi(String s){
        String str=s.trim();
        if(str.length()< 1)
        return 0;
        long ans=0;
        int index=0;
        int sign=1;
        boolean switched=true;
        char[]chars=str.toCharArray();
        if(chars[index]=='-'&&switched){
        sign=-1;
        ++index;
        switched=false;
        }else if(chars[index]=='+'&&switched){
        ++index;
        switched=false;
        }else{
        switched=false;
        }
        for(;index<chars.length;index++){
        char c=chars[index];
        if(!Character.isDigit(c)){
        break;
        }
        ans=ans*10+Integer.parseInt(String.valueOf(c));

        if(ans>Integer.MAX_VALUE){
        if(sign==-1){
        return Integer.MIN_VALUE;
        }else{
        return Integer.MAX_VALUE;
        }
        }

        }
        return(int)ans*sign;
        }
```

## 双指针

### 1. 两数之和

> 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
>
> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
>
> 你可以按任意顺序返回答案。

```java
private int[]getIndexs(int[]arrary,int target){

        Map<Integer, Integer> renmenbrence=new HashMap<>();
        for(int i=0;i<arrary.length;i++){

        if(renmenbrence.containsKey(target-arrary[i])){

        return new int[]{renmenbrence.get(target-arrary[i]),i};
        }
        renmenbrence.put(arrary[i],i);

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
> 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
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

## 滑动窗口

219. 存在重复元素 II

> 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。

```java
    public boolean containsNearbyDuplicate(int[]nums,int k){

        Set<Integer> hasInt=new HashSet<>();

        for(int i=0;i<nums.length;i++){
        if(hasInt.contains(nums[i])){
        return true;
        }
        hasInt.add(nums[i]);
        if(hasInt.size()>k){
        hasInt.remove(hasInt.remove(nums[Math.abs(i-k)]));
        }
        }

        return false;
        }
```

- 125

> 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。

> 示例 1:
>
> 输入:
> "A man, a plan, a canal: Panama"
>
>输出: true
>
>解释："amanaplanacanalpanama" 是回文串


> 示例 2:
>
> 输入: "race a car"
>
>输出: false
>
> 解释："raceacar" 不是回文串

```java
    public boolean isPalindrome(String s){
        // 将非数字和字母的剔除掉    
        String str=s.toLowerCase()
        .replaceAll("[^a-z0-9]","");
        int i=0,j=str.length()-1;
        while(i<j){
        if(str.charAt(i++)!=str.charAt(j--)){
        return false;
        }
        }
        return true;
        }
```

## 二分查找

- 704 二分查找

> 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

>
>输入: nums = [-1,0,3,5,9,12], target = 9
>
>输出: 4
>
>解释: 9 出现在 nums 中并且下标为 4
>

> 输入: nums = [-1,0,3,5,9,12], target = 2
>
>输出: -1
>
>解释: 2 不存在 nums 中因此返回 -1

```java
    public int search(int[]nums,int target){
        int left=0,right=nums.length-1;
        int mid=(left+right)/2;
        while(left<=right){
        if(nums[mid]==target){
        return mid;
        }
        if(nums[mid]>target){
        right=mid-1;
        mid=(left+right)/2;
        }else{
        left=mid+1;
        mid=(left+right)/2;
        }
        }
        return-1;
        }
```

- 739 每日温度

> 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
>
> 

> 示例 1:
>
>输入: temperatures = [73,74,75,71,69,72,76,73]
>
> 输出: [1,1,4,2,1,1,0,0]
>
> 示例 2:
>
>输入: temperatures = [30,40,50,60]
>
>输出: [1,1,1,0]
>
> 示例 3:
>
>输入: temperatures = [30,60,90]
> 输出: [1,1,0]

```java
    public int[]dailyTemperatures(int[]temperatures){

        int[]ans=new int[temperatures.length];

        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<temperatures.length;i++){
        while(!stack.isEmpty()&&(temperatures[i]>temperatures[stack.peek()])){
        ans[stack.peek()]=i-stack.pop();
        }
        stack.push(i);
        }
        return ans;
        }

```
