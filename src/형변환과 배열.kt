// 코틀린 강좌 #3 - 형변환과 배열

// 형변환 ( Type casting )
// 형변환이란 하나의 변수에 지정된 자료형을 호환되는 다른 자료형으로 변경하는 기능
// 숫자형 : Byte, Short, Int, Long, Float, Double
// 문자형 : Char       ***** 논리형은 변환할 수 없음

// 기본 자료형들은 자료형 간의 형변환을 지원하기 위해 "형변환 함수 (type casting function)"을 제공
// toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()
// to 뒤에 변환될 자료형을 붙인 이름을 갖고 있다.

// kotlin 에서는 그냥 할당만 해서는 변환되지 않는다.
/*
fun main() {
    var a: Int = 54321
    var b: Long = a
}
*/
// Type mismatch: inferred type is Int but Long was expected ( 자료형이 맞지 않는다는 에러)

/*
fun main(){
    var a: Int = 54321
    var b: Long = a.toLong()
}
*/
// 반드시 Int형 변수의 toLong() 함수를 호출하여 Long 값으로 변환된 값을 '반환 받아' Long 변수에 할당 해 줘야한다.
//------>> 이것을 전문용어로 """ 명시적 형변환 ( explicit type casting ) """ 이라고 한다.
// 참고로 kotlin 은 형변환시 발생할 수 있는 오류를 막기 위해 다른 언어들이 지원하는 '''암시적 형변환''''은 지원하지 않는다.

// 명시적 형변환(explicit type casting)은 '변환될 자료형'을 '개발자가 직접 지정'함
// 암시적 형변환은 변수를 할당할 시 자료형을 지정하지 않아도 '자동으로 변환'됨

//** 형변환시 호환이 가능한지 여부를 체크하여 변환여부를 확인할 수 있는 방법은 클래스를 배울때 추후 다시 알아봅시다.



//////  배열 ( array )
// 배열은 내부적으로  array<T> 클래스로 제공되는 기능                     <T> -->>> 제너릭

// 배열로 사욜할 변수를 만들어 주고 arrayOf 함수를 통해 배열에 저장할 값들을 나열하면 됩니다.
// 혹시라도 '특정한 크기의 공간'을 가지는 "비어있는 배열"을 만들고 싶다면 arrayOfNulls 함수에 크기를 지정하면 null로 채워진 배열이 만들어진다.
// arrayOfNulls 함수에는 꺾쇠( <> ) 가 들어간다.꺾쇠 안에는 배열에 할당할 자료형을 지정해 주면 된다. --->>> 이를 "Generic" 이라 한다.
// 배열에 값을 할당하거나 사용하려면 어떻게 해야하나?
// --> 다른 언어들 처럼 배열 이름 뒤에 대괄호를 쓰고 intArr[2] 그안에 참조할 index를 쓰면 된다. **index는 배열내의 데이터 순번이며, 0부터 시작
// 이렇게 하면 변수처럼 해당 index 위치에 값을 할당할 수도 할당된 값을 사용할 수도 있다.

// 배열은 처음 선언했을때의 전체 크기를 변경할 수 없다는 단점이 있지만 한 번 선언을 해두면 다른 자료구조보다 빠른 입출력이 가능하다는 장점이 있다.


fun main() {
    var intArr = arrayOf(1,2,3,4,5)
    var nullArr = arrayOfNulls<Int>(5)

    intArr[2] = 8

    println(intArr[4])


}

