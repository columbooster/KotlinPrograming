// kotlin 강좌 # 익명객체와 옵저버 패턴

// kotlin에서 옵저버 패턴을 구현하는 방법을 알아보자

// 코딩에서는 '이벤트가 일어나는 것을 감시'하는 감시자의 역할을 만든다고 하여 obsever라고 부르는 것이다.

// 안드로이드를 예로하자면 키의 입력, 터치의 발생, 데이터의 수신 등 함수로 직접 요청하지 않았지만 시스템 또는 루틴에 의해서 발생하게 되는 동작들을 '이벤트'라고 부르며
// 이 이벤트가 발생할 때마다 '즉각적으로 처리' 할 수 있게 만드는 프로그래밍 패턴을 '옵저버 패턴'이라고 부른다.

// 옵저버 패턴을 구현할 때는 두 개의 클래스가 필요한데 1. 이벤트를 수신하는 클래스 2. 이벤트의 발생 및 전달하는 클래스
// 이 두 클래스 간에는 어떻게 통신을 할까?
// 2에서 이벤트가 발생할 때 1에 있는 이벤트를 처리하는 함수를 호출하여 알려주면 된다. but!! 이 방법에는 문제가 있다.
// 일반적으로 이벤트를 수신하는 클래스 측에 필요에 따라 이벤트를 발생시키는 클래스에 인스턴스를 생성하여 사용하기 때문에 1은 2를 직접 참조 할 수 있지만
// 2는 1을 참조할 방법이 없는것이다.

// 그래서 우리는 이 사이에 '인터페이스'를 끼워넣는다.
// 2에서는 자신의 이벤트를 받을 수 있는 인터페이스를 만들어 공개하고 1은 이를 구현하여 2에 넘겨주면 인터페이스만 알아도 이벤트를 넘겨줄 수 있다.
// 이 때, 이 인터페이스를 'observer' 또는 코틀린에서는 'listener'라고 부르며 이렇게 이벤트를 넘겨주는 행위를 'callback'이라고 한다.

// 그럼 옵저버 패턴을 한 번 구현해보자!
// 이벤트를 수신해서 출력하는 EventPrinter 클래스, 숫자를 카운트하며 5의 배수마다 이벤트를 발생시킬 counter 클래스.
// 이 두개를 연결시킬 인터페이스인 EventListener로 이루어져 있다.
// 먼저, EventListener 인터페이스부터 만들자. 이 인터페이스는 이벤트가 발생할 때 숫자를 반환해 줄 예정인데 interface EventListener { }
// onEvent 라는 추상함수를 만들고 *리스너를 통해 이벤트를 반환하는 함수 이름은 관례적으로 'on(행위)'라고 규칙을 따른다.
// 패러미터로 정수값을 넘겨줄 수 있도록 한다.
// 그럼 이벤트가 발생되는 Counter 클래스를 만들어보자
// 이벤트를 발생시키기 위해 생성자에서 EventListener를 속성으로 받아보자.
// 그리고 count 라는 함수를 호출하면 1에서 100까지 반복하면서 5의 배수가 될 때마다 EventListener의 onEvent를 호출하도록 해보자.
// 이제 이벤트를 받아서 화면에 출력할 EventPrinter를 만들어보자.
// EventPrinter는 EventListener를 상속하여 구현해야 한다.
// onEvent 함수를 override하여 받아온 숫자와 대시문자를 출력하도록 하자.
// 여기에 start 라는 함수를 추가할텐데
// 먼저 Counter의 인스턴스를 만들되 this라는 키워드로 EventListener 구현부를 넘겨준다. 그리고 count를 시작하게 해보자.
// 여기서 this는 EventPrinter 객체 자신을 나타내지만 *this는 키워드가 사용된 '객체자신'을 참조하는 키워드입니다.
// 받는 쪽에서 'EventListener만' 요구했기 때문에 EventListener 구현부만 넘겨주게 된다. --> 이를 객체지향의 다형성이라고 한다.
// 상속받아 만들어진 클래스는 수퍼클래스의 기능을 포함하여 제작되었으므로 수퍼클래스에서 정의한 부분만 따로 념겨줄 수 있다.

// 그리고 main에서는 단지 EventPrinter의 인스턴스를 생성하고 start함수만 호출해주면 된다.
// 실행해보면 Counter가 5의 배수마다 이벤트를 발생시킨것을 EventPrinter내에서 구현된 EventListener에서 출력하고 있음을 볼 수 있다.


/*

fun main() {
    EventPrinter().start()


}

interface EventListener {
    fun onEvent(count: Int)
}

class Counter(var listner: EventListener) {
    fun count() {
        for(i in 1..100) {
            if(i % 5 == 0) listner.onEvent(i)
        }
    }
}

class EventPrinter : EventListener {
    override fun onEvent(count: Int) {
        print("${count}-")
    }
    fun start() {
        val counter = Counter(this)
        counter.count()
    }
}
*/
// 그런데 EventPrinter가 EventListner를 상속받아 구현하지 않고 임시로 만든 별도의 EventListener객체를 대신 넘겨줄 수도 있는데
// 이것을 '이름이 없는 객체'라 하여 익명 객체 (Anonymous Object) 라고 한다.

// 일단 EventPrinter 클래스를 지우고 다시 작성해보자.
// 이번엔 EventListener를 상속받지 않고 바로 start 함수를 만들어 보자
// 그리고 Counter 인스턴스를 만들 때 패러미터에 익명객체를 만들어 넘길텐데 여기에 object라는 키워드가 사용된다.
// object라고 쓰고 이름없이 바로 콜론을 쓴 후 EventListener를 상속받도록 하고 중괄호를 친 후 onEvent함수를 override하면 된다.
// object : EventListener {
//            override fun onEvent(count: Int) {
//                print("${count}-")
//            }
//        }   --->>>>>>>> 이 긴 문장이 익명함수로 넘길 패러미터 단 한개다...... 좀 길지?ㅋ
// 지난 시간에 배운 object와 형태는 비슷하다. 단지 차이는 '이름이 없다'는 점이다.
// 이렇게 만들면 인터페이스를 구현한 객체를 코드 중간에도 '즉시 생성'하여 사용할 수 있다.

// 그리고 count를 시작하게 해보자.
// 실행해보면 같은 결과가 나온다.




fun main() {
    EventPrinter().start()


}

interface EventListener {
    fun onEvent(count: Int)
}

class Counter(var listner: EventListener) {
    fun count() {
        for(i in 1..100) {
            if(i % 5 == 0) listner.onEvent(i)
        }
    }
}

class EventPrinter {
    fun start() {
        val counter = Counter(object : EventListener {
            override fun onEvent(count: Int) {
                print("${count}-")
            }
        })
        counter.count()
    }
}


// obsever 패턴은 이벤트를 기반으로 동작하는 모든 코드에서 광범위하게 쓰이는 방식이므로 그 구조를 이해하는것이 중요하다!!!
