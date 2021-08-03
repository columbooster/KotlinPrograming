// kotlin 강좌 # 15 스코프 함수

// 이제 절반 왔다!! 힘내자!! 나!! 아자!!!! 으자자자자자!!!!! 쁘샤샤샤샤샤샤!!!

// 람다함수를 이용한 특별한 기능인 스코프 함수를 알아보자. 정신놓지마!! 정신줄 잡아!!

// 스코프 함수를 배우기 전에 설명에 도움이 되도록 지난시간에 생략했던 람다함수의 특별한 케이스들을 몇가지 소개해준대.. 그만...

// 1. 람다함수도 일반 함수처럼 여러 구문의 사용이 가능 * 참고로 람다함수가 여러줄이 되는경우 마지막 구문의 결과값이 반환된다.
// ex) val calculate: (Int,Int) -> Int = (a,b ->
//         println(a)
//         println(b)
//         a+b                         ** 여기서는 마지막 구문인 a+b의 값을 Int로 반환함

// 2. 패러미터가 없는 람다함수는 실행할 구문들만 나열하면 된다.
// ex) val a:() -> Unit = { println("패러미터가 없어요") }
// 3. 패러미터가 하나 뿐이라면 it 사용. 패러미터가 여러개라면 람다함수 내에서 패러미터 이름을 일일히 써줬다.
// ex) val c: (String) -> Unit = { println("$it 람다함수") }



// 스코프 함수 (scope function)
// 스코프 함수는 함수형 언어의 특징을 좀 더 편리하게 사용할 수 있도록 기본 제공하는 함수들이다.
// 클래스에서 생성한 인스턴스를 스코프 함수에 전달하면 "인스턴스의 속성이나 함수를 좀 더 깔끔하게 불러 쓸 수 있다"

// 스코프 함수에는 apply, run, with, also, let 등 5가지가 있다.

// apply는 인스턴스를 생성한 후 변수에 담기전에 '초기화 과정'을 수행할 때 많이 쓰인다.
// Book이라는 클래스를 만들어 이름과 가격을 받돌고 해보자. 또한 discount라는 함수가 가격을 2000원 낮춰준다고 해보자
// main에서는 책하나를 만들어보자. 이 때, 책 이름에"[초특가]"라는 문자열을 넣어주고 discount를 바로 수행해보자
// 기존의 경우 인스턴스를 저장한 변수a를 통해 참조 연산자를 사용하여 속성과 함수를 사용했겠지만
// ex) var a = Book("디모의 코틀린", 10000)
//     a.name = "[초특가]"+a.name
//     a.discount()
// apply를 이용하면 인스턴스를 생성하자마자 그 인스턴스에 참조연산자를 사용하여 apply를 붙이고 중괄호로 람다함수를 하나 만들어
// apply의 스코프안에서 직접 인스턴스의 속성과 함수를 참조연산자없이 사용가능하다.
// var a = Book("디모의 코틀린", 10000).apply{
//     name = "[초특가]"+name
//     discount()   }
// 또한 apply는 인스턴스 자신을 다시 반환하므로 이렇게 생성되자마자 조작된 인스턴스를 변수a 에 바로 넣어줄수 있다.
// 이렇게 apply와 같은 스코프 함수를 사용하면 main함수와 '별도의 scope'에서 인스턴스의 변수와 함수를 조작하므로 코드가 깔끔해진다는 장점이 있다.

/*

fun main() {
    var a = Book("디모의 코틀린", 10000).apply {
        name = "[초특가]" + name
        discount()

    }

}

class Book(var name: String, var price: Int)
{
    fun discount()
    {
        price -= 2000
    }
}

*/
// run 은 apply처럼 run 스코프 안에서 참조연산자를 사용하지 않아도 된다는 점은 같지만 일반 람다함수처럼 인스턴스 대신 마지막 구문의 결과값을 반환한다는 차이점
// ex) var b = a.run{
//         println(a.price)
//         a.name    }    * 이렇게 쓰면 가격은 출력하지만 마지막 구문인 이름은 반환하여 b라는 변수에 할당됨
// 따라서 이미 인스턴스가 만들어진 후에 인스턴스의 함수나 속성을 scope내에서 사용해야할 때 유용하다.
// 그럼 아까 apply를 사용해 만들어진 변수a의 내용을 run을 사용해서 출력해보자.
// 변수 a에 참조연산자를 사용하여 run을 붙이고 중괄호 안에서 인스턴스의 속성이름을 직접사용하여 내용을 출력해주면 된다.
// 실행하면 apply에서 수정한 책 이름과 할인된 가격인 8000원이 출력된다.

/*
fun main() {
    var a = Book("디모의 코틀린", 10000).apply {
        name = "[초특가]" + name
        discount()
        }
    a.run {
        println("상품명:${name}, 가격: ${price}원")

    }

}

class Book(var name: String, var price: Int)
{
    fun discount()
    {
        price -= 2000
    }
}

*/

// with 는 run과 동일한 기능을 가지지만 단지 인스턴스를 참조연산자 대신 패러미터로 받는다는 차이일뿐
// ex)  a.run{...}     with(a){...}


// also / let 각각 apply와 run과 같은 기능을 가지고 있다.
// 처리가 끝나면 인스턴스를 반환 apply/also
// 처리가 끝나면 최종값을 반환 run/let
// 다만 한가지 공통적인 차이점이 있는데 apply와 run이 참조연산자 없이 인스턴스의 변수와 함수를 사용할 수 있었다면
// also와 let은 마치 패러미터로 인스턴스를 넘긴것 처럼 it을 통해서 인스턴스를 사용할수 있다.

// 이 두 함수는 왜 굳이 패러미터를 통해서 인스턴스를 사용하는 귀찮은 과정을 걸칠까??
// 이는 같은 이름의 변수나 함수가 'scope 바깥에 중복' 되어 있는 경우에 혼란을 방지하기 위해서다.
// main 함수 최상단에 book클래스의 속성이름과 같은 price변수를 하나 만들고 5000이라는 숫자를 할당해보자.
/*
fun main() {
    var price = 5000
    var a = Book("디모의 코틀린", 10000).apply {
        name = "[초특가]" + name
        discount()
    }
    a.run {
        println("상품명:${name}, 가격: ${price}원")

    }

}

class Book(var name: String, var price: Int)
{
    fun discount()
    {
        price -= 2000
    }
}
*/
// 8000원이 아니라 main함수에서 만든 변수의 값인 5000원이 출력되었다.
// 이는 run 함수가 인스턴스 내의 price 속성보다 run이 속해있는 'main 함수'의 price 변수를 우선시하고 있기때문이다.

// 이럴떄는 run을 대체하는 let을 사용하고 name 대신 it.name , price대신 it.price로 변경해주면 인스턴스의 값이 정상적으로 출력된다.

fun main() {
    var price = 5000
    var a = Book("디모의 코틀린", 10000).apply {
        name = "[초특가]" + name
        discount()
    }
    a.run {
        println("상품명:${name}, 가격: ${price}원")

    }
    a.let {
        println("상품명: ${it.name}, 가격: ${it.price}원")
    }

}

class Book(var name: String, var price: Int)
{
    fun discount()
    {
        price -= 2000
    }
}

// apply 역시 같은경우가 있다면 'also'로 대체하여 사용하면 된다.

// 스코프 함수는 인스턴스의 속성이나 함수를 scope 내에서 깔끔하게 분리하여 사용할수 있다는 점 때문에 코드의 가독성을 향상시킨다는 장점이 있다.
