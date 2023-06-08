package com.example.kotlinbasic2.chap07.sec03

class CustomUser{
    // lateinit 선언 후 필요할때 초기화함.
    // var로 선언된 속성에만 사용 가능하며, 게터와 세터 사용 불가
    // Nullable 타입과 기본 데이터 타입(Primitive Type) 속성에는 사용 불가

    // 프로퍼티 초기화 지연. lateinit 생략시 Property must be initialized or be abstract
    lateinit var userID : String // 'lateinit' modifier is allowed only on mutable properties
}

fun main() {
    // 객체 생성
    val obj = CustomUser()

    //userID 프로퍼티 초기화
    obj.userID = "ugkang"
    println("userID : ${obj.userID}")
}
