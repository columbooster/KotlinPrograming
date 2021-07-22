fun main(){
    val age = 5*365
    val name = "Rover"
    println("Happy Birthday, ${name}!")
    // Let's print a cake!
    println("   ,,,,,   ")
    println("   |||||   ")
    println(" =========")
    println("@@@@@@@@@@@")
    println("{~@~@~@~@~}")
    println("@@@@@@@@@@@")

    // This print is an empty line.
    println("")

    println("You are already ${age} days old, ${name}!")
    println("${age} days old is the very best age to celebrate!")
}

// val은 Kotlin에서 사용하는 특수 단어로, 키워드라고 하며 뒤에 오는 것이 변수 이름임을 나타냅니다.
//age는 변수 이름입니다.
//=는 왼쪽의 age 값을 오른쪽의 값과 동일하게 만듭니다. 수학에서 단일 등호는 양쪽의 값이 동일함을 나타내기 위해 사용됩니다. 수학과 달리 Kotlin에서는 단일 등호가 왼쪽의 이름이 지정된 변수에 오른쪽의 값을 할당하는 데 사용
// : val 키워드를 사용하여 선언된 변수는 한 번만 설정할 수 있습니다. 프로그램 후반부에 값을 변경할 수 없습니다.
//var 키워드로 변경 가능한 변수를 선언할 수 있습니다.