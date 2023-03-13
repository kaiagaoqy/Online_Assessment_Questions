You are given an integer square grid which can be devided into square sub-grids.The sub-grid sum is obtained by adding all elements of the sub-grid. Determine the maximum size of a square sub-grid such that all sub-grids of this size must have sub-grid sum less than or equal to a given value(maxSum). Return the size of that sub-grid(size=number of rows or columns).



This question  pre cal the sum like this in question
https://leetcode.com/problems/range-sum-query-2d-immutable.

Then you can use binary search for the answer, or traverse the result.(I might update the binary search method later, but seems the second way is good enough)