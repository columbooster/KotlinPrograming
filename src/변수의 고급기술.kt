// kotlin 강좌 # 29 변수의 고급기술. 상수, lateinit, lazy

// 변수의 다양한 사용방법에 대해 알아보자.

// 우리는 변수의 자료형 강좌에서 var 과 val 을 사용하여 기초적인 변수의 선언을 알아봤었다.

// 이제 변수에 대한 몇 가지 주의할 내용과 좀 더 다른방법으로 사용하는 것을 알아보자.

// var 은 한 번 할당한 객체가 있더라도 다른 객체로 변경하여 할당할 수 있으며
// var a = Pesron("유나",2003)
// a = Person("루다",1997)

// val 은 한 번 객체를 할당하면 다시 할당된 객체를 변경할수는 없다.
// val a = Person("케이",1995)
// a = Peson("조이",1996) (x) --> 변경 불가!!!

// 하지만 주의할 점이 있다!!
// val 은 할당된 객체를 바꿀 수 없을 뿐이지 객체 내부의 속성을 변경할 수 없는 것은 아니라는 점을 기억하자!!!

// 그런데 절대 변경이 불가능한 것도 있다!!
// 바로 '상수' 라는 것이다.
// 상수(constants)는 컴파일 시점에 결정되어 절대 바꿀 수 없는 값이다.
// 선언은 val 앞에 const 를 붙여 만들게 된다.
// const val CONST_A = 1234
// 상수로 선언될 수 있는 값은 기본자료형만 가능하며(String 자료형을 포함) 런타임에 생성될 수 있는 일반적인 다른 클래스의 객체들은 담을 수 없다.

// 상수는 클래스의 속성이나                      지역 변수등으로는 사용할 수 없으며
// class Sample {                              fun sample {
//   const val CONST_A = 1234 }    (x)          const val CONST_A = 1234 }   (x)

// 반드시 companion object 안에 선언하여 객체의 생성과 관계없이 클래스와 관계된(Sample.CONST_A) 고정적인 값으로만 사용하게 된다.
// class Sample {
//  companion object {
//    const val CONST_A = 1234 } }

// 상수의 이름을 만들 때는 의례적으로 대문자와 언더바를 사용한 표기법을 사용하게 되며 이를 통해 변수가 아닌 상수라는 점을 알리게 된다.
// const val CONST_A = 1234 * 대문자와 언더바(_)만 사용함
// 이는 대부분의 언어에서 통용되는 방법이다.

// 실습 ㄱㄱ

// FoodCourt 라는 클래스를 만들어보자.
// 그리고 searchPrice 라는 함수는 음식 이름을 받아 가격을 출력해준다고 해보자.

// 그런데 이 클래스를 쓰는 사람들은 FoodCourt 에 어떤 음식 이름들이 있는지를 알 방법이 없다.
// 따라서 companion object 를 선언하여 내부에 searchPrice() 에서 사용할 음식 이름들을 상수로 선언해 주도록 한다.
// 이것이 상수가 가장 자주 사용되는 예다.

// 그리고 searchPrice() 안에서는 when 을 사용하여 상수로 정의된 각각의 음식에 맞는 price 를 변수에 반환 받아 보자.

// 이제 이 가격을 println 으로 음식이름과 함께 출력하자.


// main() 에서는 FoodCourt 의 객체를 만들고
// 음식 이름을 정의해 둔 FoodCourt 내의 상수들을 searchPrice()에 하나씩 넣어보자.

// 실행해보면 각각의 상수에 따라 음식 가격을 안내하는 것을 볼 수 있다.

// 이렇게 보면 기능적으로는 굳이 왜 변수를 사용하지 않고 상수를 별도로 사용하는지 궁금하지 않으신가요? 안궁금해.. 그래도 알아야겠지..
// 이는 변수의 경우 런타임시 객체를 생성하는데 시간이 더 소요되어 성능의 하락이 있기 때문이다.
// 따라서 늘 고정적으로 사용할 값은 상수를 통해 객체의 생성없이 메모리에 값을 고정하여 사용함으로서 성능을 향상시킬수 있다는 장점이 있다.

/*
fun main() {

    val foodCourt = FoodCourt()

    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
}

class FoodCourt {
    fun searchPrice(foodName: String) {
        val price = when(foodName)
        {
            FOOD_CREAM_PASTA -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 15000
            else -> 0
        }

        println("${foodName}의 가격은 ${price}원 입니다")
    }

    companion object {
        const val FOOD_CREAM_PASTA = "크림파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}

*/

// 늦은 초기화 에 대해서 알아보자.
// 코틀린에서는 변수를 선언할 때 객체를 바로 할당하지 않는 경우에는 기본적으로 컴파일이 되지않는데 var a: Int *자료형만 지정해두고 객체는 나중에 할당하면 안될까?
// 경우에 따라서는 변수에 객체를 할당하는 것을 선언과 동시에 할 수 없을 때도 있다.
// 이럴 때는 var 앞에 lateinit 을 사용하여 일단 변수만 선언하고 초기값의 할당은 나중에 할 수 있도록 하는 키워드 다. lateinit var a: Int
// lateinit var 변수의 제한사항    ->>lateinit 으로 지정한 var 변수는 초기값을 할당하기 전에는 변수를 사용할 수 없다는 제한이 있으며 기본자료형에는 사용할 수 없다.
// 초기값 할당 전까지 변수를 사용할 수 없음(에러발생)
// 기본 자료형에는 사용할 수 없음 (*String 클래스에는 사용가능)
// 또한 lateinit 변수의 '초기화'를 하였는지 여부를 확인할 때는 변수 이름앞에 콜론을 두 개 붙이고 점 isInitialized 라는 값을 확인해보면
// 초기화가 되었는지 확인하여 사용할 수 있으므로 오류를 막을 수 있다. ::a.isInitialized


// 실습 ㄱㄱㄱ


// LateInitSample 클래스를 하나 만들어 보자.
// 내부에 lateinit var 로 문자열 변수인 text 를 만들어 보자.
// 그리고 문자열을 반환하는 getLateInitText() 함수를 만들어 if문 안에서 text가 초기화 되었다면 그 값을 반환하고
// 초기화 되지 않았다면 "기본값"이라는 문자열을 반환하도록 해보자.

// main() 함수에서는 LateInitSample 클래스의 객체를 만들어 변수 a 에 할당하고
// a 에 getLateInitText() 함수를 실행하여 출력한 뒤
// 다시 a 의 text 속성에 "새로 할당한 값" 이라는 문자열을 넣어보자.
// 이제 다시 a의 getLateInitText() 를 실행하여 출력해보자.

// 실행해보면 변수가 초기화 되었는지 여부에 따라 값을 출력하는 것을 볼 수 있다.

/*
fun main() {

    var a = LateInitSample()

    println(a.getLateInitText())
    a.text = "새로 할당한 값"
    println(a.getLateInitText())

}

class LateInitSample {
    lateinit var text: String

    fun getLateInitText(): String {
        if(::text.isInitialized){
            return text
        } else {
            return "기본값"
        }
    }
}


*/

// 마지막으로 변수를 사용하는 시점까지 초기화를 자동으로 늦춰주는 '지연 대리자 속성(lazy delegate properties)'이라는 알아보자.
// val a: Int by lazy {7}
// 이는 lateinit 과 달리 val 변수에 by 라는 키워드를 사용하여 lazy 라는 람다함수 형태의 초기화 함수를 사용하는 형태로서
// 코드에서는 선언시 즉시 객체를 생성 및 할당하여 변수를 초기화하는 형태를 갖고 있지만 실제 실행시에는 val 변수를 사용하는 시점에
// 초기화 과정을 진행함으로서 코드의 실행 시간을 최적화 할 수 있는 코드이다!!
// val a: Int by lazy {7}
// ...
// println(a)   >>>>>> 이 시점에 7로 초기화 됨!!!!!

// 참고로 람다함수로 초기화가 진행되므로 함수안에 여러개의 구문이 들어갈 수 있으며 맨마지막 구문의 결과가 변수에 할당 됨을 알아두자
// val a: Int by lazy {
//  println("initializing")
//  7         >>> 이렇게 해도 어차피 값은 7 이 된다.
// }

// 실습 ㄱㄱ

// val 로 number 라는 Int 변수를 만들고 by lazy 뒤에 람다함수를 만들어보자.

// 초기화를 진행하는 시점을 확인하기 위해 println으로 "초기화를 합니다"라고 출력하고
// 다음줄에 7이라는 값을 적어 number에 7을 초기값으로 넣어보자.

// 이제 "코드를 시작합니다" 라고 출력하고  다음줄에 number를 출력해보자.
// 그리고 또 다시 number를 출력해보자.

// 실행해 보면 코드를 시작한 뒤 number를 처음 출력할 때 lazy 함수를 통해 초기화가 진행되었음을 알 수 있으며
// 두번째 number를 출력할 때는 이미 초기화를 했기 때문에 다시 초기화 구문을 실행하지 않음을 알 수 있다.



fun main() {

    val number: Int by lazy {
        println("초기화를 합니다")
        7
    }

    println("코드를 출력합니다")
    println(number)
    println(number)
}



// 상수, 늦은 초기화, 초기화의 지연은 상황에 따라 변수를 사용하는 방법을 조금 더 세세하게 조절할 수 있다는 장점이 있다.





