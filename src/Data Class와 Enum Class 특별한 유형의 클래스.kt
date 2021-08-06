// kotlin 강좌 # 25 특별한 유형의 클래스

// 특별한 기능이나 형태를 가진 클래스들을 알아보자. 후하후하!! 가자자자자!!!!

// Data class 는 데이터를 다루는 데에 최적화된 class 로 '5가지 기능'을 내부적으로 자동으로 생성해준다.
// 1. 내용의 동일성을 판단하는 equals()의 내용을 자동으로 구현

// 2. 클래스의 내용에서 고유한 hashcode()의 자동구현 >> 객채의 내용에서 고유한 코드를 생성하는 고유한 해쉬코드를 반환해준다.

// 3. 포함된 속성을 보기쉽게 나타내는 toString()의 자동구현

// 4. 객체를 복사하여 똑같은 내용의 새 객체를 만드는 copy()이 자동구현 >> 여기서 copy() 함수를 통해 새 객체를 생성할 때는
// 똑같은 내용의 객체를 생성할 수도 있지만 생성자와 똑같은 형태의 패러미터를 주어 일부 속성을 변경할 수도 있다.
// ex) val a = Data("A",7)
//     val b = a.copy()     >>> 아무 패러미터가 없으면 똑같은 내용으로 생성함

//     val a = Data("A",7)
//     val b = a.copy("B")  >>> 패러미터가 있다면 해당 패러미터를 교체하여 생성함

// 5. 속성을 순서대로 반환하는 componentX()의 자동구현
// ex)              Data    (     "A"      ,     7       )
//                            component1()   component2()    >>> 컴퍼넌트1, 컴퍼넌트2 같은 함수로 속성의 내용을 반환한다.

// 사실 이 함수는 사용자가 직접 호출하기 위한 함수가 아닌 배열이나 리스트 등의 데이터 클래스의 객체가 담겨있을 때
// 이 내용을 자동으로 꺼내쓸 수 있는 기능 지원하기 위한 함수들이다.


// 실습 ㄱㄱ

// 여기서는 일반 class 와 Data class 의 기능을 1:1로 비교해보자.

// General 이라는 클래스를 만들어 이름과 id 를 받아보자.

// 그리고 Data 라는 data class 를 만들어 똑같이 이름과 id 를 받아보자.

// main() 에서는 General 로 이름은 보영, id는 212인 a객체를 만들어보자.

// 먼저 equals() 함수를 테스트 하기 위해 a와 똑같이 만든 객체 와 내용이 동일한지 비교하여 출력해보자.

// 그 다음 hashcCode() 함수 값을 출력해보자.

// 다시 toString()의 결과값을 보기 위해 a를 그대로 출력해보자.

// 이제 Data 클래스로 이름은 루다, id는 306인 b객체를 만들어보자.
// a객체와 동일하게 b와 똑같이 만든 객체와의 비교값을 출력하고
// hashCode()를 출력해보자
// 역시 toString()의 결과값을 확인하기 위해 b를 그대로 출력해보자.

// 다시 b를 copy()한 결과를 출력하고
// b에서 copy()를 이용하여 이름을 아린으로 바꿔 생성한 결과도 출력하자.

// 마지막으로 named argument를 통해 id만 618로 바꾼 결과도 출력하자.

// 실행해보면 일반클래스로 만든 a는 equals()나 hashCode(), toString()함수의 결과가 제대로 구현되지 않는 반면
// data 클래스로 만든 b는 세 함수 모두 의미있는 기능으로 자동 구현 되어있음을 알 수 있으며
// copy() 함수를 통해 원본을 복사한 새 객체 역시 쉽게 만들 수 있음을 알 수 있다.

/*
fun main() {

    val a = General("보영", 212)

    println(a == General("보영", 212))
    println(a.hashCode())
    println(a)

    val b = Data("루다", 306)

    println(b == Data("루다",306))
    println(b.hashCode())
    println(b)

    println(b.copy())
    println(b.copy("아린"))
    println(b.copy(id = 618))

}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)

*/


// 이번엔 componentX() 계열 함수의 동작을 확인해 보자.

// main의 내용을 지우고
// Data class 의 객체들이 담긴 list 를 작성해보자.

// 이 리스트에 담긴 Data 객체의 내용을 for 문에서 모두 순회 하려면
// 두개의 속성을 받을 수 있는 이름을 지정하여 in 앞에 써주면 된다.
// 이렇게 하면 내부적으로는 component1()>>a , component2()>>b 라는 함수를 사용하여 순서대로 값을 불러오게 된다.
// 이제 println에서 내용을 모두 출력해보자.

// 실행해보면 리스트에서 각각의 Data 객체를 참조하여 속성을 모두 출력하였음을 알 수 있다.

/*
fun main() {

    val list = listOf(Data("보영",212), Data("루다",306), Data("아린",618))

    for((a,b) in list) {
        println("${a}, ${b}")
    }


}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)

*/
// 다음은 Enum class

// enumerated type 즉, 열거형의 준말로 enum class 내에 상태를 구분하기 위한 객체들을 이름을 붙여 여러개 생성해두고
// enum class Color { RED, BLUE, GREEN }          *특이한 형태지만 모두 enum class인 Color의 객체를 생성하기 위한 선언이다.
// Color.RED 그 중 하나의 상태를 선택하여 나타내기 위한 클래스다.

// * enum 클래스 안의 객체들은 관행적으로 상수를 나타낼때 사용하는 '대문자로 기술'합니다.

// 또한 enum 의 객체들은 고유한 속성을 가질 수 있는데 enum의 생성자를 만들어 속성을 받도록 하면 객체를 선언할 때 속성도 설정할 수 있다.
// enum class Color (val number: Int) { RED(1), BLUE(2), GREEN(3)

// 또한 일반 클래스처럼 함수도 추가할 수 있다. 이때는 객체의 선언이 끝나는 위치에 세미콜론(;)을 추가한 후 함수를 기술하면 된다.
// enum class Color (val number: Int) { RED(1), BLUE(2), GREEN(3);
//    fun isRed() = this == Color.RED

// 실습 ㄱㄱㄱㄱㄱ

// State 라는 이름으로 enum class 를 만들어 보자. 그리고 message 속성을 String으로 받도록하자.
// 이제 객체들을 열거해보자. SING이라는 객체를 만들고 "노래를 부릅니다"라는 메시지를 넣어보자.
// EAT이라는 객체를 만들고 "밥을 먹습니다" , SLEEP 이라는 객체를 만들고 "잠을 잡니다"라는 메시지를 넣어보자.

// 끝에 세미콜론을 붙이고 다시 함수를 하나 추가하여 잠을 자는지 여부를 boolean 값으로 반환하는 함수인 isSleeping()을 만들어보자.
// 이 때 , 비교할 대상은 State 객체 자기 자신 이므로 this 로 해주어야한다.

// main() 에서 State 라는 이름의 변수에 초기값으로 State.SING을 넣어보자. * enum은 선언시에 만든 객체를 이름으로 참조하여 그대로 사용하게 된다.
// state를 그대로 출력해보자.

// 다음은 state 의 값을 State.SLEEP으로 바꾸자.
// 이번엔 state에서 isSleeping() 함수를 수행해보자.

// 다시 state 의 값을 State.EAT로 바꾸자.
// state의 메시지를 한 번 출력해보자.

// 실행해보면 enum의 변수를 그대로 출력할 때는 toString()을 통해 상태객체의 이름이 출력되고
// 같은 객체끼리 비교 했기 때문에 true가 반환 되었으며
// EAT 객체의 message 속성에 담긴 밥을 먹습니다가 출력되었다.

fun main() {

    var state = State.SING

    println(state)

    state = State.SLEEP
    println(state.isSleeping())

    state = State.EAT
    println(state.message)

}

enum class State(val message: String) {
    SING("노래를 부릅니다"),
    EAT("밥을 먹습니다"),
    SLEEP("잠을 잡니다");

    fun isSleeping() = this == State.SLEEP
}



// data class 와 enum class 는 일반 클래스에서 제공되지 않는 특정한 용도의 기능들을 제공하고 있으므로 여러가지 상황에서 유용하게 사용해보자!!


