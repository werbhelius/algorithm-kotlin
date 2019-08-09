package leetcode._5_longestPalindrome

class Solution {

    /***
     * 暴力解法
     */
    fun longestPalindrome(s: String): String {

        if (s.length <= 1) {
            return s
        }

        var ans = ""
        var max = 0

        for (i in 0 until s.length) {
            for (j in i + 1 .. s.length) {
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
}