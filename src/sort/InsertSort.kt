package sort

fun insertSort(nums: IntArray): IntArray {
    if (nums.size <= 1) {
        return nums
    }

    for (i in 1 until nums.size) {
        val target = nums[i]
        var j = i

        while (j > 0 && target > nums[j - 1]) {
            nums[j] = nums[j - 1]
            j--
        }

        nums[j] = target
    }

    return nums
}

fun main() {
    println(insertSort(intArrayOf(6, 4, 5, 3, 7, 8, 1)))
}