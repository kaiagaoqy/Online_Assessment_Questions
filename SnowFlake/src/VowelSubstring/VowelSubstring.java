package VowelSubstring;

import java.util.HashSet;

public class VowelSubstring {
    static int countVowelSubstrings(String word) {
        int cnt = 0;
        int l = word.length();
        if (l<5)
            return 0;
        for (int i = 0; i < l; i++){
            HashSet <Character> character = new HashSet<>();
            for (int j = i; j < l; j++){
                if(!vowel(word.charAt(j)))
                    break;
                character.add(word.charAt(j));
                if(character.size()==5)
                    cnt++;
            }
        }
        return cnt;
    }
    static boolean vowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' 
        || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Expected: 2, actual: " + countVowelSubstrings("aeiouu"));
        System.out.println("Expected: 0, actual: " + countVowelSubstrings("unicornarihan"));
        System.out.println("Expected: 7, actual: " + countVowelSubstrings("cuaieuouac"));
        System.out.println("Expected: 0, actual: " + countVowelSubstrings("bbaeixoubb"));
    }
}
