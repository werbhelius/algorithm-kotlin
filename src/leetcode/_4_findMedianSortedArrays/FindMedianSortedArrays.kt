package leetcode._4_findMedianSortedArrays

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
class Solution {

    /***
     * 暴力解法 合并数组 排序 求中间值
     * 时间复杂度 O(m+n)
     * 空间复杂度 o(m+n)
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        val len = nums1.size + nums2.size
        val array = IntArray(len)

        var count = 0
        var i = 0
        var j = 0

        while (count != len) {
            if (i == nums1.size) {
                while (j != nums2.size) {
                    array[count++] = nums2[j++]
                }
                break
            }

            if (j == nums2.size) {
                while (i != nums1.size) {
                    array[count++] = nums1[j++]
                }
                break
            }

            if (nums1[i] > nums2[j]) {
                array[count++] = nums2[j++]
            } else {
                array[count++] = nums1[i++]
            }
        }

        return if (count % 2 == 0) {
            (array[len / 2 - 1] + array[len / 2]) / 2.0
        } else {
            array[len / 2].toDouble()
        }

    }

    /***
     * 比较查找中间值，并没有真正的合并、排序数组
     * 时间复杂度 O(m+n)
     * 空间复杂度 o(1)
     */
    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {

        val len = nums1.size + nums2.size
        var i = 0
        var j = 0
        var left = 0
        var right = 0
        for (index in 0..len / 2) {
            left = right
            right = if (i < nums1.size && (j >= nums2.size || nums1[i] < nums2[j])) {
                nums1[i++]
            } else {
                nums2[j++]
            }

        }

        return if (len % 2 == 0) {
            (left + right) / 2.0
        } else {
            right.toDouble()
        }

    }

    /**
     * 把寻找中位数当作寻找第 K 小的数，每次循环排除掉 k/2 个数
     * 时间复杂度 O(log(m+n))
     * 空间复杂度 o(1)
     */
    fun findMedianSortedArrays3(nums1: IntArray, nums2: IntArray): Double {
        val len = nums1.size + nums2.size
        val left = (len + 1) / 2
        val right = (len + 2) / 2

        val a = findKth(nums1, 0, nums1.size - 1, nums2, 0, nums2.size - 1, left)
        var b = a
        if (len % 2 == 0) {
            b = findKth(nums1, 0, nums1.size - 1, nums2, 0, nums2.size - 1, right)
        }
        return (a + b) / 2.0
    }

    private fun findKth(nums1: IntArray, start1: Int, end1: Int, nums2: IntArray, start2: Int, end2: Int, k: Int): Int {

        val len1 = end1 - start1 + 1
        val len2 = end2 - start2 + 1

        // 空判断
        if (len1 > len2) {
            return findKth(nums2, start2, end2, nums1, start1, end1, k)
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1]
        }

        if (k == 1) return Math.min(nums1[start1], nums2[start2])

        // 排除
        val i = start1 + Math.min(k / 2, len1) - 1
        val j = start2 + Math.min(k / 2, len2) - 1

        return if (nums1[i] < nums2[j]) {
            findKth(nums1, i + 1, end1, nums2, start2, end2, k - (i + 1 - start1))
        } else {
            findKth(nums1, start1, end1, nums2, j + 1, end2, k - (j + 1 - start2))
        }
    }

}


fun main() {
    Solution().findMedianSortedArrays3(intArrayOf(1, 2), intArrayOf(3))
}