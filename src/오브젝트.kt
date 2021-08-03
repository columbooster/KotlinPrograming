// kotlin 강좌 # 16 오브젝트

// 생성자 없이 객체를 직접 만들어내는  object

// 기존에 배웠던 class는 단지 인스턴스 객체를 만들기 위한 '틀'이기 때문에 내부에 있는 속성이나 함수를 사용하려면 var a = Person("박보영",1990)
// 생성자를 통해 실체가 되는 인스턴스 객체를 만들어야 했다.
// 그러나 여러개의 인스턴스 객체가 필요하지 않으며 단 하나의 객체만으로 공통적인 속성과 함수를 사용해야하는 코드에서는 굳이 class를 쓸필요없이 objct 사용
// 기존 다른 언어의 개념인 singleton Pattern을 언어차원에서 지원햐는 것이다. *싱글패턴 : 클래스의 인스턴스를 단 하나만 만들어 사용하도록하는 코딩 아키텍쳐 패턴

// 만들어 봅시다.

// 코드 아무데서나 호출하여 호출한 횟수를 카운팅하거나 초기화할 수 있는 Counter라는 object를 만들어보자.
// object라는 키워드를 쓰고 이름을 Counter라고 정한 후 중괄호를 쳐라. object는 인스턴스를 생성하지 않고 그 자체로 객체이기 떄문에 '생성자는 사용하지 않는다'
// 이제 실제 카운팅한 개수를 저장하는 count라는 변수를 만들어 초기값을 0으로 해보자
// 그리고 countUp이라는 함수에서는 count갯수를 하나 늘려주고 clear라는 함수에서는 count를 0으로 초기화 해준다.
// main함수에서 사용해보자.
// object는 별도의 인스턴스를 생성하지 않기 떄문에 'object이름에 직접 참조연산자를 붙여'사용한다.  * Counter.멤버이름
// 먼저 초기 count 값을 찍어보고 두번정도 countUp()을 호출해보자. 다시 count값을 출력해보고  clear로 초기화한 후 마지막으로 count를 출력해보자
// 예쌍대로 0.2.0이 출력된다.

/*
fun main() {
    println(Counter.count)

    Counter.countUp()
    Counter.countUp()

    println(Counter.count)

    Counter.clear()

    println(Counter.count)

}

object Counter {
    var count = 0

    fun countUp() {
        count++
    }
    fun clear() {
        count = 0
    }

}
*/

// object로 선언된 객체는 '최초 사용시' 자동으로 생성되며 이후에는 코드 전체에서 '공용으로 사용'될 수 있으므로
// 프로그램이 종료되기 전까지 공통적으로 사용할 내용들을 묶어 만드는 것이 좋다.

// 그런데 기존 클래스 안에도 object를 만들 수 있다.
// 바로 Companion Object라는 녀석!!!! 컴패니언 오브젝트!!
// 클래스의 인스턴스 기능은 그대로 사용하면서 인스턴스간에 공용으로 사용할 속성과 함수를 별도로 만드는 기능이다.
// 기능적으로는 기존의 언어들이 가진 Static멤버와 비슷하다고 생각하면 된다.
// * Static 멤버 : 클래스 내부에서 별도의 영역에 고정적으로 존재하여 인스턴스를 생성하지 않아도 공용으로 사용가능한 속성이나 함수
// 예제 ㄱㄱ
// 짜장과 짬뽕 중 어느것이 좋은지를 선택하는 설문조사를 해보도록 하자. 난 짜장.
// 각각의 음식을 투표할 때마다 개별적인 투표수와 총 투표수가 동시에 집계되도록 하자.
// 일단 FoodPoll이라는 클래스를 만들고 생성자에서 음식 이름을 받아보자.
// 그리고 companion object라고 써준 후 중괄호 안에 total 이라는 총 투표수를 저장하는 속성을 만들어 0을 할당해보자.

// 이번엔 개별 투표수를 저장하는 count라는 속성을 만들어보자. var count = 0 컴패니언 오브젝트 바깥, 그러니까 일반적인 속성으로 만들어라.
// 그리고 vote라는 함수를 만들어 total과 count를 각각 1씩 증가시켜보자.

// 그럼 메인함수에서 투표를 진행해보자.
// a라는 변수에 FoodPoll의 짜장 인스턴스를 생성하고 b라는 변수에는 짬뽕 인스턴스를 생성하여 투표해보자.
// a의 vote()는 2번, b의 vote()는 세번 호출해보자.

// 결과를 한 번 볼까?
// a의 count와 b의 count. 그리고 FoodPoll의 total값을 확인해 보면 예상대로 2.3.5가 나온다.
// 이는 서로다른 인스턴스 임에도 compaion object 내에 있는 total을 공유하고 있기 떄문에 모든 인스턴스에서 투표수를 누절할 수 있기때문이다.


fun main() {

    var a = FoodPoll("짜장")
    var b = FoodPoll("짬뽕")

    a.vote()
    a.vote()

    b.vote()
    b.vote()
    b.vote()

    println("${a.name} : ${a.count}")
    println("${b.name} : ${b.count}")
    println("총계 : ${FoodPoll.total}")


}

class FoodPoll (val name: String) {
    companion object{
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}

// 이번 시간에 object를 사용하는 두가지 경우에 대해서 배웠다.
// 사실 아직 object를 사용하는 방법이 하나 더 있다. 이는 다음시간에 말해준다는데. 왜? 굳이?
