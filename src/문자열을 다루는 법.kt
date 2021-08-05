// kotlin 강좌 # 21 문자열을 다루는 법

// 코틀린에서 문자열을 다루는 여러가지 방법을 알아보자

// 이미 우리는 코틀린에서는 'String'이라는 클래스로 문자열을 다루며 쌍따옴표 사이에 문자열을 넣어 리터럴을 만들면 세 String객체가 생성되는것을 보았다.
// val text = "문자열"

// 코틀린에서는 이 string 클래스와 관련한 여러 속성과 함수가 있다.
// 그 중 자주 쓰이는 것들을 실습으로 한 번 알아보자.

// 먼저 테스트에 쓰일 문자열로 "Test.Kotlin.String"을 test1 변수에 넣어보자
// 이번 실습에서는 대소문자가 중요하니 꼭 지켜라!!

// 첫번쨰로 문자열의 길이를 알아보자.
// 바로 length라는 속성에 Int값으로 들어있다. println(test1.length)

// 다음은 toLowerCase() 와 toUpperCase()함수인데 각각 영문 소문자와 대문자로 문자열 전체를 변환하여 반환해주는 역할을 한다.

// 특정 문자열을 기준으로 문자열을 여러개로 나눠 배열에 담을 수도있다.
// 이때는 split() 이라는 함수에 '나누는 기준이 되는 문자열'을 넣어주면 된다. test1.split(".")  * delimiter 라고 부른다.
// 여기서는 '점을 기준으로 나눈 문자열' 배열을 test2 변수에 담고 출력해보자
// 참고로 코틀린에서는 자바와 달리 Split에 정규식이 아닌 '일반 문자열'을 넣어도 동작한다.


// 다음은 이렇게 문자열이 들어가있는 배열을 다시 하나의 문자열로 합치는 joinToString()함수를 써보자.
// 아무것도 넣지 않으면 그냥 합쳐지고 문자열을 넣으면 그 문자열을 사이에 넣어준다.


// 이번에는 test1에서 문자열 일부분만 사용해 보자.
// 바로 subString을 쓰면 된다. for문에서 사용했었던 IntRange 형식을 사용하여 시작과 끝을 정해주면 그 부분만 출력된다.

/*
fun main() {

    val test1 = "Test.Kotlin.String"

    println(test1.length)

    println(test1.toLowerCase())   // 소문자로 변환
    println(test1.toUpperCase())   // 대문자로 변환

    val test2 = test1.split(".")
    println(test2)

    println(test2.joinToString())    // 아무것도 넣지 않으면 합쳐진다.
    println(test2.joinToString("-"))   // 문자열을 넣으면 그 문자열을 사이에 넣어준다.

    println(test1.substring(5..10))

}
*/

// 다음은 문자열이 비어있는지 여부를 판단하여 boolean 값으로 반환받는 함수들을 알아보자.

// 먼저 nullable 로 String 변수 nullString 을 만들어 null 을 할당해보자.
// 다음은 아무것도 넣지 않은 문자열을 emptyString 으로 만들어보자.
// 그리고 빈칸을 하나 넣은 문자열을 blankString 으로 만들어보자.
// 마지막으로 A 를 하나 넣은 문자열을 normalString 으로 만들어보자

// 이 스트링 변수들이 '비어있는지를 체크' 하는 법은 여러가지가 있다.
// 그 중 제일 편하게 사용할 수 있는 '두 가지 함수'를 사용해보자.

// 먼저 isNullOrEmpty()인데 이름 그대로 'null 이거나 empty'이면 true 를 반환한다.
// 네 개의 변수에 각각 적용하여 출력해보자.

// 보기쉽게 한줄을 띄어보자.

// 다음은 isNullOrBlank() 인데 역시 이름대로 'null 이거나 blank'이면 true 를 반환한다
// 똑같이 네 개의 변수에 각각 적용하여 출력해보자.

// 두 함수의 차이는 아무것도 없는 문자열 그러니까 'empty 상태만 비어있는 것'으로 보느냐 *isNullOrEmpty() >> 난 진짜 비어있는것만 인정해
// 아니면 문자열은 있지만 '공백문자로만 이루어진' 'blank 상태도 비어있는것'으로 보느냐의 차이다. *isNullOrBlank() >> 비어있어도 되지만 공백문자만 있어도 돼

// 공백문자에는 space 뿐만아니라 tab, line Feed, Carrige Return 등 눈에 직접적으로 보이지 않는 문자들을 포함한다.

/*

fun main() {

    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"

    println(nullString.isNullOrEmpty())
    println(emptyString.isNullOrEmpty())
    println(blankString.isNullOrEmpty())
    println(normalString.isNullOrEmpty())

    println()

    println(nullString.isNullOrBlank())
    println(emptyString.isNullOrBlank())
    println(blankString.isNullOrBlank())
    println(normalString.isNullOrBlank())




}

*/


// 이번엔 좀 특수한 함수들을 한 번 알아보자.

// "kotlin.kt"라는 문자열을 test3에 넣고 "java.java"라는 문자열을 test4에 넣어준다.

// 먼저 둘 중 java로 시작하는 문자열을 찾기 위해 'startsWith() ' 함수를 써보자. * startsWith() >>> 지정한 문자열로 시작하면 true를 반환함

// 다음은 둘 중 .kt 로 끝나는 문자열을 찾기 위해 'endsWith()' 함수를 써보자 * endsWith() >>> 지정한 문자열로 끝나면 true를 반환함

// 그리고 lin 이 들어간 문자열을 찾기 위해 'contains()' 함수를 써보자 * contains() >>> 지정한 문자열이 포함되면 true를 반환함

// 실행해보면 일치하는 경우만 true를 반환하는것을 볼 수 있다.




fun main() {

    var test3 = "kotlin.kt"
    var test4 = "java.java"

    println(test3.startsWith("java"))
    println(test4.startsWith("java"))

    println(test3.endsWith(".kt"))
    println(test4.endsWith(".kt"))

    println(test3.contains("lin"))
    println(test4.contains("lin"))

}



// 문자열을 다루는 법은 입력값을 받거나 문자열로 된 자료를 처리할 때 매우 자주 사용되는 기능이니 잘 익혀두자!!!


