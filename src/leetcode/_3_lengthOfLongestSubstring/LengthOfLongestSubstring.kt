package leetcode._3_lengthOfLongestSubstring

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
class Solution {

    fun lengthOfLongestSubstring(s: String): Int {

        if (s.isEmpty()) {
            return 0
        }

        var length = 1
        val set = linkedSetOf<Char>()

        for (index in 0 until s.length) {
            set.clear()
            set.add(s[index])
            for (index2 in index + 1 until s.length) {
                val char = s[index2]
                if (!set.add(char)) {
                    break
                }

                if (set.size > length) {
                    length = set.size
                }
            }

        }

        return length

    }

    fun lengthOfLongestSubstring2(s: String): Int {

        if (s.isEmpty()) {
            return 0
        }

        val n = s.length
        val set = linkedSetOf<Char>()
        var length = 0
        var i = 0
        var j = 0

        while (i < n && j < n) {
            if (!set.contains(s[j])) {
                set.add(s[j++])
                length = Math.max(length, j - i)
            } else {
                set.remove(s[i++])
            }
        }

        return length

    }

    fun lengthOfLongestSubstring3(s: String): Int {

        if (s.isEmpty()) {
            return 0
        }

        val n = s.length
        var length = 0
        var left = 0
        val map = hashMapOf<Char, Int>()

        for (index in 0 until n) {
            if (map.containsKey(s[index])) {
                left = Math.max(left, map[s[index]]!! + 1)
            }
            map[s[index]] = index
            length = Math.max(length, index - left + 1)

        }

        return length

    }

}

fun main() {
    Solution().lengthOfLongestSubstring("abcabcbb")
}