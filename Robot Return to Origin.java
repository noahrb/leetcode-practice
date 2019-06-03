import java.util.Stack;

class Solution {
    public boolean judgeCircle(String moves) {
        int hCount = 0;
        int vCount = 0;
        char[] arr = moves.toCharArray();
        for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 'U') {
                    vCount++;
                } else if(arr[i] == 'D') {
                    vCount--;
                } else if(arr[i] == 'R') {
                    hCount++;
                } else if(arr[i] == 'L') {
                    hCount--;
                }
        }

        if(vCount == 0 && hCount == 0) {
            return true;
        } else 
            return false;
    }
}