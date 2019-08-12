package leetcode._5_longestPalindrome

class Solution {

    /***
     * 暴力解法
     * 找出所有字符的回文字符串，然后比较得出最长
     * 时间复杂度 O(n^3)
     * 空间复杂度 O(1)
     */
    fun longestPalindrome(s: String): String {

        if (s.length <= 1) {
            return s
        }

        var ans = ""
        var max = 0

        for (i in 0 until s.length) {
            for (j in i + 1..s.length) {
                val sub = s.substring(i, j)
                if (isPalindromic(sub) && sub.length > max) {
                    ans = sub
                    max = sub.length
                }
            }
        }

        return ans
    }

    private fun isPalindromic(s: String): Boolean {

        for (i in 0 until s.length / 2) {
            if (s[i] != s[s.length - 1 - i]) {
                return false
            }
        }

        return true

    }

    /**
     * 动态规划
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    fun longestPalindrome2(s: String): String {

        if (s.length <= 1) {
            return s
        }

        val len = s.length
        val reverseS = StringBuffer(s).reverse().toString()
        var maxLen = 0
        var maxEnd = 0
        val array = IntArray(len)

        for (i in 0 until len) {
            for (j in len - 1 downTo 0) {
                if (s[i] == reverseS[j]) {
                    if (i == 0 || j == 0) {
                        array[j] = 1
                    } else {
                        array[j] = array[j - 1] + 1
                    }
                } else {
                    array[j] = 0
                }

                if (array[j] > maxLen) {
                    val beforeArr = len - 1 - j
                    if (beforeArr + array[j] - 1 == i) {
                        maxLen = array[j]
                        maxEnd = i
                    }
                }
            }
        }

        return s.substring(maxEnd - maxLen + 1, maxEnd + 1)
    }

    /**
     * 暴力算法 + 动态规划
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    fun longestPalindrome3(s: String): String {
        val n = s.length
        var res = ""
        val P = BooleanArray(n)
        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo i) {
                P[j] = s[i] == s[j] && (j - i < 3 || P[j - 1])
                if (P[j] && j - i + 1 > res.length) {
                    res = s.substring(i, j + 1)
                }
            }
        }
        return res
    }

}

fun main() {
    Solution().longestPalindrome2("babad")
}