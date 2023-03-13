## Question
Given the length of a word(wordLen) and the maximum number of consecutive vowels that it can contain(maxVowels), determine how many unique words can be generated. Words will consist of English alphabetic letters a through z only. Vowels are `v`{a,e,i,o,u}; consonants are `c` the remaining 21 letters. In the explanations, v and c represent vowels and consonants.

## Method
Take a simple example of wordlen = 2, maxVowels = 1

C (21+5)*21           V (5*21) \\
|-|                   |        \\
C V (21+5)            C  (21)  \\

(21+5)*21 + (21*5) = 651

We only need to pass the sum of possibilities to its upper layer then multiplied by 21 or 5 then pass upward...
