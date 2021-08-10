// kotlin 강좌 # 31 코루틴을 통한 비동기 처리

// 으아아아아!!!! 마지막 강의다다!!!!!! 고생했어 나!!!

// '비동기'로 여러개의 루틴을 동시에 처리할 수 있는 법을 알아보자.

// 여태까지 우리는 하나의 구문이 끝나면 다른 구문을 실행하는 식으로 모든 구문을 '동기적'으로 실행하였다.
// 하지만 '여러개의 루틴'을 동시에 실행하여 결과를 내고 싶다면 어떻게 해야할까? 바로 비동기 처리를 지원하는 코루틴!!을 사용하면 된다!!

// 코루틴 (coroutine) 은 메인이 되는 루틴과 별도로 진행이 가능한 루틴으로 개발자가 루틴의 실행과 종료를 마음대로 제어할 수 있는 단위다.

// 코루틴을 사용할 때는 코틀린익스텐션에 코루틴스 패키지를 모두 import 해야한다. -->> import kotlinx.coroutines.*

// 코루틴은 제어범위 및 실행범위를 지정할 수 있는데  이를 '코루틴의 Scope'라고 한다.
// 기본적으로 GlobalScope 와 CoroutineScope 를 지원한다.

// GlobalScope 는 프로그램 어디서나 제어, 동작이 가능한 기본 범위

// CoroutineScope 는 특정한 목적의 Dispatcher 을 지정하여 제어 및 동작이 가능한 범위

// Coroutine 의 Dispatcher ?  그게 뭐야?  ---> CoroutineScope 를 만들 때 적용가능한 Dispatcher

// Dispatcher.Default  기본적인 백그라운드 동작
// Dispatcher.IO  네트웍이나 디스크 등 I/O 에 최적화 된 동작
// Dispatcher.Main  메인(UI) 스레드에서 동작

// 이러한 Dispatcher 들은 모든 플랫폼에서 지원되지는 않으니 지원되는 플랫폼에 따라서 사용해야한다.

// 코루틴은 이러한 Scope 에서 제어 되도록 생성될 수 있는데 생성된 스코프에서 launch 나 async 라는 함수를 통해 새로운 코루틴을 생성할 수 있다.
// val scope = CoroutineScope(Dispatcher.Defaunt)
// val coroutineA = scope.launch{}
// val coroutuneB = socope.async{}

// launch 와 async 의 차이는 코루틴에서 반환값이 있는지의 여부!!

// launch 는 반환값이 없는 Job 객체

// async 는 반환값이 있는 Deffered 객체

// launch 와 async 는 모두 람다함수의 형태를 가지고 있으며 그렇기 때문에 async 는 마지막 구문의 실행결과가 반환된다!!

// launch{                              async{
//   for(i in 1..10) {                     var sum = 0
//     println(i)                          for(i in 1..10) {
//   }                                        sum++
// }                                        }
//                                          sum   --->> 반환
//                                      }


// 실습 ㄱㄱ


// 먼저 import kotlinx.coroutines.* 를 선언하여 코루틴 관련 라이브러리를 import 한다.

// 그리고 GlobalScope 를 변수 scope 에 받은 후
// 이 scope에서 launch 로 Job 객체의 코루틴을 하나 만들어보자.
// 내용은 for 문을 통해 1부터 5까지 반복하며 숫자를 출력하도록 하자.

// 실행해볼까? 이상하지? 안나오지? 이 결과는 당연하다. why? -> 코루틴은 제어되는 스코프 또는 프로그래 전체가 종료되면 함께 종료되기 때문에
// 코루틴이 끝까지 실행되는 것을 보장하려면 일정한 범위에서 코루틴이 모두 실행될 때까지 잠시 기다려주어야한다.
// 우리가 테스트하는 루틴의 경우 main()함수 단 하나이기 때문에 프로세스가 거의 "실행 즉시 종료" 되므로 코루틴도 동작되지 못한 것이다.
// 이럴때는 runBlocking 블럭을 만들고 이 안에서 launch{} 나 async{}를 직접 생성하면 코루틴이 종료될 때까지 메인 루틴을 잠시 대기시켜준다.
// runBlocking {
//   launch{}
//   async{}
// }

// 주의할 점은 안드로이드에서는 메인 스레드에서 runBlocking 을 걸어주면 일정시간이상 응답이 없는 경우 ANR이 발생하며 * ANR : Application Not Responding : 응답없음 오류
// 앱이 강제 종료 된다는 점을 유의하자.

/*

import kotlinx.coroutines.*

fun main() {

    val scope = GlobalScope

    scope.launch {
        for(i in 1..5)
        {
            println(i)
        }
    }

}

*/

// 새로 실습 ㄱㄱ

// runBlocking 블럭을 생성하고 launch 를 직접 생성하여 아까처럼 1부터 5까지 반복하며 숫자를 출력해보자.

// 실행해보면 끝까지 출력됨을 알 수 있다. 안되는데...?

/*
import kotlinx.coroutines.*

fun main() {

    runBlocking {
        launch {
            for(i in 1..5) {
                println(i)
            }
        }
    }


}
*/


// 루틴의 대기를 위한 추가적인 함수들도 있는데 delay(), join(), await() 등이 있다.

// delay(milisecond: Long) 는 milisecond 단위로 루틴을 잠시 대기시켜주는 함수

// join()은 job 객체에서 호출하여 Job.join() Job의 실행이 끝날떄까지 대기하는 함수

// await()는 Deffered 객체에서 호출하여 Deffered.await()  Deffered 의 실행이 끝날때까지 대기하는 함수
// await() 는 Deffered 객체의 결과값도 반환함

// 세 함수들은 코루틴 내부 또는 runBlocking{} 과 같은 루틴의 대기가 가능한 구문 안에서만 동작이 가능하다.

// 실습 ㄱㄱ

// 일단 launch 로 실행된 Job 객체를 변수 a에 받아보자.
// 그리고 launch 함수의 동작을 일부러 늦추기 위해 for 문 안에 delay를 10정도 넣어보자.

// 그리고 async 로 새로운 Deffered 객체를 생성하여 변수b 에 받아보자.

// async 안에서는 간단하게 "async종료" 라는 문자열을 반환해보자.


// 그리고 메인루틴에서 "async 대기" 라는 문자열을 출력하고
// b 에 await() 를 걸어준 결과를 출력해보자.

// 그리고 "launch 대기" 라는 문자열을 출력한 뒤
// a 에 join()을 걸어 대기한 후

// 다시 "launch 종료" 라는 문자열을 출력해보자.

// 실행해보면 async의 결과를 기다린 후 await() 함수에서 결과를 받아 출력하고
// 다시 launch 가 끝까지 수행 되기를 기다린 후 launch 가 종료되었음을 출력하는 것을 볼 수 있다.

/*
import kotlinx.coroutines.*

fun main() {

    runBlocking {
        val a = launch {
            for(i in 1..5)
            {
                println(i)
                delay(10)
            }
        }

        val b = async {
            "async 종료"
        }

        println("async 대기")
        println(b.await())

        println("launch 대기")
        a.join()
        println("launch 종료")
    }


}
*/

// 코루틴 실행 도중에 중단 하는 방법도 알아보자. cancel()함수!

// 코루틴에 cancel() 을 걸어주면 다음 두가지 조건이 발생하며 코루틴을 중단시킬 수 있다.

// 1. 코루틴 내부의 delay() 함수 또는 yield()함수가 사용된 위치까지 수행된 뒤 종료됨
// 2. cancel()로 인해 속성인 isActive 가 false 되므로 이를 확인하여 수동으로 종료함.


// 실습으로 다시 ㄱㄱ

// "launch 대기" 대신 "launch 취소" 를 출력하고
// a.join() 대신 a.cancel()을 수행해보자.

// 실행해보면 아까와 달리 코루틴의 작업이 중간에 취소되어 숫자가 끊기는 것을 볼 수 있다.


import kotlinx.coroutines.*

fun main() {

    runBlocking {
        val a = launch {
            for(i in 1..5)
            {
                println(i)
                delay(10)
            }
        }

        val b = async {
            "async 종료"
        }

        println("async 대기")
        println(b.await())

        println("launch 취소")
        a.cancel()
        println("launch 종료")
    }


}



// 마지막으로 제한시간 내에 수행되면 결과값을 아닌 경우 null 을 반환하는 withTimeoutOrNull() 함수를 알아보자.

// 이것은 괄호안에 밀리세컨드 단위의 타임아웃 시간을 정해두고 중괄호 안에 코루틴 구문들을 만든 후 그 결과값을 받는 형태로 사용한다.
// withTimeoutOrNull(50){
//   for(i in 1..1000){
//     println(i)
//     delay(10)
//   }
//   "Finish"
// }
// 이 함수도 join() 이나 await() 처럼 blocking 함수라는 점을 기억하자.



// 새로 실습 ㄱㄱ


// runBlocking 블럭을 만들어보자.
// 그리고 withTimeoutOrNull() 에 timeout 값으로 50ms를 주고
// for문을 이용해 1부터 10까지 출력해보자.

// 실행속도를 일부러 늦추기 위해 delay 를 10 넣어보자
// 그리고 끝났다는 의미로 "Finish"를 반환해보자.

// 결과값은 result로 받자.

// 마지막으로 result 값을 출력해보자.


// 실행해보면 timeout 내에 수행할 수 없어 null 이 출력되는것을 볼 수 있다.


import kotlinx.coroutines.*

fun main() {

    runBlocking {
        var result = withTimeoutOrNull(50) {
            for(i in 1..10){
                println(i)
                delay(10)
            }
            "Finish"
        }

        println(result)
    }
}





// 끝....






