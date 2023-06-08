package com.example.kotlinprojects.chap02.sec02
import java.util.*

// Array 클래스의 생성자를 이용한 배열 생성
// var arry = Array(size, {초기값}) - 초기값은 람다식으로 표현 가능
// 람다식 초기값은 {init: (Int) -> T}로 정의되어 있으며,
// 첫번째 요소부터 init 함수를 호출하여 반환값으로 초기값 설정

fun main(){
    val num = Array<Int>(10){i -> i} // 10개의 정수를 저장하는 배열을 생성하고 0~9로 초기화

    for(value in num){
        print("$value, ")
    }
    println()

    // 문자열로 변환하여 String 타입의 요소에 저장
    val num2 = Array<String>(10) { it -> (it*2).toString()}
    for(value in num2){
        print("$value, ")
    }
    println()

    // 매개 변수 it은 사용되지 않는 경우 _으로 바꿀 수 있음
    val num3 = Array(10) { _ -> 0}
    num3.forEach{print("$it, ")} // forEach문 ... 배열(데이터)의 크기만큼 반복함, it 키워드로 배열의 요솟값을 받는다.
    println()

    // 배열의 요소를 문자열 형태로 반환(Arrays.toString(num4))
    val num4 = Array(10) { i -> i * 3 }
    println("num4 : ${Arrays.toString(num4)}") // Arrays.toString() 출력
    println("num4 : ${num4.contentToString()}") // contentToString() 출력

    // 기본 타입 배열 클래스를 이용한 배열 생성 (IntArray, DoubleArray, ...)
    val intItem : IntArray = intArrayOf(100, 200, 300)
    intItem.forEach {print("$it, ")}
    println()

    val intNum = IntArray(5) { i -> (i) }
    intNum.forEach{print("$it, ")}
    println()

    val doubleNum = DoubleArray(5) {i -> (i).toDouble()}
    doubleNum.forEach{print("$it, ")}
    println()

    doubleNum[0] = 100.0
    println("doubleNum[0] : ${doubleNum[0]}")
    println()

    // 다차원 배열 생성 방법
    // val intItem = arrayOf(arrayOf(0,0,0), arrayOf(0,0,0)
    // val intNum = Array(2, { Array(3, { i -> 0 } ) } )
    // val intNum = Array(2) { Array(3, { i -> 0 } ) }

    val array2D = Array(2){Array(3) { _ -> 0} }
    for(x in array2D.indices) {
        for(element in array2D[x]){
            print("$element")
        }
        println()
    }
    println()

    val array2D2 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6))
    for(x in array2D2.indices){
        for(element in array2D2[x]){
            print("$element")
        }
        println()
    }
}