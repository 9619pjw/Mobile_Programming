package com.example.kotlinprojects.chap01.sec02

fun main(){
    // 변수 선언 <-- 변경이 가능함
    var a: Int = 100
    var b = 200
    var c : Int

    // 상수 선언 <-- 변경이 불가능.
    val d : Int = 1000
    val e  = "Kotlin"

    println("a: $a")
    println("b: $b")
    //println(c) <- 에러 발생. 변수 c는 초기화한 후 사용해야함
    c = a+b
    println("c: $c")
    println("a+b = ${a+b}")
    println("d: $d")
    println("e: $e")

    var flag = true
    println("flag : $flag")

    flag = false
    println("flag : $flag")

    val flag2 = "true"
    println("flag2 : ${flag2.toBoolean()}")
}