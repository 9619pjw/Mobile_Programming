package com.example.kotlinbasic2.chap08.sec02
// 인터페이스 선언
interface Inter1{
    fun method1()
    fun method2(){
        println("Inter1 method2")
    }
}

interface Inter2{
    fun method3()
    fun method4(){
        println("Inter2 method4")
    }
}

fun testF1(i1 : Inter1){
    i1.method1()
    i1.method2()
}

fun testF2(i2 : Inter2){
    i2.method3()
    i2.method4()
}

class InterfaceTest : Inter1{
    override fun method1(){
        println("InterfaceTest method1")
    }
}

class InterfaceTest2 : Inter1, Inter2 {
    override fun method1() {
        println("InterfaceTest2 method1")
    }
    override fun method3(){
        println("InterfaceTest2 method3")
    }
}

fun main(){
    var obj1 = InterfaceTest()
    obj1.method1()
    obj1.method2()
    testF1(obj1)

    println("=======================")
    var obj2 = InterfaceTest2()
    obj2.method1()
    obj2.method2()
    obj2.method3()
    obj2.method4()
    testF2(obj2)
}
