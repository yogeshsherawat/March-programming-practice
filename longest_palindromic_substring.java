package March;

import java.util.*;
public class longest_palindromic_substring {
    static int longest_palindromic_substring(String s) {
        System.out.println(s.length());
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                ArrayList<Integer> l = map.get(c);
                System.out.println(l);
                for (int ele : l) {
                    int k = isSubstring(s, ele, i);
                    ans = Math.max(ans, k);
                }
                l.add(i);
                map.put(c, l);

            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(c, l);
            }
        }

        return ans;
    }

    static int isSubstring(String s, int start, int end) {
        int ans = end - start + 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return 0;
            start++;
            end--;
        }
        return ans;

    }
    
}


