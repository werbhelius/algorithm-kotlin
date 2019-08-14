package leetcode._11_maxArea

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
class Solution {

    /**
     * 暴力解法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    fun maxArea(height: IntArray): Int {

        if (height.size <= 1) return 0

        var ans = 0

        for (i in 0 until height.size) {

            val h = height[i]

            for (j in i + 1 until height.size) {
                val num = Math.min(h, height[j]) * (j - i)
                if (num > ans) {
                    ans = num
                }

            }

        }

        return ans

    }

    /**
     * 暴力解法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    fun maxArea2(height: IntArray): Int {
        if (height.size <= 1) return 0

        var ans = 0
        var i = 0
        var j = height.size - 1

        while (i != j) {
            val ih = height[i]
            val jh = height[j]
            val num = Math.min(ih, jh) * (j - i)
            if (num > ans) {
                ans = num
            }

            if (ih > jh) {
                j--
            } else {
                i++
            }

        }

        return ans
    }
}

fun main() {
    Solution().maxArea2(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
}