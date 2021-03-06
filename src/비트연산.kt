// kotlin 강좌 # 30 비트연산

// 다와간다.. 좀만 더 힘을...내자... 고지가 눈앞이다..

// 비트연산은 정수형 변수를 사람이 사용하는 10진법(173)으로 연산하는 대신 2진법(10101101)인 비트단위로 연산할 수 있는 기능

// 학교에서는 학술적인 부분을 알려주기 위해서 00001001 << 1 이렇게 하면 2배가 되고 00001001 >> 1 이렇게하면 반이 된다는 식...
// 시프트 연산등으로 수가 변하는 모습을 알려주면서 실제 10진법의 결과와 비교하는 식으로 가르쳐주지만


// 실무에서 비트연산은 거의 계산에는 사용하지 않으며 * 2진법을 이용한 연산 최적화가 필요하다면 컴파일러의 기능을 사용하는 경우가 대부분임
// 정수형의 값을 비트단위로 나누어 데이터를 좀 더 작은 단위로 담아 경제성을 높이기 위한 용도로 사용된다.

// 예를들어, 32비트인 인티저 타입안에 32개의 0과 1로된 서로 다른 값을 넣는 다거나 앞에 5비트와 뒤에 27비트에 서로 다른 값을 넣는 식으로
// 변수 하나에 여러개의 값을 담아 사용할 수 있는 것이다.

// 다만 비트연산을 사용하는 부하도 무시할 수 없으므로 주로 플래그 값을 처리하거나  * 플래그 값 : 여러개의 상태값을 0과 1로 담는 방법
// 네트워크 등에서 프로토콜의 데이터양을 줄이기 위해 자주 사용된다.

// 정수형 변수의 비트연산을 할 때는 좌측으로 갈 수록 상위비트. 우측으로 갈 수록 하위비트라는 점도 알아두자.

// 참고로 코틀린은 모든 정수형이 부호를 포함하므로 * 참고로 부호없는 정수형도 실험 중에 있다.
// '최상위 비트'를 마이너스인지 플러스인지를 표시하는 부호. 부호 비트로 사용하기 때문에 이 부분에는 데이터를 담지 않는 것이 좋다.
// '0'0010101001110101101111000001001 -> 최상위 비트는 0이면 양수 , 1이면 음수인 부호비트로 사용



// 비트를 밀어주는 bitwise shift operators 에 대해서 알아보자.
// 부호비트를 제외한 모든 비트를 좌측으로 원하는 만큼 밀어주는 기능 -> shl(shift left)   우측으로 밀어주는 기능 -> shr(shift right)
// 부호비트를 포함하여 모든 비트를 우측으로 밀어주는 기능-> ushr(unsigned shift right)



// 비트를 조적하는 일반적인 bitwise operators  비트와이트 연산자
// and 연산자는 원본과 비교대상의 값을 비트 단위로 비교하여 둘다 1인 경우 결과를 1로 반환 하며
// 1010 and 0110  비트가 둘다 1인 자리만 1로 반환함
// 결과값 0010
// or 연산자는 값을 비교하여 하나라도 1이면 1을 반환한다.
// 1010 or 0110
// 결과값 1110
// xor 연산자는 두 값을 비교하여 같으면 0, 다르면 1을 반환한다.
// 1010 xor 0110
// 결과값 1100


// and 연산자는 그 특성을 이용하여 두가지 기능으로 사용한다.
// 1. 비트를 확인하는 용도
// 원본  0110
//
// 비교값 0110
//      and   아래서 세번째 비트의 값만 알고 싶어!
// 결과값 0100

// 2. 비트를 clear 하는 용도
// 원본 0110
//    and
// 비교값 1100
// 아래 두개의 비트를 0으로 만들고 싶어!
// 결과값 0100

// or 연산자는 반대로  비트의 set 연산. 즉 비트값을 1로 설정하고 싶을 때 사용한다.
// 비트를 set하는 방법
// 원본 0110
//     or   상위  두개의 비트를 1로 만들고 싶어!
// 비교값 1100
// 결과값 1110

// 그리고 xor 연산자는 비교할 두 값이 비트별로 동일한지 확인하는 데에 사용한다.
// 비트들이 같은지 비교하는 방법
// 원본 0110
//    xor     내가 워하는 값과 비트들이 똑같을까?
// 비교값 1100
// 결과값 1010

// 마지막으로 비트를 반전하는 inv() 함수
// inv() 함수는 비트를 모두 반전시키는 역할을 한다. 0은 1로 1은 0으로되는것이지..
// 01101001  -> 10010110

// 실습 ㄱㄱ

// 먼저 bitData라는 Int 변수를 만들고 0b10000 으로(하위)다섯번째 비트에 1을 넣어보자

// 여기서 (하위)세번째 비트에 1을 set 해보자
// 1이라는 값을 shl을 사용하여 좌측으로 2번 밀어보자.
// 그리고 이 값을 bitData 와 or 연산하면 (하위) 세번째 비트가 set 되게 된다. * bitData or(1 shl 2) >>> ob10000 or 0b100
// 이 값을 다시 bitData 에 할당하도록 하죠. bitData = 0b10100

// 이제 bitData를 toString() 을 통해 2진수 형태의 문자열로 변경하여 출력하자.

// 다음은 and 연산을 통해 (하위) 다섯번째 비트에 있는 값을 꺼내어 사용해보자.
// 1이라는 값을 shl을 사용하여 좌측으로 4번 밀어보자.
// 그리고 이 값을 bitData와 and 연산하면     * bitData and(1 shl 4) >>> ob10100 or 0b10000
// (하위) 다섯번째 비트의 값을 제외한 나머지는 0이 된다.
// 이 값을 변수에 넣고 var result = 0b10000
// 바로 출력해보자.


// 우측으로 네번 밀어주면 원래의 값을 복원할 수 있겠지?

// 다음은 (하위) 다섯번째 비트에 있는 1을 clear 해보자.
// 이 때는 1이라는 값을 shl을 사용하여 좌측으로 4번 밀어준다.
// 그리고 이 값에 다시 inv() 함수를 사용하여 반전 시켜 준다.   * (1 shl 4).inv()  --> 0b01111
// 이것을 bitData와 and연산하면   * bitData and((1 shl4).inv())  --> 0b10100 and 0b01111
// 0으로 반전된 (하위) 다섯번째 비트만 clear 됩니다. bitData = 0b00100

// clear 가 잘 되었는지 한번 출력해보자.

// 마지막으로 현재 bitData가 10100과 같은지 비트별로 확인하기 위해 xor 연산을 하여 출력해보자.
// (하위) 다섯번째 비트만 다르기 때문에 10000이 출력될거라고 생각할 수 있다.


fun main() {

    var bitData: Int = 0b10000  // 지정되지 않은 상위 비트들은 0으로 채워진다.

    bitData = bitData or(1 shl 2)  // (1 shl 2) --> 0b100이 된다.
    println(bitData.toString(2))  // * 정수형의 경우 toString의 패러미터로 진법변환을 할 수 있다.

    var result = bitData and(1 shl 4) // (1 shl 4) --> ob10000이 된다.
    println(result.toString(2))

    println(result shr 4)  // (result shr 4) --> 0b1

    bitData = bitData and((1 shl 4).inv())     // (1 shl 4)  ---> 0b10000
    println(bitData.toString(2))

    println((bitData xor(0b10100)).toString(2))
}


// 비트연산은 아주 제하적인 경우에 사용되지만 반드시 알아야 할 중요한 연산이므로 꼭 기억해 두자!!