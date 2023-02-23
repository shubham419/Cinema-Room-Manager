fun main() {
    val size = readln().toInt()
    val list = mutableListOf<Int>()
    for (i in 0..size - 1) {
        list.add(readln().toInt())
    }
    val noOfRotation = readln().toInt() % size
    val resultlist = mutableListOf<Int>()
    val separator = size - noOfRotation // 4
    for (i in separator..size - 1) {
        resultlist.add(list[i])
    }
    for (i in 0..separator - 1) {
        resultlist.add(list[i])
    }
    for (i in resultlist) {
        print("$i ")
    }
}
