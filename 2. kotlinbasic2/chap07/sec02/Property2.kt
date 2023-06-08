package com.example.kotlinbasic2.chap07.sec02

fun main() {
    // 객체 생성
    val result = MyCalcu(100,200)
    println(result.sum)
}

class MyCalcu constructor(_p1 : Int, _p2: Int){
    // 속성
    var p1 : Int
    var p2 : Int
    val sum : Int
    // val는 불변값이므로 setter 생성 안함
    init{
        this.p1 = _p1
        this.p2 = _p2
        sum = p1 + p2
    }
}