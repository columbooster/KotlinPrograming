// kotlin 강좌 # 20 리스트

// 데이터를 코드에서 지정한 순서대로 저장해두는 List

// List는 '데이터를 모아 관리'하는 collection 클래스를 상속받는 서브클래스중 가장 단순한 형태로
// 여러개의 데이터를 원하는 순서로 넣어 관리하는 형태.

// 리스트에는 두가지가 있는데 그냥 List<T>와 뮤터블리스트 MutableList<T>가 있다.

// 두 클래스의 차이는 이름에 붙은 Mutable이 말해주듯이 *Mutable : 변할 수 있는

// List<T>의 경우 생성시에 넣은 객체를 대체,추가,삭제할 수 없음
// MutableList<T>의 경우 생성시에 넣은 객체를 대체,추가,삭제가 가능함  >> 상황에 맞춰 둘중 사용하면 된다.

// 리스트를 만들 때는 전용함수인 listOf(1,2,3)나 mutableListOf("A","B","C")를 쓰고 괄호 안에 리스트에 담을 데이터요소를 나열하면 된다.
// 또한 MutableList에서는 요소의 추가 add(데이터) add(인덱스,데이터) , 삭제 remove(데이터) removeAt(인덱스) 를 위한 함수 외에도
// 요소를 무작위 섞기 shuffle() , 정렬 sort() 하는 함수도 사용할 수 있으며

// 당연히 특정위치의 요소를 다른요소로 대체도 가능하다. list[인덱스] = 데이터

// 실습 ㄱㄱㄱ


// 먼저 listOf로 리스트를 만들어 사과,딸기,배를 넣고 이 리스트를 변수 a에 할당하자.
// 이제 특정 인덱스의 요소를 출력해보자.  ** 배열과 사용법이 똑같다는 것을 알 수 있다.

// 리스트의 모든요소를 출력해보자
// for 문에서 키워드 in을 사용하면 리스트의 순서대로 '하나씩 꺼내어 출력'이 가능하다.
// 실행해 보면 1번 인덱스의 딸기가 출력되고 이어서 모든요소가 출력된다.

// 다음 코드를 만들기 전에 일단 출력에서 '한줄을 떼기 위해' println을 아무것도 넣지않고 추가 해보자.

// 이번엔 mutableListOf로 리스트를 만들어 6,3,1을 넣고 변수b에 할당하자
// 이번엔 println에서 b를 그대로 출력해보자.

// 다음엔 b에 add함수로 리스트 맨 뒤에 4를 추가해보자
// 추가가 정상적으로 됐는지 b를 출력하여 확인해보자.

// 이번엔 b에 add함수를 쓰되 인덱스 2번 자리에 8을 삽입해보자.
// 다시 b를 출력해보자

// 이제 removeAt함수로 인덱스 1번의 요소를 삭제 해보자
// 이번에도 b를 출력해보자.

// suffle함수로 무작위로 섞어보자

// sort를 사용하면 순서대로 정렬이 된다.



fun main() {

    var a = listOf("사과","딸기","배")
    println(a[1])

    for(fruit in a) {
        print("${fruit}:")
    }

    println()

    var b = mutableListOf(6,3,1)
    println(b)

    b.add(4)
    println(b)

    b.add(2,8)
    println(b)

    b.removeAt(1)
    println(b)

    b.shuffle()
    println(b)

    b.sort()
    println(b)


}

// 추가, 삽입, 삭제, 셔플, 정렬이 잘 실행된것을 볼 수 있다.



// 리스트는 목록이 필요한 모든 코드에서 가장 편리하게 사용할 수 있는 컬렉션이므로 꼭 사용 잘하자!
