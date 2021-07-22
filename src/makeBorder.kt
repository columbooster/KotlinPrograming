fun main() {
    val border = "'-._,-'"
    val timesToRepeat = 4
    printBorder(border, timesToRepeat)
    println("  Happy Birthday, Jhansi!")
    printBorder(border, timesToRepeat)
}
    fun printBorder(border: String, timeToRepeat: Int) {
        repeat(timeToRepeat) {
            print(border)
        }
        println()
    }
