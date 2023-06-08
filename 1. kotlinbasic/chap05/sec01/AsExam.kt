package com.example.kotlinprojects.chap05.sec01

// as 연산자는 객체의 타입을 변화시킬때 사용함. (명시적인 타입 변환)
// 기본 타입 간에는 toString()같은 함수로 변환함.
// as? 연산자는 안전타입 변환 연산자로, 부적합한 변환시 null을 반환함.
fun main(){
    val userId = 1001
    var idCheck: String?

    idCheck = userId as? String?
    println("idCheck : $idCheck")
}