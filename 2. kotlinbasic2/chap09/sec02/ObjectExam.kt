package com.example.kotlinbasic2.chap09.sec02
// object 객체는 하나의 인스턴스만 생성하고 공유하는 싱글톤 패턴을 구현

fun main(){
    for(i in 1 .. 10){
        StateManager.msgNumber += 1 // 객체의 멤버는 객체의 이름으로 참조함
        StateManager.msgContent = StateManager.msgNumber.toString() + "번 메시지"
        StateManager.showMessage()
    }
}

object StateManager{
    // 초기화 블럭
    init{
        println("수신 메시지")
        println("-----------------------------")
    }
    // 속성 선언
    var msgNumber : Int = 0         // 메시지 번호
    var msgContent : String? = null // 내용

    // 함수 선언
    fun showMessage() {
        println("[No $msgNumber] Content: $msgContent 입니다.")
    }
}