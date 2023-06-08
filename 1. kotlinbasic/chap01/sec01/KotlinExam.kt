package com.example.kotlinprojects.chap01.sec01
// 코틀린 프로그램 구조

fun main(){ // main() 함수 : 프로그램 시작점
    println("Hello Kotlin!")
    println(makeMsg1(1))
    println(makeMsg1(2))
    println(makeMsg2(1))
    println("makeMsg3(1) : ${makeMsg3(1)}") // 문자열 템플릿 $으로 문자열 결합
    println("makeMsg4(2) : ${makeMsg4(2)}" ) // 표현식을 문자열에 포함 시킬때는 {} 사용함
}

// 함수 선언
fun makeMsg1(msgType: Int): String {
    return if(msgType == 1){
        "대한민국"
    } else{
        "KOREA"
    }
}
// if문 축약
fun makeMsg2(msgType : Int) : String{
    return if (msgType == 1) "대한민국" else "KOREA"
}

// 함수 선언(return 생략) ... "="로 대입함
fun makeMsg3(msgType : Int) : String = if (msgType == 1) "안녕!" else "HI~"

// 함수 선언(타입 추론)
fun makeMsg4(msgType: Int) = if(msgType == 1) "코틀린" else "Kotlin"

