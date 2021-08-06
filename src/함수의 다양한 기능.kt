// kotlin 강좌 # 23 함수의 다양한 기능

// 함수의 argument를 다루는 방법과 infix함수
// 코틀린에서도 대부분의 언어에서 지원하는 함수의 overloading이 지원된다. *overriding과 혼동하지말라.

// 이것은 같은 scope 안에서 같은 이름의 함수를 여러개 만들수 있는 기능이다.
// 이름이 같더라도 패러미터의 자료형이 다르거나 패러미터의 개수가 다르다면 서로 다른 함수로 동작할 수 있다.
// fun same(x:Int)
// fun same(x:Int, text:String)
// fun same(x:Int, y:Int)

// 다만 패러미터의 이름만 다르게 붙고 자료형과 개수가 동일 하다면 오버로딩을 할 수 없다.
// fun same(x:Int, y:Int)
// fun same(a:Int, b:Int)

// 실습ㄱㄱㄱ

// read() 라는 함수를 만들고 패러미터로 x라는 Int 값을 받아보자.
// 그리고 "숫자 $x입니다"라고 출력해보자.

// 다음은 똑같이 read()라는 함수를 만들되 패러미터로 x라는 String을 받아보자.
// 그리고 x를 그대로 출력해보자

// main 에서 read() 함수에 정수 7을 넣어보고 다시 똑같이 read()함수지만 "감사합니다"라는 문자열을 넣어보자
// 실행해보면 함수 이름은 같지만 자료형을 구분하여 함수가 매칭되어 실행되는것을 알수있다.

/*
fun main() {

    read(7)
    read("감사합니다")

}

fun read(x:Int) {
    println("숫자 $x 입니다")

}

fun read(x:String) {
    println(x)
}
*/

// 다른 고민을 한 번 해볼까?

// 패러미터를 받아야 하는 함수지만 별다른 패러미터가 없더라도 기본값으로 동작해야 한다면 어떻게 해야할까?
// 이때는 default argument 를 사용한다.

// deliveryItem()이라는 함수를 만들어보자
// 패러미터로는 이름과 개수, 목적지를 받도록 하되 개수를 받는 패러미터 옆에 equl을 사용하여 숫자1을 넣어주고
// 목적지를 받는 패러미터에는 equl을 사용하여 "집"이라는 문자열을 넣어보자.
// 내용에는 "${name},${count}개를 ${destination}에 배달하였습니다"라고 출력해보자.

// main() 에서는 deliveryItem()에 "짬뽕"이라는 문자열을 넣어보고
// 다시 deliveryItem()에 "책"과 3이라는 숫자를 넣어봅시다.
// 이번에는 deliveryItem()에 "노트북"과 30, "학교"라는 값을 넣어보자.

// 실행해보면 '패러미터가 채워진 경우'에는 '입력받은 패러미터를 사용'하여 출력되지만 "패러미터가 없다"면 '지정된 기본값'으로 출력된다.

// 그런데, 이름과 목적지만 넣고 개수는 기본값을 이용하고 싶다면 어떻게 해야할까?
// 차례대로 넣는다면 중간의 개수파틀 비우면 함수는 동작하지 않는다.
// 이때는 named argument를 사용하는데 named argument는 패러미터의 순서와 관계없이 패러미터의 이름을 사용하여 직접 패러미터의 값을 할당하는 기능이다.

// 다시 main()에서 delriveryItem()에 "선물"이라는 문자열을 넣고 destination에 equal을 달아 "친구집"이라고 해보자.
// 별도의 패러미터 이름이 지정되지 않은 "선물"이라는 문자열은 순서에 따라 맨 앞의 name 으로 들어가게 되지만      *이건 첫 패러미터니까 name 이겠군
// destination 임이 지정된 "친구집"이라는 문자열은 해당 패러미터로 받게 된다.
// 실행해보면 중간에 있는 개수(count)는 기본값인 1로 출력되고 나머지 두 패러미터만 할당되어 실행되었음을 알 수 있다.

/*
fun main() {

    deliveryItem("짬뽕")
    deliveryItem("책",3)
    deliveryItem("노트북", 3, "학교")

    deliveryItem("선물", destination = "친구집")
}

fun deliveryItem(name:String, count:Int=1, destination:String="집") {

    println("${name}, ${count}개를 ${destination}에 배달하였습니다")

}
*/

// 이번엔 같은 자료형을 개수에 상관없이 패러미터로 받고싶을 때 사용하는 variable number of arguments(vararg) 를 사용해보자.

// sum()이라는 함수를 만들고 패러미터에서 vararg 가 붙은 Int 값을 받아보자
// 그리고 숫자들을 더할 변수 sum을 0으로 초기화 해보자.

// vararg 붙은 패러미터는 마치 "배열처럼" for 문으로 참조할 수 있다.
// sum에 받아 온 모든 정수값을 더해 보자.
// 그리고 더해진 값을 출력해보자.

// main() 에서 sum()에 1,2,3,4 를 넣어보자
// 실행해보면 모든 값을 더한 10 이라는 숫자가 출력된다.

// vararg 는 개수가 지정되지 않은 패러미터라는 특징이 있으므로 다른 패러미터와 같이 쓸때는 반드시 맨 마지막에 위치해야한다!!!
// ex) fun sampl(text: String, vararg x: Int)

/*
fun main() {

    sum(1,2,3,4)
}

fun sum(vararg numbers: Int) {
    var sum = 0

    for(n in numbers) {
        sum += n
    }

    println(sum)

}
*/

// 마지막으로 마치 '연산자 처럼' 쓸 수 있는 infix function 을 알아보자.  인픽스함수

// 함수를 정의할 때 앞에 infix를 붙인 후 함수의 이름을 'infix 함수가 적용될 자료형.이름'으로 지정한다.
// 여기서는 Int 값에 사용할 miltiply() 함수를 만들어보자. 그리고 패러미터로 역시 Int 값 x를 지정해보자.
// 반환값 역시 Int 로 해보자. 그리고 this 와 x 를 곱해서 반환하자.

// main() 에서는 6과 4를 multiply 하여 출력해보자.
// 여기서 좌측에 붙은 6이 infix 함수가 적용되는 객체 자신, 즉 this 에 해당하고  우측에 붙은 4가 패러미터인 x에 해당한다.

// 그냥 일반적인 클래스의 함수처럼 사용할 수도 있는데 6.multiply에 괄호치고 4를 써도 똑같이 동작한다.
// 실행해보면 6과 4를 곱한 24가 출력된다.

// 참고로 class 안에서 infix 함수를 선언할 때에는 적용할 클래스가 자기 자신이므로 클래스의 이름은 쓰지 않는다.
// infix fun multiply(x: Int): Int = this * x

fun main() {

    println(6 multiply 4)

    println(6.multiply(4))
}

infix fun Int.multiply(x: Int): Int = this * x

// 코틀린은 많은 언어들이 지원하는 함수의 다양한 편의기능을 거의 대부분 가지고 있다.