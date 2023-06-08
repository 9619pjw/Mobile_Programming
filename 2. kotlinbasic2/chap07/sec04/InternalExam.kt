package com.example.kotlinbasic2.chap07.sec04


// internal 가시성 지시자
internal class InternalClass{
    internal var num = 1

    internal fun addFunc() {
        num += 1
        println("num : $num")
    }
}