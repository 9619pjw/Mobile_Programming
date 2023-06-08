package com.example.kotlinbasic2.chap07.sec03
// lazy 지연 초기화 - Property

/* by lazy 지연 초기화.
* 사용 시점에 초기화 ... 실제 속성이 처음 사용될 때 초기화 구문 동작함
* 속성을 선언할 때 초기화 구문도 람다식으로 함께 정의하여
* val 속성에서만 사용 가능.
* 기본 데이터 타입(primitive type)과 Nullable 타입 속성에도 사용 가능함
* */

fun main(){
    val account = Account() // account 객체 생성

    // 사용 시점에 초기화
    println(account.balance) // balance 속성값 초기화 (balance = 10000)
    println("=======================")
    println("account.balance : ${account.balance}") // 이미 초기화된 값 출력

}

class Account(){
    init{
        println("init block")
    }

    val balance: Int by lazy{
        print("Setting balance: ")
        10000 // lazy 반환값
    }
}
