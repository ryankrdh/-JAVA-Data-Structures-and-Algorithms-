package com.javanotes;

// 242. Valid Anagram
public class Arrays {
    public boolean isAnagram(String s, String t) {

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

        // 3. Uses for loop to iterate through the array for any alphabet that has not tallied off.
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
            // System.out.println(count[i]);
        }
        return true;
    }
}


// Challenge 1: Remove Even Integers from an Array.
class CheckRemoveEven {

    public static int[] removeEven(int[] arr) {

        // Write - Your - Code- Here
        int oddElements = 0;

        // 1. find the number of odd numbers in the array.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddElements++;
            }
        }

        // 2. create result array with the size of the odd elements.
        int[] result = new int[oddElements];
        int result_index = 0;

        // 3. Add odd element numbers into the new array.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[result_index++] = arr[i];
            }
        }
        return result;
    }
}
//Since the entire array has to be iterated over, this solution is in O(n)
