package sort

fun selectSort(nums: IntArray): IntArray {

    if (nums.size <= 1) return nums

    var max = 0

    for (i in 0 until nums.size) {
        max = i

        for (j in i + 1 until nums.size) {
            if (nums[max] < nums[j]) {
                max = j
            }
        }

        if (i != max) {
            swap(nums, max, i)
        }

    }

    return nums

}


fun main() {
    println(selectSort(intArrayOf(6, 4, 5, 3, 7, 8, 1)))
}