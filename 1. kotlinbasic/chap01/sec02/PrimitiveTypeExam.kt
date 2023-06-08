package com.example.kotlinprojects.chap01.sec02

// 코틀린 변수의 기본 타입은 모두 클래스(참조 타입, Reference type)로 정의되어 있음
// 타입을 선언하면 컴파일러가 바이트 코드 파일을 생성할 때 자동으로 JVM의 기본 타입(Primitive type)으로 생성

fun main(){
    val v1 : Int = 123
    val v2 = 123
    val v3 = 123L

    // 정수를 나타내는 기본 타입 : Byte(8bit), Short(16bit), Int(32bit), Long(64bit)
    val v4 : Byte = 123
    val v5 : Short = 123
    var v6 : Long = 123
    v6 = v3
    // 실수를 나타내는 기본 타입 : Float(32), Double(64)
    val v7 : Double = 123.4
    val v8 = 123.4
    val v9 = 3.14F

    // 문자형 Char은 ''로 감싸서 표현함.
    val ch1 : Char = 'A'
    val ch2 = ch1 + 1
    val ch3 = 'c'

    // 문자에 해당하는 숫자로 선언하려면 toChar()로 변환
    // Char 타입의 값을 숫자로 처리 시 toInt()로 변환
    val ch5 : Char = 65.toChar()


    val t : Byte = 65
    val t1 = t.toShort()
    val t2 = t.toInt()
    val t3 = t.toLong()
    val t4 = t.toFloat()
    val t5 = t.toDouble()
    println(t5)

    // 논리 자료형 기본 타입 Boolean(1bit) : true / false
}