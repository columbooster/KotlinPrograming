// kotlin 강좌 # 28 컬렉션 함수 2

// 지난 영상에서 알아보지 않은 나머지 컬렉션 함수에 대해서 알아보자

// 이제 좀 더 복잡한 기능의 컬렉션 함수들을 알아보자. 하.... 지금도 복잡한데...

// associateBy 함수    -> 아이템에서 key를 추출하여 map으로 변환하는 함수
// 어쏘시에이트바이 라는 함수는 객체에서 key를 따로 뽑아내서 map으로 만드는 함수
// 예를들어 , 이름과 태어난 해가 들어간 person 객체들이 있고 이를 list에 넣어두었다고 해보자.
// 이 list를 이름을 key로 하고 객체를 value로 하는 map으로 변경하려면 associateBy의 중괄호 안에 이름 속성을 넣어주면 자동으로 map으로 변환하여 반환해준다.
// collection.associateBy{it.name}

// groupBy 함수     --> key 가 같은 아이템끼리 배열로 묶어 map으로 만드는 함수
// 특정한 값을 t로 지정하여 해당값을 가진 객체끼리 묶은 배열은 value로 하는 map을 만들어 주는 기능이다.

// partition 함수   --> 아이템에 조건을 걸어 두개의 컬렉션으로 나누어 줌
// 파티션은 아이템에 조건을 걸어 true 인지 false 인지에 따라 두 컬렉션으로 나누어 준다.
// collection.partition{it.birthYear>2002}
// 두 객체를 담을 수 있는 Pair라는 클래스 객체로 반환되므로 각각의 컬렉션을 first, second로 참조하여 사용하면된다.
// 또는 pair를 직접 받아줄 수 있도록 변수 이름을 괄호안에 두개 선언해주면 각각의 변수 이름으로 받을 수 있다.
// val (over2002, under2002) =
// collection.partiton{it.birthYear > 2002}


// 이 3 함수에 대한 실습 ㄱㄱ


// data class Person을 만들고 이름과 태어난 년도를 받아보자.
// 리스트에 유나,1992, 조이,1996,츄,1999,유냐,2003인 네명의 person 객체를 넣어보자.

// associateBy로 person 객체의 년도를 기준으로 map을 만들어 출력하자.
// 그리고 grouBy로 person객체의 이름을 기준으로 묶어 map을 만들어 출력해보자.

// 그다음 partition에서 pesron객체의 년도가 1998보다 큰지를 비교하여 리스트를 나눠보자.

/*
fun main() {

    data class Person(val name: String, val birthYear: Int)

    val personList = listOf(Person("유나",1992), Person("조이",1996),
    Person("츄",1999),Person("유나",2003))

    println(personList.associateBy{it.birthYear})
    println(personList.groupBy { it.name })

    val (over98, under98) = personList.partition { it.birthYear > 1998 }
    println(over98)
    println(under98)
}

*/

//  flatMap() 함수    -->> 아이템마다 만들어진 컬렉션을 합쳐서 반환하는 함수
// 중괄호 안에서 아이템마다 새로운 컬렉션을 생성하면 이를 합쳐서 하나의 컬렉션으로 반환해준다.
// collection.flatMap {
// listOf(it*3, it+3) }


// getOrElse() 함수 --> 인덱스 위치에 아이템이 있으면 아이템을 반환하고 아닌 경우 지정한 기본값을 반환하는 함수
// 괄호안에 지정한 인덱스에 객체가 존재하는 경우 해당 해당객체를 반환하고, 없는 경우 중괄호 안에 객체를 반환해준다.


// zip 함수  --> 컬렉션 두 개의 아이템을 1:1로 매칭하여 새 컬렉션을 만들어 줌
// collectionA zip collection B
// 두 컬렉션에 포함된 아이템을 1:1로 pair 클래스의 객체로 만들어 list에 넣어 반환해준다.
// 이 때, 결과 List의 아이템 개수는 더 작은 컬렉션을 따라가게 된다.

// 실습 ㄱㄱ

// 정수값 -3,7,2,-10,1을 가진 numbers 리스트를 만들어보자.

// 이제 이 리스트에서 flatMap을 적용하여 개별 아이템에 곱하기10, 더하기10을 한 리스트를 새로 만들어 출력해보자.

// 이번엔 리스트에 getOrElse 라는 함수를 사용하여 index 1 번 아이템이 없는 경우 50
// index 10번 아이템이 없는 경우에도 50 을 반환하도록 각각 출력해보자.

// 이제 A,B,C,D라는 문자열을 가진 names 리스트를 만들어보자.
// 그리고 names와 numbers 를 zip을 하여 줄력해보자.


fun main() {

    val numbers = listOf(-3,7,2,-10,1)

    println(numbers.flatMap { listOf(it*10, it+10) })

    println(numbers.getOrElse(1){50})
    println(numbers.getOrElse(10){50})

    val names = listOf("A","B","C","D")

    println(names zip numbers)  // * 숫자 1은 짝이 맞지 않으므로 제외된다.
}

// 이렇게 컬렉션 함수는 데이터의 조작을 더 수월하게 만들수 있는 다양한 기능을 갖고 있으므로 컬렉션에 담긴 데이터를 다룰 때는 꼭 이용해보자!






