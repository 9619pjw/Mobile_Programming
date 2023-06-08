package com.example.kotlinbasic2.chap08.sec01

/*
* 코틀린에서 일반 클래스는 모두 final class로 선언되기 때문에 상속 X
* 상속이 가능하도록 open class 선언
* public final class SuperClass{ }
*/

open class SuperClass {
    var supMember = 100
    fun supMethod() {
        println("Super class Method")
    }
}

class SubClass : SuperClass() { }
