package com.example.kotlinbasic2.chap07.sec04
// 접근 제한자

open class SuperClass{
    private var num = 0
    protected var num2 = 100

    protected fun addFunc(): Int{
        num += 1
        return num
    }
}

// SuperClass 를 상속한 SubClass 선언
class SubClass : SuperClass(){
    fun resultFunc(){ // public func
        var result = addFunc() // 부모 클래스의 함수 접근 가능
        println("result : ${result+num2}") // 부모 클래스의 프로퍼티 접근 가능
    }
}

fun main() {
    val obj = SubClass()
    obj.resultFunc()
}