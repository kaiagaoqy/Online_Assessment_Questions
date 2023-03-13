package PerfectPairs;

import java.util.Arrays;

public class PerfectPairs {
    
    static int perfectPairs(int[] arr){
        int[] map = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int abs = Math.abs(arr[i]);
            map[i] = abs;
        }

        Arrays.sort(map);

        int res = 0;
        int pointer = 1;

        for(int j=0;j<map.length;j++){
            pointer = pointer>j?pointer:j+1; // suppose y >= x
            while(pointer < map.length){
                if (map[pointer] <= 2*map[j]){
                    res++;
                    pointer++;
                }
                else{
                    break;
                }
                
            }
            
        }
        return res;
    }


    public static void main(String[] args){
        System.out.println("Expected: 2, actual: " + perfectPairs(new int[]{-9,6,-2,1}));
        System.out.println("Expected: 2, actual: " + perfectPairs(new int[]{2,5,-3}));
    }
    
}
