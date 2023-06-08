package com.example.kotlinprojects.chap03.sec01
// is 연산자 ... 객체 타입 확인용  == 자바의 instanceof

fun main(){
    val obj1 = B()

    if (obj1 is A){
        println("A class Type")
    }else{
        println("Not A Class Type")
    }

    if(obj1 is B){
        println("B class Type")
    }else{
        println("Not B Class Type")
    }
}
open class A{}
class B: A(){}
