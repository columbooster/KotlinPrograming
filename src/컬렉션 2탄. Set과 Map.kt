// Kotlin 강좌 # 26 컬렉션 2탄! Set 과 Map

// 코틀린이 기본적으로 지원하는 컬렉션 클래스인 Set과 Map을 알아보자.

// class Collection -> class List, class Set, class Map


// 지난 20화 강의에서 컬렉션 클래스 중 가장 단순한 형태인 list 를 알아보았다.

// Set 은 List 와 달리, 순서가 정렬되지 않으며 중복이 허용되지 않는 컬렉션이다.
// 따라서 Set 은 인덱스로 위치를 지정하여 객체를 참조할 수는 없으며 contains로 객체가 set안에 존재하는지를 확인하는 식으로만 사용한다.
// SampleSet.contains("디모") -->> sampleSet에 디모가 있는지 알려줘.

// set 역시 set<out T>  MutableSet<T> 이 존재하는데 List와 마찬가지로 객체의 추가, 삭제가 가능한지 여부에 따라 사용하게 된다.
// 그리고 요소의 추가는 add (데이터), 삭제는 remove ) 데이터 함수를 사용하게 된다.

// 실습 ㄱㄱ

// mutableSetOf() 로 귤,바나나,키위를 a라는 변수에 Set으로 만들어보자.

// for 문을 사용하여 Set의 모든 객체를 꺼내서 출력해보자.

// 그리고 add() 함수를 사용하여 "자몽"을 추가하고 println으로 a를 출력해보자.

// 다시 remove() 함수를 사용하여 "바나나"를 삭제한 후 println으로 a를 출력해보자.

// 이번에는 contains() 함수로 "귤"이 존재하는지를 확인해 보자.

// 실행해보면 객체의 추가, 삭제, 확인이 잘 싱핼되었음을 알 수 있다.

/*

fun main() {

    val a = mutableSetOf("귤","바나나","키위")

    for(item in a) {
        println("${item}")
    }

    a.add("자몽")
    println(a)

    a.remove("바나나")
    println(a)

    println(a.contains("귤"))

}

*/

// Map 은 객체를 넣을 때 그 객체를 찾아낼 수 있는 Key를 쌍으로 넣어주는 컬렉션이다.

//     key           와       value         즉 객체는 내부적으로는 MutableMap.MutableEntry에 객체로 담겨져 있으며
// 객체를 찾기위한 값          key와 연결된 객체

// 이런 구조 때문에 객체의 위치가 아닌 고유한 키를 통해 객체를 참조하는 특징을 가지고 있다.
// sampleMap["디모"]  --->  디모라는 key에 연결된 객체를 알려줘

// 또한 같은 key에 다른 객체를 넣으면 기존의 객체가 대체되니 주의해서 사용하자!!

// Map<K, out V> 역시 추가 ,삭제가 가능한 MutableMap<K,V> 이 별도로 존재하며
// 요소의 추가는 put (키, 값) 삭제는 remove (키) 로 하게 된다.

// 실습 ㄱㄱㄱ


// mutableMapOf()로 key "레드벨벳"에 "음파음파", key 트와이스에 Fancy, 키 Itzy에 ICY를 a라는 변수에 넣어보자.

// 각각 key와 value를 to 로 이어주는 것을 볼 수 있다.

// for 문으로 하나씩 꺼내어 출력해보자.
// 앞서 배웠듯이 MutableMap.MuableEntry 객체로 들어있기 때문에 속성인 key 와 value 를 출력하면 된다.

// put()을 통해 새 key 와 객체를 넣어볼까?
// 오마이걸에 번지를 넣어보고 a를 출력해보자.

// 그리고 remove()로 ITZY라는 key를 가진 객체를 삭제하고 a를 출력해보자

// 또한 "레드벨벳"이라는 key를 마치 배열을 참조하듯 map의 인덱스 형태로 참조해서 출력해보자.

// 출력해보면 객체의 추가, 삭제, 참조가 잘 실행된것을 볼 수 있다.


fun main() {

    val a = mutableMapOf("레드벨벳" to "음파음파", "트와이스" to "FANCY","ITZY" to "ICY")

    for(entry in a){
        println("${entry.key}:${entry.value}")
    }

    a.put("오마이걸","번지")
    println(a)

    a.remove("ITZY")
    println(a)

    println(a["레드벨벳"])
}


// 20화와 26화에 걸쳐 코틀린이 제공하는 컬렉션 3가지를 알아보았는데

// 이 컬렉션은 그 자체로도 중요하지만 다음에 설명드릴 컬렉션 함수와 같이 사용할 때 더욱 유용하다.





