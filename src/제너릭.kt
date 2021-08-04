// kotlin 강좌 # 19 제너릭

// 캐스팅을 줄여주는 Generic

// 클래스나 함수에서 사용하는 자료형을 외부에서 지정할 수 있는 기능인 Generic에 대해 알아보자.

// Generic은 어떤 기능일까?
// 예를 들어 클래스A와 A를 상속받은 클래스B가 있다고 해보자.
// 이 두 클래스의 인스턴스를 공용으로 사용하는 하나의 함수에 패러미터로 받으려면 어떻게 해야할까?
// 지난영상에서 배웠듯이 수퍼클래스인 A의 자료형으로 받으면 B는 자동으로 A로 캐스팅 되면서 두 클래스 모두 함수의 패러미터로 사용할 수 있다.
// fun castingExam(var a: A) >>> B를 넣어도 A로 캐스팅 됨

// 하지만 캐스팅 연산을 거치는 것은 프로그램의 속도를 저하시킬 수 있다는 단점이 있다.

// 그래서 Generic 이라는 개념이 나왔다.
// 제너릭은 함수나 클래스를 선언할 때 고정적인 자료형 대신 실제 자료형으로 대체되는 '타입 패러미터'를 받아 사용하는 방법이다.
// fun <T> genericFunc (param: T): T
// class GenericClass <T> (var pref: T) >> 이 타입 패러미터에 특정 자료형이 할당되면 제너릭을 사용하는 모든 코드는 할당된 자료형으로 대체되어 컴파일 된다.
// fun <Int> genericFunc (param: Int): Int
// class GenericClass <Int> (var pref: Int)

// 따라서 var param: A = B (x) 캐스팅 연산없이도 자료형을 그대로 사용할 수 있다.

// <T> 타입패러미터의 이름은 클래스 이름과 규칙이 같지만 일반적으로 'Type'의 이니셜인 'T'를 사용하는것이 관례이며
// 여러개의 제너릭을 사용할 경우 T의 다음 알파벳인 <T,U,V> 를 추가적으로 사용하기도 한다.

// 또한 제너릭을 특정한 수퍼클래스를 상속받은 클래스 타입으로만 제한하려면
// 콜론을 쓰고 수퍼클래스명을 명시하면 된다. <T:SuperClass>
// 이렇게 선언된 제너릭은 어떻게 사용할까??

// 함수에 제너릭을 선언한 경우 일반적인 함수처럼 사용하면 패러미터나 반환형을 통해 타입 패러미터를 자동으로 추론해주며
// fun <T> genericFunc (var param:T){}   >>> T에 Int 넣으면 정수리터럴이니까 Int 타입으로 추론
//           genericFunc(1)

// class의 경우 인스턴스를 만들 때 타입패러미터를 수동으로 지정하거나
// class GenericClass <T>
//  GenericClass<Int> ()

// 생성자에 제너릭이 사용된 경우 지정하지 않아도 자동으로 추론된다.
// class GenericClass <Int> (var pref: Int)
//           GenericClass(1)


//실전 ㄱㄱㄱㄱ

// 먼저 수퍼클래스로 사용될 open된 클래스 A를 만들어보자
// open된 함수 shout를 만들고 "A가 소리칩니다"라고 출력해보자

// 이번엔 A를 상속받은 클래스 B를 만들고
// shout를 override하여 "B가 소리칩니다"라고 출력하자.

// A를 상속받은 다른 클래스 C도 만들어보자.
// 역시 shout을 override하여 "C가 소리칩니다"라고 출력

// 이제 Usinggenric클래스를 만들되 '수퍼클래스 A로 제한'한 '제너릭 T를 선언'하고 생성자에서는 제너릭 T에 맞는 인스턴스를 속성 t로 받아보자
// 그리고 doShouting 함수를 만들어 t의 shout를 수행하자.

// main에서는 UsingGeneric 인스턴스를 만들되 패러미터로는 클래스 A의 인스턴스를 넘겨주자. 그리고 doShouting()을 수행해보자.

// 타입 패러미터를 수동으로 전달할 수도 있지만 UsingGeneric<A>(A()).doShouting()
// 생성자의 패러미터를 통해 클래스A라는 것을 알 수 있기 때문에 UsingGeneric(A()).doShouting() >>>A의 인스턴스를 받았으니 T는 A겠군!!
// 여기서는 생략해도 괜찮다.

// 클래스 B와 C도 같은 방법으로 UsingGenric에 넘겨서 사용해보자.
// 실행해보면 A.B.C 각각의 클래스에 shout의 함수가 잘 실행되었다.

// 사실 제너릭을 사용하지 않고 UsingGeneric의 생성자에서 수퍼클래스인 A로 캐스팅하여 class UsingGeneric(val t: A)
// shout을 호출하여도 동작은 같겠지만 이렇게 제너릭을 사용하는 경우 class UsingGeneric <T: A> (val t: T)
// 사용할 때 Generic이 자료형을 대체하게 되어 캐스팅을 방지할 수 있으므로 성능을 더 높일 수 있다.



// 제너릭을 함수에 사용하는 법도 배워보자!!
// fun뒤에 수퍼클래스르 A로 제한한 제너릭 T를 선언하고 함수 이름은 doShouting이라고 해보자
// 패러미터로는 제너릭 T에 맞는 인스턴스 t를 받아보자.
// 그리고 t의 shout를 수행해보자

// main에서는 doShouting 함수에 B의 인스턴스를 넘겨보자.
// 함수 역시 제너릭의 타입을 자동으로 추론하므로 별도로 타입 패러미터에 자료형을 전달할 필요는 없다.
// 실행해보면 B가 소리칩니다 라고 출력
// 역시 캐스팅 없이 B의 객체 그대로 함수에서 사용하는 것이다.

fun main() {

    UsingGeneric(A()).doShouting()
    UsingGeneric(B()).doShouting()
    UsingGeneric(C()).doShouting()

    doShouting(B())

}

fun <T: A> doShouting(t: T) {
    t.shout()

}

open class A {
    open fun shout() {
        println("A가 소리칩니다")
    }
}

class B : A() {
    override fun shout() {
        println("B가 소리칩니다")
    }
}

class C : A() {
    override fun shout() {
        println("C가 소리칩니다")
    }

}

class UsingGeneric<T: A> (val t: T) {
    fun doShouting() {
        t.shout()
    }

}


// 제너릭은 많은 기본 클래스에서도 사용되고 있으니 꼭 잘알아두세용~~~!!

