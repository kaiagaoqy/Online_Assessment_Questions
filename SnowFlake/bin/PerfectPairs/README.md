A pair of integers (x,y) is perfect if both the below conditions are met:

min(|x-y|,|x+y|)<=min(|x|,|y|)
max(|x-y|,|x+y|)>=max(|x|,|y|)
Given an array of length n, find the number of perfect pairs (arr[i],arr[j]) where 0<=i<j<n

Here min(a,b) is the min of a and b, max(a,b) is the max of a and b, and |x| is the absolute value of x.

Exmaple:
arr = [-9,6,-2,1] -> ans=2
arr = [2,5,-3] -> ans = 2

How can I solve this with time complexity less than O(n^2)?



Answer:
We need to understand the "physical" meaning of the two conditions.

If x and y have the same sign, i.e., both positive or both negative, then:
min(|x-y|,|x+y|)=|x-y|=||x|-|y|| (the difference between |x| and |y|)
max(|x-y|,|x+y|)=|x+y|=|x|+|y|

If x and y have different signs, i.e., one positive and one negative, then:
min(|x-y|,|x+y|)=|x+y|=||x|-|y||
max(|x-y|,|x+y|)=|x-y|=|x|+|y|

So the two conditions mean:
difference(|x|,|y|) <= min(|x|,|y|);
|x|+|y|>=max(|x|,|y|), which is always true.

If we sort the integers by their absolute values and suppose |x|<=|y|, then min(|x-y|,|x+y|)=||x|-|y||=|y|-|x|<=min(|x|,|y|)=|x| ==> |y|-|x|<=|x| ==> |y|<=2|x|
The number of perfect pairs can be counted on the sorted arrays using two pointers with O(n) time complexity.