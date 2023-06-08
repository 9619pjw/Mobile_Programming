package com.example.kotlinbasic2.chap07.sec01
 // 속성 : 함수나 클래스 외부에 선언된 최상위 변수 또는 클래스의 멤버 변수
fun main(){
    // 필드 : 함수 또는 {} 내부의 지역 변수
    var result = f1(100, 100)
    println(result)
}

fun f1(a1: Int, a2 : Int) : Int{
    // 필드
    var count = a1+a2
    return count
}