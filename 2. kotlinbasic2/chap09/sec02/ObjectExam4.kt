package com.example.kotlinbasic2.chap09.sec02
// companion object (동반 객체)
fun main(){
    OuterClass.printMsg() // 클래스명.함수명으로 함수 호출
}

class OuterClass{
    // companion object 키워드 : 동반 객체 생성
    // 동반 객체는 static 객체로 생성 되기 때문에 해당 객체에 포함된 멤버함수를 객체명 없이 접근 가능함
    companion object ComObj{ // 이름 없이 companion object{ } 선언도 가능함
        fun printMsg() {
            println("동반 객체의 함수가 호출됨")
        }
    }
}