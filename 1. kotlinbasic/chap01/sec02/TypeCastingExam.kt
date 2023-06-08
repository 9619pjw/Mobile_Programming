package com.example.kotlinprojects.chap01.sec02
// 코틀린에서는 타입 간의 변환을 자동으로 해주지 않음
// 자료형이 다른 변수에 값을 할당할 때는 타입 변환함수를 사용하여 호환되는 다른 자료형으로 변환
fun main(){
    var intData = 100

    // 형 변환

    val data1 : Long = intData.toLong()
    if(data1 is Long) println("data1 : Long = $data1")
    val data2 : Float = intData.toFloat()
    if(data2 is Float) println("data2 : Float = $data2")
    val data3 = intData.toDouble()
    if(data3 is Double) println("data3 : Double = $data3")

    // 문자열 String은 내부적으로 자바의 String 클래스를 사용함
    // String 타입의 변수는 문자열 객체를 참조.
    // Primitive 타입은 String 클래스의 toString() 함수를 호출해서 String 타입으로 변환 가능함
    var strData : String = "Kotlin"
    println("strData : $strData")

    strData = "Android"
    println("strData: $strData")

    val data4 : Int = 100

    val data6 : String = data4.toString()
    println("data6 : $data6")

    // 문자열 타입의 변수에 타입 변환 함수를 사용하면 문자열 값을 기본 타입의 값으로 변환 가능
    val data7 : String = "100"
    val data8 : Int = data7.toInt()
    println("data8 : $data8")
    val data9 : String = "98.72"
    val data10 = data9.toFloat()
    println("data10 : $data10")

    val data11 : String = "100o"
    val data13 : Int? = data11.toIntOrNull() // toㅁㅁㅁOrNull <- 변환 안되면 null값
    println("data13 : $data13")

    try{
        val data14: Int = data11.toInt()
    }catch (e: NumberFormatException){
        println("data11 is not number: $data11")
    }
}