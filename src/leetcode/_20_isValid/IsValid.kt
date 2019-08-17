package leetcode._20_isValid

import java.util.*

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (c in s) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c)
            } else {

                val top = if (stack.empty()) '#' else stack.pop()

                if (c == ']' && top != '[') {
                    return false
                }

                if (c == ')' && top != '(') {
                    return false
                }

                if (c == '}' && top != '{') {
                    return false
                }
            }
        }

        return stack.isEmpty()

    }
}