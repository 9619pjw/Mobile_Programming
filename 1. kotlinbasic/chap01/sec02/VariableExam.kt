package com.example.kotlinprojects.chap01.sec02

// 변수 선언 형식 ... 모든 변수는 사용하기 전에 반드시 한번 초기화해야함
// val userID: String = "jwpark"
// 선언 키워드 변수명: 자료형 = 초기값
// 기본적으로 변수에 null값을 허용하지 않음. 타입 이름끝에 ?붙여야 nullable 타입 변수

fun main(){
    // var 선언 <-- 변경이 가능함
    var a: Int = 100
    var b = 200
    var c : Int

    // val 선언 <-- 변경이 불가능. JAVA의 final 변수와 동일함
    // val 변수가 객체를 참조하는 경우는 변수 자신의 참조값은 변경할 수 없지만 참조되는 객체가 갖는 멤버들의 데이터는 변경가능함
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