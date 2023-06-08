package com.example.kotlinbasic2.chap07.sec03
// 객체 지연 초기화

// user 클래스 선언
data class User(var id: Int, var name: String, var age: Int)

/* 객체 생성의 지연 초기화
  - user를 초기화없이 선언하면 오류(Property must be initialized) 발생
  - lateinit 키워드를 사용하여 지연 초기화 선언
 */
lateinit var user: User

fun main(){
    // 생성자 호출 시점에서 초기화됨 (지연 초기화)
    user = User(101, "손흥민", 28)
    println("id: ${user.id}, name: ${user.name}, age: ${user.age}")
}