//KEY Topics: Morse Code generator, Maps, HashSet

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<String>();
        //ArrayList<String> list = new ArrayList<String>();
        String[] morseArr = wordsToMorse(words);
        int count = 0;
        for(int i = 0; i < morseArr.length; i++) {
            if(set.contains(morseArr[i])) {
                count++;
                set.add(morseArr[i]);
            } else {
                set.add(morseArr[i]);
            }
        }
        return count;
    }

    private String[] wordsToMorse(String[] words) {
        String[] morse26 = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<Character, String> map = new Map<>();
        for(int i = 0; i < morse26.length; i++) {
            map.put(alphabet[i], morse26[i]);
        }

        String[] output = new String[words.length];
        
        for(int i = 0; i < words.length; i++) {
            String temp = "";
            char[] arr = words[i].toCharArray();
            for(int j = 0; j < arr.length; j++) {
                temp += map.get(arr[j]);
            }
            output[i] = temp;
            // ***** ADDS A SPACE BETWEEN WORDS ***** output += " ";
        }
        return output;
    }
}