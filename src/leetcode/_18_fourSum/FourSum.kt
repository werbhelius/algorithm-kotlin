package leetcode._18_fourSum

import java.util.*

/**
 * https://leetcode-cn.com/problems/4sum/
 */
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(nums)

        val list = arrayListOf<List<Int>>()
        val n = nums.size

        for (i in 0 until  nums.size - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue

            for (j in i + 1 until nums.size - 2) {
                if (j - i > 1 && nums[j] == nums[j - 1]) continue
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break
                if (nums[i] + +nums[j] + nums[n - 1] + nums[n - 2] < target) continue

                var left = j + 1
                var right = n - 1

                while (left < right) {

                    val sum = nums[i] + nums[j] + nums[left] + nums[right]

                    if (sum == target) {
                        list.add(arrayListOf(nums[i], nums[j], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left ++
                        while (left < right && nums[right] == nums[right - 1]) right--
                        left ++
                        right --
                    } else if (sum < target) {
                        left ++
                    } else {
                        right --
                    }

                }
            }

        }

        return list

    }
}

fun main() {
    Solution().fourSum(intArrayOf(1,0,-1,0,-2,2), 0)
}