package leetcode._22_generateParenthesis

class Solution {

    private val list = arrayListOf<String>()

    fun generateParenthesis(n: Int): List<String> {

        if (n == 0) {
            return list
        }

        generate("", n, list, 0, 0)

        return list
    }

    private fun generate(cur: String, max: Int, list: ArrayList<String>, open: Int, close: Int) {

        println(cur)

        if (cur.length == 2 * max) {
            list.add(cur)
            return
        }

        if (open < max) {
            generate("$cur(", max, list, open + 1, close)
        }

        if (close < open) {
            generate("$cur)", max, list, open, close + 1)
        }

    }
}

fun main() {
    Solution().generateParenthesis(3)
}