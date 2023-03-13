package LargestSubGrid;

import java.util.Arrays;

public class LargestSubGrid {


    public static int[][] sumMatrix(int row, int col, int[][] grid){
        int[][] sums = new int[row+1][col+1];
        for(int[] arr: sums){
            Arrays.fill(arr,0 );
        }

        for(int i = 0; i <row;i++){
            for(int j = 0; j<col;j++){
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + grid[i][j];
                
            }
        }
        return sums;

    }
    public static int sumSubarray(int row1, int col1, int row2, int col2, int[][] sums) {
        int res = sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        return res;
    }

    public static int largestSubGrid(int row, int col, int[][] grid, int maxSum){
        int[][] sums = sumMatrix(row,col,grid);
        int n = row;
        int[] maxSumArr = new int[row+1];
        Arrays.fill(maxSumArr,0);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = n; k>=0; k--){
                    if((i+n-1<row) && (j+n-1<col) && (sumSubarray(i, j,i+n-1, j+n-1,sums)>maxSum)){
                        n--;
                        if(n==0){return 0;}
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return n;
    }

    
    public static void main(String[] args){
        System.out.println("Expected: 2, actual: " +largestSubGrid(3,3,new int[][]{{1,1,1}, {1,1,1},{1,1,1}},4));
        System.out.println("Expected: 3, actual: " +largestSubGrid(4,4,new int[][]{{1,1,1,1}, {2,2,2,2}, {3,3,3,3},{4,4,4,4}},39));
        System.out.println("Expected: 4, actual: " +largestSubGrid(4,4,new int[][]{{1,1,1,1}, {2,2,2,2}, {3,3,3,3},{4,4,4,4}},40));
        System.out.println("Expected: 1, actual: " +largestSubGrid(4,4,new int[][]{{1,1,1,1}, {2,2,2,2}, {3,3,3,3},{4,4,4,4}},4));
        System.out.println("Expected: 0, actual: " +largestSubGrid(4,4,new int[][]{{1,1,1,1}, {2,2,2,2}, {3,3,3,3},{4,4,4,4}},3));
        System.out.println("Expected: 0, actual: " +largestSubGrid(2,2,new int[][]{{4,5}, {6,7}},2));
    }
}
