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


// Challenge 2: Merge Two Sorted arrays

class CheckMergeArray
{
    // merge arr1 and arr2 into a new result array
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // write your code here
        int s1 = arr1.length;
        int s2 = arr2.length;
        int [] arr3 = new int[s1 + s2];
        int i = 0, j = 0, k = 0;

        // 1. Traverse both arrays
        while (i < s1 && j < s2) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            }
            else {
                arr3[k++] = arr2[j++];
            }
        }

        // 2. Store the remaining array.

        while (i < s1) {
            arr3[k++] = arr1[i++];
        }
        while (j < s2) {
            arr3[k++] = arr2[j++];
        }

        return arr3; // make a new resultant array and return your results in that
    }
}
// The time complexity for this algorithm is O(n+m). This is because both arrays are iterated over once.


// 88. merge sorted Array
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // creates a pointer for the last index
        int index = m + n - 1;

        // 1. int m and n are the lengths of the array, so we need to convert it to index base.
        m--;
        n--;

        // 2. Using the while loop, iterate from the back replacing the '0' with larger number
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                index--;
                m--;
            } else {
                nums1[index] = nums2[n];
                index--;
                n--;
            }
        }

        while (n >= 0) {
            nums1[index] = nums2[n];
            index--;
            n--;
        }
    }
}
// time complexity is O(m + n)


// 1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            } else {
                map.put(nums[i], i);
            }
        }
        // must return something or an error message since our return statement is inside the for loop.
        throw new IllegalArgumentException("No solutions.");
    }
}
// Time complexity is O(n)

// 238. Product of Array Except Self
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // the returning result array does not count as extra space.
        int[] res = new int[nums.length];

        // 1. calculate the left array first
        res[0] = 1;

        //res[i] is the products of all the elements on the left.
        for (int i = 1; i < nums.length; i ++) {
            res[i] = res[i-1] * nums[i-1];
        }

        // 2. on top of the caculated left array, we add right array to update the res array.
        // Then we update the res[i] from above with the product of right elements.
        int R = 1;
        for (int i = nums.length-1;  i >= 0; i--) {
            res[i] *= R;
            R *= nums[i];
        }
        return res;
    }
}
// O(n)


// Challenge 5: Find minimum Value in Array
class CheckMinimum {

    public static int findMinimum(int[] arr) {
        // Write your code here

        int minimum = arr[0];

        // At every index, compare its value with minimum and if its less,
        // then make that index value new minimum value.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }
}
// O(n)


// Challenge 6: First Non-Repeating Integer in an Array.
class CheckFirstUnique {
    public static int findFirstUnique(int[] arr) {

        Map<Integer, Integer> countElements = new HashMap<>();
        // if the element does not exist in the HashMap, add that element with value of 0.
        // or else update the number of occurrences of that element by adding 1
        for (int i = 0; i < arr.length; i++) {
            if (countElements.containsKey(arr[i])) {
                int occurrence = countElements.get(arr[i]) + 1;
                countElements.put(arr[i], occurrence);
            } else {
                countElements.put(arr[i], 0);
            }
        }

        // Traverse the array and check the number of occurrences
        // Return the first element with 0 occurrences.
        for (int i = 0; i < arr.length; i++) {
            if (countElements.get(arr[i]) == 0) {
                return arr[i];
            }
        }

        // If no such element is found, return -1
        return -1;
    }
}
// O(n)


// Challenge 7: Find Second Maximum Value in an array.
class CheckSecondMax {

    public int findSecondMaximum(int[] arr)
    {
        // Write - Your - Code
        int max = -214748364;
        int secondMax = -214748364;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                //so that we dod not lose max
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }

        return secondMax;
    }
}


class CheckSecondMax {

    public int findSecondMaximum(int[] arr)
    {
        // Write - Your - Code
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        // Keep track of maximum value, whenever the value at an array index is greater
        // than current maximum value then make that max value 2nd max value and
        // make that index value maximum value.

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}
// O(n)


// Right Rotate the Array by One Index
class CheckRotateArray{

    public static void rotateArray(int[] arr){

        // Store Last Element of Array.
        // Start from last and Right Shift the Array by one.
        // Store the last element saved to be the first element of array.
        int lastElement = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;
    }
}
// O(n)