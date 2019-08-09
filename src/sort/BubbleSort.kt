package sort

fun swap(nums: IntArray, i: Int, j: Int): IntArray {
    val temp = nums[j]
    nums[j] = nums[i]
    nums[i] = temp
    return nums
}

fun bubbleSort(nums: IntArray): IntArray {

    if (nums.size < -1) return nums

    for (i in 0 until nums.size) {
        for (j in 0 until nums.size - 1) {
            if (nums[j] > nums[j + 1]) {
                swap(nums, j, j + 1)
            }
        }
    }

    return nums

}

fun main() {
    println(bubbleSort(intArrayOf(6, 4, 5, 3, 7, 8, 1)))
}