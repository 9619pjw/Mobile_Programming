package com.example.kotlinprojects.chap05.sec01

// !! <- nullable로 설정된 프로퍼티/변수에 강제로 null이 아님을 선언하는 연산자
// 해당 연산자의 왼쪽에 있는 피연산자값이 null 아니면 정상적으로 코드 수행
// null이면 런타임 시 NullPointerException 예외 발생함.


fun main(){
    ignoreNulls("Kotlin")
}

fun ignoreNulls(s:String?){
    val sNotNull : String = s!! // s가 null이 아님을 선언함
    println("sNotNull.length : ${sNotNull.length}")
}