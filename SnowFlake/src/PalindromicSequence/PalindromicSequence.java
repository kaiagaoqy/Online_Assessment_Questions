package PalindromicSequence;

public class PalindromicSequence {
    static boolean check(char[] s, int state) {
        int left = 0, right = s.length - 1;
        
        // 检查 state 对应的子序列是不是回文串
        while (left < right) {
            // 将 left 和 right 对应上 「状态所对应的字符」 位置
            while (left < right && (state >> left & 1) == 0) {
                left++;
            }
            while (left < right && (state >> right & 1) == 0) {
                right--;
            }
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    static int maxProduct(String s) {
        int n = s.length(), m = 1 << n;
        char[] str = s.toCharArray();
        int[] count = new int[m];
        
        // 记录所有合法状态的字符串长度
        for (int i = 1; i < m; i++) {
            if (check(str, i)) {
                count[i] = Integer.bitCount(i);
            }
        }
        
        int res = 0;
        // 对 s 的每个子序列进行子集枚举
        for (int i = 1; i < m; i++) {
            int split = i >> 1;
            // 由于 j 与 i ^ j 是互补的关系，即 j ^ i ^ j = i 
            // 因此只需枚举到 i / 2 就可以了
            for (int j = (i - 1) & i; j > split; j = (j - 1) & i) {
                // 假设 i 代表字符串 "etcdec"，j 为 i 的子集
                // 且 j = "ete" and i ^ j = "cdc" 时，记录答案
                res = Math.max(res, count[j] * count[i ^ j]);
            }
        }
        
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println("Expected: 9, actual: " + maxProduct("leetcodecom"));
        System.out.println("Expected: 1, actual: " + maxProduct("bb"));
        System.out.println("Expected: 25, actual: " + maxProduct("accbcaxxcxx"));
    }    
}

