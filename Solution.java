import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;


/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class Solution {


    /**
     * Given a string, find the first non-repeating character in it and return its index.
     * If it doesn't exist, return -1.
     * 
     * Runtime: 30 ms, faster than 24.99% of Java online submissions.
     * Memory Usage: 39.4 MB, less than 95.22% of Java online submissions .
     * 
     * Runtime:  O(2 * n)
     */
    static int firstUniqChar0(String s) {

        // **** ****
        LinkedHashMap<Character, Integer> freqs = new LinkedHashMap<Character, Integer>();

        // **** traverse string updating frequencies O(n) ****
        for (int i = 0; i < s.length(); i++) {

            // **** for ease of use ****
            char ch = s.charAt(i);

            // **** ****
            if (!freqs.containsKey(ch)) {
                freqs.put(ch, 1);
            } else {
                int count = freqs.get(ch);
                freqs.replace(ch, count, count + 1);
            }
        }

        // **** look for first non-repeating character in the string O(n) ****
        char ch = 0;

        // for (Entry<Character, Integer> entry : freqs.entrySet()) {
        //     if (entry.getValue() == 1) {
        //         ch = entry.getKey();
        //         break;
        //     }
        // }

        for (char c : freqs.keySet()) {
            if (freqs.get(c) == 1) {
                ch = c;
                break;
            }
        }

        // **** unique character NOT found ****
        if (ch == 0)
            return -1;

        // **** find ch in s ****
        return s.indexOf(ch, 0);
    }

    
    /**
     * Given a string, find the first non-repeating character in it and return its index.
     * If it doesn't exist, return -1.
     * 
     * Runtime: 8 ms, faster than 80.02% of Java online submissions.
     * Memory Usage: 39.5 MB, less than 91.98% of Java online submissions.
     * 
     * Runtime:  O(2 * n)
     */
    static int firstUniqChar(String s) {

        // **** initialization ****
        int[] freq      = new int[26];
        int[] firstPos  = new int[26];

        // **** populate arrays O(n) ****
        for (int i = 0; i < s.length(); i++) {

            // **** ****
            freq[s.charAt(i) - 'a']++;

            // **** ***
            if (firstPos[s.charAt(i) - 'a'] == 0)
                firstPos[s.charAt(i) - 'a'] = i + 1;
        }

        // **** look for the first unique character O(26) ****
        int pos = Integer.MAX_VALUE;
        for (int i = 0; i < freq.length; i++) {
            if ((freq[i] == 1) && (firstPos[i] < pos)) {
                pos = firstPos[i];
            }
        }

        // **** return the result ****
        return pos == Integer.MAX_VALUE ? -1 : pos - 1;
    }
        

    /**
     * Test scaffolding
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read string ****
        String s = sc.nextLine().trim();

        // **** close scanner ****
        sc.close();

        // ???? display string ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** generate and display result ****
        System.out.println("main <<< firstUniqChar0: " + firstUniqChar0(s));

        // **** generate and display result ****
        System.out.println("main <<<  firstUniqChar: " + firstUniqChar(s));
    }

}