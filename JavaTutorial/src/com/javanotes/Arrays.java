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
// time O(m + n). space O(1)


// 1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            } else {
                // nums[i] is at the index of 0.
                map.put(nums[i], i);
            }
        }
        // must return something or an error message since our return statement is inside the for loop.
        throw new IllegalArgumentException("No solutions.");
    }
}
// Time O(n). space O(n) ??

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

        // 2. on top of the calculated left array, we add right array to update the res array.
        // Then we update the res[i] from above with the product of right elements.
        int R = 1;
        for (int i = nums.length-1;  i >= 0; i--) {
            res[i] *= R;
            R *= nums[i];
        }
        return res;
    }
}
// time O(n). space O(n)


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


// 121. Best Time to Buy and Sell Stock (see 122)
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


//122. Best Time to Buy and Sell Stock II (see 121)
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i-1];
            }
        }
        return maxprofit;
    }
}
//O(n)


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
// time O(N^2). spaceO(n^2) ???


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

        // assigning += 1 to each index. Grabbing the total and putting the negative number
        // of the total at the end to make the sum 0.
        for (int i = 0; i < n - 1; i++) { // n - 1 since we only want to loop one before the last element.
            result[i] = i + 1;
            total += result[i];
        }
        result[n-1] = -1 * total;

        return result;
    }
}
// time O(n). space O(n)


// 724. Find Pivot Index
class Solution {
    public int pivotIndex(int[] nums) {
        // corner case: ask what will it return if array is empty?
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 1. calculate the total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 2. calculate left sum and right sum.
        // 2-1. see if left == right.
        int leftSum = 0; // placed outside of for loop so we save the reference.
        for (int i = 0; i < nums.length; i++) {
            // i = 0 has no leftSum
            if (i != 0) {
                leftSum += nums[i-1];
            }
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
        }
        return -1;

    }
}
// O(n)


// 628 Maximum Product of Three Numbers.
public class Solution {
    public int maximumProduct(int[] nums) {

        // corner case
        if (nums == null || nums.length == 0)
            return 0;
        // you need two lowest numbers just in case of two negatives resulting in a positive number.
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        // 1. find min1, min2, max1, max2, max3
        for (int num : nums) {
            // n is greater than max1, max2 and max3
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
                // n lies between max2 and max3
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
                // n lies between max2 and max3
            } else if (num > max3) {
                max3 = num;
            }
            // n is greater than min1 and min2
            if (num < min1) {
                min2 = min1;
                min1 = num;
                // n lies between min1 and min2
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(min1*min2*max1, max1*max2*max3);
    }
}
// O(n)


// 448. Find All Numbers Disappeared in an Array. (see 442)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // When the value is x, we mark the value at position x negative.
        // meaning value x exists
        // for the value to become newIndex, we only check the absolute value since it may be marked negative before.
        // example ([4, 3, 2, 7, 8, 2, 3, 1]):
        // At index[0] which is 4. We will subtract the absolute value of 4 by 1.
        // In this case the newIndex is 3 and the position is 4. The element at that position will be turned into negative. Because we want to indicate that the position (4) is in the array.

        for (int i = 0; i < nums.length; i++) {
            // treat the value as the new index.
            int newIndex = Math.abs(nums[i]) -1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // 2. if the value is positive, meaning the position of that value is missing in the array.
        // if the value is positive, then the position number indicates which number in the array is missing.
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
// time O(n). space O(1) constant


// 442. Find All Duplicates in an Array. (see 448)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // we treat value as the new index
            // if we see a '4', we want to put into the array at position 4 and make it to negativ so that we know that '4' existed
            int newIndex = Math.abs(nums[i]) -1;
            if (nums[newIndex] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[newIndex] *= -1;
            }
        }
        return res;
    }
}
//  time O(n). space O(1) constant


// 283. Move Zeroes.
class Solution {
    public void moveZeroes(int[] nums) {
        // We move the non-zero element to the front by swapping the non-zero element and zero

        int anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[anchor];
                nums[anchor] = nums[i];
                nums[i] = temp;
                // 2. move anchor to the next position to store the next element if we did the swap
                anchor++;
            }
        }
    }
}
// Time O(n). space O(1)


// 26. Remove Duplicates from Sorted Array.
class Solution {
    public int removeDuplicates(int[] nums) {

        // corner case
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // if the current number is not the same as the next number.
            if (nums[i] != nums[i + 1]) {
                // we save the next number
                nums[index] = nums[i + 1];
                // move the index so that it can save the next number
                index++;
            }
        }
        // it does not matter what the numbers are beyond the returned index of the array.
        // example output 5, nums = [0, 1, 2, 3, 4, 1, 1, 2, 2, 3, 4, 4, 4]
        return index;
        /*
        Why do we return the index instead of the array, but still getting the array as an answer?
        because we are modifying the input array. We will get the array as an answer even
        if we jus return the index.
        */
    }
}
// time O(n). space O(1)


// 832. Flipping an Image.
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        /*
        [solution 2 - one pass]
        1. If they are different, dont do anything, just keep traversing
        2. if they are the same, change 0 to 1, 1 to 0.
        */

        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image.length -1;
            while (start <= end) {
                if (image[i][start] == image[i][end]){
                    image[i][start] = image[i][start] == 0 ? 1 : 0;
                    image[i][end] = image[i][start];
                }
                start++;
                end--;
            }
        }
        return image;
    }
}
// time O(n^2). space O(1)


// 349. Intersection of Two Arrays I (see 350)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // turn nums1 array into set.
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }

        // creates a set called intersection. Add numbers if num1 set has num2 numbers.
        Set<Integer> intersection = new HashSet<>();
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                intersection.add(num2);
            }
        }

        // initializing a new array called result. appending each element from the intersection set.
        int[] res = new int[intersection.size()];
        // need to initialize i for iterating through res.
        int i = 0;
        // Integer is a wrapper class of int. It's a convenient way to use object methods for primitive values.
        // Cannot use for loop here because a Set is not like a List and the elements are not indexed.
        for (Integer num : intersection) {
            res[i] = num;
            i++;
        }
        return res;
    }
}
// time O(n). space O(n)

// 350. Intersection of Two Arrays II (see 349)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();

        // 1. add num1 into map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);

        }

        // 2. check if num2 is in the map, if the count > 0, we add to our res and -1 count.
        for (int num2 : nums2) {
            if (map.containsKey(num2)) {
                if (map.get(num2) > 0) {
                    result.add(num2);
                    map.put(num2, map.get(num2) - 1);
                }
            }
        }

        // 3. transform arrayList into int[]
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
// time O(n). space O(n)


// 532. K-diff pairs in an array.
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 1. sort the array
        Arrays.sort(nums);

        // 2. if we found a pair, we move left till diff number
        int left = 0;
        int right = 1;
        int count = 0;
        while (left < nums.length && right < nums.length) {
            if (nums[right] - nums[left] > k) {
                left++;
            } else if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] == k) {
                count++;
                left++;
                // if(nums[left] == nums[left - 1]) is wrong. if we use IF, then it will only execute once. We need to do while loop, it will execute till the condition fails.
                while (left <nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        return count;
    }
}
// time(nlogn). space(n)


// 169. Majority Element
class Solution {
    public int majorityElement(int[] nums) {
        // HASH TABLE SOLUTION

        // 1. store the counts
        /*
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        // 2. find the counts > nums.length/2
        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > (nums.length/2)) {
                res = key;
            }
        }
        return res;
        */
        // time O(N). space O(N)

        // BOYER-MOORE VOTING ALGORITHM
        Integer candidate = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
        // time O(N). space O(1)
    }
}


// SINGLY LINKED LIST SYNTAX NOTES
public class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    //head node of the linked list
    public Node headNode;
    public int size;

    //constructor
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {

        if (headNode == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    //Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
        //if the list is empty then call insertATHead()
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        //iterate to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //make newNode the next element of the last node
        last.nextNode = newNode;
        size++;
    }

    //inserts data after the given prev data node
    public void insertAfter(T data, T previous) {

        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        //Start from head node
        Node currentNode = this.headNode;
        //traverse the list until node having data equal to previous is found
        while (currentNode != null && currentNode.data != previous) {
            currentNode = currentNode.nextNode;
        }
        //if such a node was found
        //then point our newNode to currentNode's nextElement
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    //Searches a value in the given list.
    public boolean searchNode(T data) {
        //Start from first element
        Node currentNode = this.headNode;

        //Traverse the list till you reach end
        while (currentNode != null) {
            if (currentNode.data.equals(data))
                return true; //value found

            currentNode = currentNode.nextNode;
        }
        return false; //value not found
    }

    //Deletes data from the head of list
    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the nextNode of the headNode equal to new headNode
        headNode = headNode.nextNode;
        size--;
    }

    //Deletes data given from the linked list
    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node currentNode = this.headNode;
        Node prevNode = null; //previous node starts from null

        if(currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)){
                prevNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }
}


// DOUBLE LINKED LIST SYNTAX NOTES
public class DoublyLinkedList<T> {

    //Node inner class for DLL
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public int size;

    public DoublyLinkedList() {
        this.headNode = null;
    }

    //checks if the list is empty
    public boolean isEmpty() {
        if (headNode == null)
            return true; //is empty
        return false;    //is not empty
    }

    public void insertAtHead(T data) {
        //create node and put in the data
        Node newNode = new Node();
        newNode.data = data;
        // Make next of new node as head and previous as NULL
        newNode.nextNode = this.headNode;
        newNode.prevNode = null;
        //Change previous of head node to new node
        if (headNode != null)
            headNode.prevNode = newNode;
        this.headNode = newNode;
        size++;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : null <- ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }
    //deletes the first element
    public void deleteAtHead(){
        //if list is empty do nothing
        if(isEmpty())
            return;

        //if List is not empty then link head to the
        //nextElement of firstElement.
        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }
    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node currentNode = this.headNode;

        if (currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if(currentNode.nextNode != null)
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }
}


// 206. Reverse Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // Solution 1: Iterative
        ListNode cur = head;
        ListNode pre = null;
        // swapping
        while (cur != null) {
            //1. We set the nextNode first.
            ListNode nextNode = cur.next;

            //2. we link the current node to previous node.
            cur.next = pre;

            //3. because of reverse, the previous node is current node.
            pre = cur;

            //4. and the current node should be next node.
            cur = nextNode;
        }
        return pre;
    }
}

