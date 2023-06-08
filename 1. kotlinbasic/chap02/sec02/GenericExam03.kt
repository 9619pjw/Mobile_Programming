package com.example.kotlinprojects.chap02.sec02

// 함수 선언부에 제네릭 형식 타입<T>을 지정하고
// 이를 함수의 매개변수와 리턴값의 타입으로 지정함
// Number class : 숫자를 표현하는 자료형(Int, Double, Float, Long, Short, Byte)의 super class

fun <T: Number> getSum(num1: T, num2 : T) : T{
    // 매개변수 num1, num2를 Double 타입으로 변환하여 연산
    // 반환값은 제네릭 타입으로 변환하여 반환
    return (num1.toDouble() + num2.toDouble()) as T
}

fun main(){
    // 제네릭으로 선언된 getSum() 함수에 Int, Float, Double 값을 인자로 호출
    println(getSum(10, 20))
    println(getSum(10.0f, 20.0f))
    println(getSum(10.0, 20.0))
}