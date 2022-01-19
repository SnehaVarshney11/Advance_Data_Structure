package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                // If we don't use Math.max the we will go prev index that we don't want
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}
