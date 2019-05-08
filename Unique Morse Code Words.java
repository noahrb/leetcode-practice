//KEY Topics: Morse Code generator, Maps, HashSet

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length == 0)
            return 0;
        ArrayList<String> set = new ArrayList<>();
        String[] morseArr = wordsToMorse(words);
        int count = 0;
        
        for(int i = 0; i < morseArr.length; i++) {
            if(!set.contains(morseArr[i])) {
                count++;
                set.add(morseArr[i]);
            }
        }
        if(count == 0)
            count++;

        return count;
    }

    private String[] wordsToMorse(String[] words) {
        String[] morse26 = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<Character, String> map = new HashMap<>();
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
            System.out.println(output[i]);
        }
        return output;
    }
}