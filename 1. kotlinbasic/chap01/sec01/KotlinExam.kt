package com.example.kotlinprojects.chap01.sec01

fun main(){
    println("Hello Kotlin!")
    println(makeMsg1(1))
    println(makeMsg1(2))
    println(makeMsg2(1))
    println("makeMsg3(1) : ${makeMsg3(1)}")
    println("makeMsg4(2) : ${makeMsg4(2)}" )
}

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

