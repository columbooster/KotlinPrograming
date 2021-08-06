// kotlin 강좌 # 24 중첩클래스와 내부클래스

// 코틀린에서 지원하는 클래스 유형 중에 클래스안에 클래스가 중첩되는 두 가지 유형의 클래스를 알아보자.

// 코틀린에서는 기본적으로 클래스안에 클래스를 하나 더 넣을 수 있는 "중첩 클래스 ( Nested Class )"를 지원한다.
// class Outer{
//   class Nested{
//   }
// }

// 중첩클래스는 하나의 클래스가 다른 클래스의 기능과 "강하게 연관"이 있다는 의미를 전달하기 위해 만들어진 형식으로
// 사용할 떄는 외부클래스의 이름 . 중첩클래스의 이름 으로 사용하게 된다. >>>>   Outer.Nested()

// 이 때, 중첩클래스 대신 '내부 클래스(Inner Class)'라는 것을 사용할 수도 있다.
// class outer{
//   inner class Inner{
//   }
// }
// 중첩 클래스에 inner라는 키워드를 붙인 내부 클래스는 혼자서 객체를 만들 수 는 없고 외부 클래스의 객체가 있어야만 생성과 사용이 가능한 클래스다.



// 중첩클래스는 형태만 외부에 존재할 뿐 실질적으로는 서로 내용을 직접 공유할 수 없는 별개의 클래스다. * 외부클래스의 내용을 공유할 수 없음
// 내부 클래스는 외부클래스 객체 안에서 사용되는 클래스 이므로 외부클래스의 속성과 함수의 사용이 가능하다.


// Outer 라는 클래스를 만들고 "Outer Class"라는 문자열을 text라는 속성에 넣어보자.

// 그 안에 Nested 라는 클래스를 만들어 보자.
// 그리고 introduce() 라는 함수를 만들어
// "Nested Class"라는 문자열을 출력해보자.

// 그리고 다시 Inner 라는 클래스를 만들어
// Outer랑 똑같이 text라는 속성을 만들되 "Inner Class"라는 문자열을 담아보자.
// 이제 introduce()라는 함수를 만들고 text 속성을 출력하고
// introduceOuter()라는 함수를 만들어 OuterClass에 있는 text 속성을 출력해보자.

// 이 때, 예제와 같이 Outer 클래스와 Inner 클래스에 같은 이름의 속성이나 함수가 있다면 "this@OuterClass이름"으로 참조하면 된다.

// main() 에서 Outer.Nested 클래스의 객체를 만들어 introduce() 함수를 호출해보자
// 다시 Outer 의 객체를 만들어 변수에 담은 후 이 변수에서 Inner 의 객체를 생성하여 변수에 담아보자.

// 이 객체에서 introduceInner() 와 introduceOter() 를 호줄해보자.

// 그리고 outer 객쳉의 text 속성을 "Changed Outer Class"로 변경하고
// 다시 introduceOuter() 를 호출해보자.

// 실행해보면 각각의 클래스의 특징에 따른 동작을 확인할 수 있다.

// 중첩클래스와 내부클래스는 클래스간에 연계성을 표현하여 코드의 가독성 및 작성 편의성이 올라갈 수 있으므로 적절한 상황에서 사용하는것이 좋다.


fun main() {

    Outer.Nested().introduce()

    var outer = Outer()
    var inner = outer.Inner()

    inner.introduceInner()
    inner.introduceOuter()

    outer.text = "Changed Outer Class"
    inner.introduceOuter()


}

class Outer {
    var text = "Outer Class"

    class Nested {
        fun introduce() {
            println("Nested Class")
        }
    }
    inner class Inner {
        var text = "Inner Class"

        fun introduceInner() {
            println(text)
        }
        fun introduceOuter() {
            println(this@Outer.text)
        }
    }
}



