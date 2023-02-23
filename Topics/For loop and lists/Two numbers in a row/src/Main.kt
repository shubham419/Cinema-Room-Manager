fun main() {
    val size = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(size) {
        list.add(readln().toInt())
    }
    val pm = readln().split(" ").map { it.toInt() }.toMutableList()
    val p = pm[0]
    val m = pm[1]
    val lastIndex = list.lastIndex
    var check = true

    for (i in list.indices) {
        if (p == list[i] && i == 0) {
            if (m == list[i + 1]) {
                print("NO")
                check = false
                break
            }
        }
        if (p == list[i] && i != lastIndex) {
            if (m == list[i - 1] || m == list[i + 1]) {
                print("NO")
                check = false
                break
            }
        }
        if (p == list[i] && i == lastIndex) {
            if (m == list[i - 1]) {
                print("NO")
                check = false
                break
            }
        }
    }
    if (check) {
        print("YES")
    }
}
