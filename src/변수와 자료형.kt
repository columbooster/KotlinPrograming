//코틀린 강좌 #2 - 변수와 자료형

// --> 한줄짜리 주석 슬래시 두번
/* 주석
여러
줄  --->> 슬래시 별표로 시작해서 별표 슬래시로 마무리
 */

// 코틀린은 구문이 끝나는 부분에서 세미콜론을 붙이지 않아도 된다.
// println("구문 끝에 세미콜론은 달지 않아도 된다는게 바로여기여기여기라고") ->규칙 지키면 언어차원에서 판단하도록 설정되어있다.

// 클래스 이름은 "파스칼 표기법" -> 모든 단어를 대문자로 시작  ex) ClassName
// 함수나 변수 이름은 "카멜 표기법" _> 첫 단어만 소문자로 시작 ex) functionName


// 변수의 선언 variable declaration
// 코틀린은 변수를 두가지 방법으로 선언한다.
// 1. var -> 일반적으로 통용되는 변수. 언제든지 읽기 쓰기가 가능함
// 2. val -> 선언시에만 초기화 가능. 중간에 값을 변경할 수 없음
// runtime 시 "변경되지 말아야 할 값"은 안전하게 val로 선언하는것이 좋다.
// 변수는 선언 위치에 따라 두가지 이름으로 불린다.
// 1. Property(속성) -> 클래스에 선언된 변수
// 2. Local Variable(로컬변수) -> 이 외의 Scope 내에 선언된 변수

// 변수선언 실습 -> 비어 있는 메인 함수에 "정수형 변수"를 하나 만들어보자.
// var 을 쓰고 변수명은 a로 정하자. 그다음 콜론을 쓴 뒤 정수 자료형인 Int로 지정

/*
fun main() {
    var a: Int
}
*/

// 주황 느낌표 warning 메세지  'warning' --> 치명적이지는 않지만 불필요한 구문이 있거나 잠재적 문제가 있을 수 있음
// variable 'a' is never uesed -> 아직 'a' 변수가 코드내에서 사용되지 않았다는 warning 메시지


// println으로 변수 출력해보기
// println은 "문자열 출력기능"도 있지만
// println(변수명) ---> 이렇게 "정수형 변수의 값"도 바로 출력이 가능하다.

/*
fun main() {
    var a: Int
    println(a)
}

 */

// 빨간느낌표 "error" --> 구문상에 심각한 문제가 생겨 컴파일 자체가 불가능한 상태
// variable 'a' must be initialized ---> a라는 변수가 반드시 초기화 되어야 한다는 메시지
// -->> 이것이 Kotlin이 고전적인 언어들과 크게 다른점이다.
// --> '고전적인 언어들'은 변수가 선언된 후 초기화 되지 않으면 기본값으로 초기화 되거나 값이 할당되지 않았다는 표시 "null"값을 가지게 된다.
// --> kotlin은 기본변수에서 null을 허용하지 않으며 또한 변수에 값을 할당하지 않은채로 사용하면 문법 에러를 표시하고 컴파일을 막아준다.
// ----> 의도지 않은 동작이나 null pointer exception 등을 원천적으로 차단해 주는 장점이 있다.

// a라는 변수에 '값을 할당' 해주면 문제 해결
/*
fun main() {
    var a: Int = 123
    println(a)
}
*/
// 변수에 값을 할당하는 것은 반드시 선언시에 할 필요는 없다.

/*
fun main() {
    var a: Int
    a = 123

    println(a)
}
*/

// 이런식으로 변수를 참조하여 사용하기 전까지만 해주면 된다.

// But!! 프로그램에 따라서 '변수에 값이 할당되지 않았다는 것'을 '하나의 정보로 사용하는 경우'도 있을 수 있겠지?
// 이런경우는 변수 선언시 자료형 뒤에 '물음표'를 붙이면 null을 허용하는 nullable 변수로 선언해 줄 수 있다.
/*
fun main() {
    var a: Int? = null
}
*/

// nullable 변수는 값이 null인 상태로 연산할 시 null pointer exception이 발생할 수 있으므로 꼭필요할 때만 주의해서 사용
// 이 외에도 변수의 초기화를 늦추는 lateinit 이나 lazy 속성도 있으나 이건 클래스에 관한 지식이 필요하므로 뒷편 참조!

// 변수에서 사용할 수 있도록 kotlin이 제공하는 기본 자료형(primitive type)들은 자바와 호환을 위해 자바과 거의 동일
// 숫자형으로는
// 정수형인 Byte 8bits, Short 16bits, Int 31bits, Long 64bits
// 실수형으로는 Float 32bits,  Double 64bits
// 사용하고자 하는 숫자의 크기에 따라 선택해서 사용하면 된다.

// 정수형의 리터럴      리터럴 : 코드 내에 값을 표기하는 것
// 정수형 데이터를 직접 코드에서 표기할 때는 10진수 16진수 2진수
// "32비트 이내의 10진수"가 기본형으로 숫자만 표시하면 되며
// 64비트인 Long 타입의 10진수는 숫자 뒤에 대문자 L을 붙여 다 큰 메모리를 사용하는 정수임을 표시해야한다.
// 16진수인 경우 '0x'를 앞에 붙이면 되고 ( x는 hexadecimal의 약어)
// 2진수인 경우 '0b'를 앞에 붙이면 된다. ( b는 binary의 약어)
// kotlin은 8진수의 표기는 지원하지 않는다.

/*
fun main() {
    var intValue: Int = 1234
    var longValue: Long = 1234L
    var intValueByHex: Int = 0x1af
    var intValueByBin: Int = 0b10110110
}
*/

// '실수의 경우 기본이 Double 형'이며 소수점을 포함하여 숫자를 써주거나
// 필요시 지수 표기법을 추가하면 된다. ( e 는 exponential의 약어)
// Float 형인 경우 뒤에 소문자 또는 대문자 f를 붙여주면 16비트의 float형으로 취급한다. ( f 는 float의 약어)
/*
fun main() {
    var doubleValue: Double = 123.5
    var doubleValueWithExp: Double = 123.5e10
    var floatValue: Float = 123.5f
}
*/

// 문자형
// Char 1개의 문자 (문자 하나를 넣을 수 있는 캐릭터)
// kotlin은 내부적으로 문자열을 유니코드 인코딩 중에 한 방식인 UTF-16 BE 를 사용.
// 따라서 글자 하나하나가 2bytes(16bits)의 메모리 공간을 사용합니다.

// Char의 리터럴    리터럴 : 코드 내에 값을 표기하는 것
// 캐릭터 값을 직접 코드에서 표기할 때는 문자 하나를 작은 따옴표로 감싸서 표기한다.
// 아래의 특수 문자 지원
// \t 탭, \b 백스페이스. \r 첫 열로 커서 옮김, \n 개행, \' 작은 따옴표, \" 큰 따옴표, \\ 역 슬래시, \$ $문자, \uxxxx 유니코드문자
/*
fun main() {
    var charValue: Char = 'a'
    var koreanCharValue: Char = '가'

}
*/


// 논리형
// Boolean(불린값) 참 또는 거짓  ->> true 인지 false 인지 둥 중에 하나를 저장하는 값

// Boolean의 리터럴    리터럴 : 코드 내에 값을 표기하는 것
// Boolean 값을 직접 코드에서 표기할 때는 직접 true 또는 false라고 표기해주면 된다.
/*
fun main() {
    var booleanValue: Boolean = true
}
*/



// 이 외에 기본적으로 문자열을 사용할 수 있다.
// 문자열 변수는 코드에서 표기할 때는 따옴표 내에 문자열을 써주면 된다.
// val 변수명 = "문자열"
// 여러줄로 된 문자열을 사용할 때는 따옴표 3개 사용 ("""여러줄의 문자열""" )하면 줄바꿈이나 특수문자까지 그대로 문자열로 사용가능

fun main() {
    val stringValue = "one line string test"
    val multiLineStringValue = """multiline
        |string
        |test
    """.trimMargin()

    println(multiLineStringValue)
}






