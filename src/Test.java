/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.


Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1*/
public class Test {
  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12,1,0,0,0,0,3,4,5,12,4};
    moveZeroes(nums);
  }

  public static void moveZeroes(int[] nums) {

    int start = 0;
    for (int i = 1; i < nums.length; i++) {

      if (nums[start] == 0 && nums[i] != 0) {
        swapZeroToEnd(nums, start, i);
        start++;
      }
    }

    for (int i : nums) {
      System.out.print(i + " ");
    }
  }

  private static void swapZeroToEnd(int[] nums, int start, int i) {
    int temp = nums[start];
    nums[start] = nums[i];
    nums[i] = temp;
  }
}
