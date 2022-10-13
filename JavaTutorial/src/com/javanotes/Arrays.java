package com.javanotes;

public class Arrays {

    // 242. Valid Anagram
    public boolean isAnagram(String s, String t) {
//         s = "dog", t = "d g o  "
//         false
//         s = "dog", t = "d go"
//         false
//         s = "Dog", t = "dgo"
//         false

        // confirm if the lengths of both inputs are same
        if (s.length() != t.length()) {
            return false;
        }

        // 1. create new empty array of 26 spaces
        int[] count = new int[26];

        // 2. Uses for loop to keep tally for each alphabet in the input.
        // subtracts the unicode of 'a' to get i
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // 3. Uses for each to iterate through the array for any alphabet that has not tallied off.
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
            // System.out.println(count[i]);
        }
        return true;

    }
}
