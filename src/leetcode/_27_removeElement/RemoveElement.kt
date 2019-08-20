package leetcode._27_removeElement

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {

        var index = 0

        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                nums[index] = nums[i]
                index ++
            }
        }

        return index

    }
}

fun main() {
    Solution().removeElement(intArrayOf(4,5), 4)
}