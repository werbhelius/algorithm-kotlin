package leetcode._26_removeDuplicates


/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */

class Solution {
    fun removeDuplicates(nums: IntArray): Int {

        if (nums.isEmpty()) {
            return 0
        }

        var index = 0

        for (i in 0 until nums.size) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i]
            }
        }

        return ++index

    }
}

fun main() {
    Solution().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))
}