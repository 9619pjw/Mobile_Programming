package com.example.kotlinprojects.chap02.sec02

import java.util.*


fun main(){
    val num = Array<Int>(10){i -> i}

    for(value in num){
        print("$value, ")
    }
    println()

    val num2 = Array<String>(10) { it -> (it*2).toString()}
    for(value in num2){
        print("$value, ")
    }
    println()

    val num3 = Array(10) { _ -> 0}
    num3.forEach{print("$it, ")}
    println()

    val num4 = Array(10) { i -> i*3}
    println("num4 : ${Arrays.toString(num4)}")
    println("num4 : ${num4.contentToString()}")


    val intItem : IntArray = intArrayOf(100, 200, 300)
    intItem.forEach {print("$it, ")}
    println()

    val intNum = IntArray(5) { i -> (i)}
    intNum.forEach{print("$it, ")}
    println()

    val doubleNum = DoubleArray(5) {i -> (i).toDouble()}
    doubleNum.forEach{print("$it, ")}
    println()

    doubleNum[0] = 100.0
    println("doubleNum[0] : ${doubleNum[0]}")
    println()


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