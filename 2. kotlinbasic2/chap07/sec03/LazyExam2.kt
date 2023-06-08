package com.example.kotlinbasic2.chap07.sec03
// 객체 지연 초기화(by lazy)

class Customer(val id: Int, val name: String, val email: String)

fun main(){
    var isInitialized : Boolean = false // 초기화 확인용

    val sony : Customer by lazy{ // 객체의 지연 초기화 선언
        println("Customer 객체 초기화")
        isInitialized = true

        //lazy 객체 반환 ... 객체 생성자 반환
        Customer(1001, "손흥민", "sony@gmail.com")
    }

    println("초기화 여부 : $isInitialized")

    // 객체 초기화 - Customer 객체의 속성에 접근하는 시점에 초기화가 이루어짐
    println("sony => id : ${sony.id}, name: ${sony.name}, email: ${sony.email}")
    println("초기화 여부 : $isInitialized")
}