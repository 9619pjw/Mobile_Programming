package com.example.kotlinprojects.chap04.sec01
// 코틀린에서 if와 when은 명령문이 아닌 표현식으로 간주함.
// 다양한 상황에 간결하게 사용할 수 있음

fun main(){
    var x = 100

    if(x == 100){
        println("x = $x")
    }else{
        println("x는 100이 아님")
    }

    // if 문을 표현식으로 사용함
    // - if문을 표현식 상태로 사용할때는 반드시 하나의 결과값으로 결정되어야하므로
    //   항상 else문을 함께 사용함.
    val msg = if(x == 100) "x = 100 " else "x는 100이 아님"
    println(msg)

    println(if(x == 100) "x = 100" else "x는 100이 아님")

}