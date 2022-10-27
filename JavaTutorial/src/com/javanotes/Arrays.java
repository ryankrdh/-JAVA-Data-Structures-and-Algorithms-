package com.javanotes;

// 242. Valid Anagram
class Solution {
    public boolean isAnagram(String s, String t) {
        //corner case
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 && s.length() == t.length()) {
            return true;
        }

        // 1. store the count with map
        HashMap<Character, Integer> map = new HashMap <>();

        // at key of s.charAt(i), if I can get s.charAt(i) add one, if not default 0.
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        //2. check the counts
        for (char key : map.keySet()) {
            int count = map.get(key);
            if (count != 0) {
                return false;
            }
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
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

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


// Challenge 8: Right Rotate the Array by One Index
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


// Challenge 9: Re-arrange Positive & Negative Values
class CheckReArrange {

    public static void reArrange(int[] arr) {
        int index = 0;
        // creates new array to hold the numbers in.
        int[] newArray = new int[arr.length];
        // grabs all the negative numbers and puts it in the newArray
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        // grabs all the positive numbers and puts it in the newArray
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        // transfers the re-arranged elements from newArray to original arr.
        for (int i = 0; i < newArray.length; i++) {
            arr[i] = newArray[i];
        }
    }
}


// Challenge 10: Rearrange Sorted Array in Max/Min Form.
class CheckMaxMin {

    public static void maxMin(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for (int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx -= 1;
            } else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }
}
//O(n)


// Challenge 11: Find the Sum of Maximum Sum Subarray.
class FindMax {
    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int currMax = arr[0];
        int globalMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // if currMax is a negative number, start from arr[i]
            if (currMax < 0) {
                currMax = arr[i];
            } else {
                currMax += arr[i];
            }

            if (globalMax < currMax) {
                globalMax = currMax;
            }
        }
        return globalMax;
    }
}
// O(n)


// 53. Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int currSum  = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
//O(n)


// 152. Maximum Product Subarray
class Solution {
    public int maxProduct(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // We store the min here because later on min will be modified.
            // The numbers can switch into negative, so min = Math.min(nums[i], min) is wrong.
            int originalMin = min;

            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            // We are using the original min here because the new min already got modified.
            max = Math.max(nums[i], Math.max(max * nums[i], originalMin * nums[i]));

            if (max > res) {
                res = max;
            }
        }

        return res;
    }
}
// O(n)


// 121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {

        // 1. variable to hold the lowest and the highest value.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
// O(n)


// 217. Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {

        // corner case.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // 1. store the count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //2.
        for(int key : map.keySet()) {
            if(map.get(key) > 1)
                return true;
        }
        return false;
    }
}
// O(n)


// 153. Find Minimum in Rotated Sorted Array.
// must solve in O(log n)
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // Binary search with two pointers
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
// same as binary search O(logN)


// 1480 Running sum of 1d Array.
class Solution {
    public int[] runningSum(int[] nums) {

        // nums[1] since nums[0] stays the same.
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        return nums;
    }
}
// O(n)


// 33. Search in Rotated Sorted Array
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // if the target is in the left half, move the right pointer to the left.
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // Then move the left pointer to the right.
                    left = mid + 1;
                }
            } else {
                // if the target is in the right half, move the left pointer to the right.
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // Then move the right pointer to the left
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
// O(logN)


// 118. Pascal's Triangle
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Creates a List within a list.
        List<List<Integer>> res = new ArrayList<>();

        // corner case
        if (numRows == 0) {
            return res;
        }

        // 1. add the first row first
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        // 2. start adding by finding the previous row
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = res.get(i - 1);
            List<Integer> curRow = new ArrayList<>(); // curRow needs to be put inside the for loop, so it gets empty every iteration for for loop. If it is placed outside the for loop, then the elements will not get removed if we move to the next level/row.

            // 2-1. add 1 in the current row first because every first element in every row is 1.
            curRow.add(1);

            // 2-2 start adding the middle part
            // j starts with index 1 because index 0 is 1. We added already.
            // j ends with i because ith row has i elements.
            for (int j = 1; j < i; j++) {
                curRow.add(previousRow.get(j) + previousRow.get(j-1));
            }

            //2-3 add 1 to the last element.
            curRow.add(1);
            res.add(curRow);
        }
        return res;
    }

}
// O(N^2)


// 189. Rotate Array
class Solution {
    public void rotate(int[] nums, int k) {
        // if k > nums.length
        // we do not neeed to do k times rotation, we do (k % nums.length) times instead.
        // for example if k = 8. because of k % nums.length, we only do 1 time.
        k %= nums.length;

        // [1, 2, 3, 4, 5, 6, 7] k = 3

        // [7, 6, 5, 4, 3, 2, 1]
        reverse(nums, 0, nums.length-1);
        // '[5, 6, 7]', [4, 3, 2, 1]
        reverse(nums, 0, k-1);
        // [5, 6, 7] '[1, 2, 3, 4]'
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
//O(n)


// 1304. Find N Unique Integers Sum up to Zero
class Solution {
    public int[] sumZero(int n) {

        int[] result = new int[n];
        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            result[i] = i+1;
            total += result[i];
        }
        result[n-1] = -1 * total;

        return result;
    }
}
// O(n)