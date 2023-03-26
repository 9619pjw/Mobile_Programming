package com.example.kotlinprojects.chap02.sec02

fun main(){
    val itemString = arrayOf<String>("사과", "복숭아", "배")

    for(fruit in itemString){
        println("fruit : $fruit")
    }
    println()

    val numArray = arrayOf<Int>(1,2,3,4,5)
    for(num in numArray){
        print("$num, ")
    }
    println()

    val itemAny = arrayOf("Kotlin", 100, "Java", 97, true)
    for(item in itemAny){
        print("$item, ")
    }
    println()

    val arr1 = arrayOfNulls<Int>(3)
    arr1[0] = 10
    arr1[1] = 20
    arr1[2] = 30

    for(i in arr1){
        print("$i, ")
    }
    println()

    val arr2 = arrayOfNulls<String>(3)
    for(value in arr2){
        print("$value, ")
    }
    println()

    arr2[0] = "Kotlin"
    arr2[1] = "Java"
    arr2[2] = "Swift"
    for(value in arr2){
        println("arr2 : $value")
    }
}