package leetcode

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        var num: Int
        for (i in 0 until nums.size) {
            num = target - nums[i]
            map[num]?.let {
                return intArrayOf(it, i)
            }
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum solution");
    }
}