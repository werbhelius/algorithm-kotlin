package leetcode._14_longestCommonPrefix

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {

        if (strs.isEmpty()) return ""

        var prefix = strs[0]

        for (i in 1 until strs.size) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length - 1)
                if (prefix.isEmpty()) return ""
            }

        }

        return prefix

    }
}