package com.example.kotlinbasic2.chap09.sec02
// object 클래스에서 인터페이스 & 추상클래스 구현

interface Interf{
    fun iMethod()
}

// 추상 클래스 선언
abstract class AbsClass{
    abstract fun aMethod()
}

fun main(){
    // 추상 클래스와 인터페이스를 구현한 익명 객체 생성
    var obj2 = object : AbsClass(), Interf{
        // 추상 클래스의 메서드 오버라이딩
        override fun aMethod() {
            println("익명 객체의 aMethod() 호출")
        }
        // 인터페이스의 메서드 오버라이딩
        override fun iMethod() {
            println("익명객체의 iMethod() 호출")
        }
    }

    obj2.aMethod()
    obj2.iMethod()

    Outer.InnerObject.printCount() // 객체 멤버는 클래스 이름으로 참조함
}

// object 클래스 선언은 클래스 내부에서도 가능하며
// 이 경우 클래스의 인스턴스가 여러 개 생성되더라도 object 객체는 하나만 생성됨
class Outer(){
    object InnerObject{
        var count : Int = 0
        fun printCount(){
            println(count)
        }
    }
}