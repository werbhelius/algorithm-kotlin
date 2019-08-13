package leetcode._6_convert

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
class Solution {
    fun convert(s: String, numRows: Int): String {

        if (numRows <= 1) return s

        val list = arrayListOf<StringBuilder>()

        for (i in 0 until Math.min(numRows, s.length))
            list.add(StringBuilder())


        var goingDown = false
        var curRow = 0

        for (i in 0 until s.length) {
            list[curRow].append(s[i])

            if (curRow == 0 || curRow == numRows -1) {
                goingDown = !goingDown
            }

            curRow += if (goingDown) 1 else -1

        }

        val string = StringBuilder()
        for (i in list) {
            string.append(i)
        }

        return string.toString()

    }
}

fun main() {
    Solution().convert("LEETCODEISHIRING", 4)
}