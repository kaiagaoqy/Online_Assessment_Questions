package stringPatterns;
import java.util.Arrays;

public class StringPatterns {
    private static int getPatterns(int wordLen, int maxVowels){
        if(wordLen<1){
            return 0;
        }
        if(maxVowels<1){
            return ((int)Math.pow(21,wordLen));
        }
        
        int v = 5*dfs(new int[]{1,1,1}, maxVowels, wordLen);
        int c = 21*dfs(new int[]{0,0,1}, maxVowels, wordLen);

        return v+c;

    }
    private static int dfs(int[] pattern,int maxVowels, int wordLen){
        // 1 = vowel; 0 = consonant
        int letter = pattern[0];
        int consec = pattern[1];
        int total = pattern[2];
        int[] possibility = new int[]{0,0};
        if(total == wordLen){
            return 1;
        }
        if ( letter == 1 && consec == maxVowels){
            possibility[0] += 21*dfs(new int[]{1,consec,total+1},maxVowels, wordLen);
        }
        else{
            possibility[0] += 21*dfs(new int[]{0,consec,total+1},maxVowels,wordLen); // add a consonant means to multiply current possibility by 21
            possibility[1] += 5*dfs(new int[]{0,consec+1,total+1},maxVowels,wordLen);
        }
        return possibility[0]+possibility[1];

    }

    public static void main(String[] args) throws Exception{
        System.out.println("Expected: 26, actual: " + getPatterns(1,1));
        System.out.println("Expected: 651, actual: " + getPatterns(2,1));
        System.out.println("Expected: 676, actual: " + getPatterns(2,2));

    }
}
