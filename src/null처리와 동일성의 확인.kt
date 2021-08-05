// kotlin 강좌 # 22 null 처리와 동일성 확인

// nullable 변수에서 null 을 처리하는 법과 변수간에 동일성을 확인하는 법을 알아보자. 가자!!!!!! 으자!!!!

// 우리는 코틀린에서 nullable 변수를 만들어 var sample: String? = null 객체가 들어있지 않는 null 상태를 만들 수 있다.
// 하지만 null 상태로 속성이나 함수를 쓰려고 하면 null pointer exception(null인 객체를 참조하면 발생하는 오류)이 발생하기 때문에
// nullable 변수를 사용할 때는 null 체크가 없이는 코드가 컴파일 되지 않는다.
// ex ) var sample: String? = null
//      if(sample ! = null)
//        println(sample.toUpperCase())

// null 체크를 하기 위해 일일히 if문으로 조건을 체크하는 대신 좀 더 편리한 방법은 없을까? 있겠지...

// 참조연산자 앞에 물음표를 붙여 사용하는 널세이프연산자 --> ?.  null safe operator
// sample?.toUpperCase() 참조연산자를 실행하기 전에 먼저 객체가 null인지 확인부터하고 객체가 null이라면 뒤따라오는 구문을 실행하지 않는 연산자다.
// 객체가 null이면 toUpperCase() 구문실행 안한다

// 물음표와 콜론이 합쳐진 엘비스연산자  ---> ?:  elvis operator
// 객체가 null이 아니라면 그대로 사용하지만 null이라면 연산자 우측의 객체로 대체되는 연산자다.
// sample?:"default"  >> sample이 null 이니까 대신 "default"를 쓴다


// 느낌표 두개와 참조연산자를 사용한 논널어썰션연산자   --> !!.  non-null assertion operator
// 참조연산자를 사용할 때 null 여부를 컴파일시 확인하지 않도록하여 런타임시 null pointer exception이 나도록 의도적으로 방치하는 연산자.
// sample!!.toUpperCase()

// 실습 ㄱㄱ



// 먼저 nullable String 변수 a를 만들어 null을 할당해보자.
// 그리고 a에 null safe 연산자를 사용하여 toUpperCase() 함수를 사용하고 결과를 출력해보자.

// 다시 a에 elvis 연산자를 사용하고 null일 때 대체되는 문자열 객체로 "default"를 넣고 toUpperCase() 함수를 사용하고 결과를 출력해보자.

// 마지막으로 a에 non-null assertion 연산자를 사용하여 toUpperCase()를 실행하고 결과를 출력해보자.

// 실행해보면 첫번째 출력구문에서는 변수의 내용이 null이기 때문에 toUpperCase()함수가 실행되지 않아 a가 null이라는 내용이 그냥 출력 되었으며
// 두번쨰에서는 null대신 "default"라는 문자열로 대체된 뒤 '대문자'로 바뀌었음
// 세번째에서는 '구문이 실행되는 도중 null임을 확인'하고 exception이 발생하여 에러가 나고 프로그램이 중단되었다.

/*
fun main(){

    var a:String? = null

    println(a?.toUpperCase())

    println(a?:"default".toUpperCase())

    println(a!!.toUpperCase())
}

*/


// null safe 연산자는 스코프함수와 사용하면 더욱편리하다.

// 프린트 구문 3개를 지우고 이번에는 a에 null safe 연산자를 사용한 후 스코프함수 run을 사용하여 toUppercase()와 toLowerCase() 함수를 실행해 출력해보자.
// 그대로 실행해보면 a가 null이기 때문에 scope 함수 전체가 수행되지 않는다.

/*
fun main() {

    var a:String? = null

    a?.run {
        println(toUpperCase())
        println(toLowerCase())
    }
}

*/


// 이제 a에 "Kotlin Exam"문자열을 넣어보자
// 다시 실행해보면 스코프 함수 run 전체가 실행된다.

// 이는 'null을 체크하기 위해 if문 대신 사용'하면 상당히 편리한 기능이므로 꼭 알아두자!!!!!!!!!!!!

/*
fun main() {

    var a:String? = "Kotlin Exam"

    a?.run {
        println(toUpperCase())
        println(toLowerCase())
    }
}
*/


// 이번엔 '변수의 동일성'을 체크하는 방법을 알아보자.

// 동일성에는 두가지 개념이 있는데 "내용의 동일성", "객체의 동일성" 이다

// 내용의 동일성은 메모리 상에 서로 다른 곳에 할당된 객체라고 해도 그 내용이 같다면 동일하다고 판단하는 것이며
// ex) "사이다"   "콜라"   "환타"   "사이다"
//      변수a                       변수b      >>>> a와b는 내용이 동일하군!!!

// 객체의 동일성은 서로 다른 변수가 메모리상에 같은 객체를 가리키고 있을때만 판단하는 것이다.
// ex) "사이다"   "콜라"   "환타"   "사이다"
//             변수a 변수b                     >>>> a와b는 객체가 동일하군!!!


// 내용의 동일성을 판단하는 연산자는 이퀄두개를 사용한 연산자 == 이며      a==b
// 객체의 동일성을 판단하는 연산자는 이퀄세개를 사용한 연산자 === 이다     a===b

// 이 중 내용의 동일성은 자동으로 판단되는 것이 아닌 '코틀린의 모든 클래스가 내부적으로 상속받는 "Any"라는 최상위 클래스의
// equals() 함수가 반환하는 Boolean 값으로 판단하게 된다.

// '기본자료형'에는 자료형의 특징에 따라 equals() 함수가 이미 구현되어 있지만 우리거 커스텀 class를 만들때는
// open fun equals(other: Any?): Boolean 이러한 equals를 상속받아 동일성을 확인해주는 구문을 별도로 구현해야한다.

// 새로 실습 가자!!!

// product라는 클래스를 만들어 이름과 가격을 받아보자
// 그리고 equals()함수를 override하여
// 패러미터로 넘어온 객체가 Product라면 이름과 가격이 모두 같은지를 비교하여 boolean 값으로 반환하고
// 아니라면 false를 반환합니다.

// main 에서는 변수 a에 1000원 짜리 콜라를 만들고 변수 b 역시 1000원짜리 콜라를 만들자.
// 그리고 변수 c는 a를 그대로 할당 받고 변수 d 에는 1000원짜리 사이다를 만들어보자.


// 이제 a와b의 내용의 동일성, 그리고 객체의 동일성을 각각 출력해보고

// a와c의 내용의 동일성과 객체의 동일성도 출력해보자. a와d도 ㄱㄱ

// 출력해보면 a와b는 내용은 같지만 객체는 서로 별개임을 알 수있다.
// a와c는 내용곽 객체 모두 일치
// a와d는 내용과 객체 모두 불일치 함을 알 수있다.


fun main() {

    var a = Product("콜라",1000)
    var b = Product("콜라",1000)
    var c = a
    var d = Product("사이다", 1000)

    println(a == b)
    println(a === b)

    println(a == c)
    println(a === c)

    println(a == d)
    println(a === d)



}


class Product(val name:String, val price:Int) {
    override fun equals(other: Any?): Boolean {
        if(other is Product) {
            return other.name == name && other.price == price
        } else {
            return false
        }
    }

}


// null 처리와 동일성의 확인은 프로그램 작성도중 빈번하게 사용하는 기능이므로 그 동작 방식들을 잘 알고 사용하는 게 좋다!!!

