package leetcode._15_threeSum

import java.util.*


/**
 * https://leetcode-cn.com/problems/3sum/
 */
class Solution {

    /**
     * 排序后，双指针同时向0移动，牛逼啊这个
     */
    fun threeSum(nums: IntArray): List<List<Int>> {

        Arrays.sort(nums)

        val res = ArrayList<List<Int>>()

        for (k in 0 until nums.size - 2) {

            if (nums[k] > 0) break
            if (k > 0 && nums[k] == nums[k - 1]) continue
            var i = k + 1
            var j = nums.size - 1

            while (i < j) {

                val sum = nums[k] + nums[i] + nums[j]

                when {
                    sum < 0 -> while (i < j && nums[i] == nums[++i]) { }
                    sum > 0 -> while (i < j && nums[j] == nums[--j]) { }
                    else -> {
                        res.add(arrayListOf(nums[k], nums[i], nums[j]))
                        while (i < j && nums[i] == nums[++i]) { }
                        while (i < j && nums[j] == nums[--j]) { }
                    }
                }

            }

        }

        return res

    }
}

fun main() {
    Solution().threeSum(intArrayOf(0, 0, 0, 0))
}