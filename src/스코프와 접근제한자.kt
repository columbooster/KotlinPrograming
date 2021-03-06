// kotlin 강좌 # 13 변수,함수,클래스의 접근범위와 접근제한자

// 지난 강의에서 우리는 프로젝트의 기본 구조를 배웠지 ?

// 이번 강의에서는 그 구조내에서 변수나 함수, 클래스의 '공용범위'를 제어하는 단위인 "스코프"와 스코프 외부에서 스코프 내부로의 접근을 제어하는 "접근제한자" 알아보자

// 스코프( scope ) 는 '범위'라는 뜻 그대로 언어 차원에서 변수나 함수, 클래스 같은 '멤버'들을 서로 공유하여 사용할 수 있는 범위를 지정해둔 단위
// 스코프가 지정되는 범위는 패키지 내부, 클래스 내부, 함수 내부등이 있다.
// 예를들어, 하나의 패키지 안에 변수,함수,클래스가 있다면 그것들은 모두 하나의 스코프 안에 있는 멤버들이지만 다시 그안에 있는 함수나 변수등이 있다면
// 패키지 스코프안에 또다른 하위 스코프로 동작하게 된다.

// 스코프에 대한 3가지 규칙을 알아보자
// 1. 스코프 외부에서는 스코프 내부의 멤버를 '참조 연산자'로만 참조가 가능합니다.
// -> 클래스의 멤버를 참조할 때 클래스 외부에서 인스턴스 명에 참조연산자를 사용하여 접근했었다. ex) a.eat()
// -> 하나의 패키지에서 다른 패키지 내의 멤버를 참조할 때도 import를 사용하거나 직접 참조연산자를 사용했어야했다.

// 2. 동일 스코프 내에서는 멤버들을'공유'할 수 있다.
// ex) 지난 시간에 파일에 package를 명시하지 않으면 default paclage라고 했었지? 이 상태에서 만드는 모든 멤버들은 같은 패키지 스코프에 포함.
// 먼저 변수 a를 하나 만들어보자. 그리고 클래스 B를 만들고 print라는 함수를 만들어서 변수a를 출력해보자.
// 이번엔 main 함수를 만들어서 그 안에서 변수 a를 출력하고 클래스 B의 인스턴스를 만들어 print를 실행해보자.
// 실행해보면 변수 a는 클래스 B나 main 함수에 속해 있지는 않지만 통일한 스코프 내에서 변수를 공유하여 사용할 수 있는것을 볼수있다.

/*
val a = "패키지 스코프"

class B {
    fun print() {
        println(a)
    }
}

fun main() {
    println(a)
    B().print() // 인스턴스를 변수에 담지않고 이렇게 바로 사용할 수 도 있다.
}
*/


// 3. 하위 스코프에서는 상위 스코프의 멤버를 재정의 할 수 있다.
// -> 원래 스코프의 같은 레벨에서는 같은 이름의 멤버를 만들어서는 안된다.
// ex ) a라는 변수를 두번 선언하면 var a = "너두나두" var a = "야나두" conflicting declaration 컨플릭팅에러가 난다.(선언부가 서로 충돌한다는 뜻)
// 하지만 하위 스코프에서는 같은 이름의 멤버를 만들어 사용할 수 있다.
// ex) 메인 함수 안에 변수 a를 값을 다르게 하여 새로 만들어보자. 클래스 B 안에도 같은 작업을 해보자
// 실행해보면 상위 스코프에 있던 변수 a를 참조 하지 않고 각각의 스코프에 있는 값을 참조한다.
/*
val a = "패키지 스코프"

class B {
    val a = "클래스 스코프"
    fun print() {
        println(a)
    }
}

fun main() {
    val a = "함수 스코프"
    println(a)
    B().print()
}
*/
// 스코프 외부에서 스코프 내부로 접근하려면 참조 연산자를 사용한다고 했었재?
// 이제 부터 알아볼 접근제한자 ( Access Modifier ) 는 이렇게 스코프 외부에서 스코프 내부에 접근할 때 그 권한을 '개발자가 제어'할수 있는 기능.
// 접근 제한자에는 public, internal, private, protected 가 있다.
// 이 접근 제한자들은 변수,함수,클래스 선언시 맨 앞에 붙여 사용한다. private var a = "..." public fun b {...} internal class C {...}
// 상황에 따라 두가지 경우로 기능이 나뉘는데
// 패키지 스코프에서는 public(기본값) 어떤 패키지에서도 접근 가능한 멤버, internal은 같은 모듈 내에서만 접근 가능멤버, private은 같은 파일내에서만 접근가능
// portected는 는 패키지 스코프에서는 사용하지 않는다.
// 클래스 스코프에서는 public(기본값) 클래스 외부에서 늘 접근가능, private 클래스 내부에서만 접근 가능, protected는 클래스 자신과 상속받은 클래스에서 접근가능
// intenal은 클래스 스코프에서는 사용하지 않는다.


// 스코프는 멤버들의 가용 범위를 지정해 둔 단위로 개발자는 의도에 따라 스코프 안에 변수나 함수, 클래스를 배치할 수 있으며
// 접근 제한자는 이러한 스코프의 외부와 내부에서 사용할 멤버를 분리하여 스코프 외부에서 건드리지 말아야 할 기능이나 값들을 안전하게 제한하는 용도
