fun main() {
    val age = 24
    val layers = 5
    printCakecandles(age)
    printCakeTop(age)
    printCakeBottom(age, layers)
}
fun printCakecandles(age: Int) {
    print(" ")
    repeat(age) {
        print(",")
    }
    println() // print an empty line

    print(" ")
    repeat(age) {
        print("|")
    }
    println()
}

fun printCakeTop(age: Int) {
    repeat(age + 2) {
        print("=")
    }
    println()
}

fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age+2) {
            print("@")
        }
        println()
    }
}