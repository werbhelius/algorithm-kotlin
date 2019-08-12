package leetcode._9_isPalindrome

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
class Solution {
    fun isPalindrome(x: Int): Boolean {

        if (x < 0 || (x % 10 == 0 && x != 0)) return false

        var num = x
        var ans = 0

        while (num > ans) {
            ans = ans * 10 + num % 10
            num /= 10
        }

        return ans == num || num == ans /10
    }
}

fun main() {
    Solution().isPalindrome(121)
}