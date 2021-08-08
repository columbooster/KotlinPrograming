// kotlin 강좌 # 27 컬렉션함수 첫번째!

// 컬렉션에 사용할 수 있는 여러가지 유용한 함수를 알아보자.

// 여태까지 우리는 컬렉션을 for 문으로 반복하여 포함된 아이템을 하나하나 꺼내어 사용했다. for(item in collection)

// 하지만 코틀린은 함수형 언어의 특징을 가지고 있기 떄문에 좀 더 편리하게 컬렉션을 사용할 수 있다.

// 컬렉션 함수는 list나 set, map과 같은 컬렉션 또는 배열에 일반 함수 또는 람다 함수 형태를 사용하여
// for문 없이도 어아탬울 순회하며 참조하거나 조건을 걸고, 구조의 변경까지 가능한 여러가지 함수를 지칭한다.
// 컬렉션 함수의 동작예를 하나 살펴보자.

//  forEach 라는 함수가 있는데 이는 컬렉션 객체에 사용하게 되면 중괄호 안에서 컬렉션에 포함된 모든 모든 아이템을 it 이라는 변수로 순서대로 참조할 수 있다.
// collection.forEach {
//  printlb(it)  }
// 예제와 같은 경우 list에 들어있는 모든 객체를 순서대로 출력하게 된다.

// 이렇게 단순히 반복만 하는 함수도 있지만 특정한 조건을 걸 수도 있다.
// filter 라는 함수는 중괄호 안에서 it에 조건을 걸어주면 조건에 맞는 객체만 다시 컬렉션으로 만들어서 반환해주는 기능을 가지고 있다.
// collection.filter {
//   it < 4   }

// map 이라는 함수는 중괄호 안에서 it에 수식을 적용하여 값을 변경하면 그 값을 컬렉션으로 만들어 반환해주게 된다. 일괄적으로 값을 변경할 수 있다.
// collection.map {
// it*2    }


// any, all, none 이라는 함수가 있는데 이는 중괄호안에서 it에 조건을 걸어주면 조건에 따라 boolean 값이 true를 반환해준다.
// collection.any{it == 0}   하나라도 조건에 맞으면 true
// collection.all{it == 0}   모두 조건에 맞으면 true
// collection.none{it == 0}  하나도 조건에 맞지 않으면 true


// first 라는 함수는 일반 함수로 사용하는 경우 첫번째 객체를 반환하지만  collection.first()  컬렉션의 첫번째 아이템을 반환
// 람다함수의 형태로 중괄호 안에 it에 조건을 걸어주면 조건에 맞는 첫번째 객체를 반환하며 collection.first{it > 3} 조건에 맞는 첫번째 아이템을 반환

// last 함수는 마지막 객체를 반환한다. collection.last{it > 3} 조건에 맞는 마지막 아이템을 반환

// first 는 find 라는 함수로 대체할 수 있으며 first -> find
// last 는 findLast 라는 함수로 대체 가능 last -> findLast

// first 와 last 함수를 사용할 때 문제가 생길 수도 있는데 "바로 조건에 맞는 객체가 없는경우"(=컬렉션이 비어있는 경우)
// NoSuchElementException 이 발생할 수 있다.
// 이 때는 firstOrNull 또는 lasOrNull을 사용하면 객체가 없는 경우 'null'을 반환해 준다.


// count 함수는 그냥 일반함수로 사용하면 포함된 모든 아이템 개수를 반환하는데  collection.count()  컬렉션의 모든 아이템 개수를 반환
// 중괄호와 함께 it 에 조건을 걸어주면 조건에 맞는 아이템 개수만 반환해준다. collection.count { it > 7 } 조건에 맞는 아이템의 개수 반환

// 여태까지 알아봤듯이 컬렉션 함수들을 사용하면 반복문과 조건문을 사용하는 경우를 대부분 대체할 수 있다는 장점이 있다.

// 실습 ㄱㄱ

// 박수영,김지수,김다현,신유나,김지우 라는 이름이 들어간 문자열 리스트를 만들어보자.

// 먼저 forEach를 통해 아이템을 차레로 표시해보자.

// 그리고 filter를 걸어 김씨 성을 가진 사람만 startsWith()함수를 사용하여 별도의 리스트를 만들어 출력해보자.

// 다음은 map 함수를 사용하여 각각에 이름앞에 "이름:"을 붙인 리스트를 만들어 출력해보자.

// 이번엔 any 를 사용하여 김지연이라는 이름을 가진 사람이 하나라도 있는지 Boolean 값으로 출력하자.
// 다음은 all 을 사용하여 이름이 모두 3글자인지 Boolean 값으로 출력해보자.
// 그리고 none을 사용하여 이씨 성을 가진 사람이 하나도 없는지를 Boolean 값으로 출력하자

// 이번엔 first 에서 김씨 성을 가진 첫번째 사람을 반환받아 출력해보고
// 다음은 last 에서 김씨 성을 가진 마지막 사람을 반환받아 출력해보자.

// 마지막으로 count 함수를 사용하여 이름에 "지"라는 글자가 들어가는 사람을 세어보자.

fun main() {

    val nameList = listOf("박수영","김지수","김다현","신유나","김지우")

    nameList.forEach{ print(it + " ")}
    println()

    println(nameList.filter { it.startsWith("김") })

    println(nameList.map{ "이름: " + it})

    println(nameList.any{ it == "김지연"})
    println(nameList.all{it.length == 3 })
    println(nameList.none{it.startsWith("이")})

    println(nameList.first{it.startsWith("김")})
    println(nameList.last{it.startsWith("김")})

    println(nameList.count{it.contains("지")})

}

// 컬렉션 함수는 람다 함수를 사용하여 컬렉션을 좀 더 편리하게 조작할 수 있는 장점을 가진 함수로 경우에 따라
// 반복문과 조건문 대신 사용하면 아주 편리하다.
