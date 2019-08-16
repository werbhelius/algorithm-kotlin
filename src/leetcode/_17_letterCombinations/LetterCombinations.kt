package leetcode._17_letterCombinations

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */

class Solution {

    private val phone = object : HashMap<String, String>() {
        init {
            put("2", "abc")
            put("3", "def")
            put("4", "ghi")
            put("5", "jkl")
            put("6", "mno")
            put("7", "pqrs")
            put("8", "tuv")
            put("9", "wxyz")
        }
    }


    fun letterCombinations(digits: String): List<String> {
        val list = arrayListOf<String>()
        if (digits.isNotEmpty()) {
            backtrack(list, "", digits)
        }
        return list
    }

    private fun backtrack(list: ArrayList<String>, str: String, digits: String) {

        if (digits.isEmpty()) {
            list.add(str)
            return
        }

        val p = digits.substring(0, 1)
        val letter = phone[p] ?: ""

        for (c in letter) {
            backtrack(list, str + c, digits.substring(1))
        }

    }
}