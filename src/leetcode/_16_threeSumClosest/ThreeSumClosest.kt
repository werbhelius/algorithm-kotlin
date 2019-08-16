package leetcode._16_threeSumClosest

import java.util.*

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 */
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        Arrays.sort(nums)

        var ans = nums[0] + nums[2] + nums[nums.size - 1]
        for (i in 0..nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val res = nums[i] + nums[left] + nums[right]
                if (res == target) return res
                if (Math.abs(res - target) < Math.abs(ans - target)) ans = res
                if (res > target) {
                    right--
                }
                if (res < target) {
                    left++
                }
            }
        }

        return ans

    }
}

fun main() {
    Solution().threeSumClosest(intArrayOf(1, 1, -1), 0)
}