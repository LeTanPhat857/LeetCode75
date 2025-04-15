public class MediumProductOfArrayExceptSelf {
    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

    Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
    
    Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
     */

    /**
     * stupid solution with O(n^2) time complexity
     */
    public int[] productExceptSelf_stupid(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = 1;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }

    /**
     * O(n) time complexity and O(1) space complexity
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        // result[i] = product of all elements to the left of i
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // product variable is product of all elements to the right of i
        // result[i] = product of all elements to the left of i * product of all elements to the right of i
        int productFromRightToLeft = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            result[i] = result[i] * productFromRightToLeft;
            productFromRightToLeft *= nums[i];
        }

        return result;
    }


    public static void main(String[] args) {
        MediumProductOfArrayExceptSelf mediumProductOfArrayExceptSelf = new MediumProductOfArrayExceptSelf();
        int[] result1 = mediumProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println(); // expected [24, 12, 8, 6]

        int[] result2 = mediumProductOfArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println(); // expected [0, 0, 9, 0, 0]
    }
}
