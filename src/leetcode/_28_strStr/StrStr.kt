package leetcode._28_strStr

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
class Solution {
    fun strStr(haystack: String, needle: String): Int {

        if(needle.isEmpty()) return 0
        if(haystack.length < needle.length) return -1

        var i = 0

        while (i <= haystack.length - needle.length) {
            if (haystack.substring(i, i + needle.length) == needle) {
                return i
            } else {
                i++
            }
        }

        return -1
    }
}