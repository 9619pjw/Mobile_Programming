package com.example.kotlinprojects.chap04
// 코틀린에서는 기본적으로 모든 type에 null값을 직접 넣는것을 허용하지 않음
// null 값을 허용하려면 type에 ?를 붙여 null이 가능한 변수(nullable type)임을 명시적으로 표현
fun main(){
    val s1 : String? = null
    val s4 : String = "Kotlin"
    val s5 : String? = s4

    var s6 : Int? = null
    s6 = 100

    val s7: String? = "Kotlin"
// null 값이 들어올 수 있는 nullable type의 변수를 사용할 때는
// 반드시 null check를 한 후 사용해야함 ... null check 없이 사용시 컴파일 error 발생

    if(s7 != null) println(s7.length) // 스마트 캐스트 ... 변수 s7이 null 아니라는 것을 컴파일러가 인식하고,
                                      // String 타입으로 캐스팅하여 s7.length 속성 처리

    println(s7?.length)
    // ?. <- safe call 연산자. 객체의 속성이나 함수를 안전하게 참조 또는 호출할 수 있음.
    // s7의 값이 null이 아닐때만 s7?.length 실행 null이면 null 반환

    var s8: String? = "코틀린을 배우자"
    println(s8?.substring(5)?.length)

    if (s8 != null){
        val b : String? = s8.substring(5)
        if(b != null){
            println(b.length)
        }
    }

    // ?: <- 엘비스 연산자
    // 연산자의 왼쪽 피연산자가 null이 아니면 그 피연산자의 결과값을 반환하고,
    // null인 경우 오른쪽 피연산자의 결과값을 반환

    val s9 = s8?.length?:0
    println("s9 : $s9")

}