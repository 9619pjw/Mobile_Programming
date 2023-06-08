package com.example.kotlinprojects.chap02.sec02
// 배열 ... Array 클래스로 정의됨. Array<String>처럼 배열에 저장되는 요소의 타입을 제네릭<T> 타입으로 나타냄.
// 라이브러리 함수를 이용한 배열 생성
// arrayOf() : 배열 선언과 동시에 초기화
// arrayOfNulls<T>() : 배열의 크기만 지정하고 값은 나중에 저장함

fun main(){
    // [1] arrayOf() 함수를 이용한 배열 생성 - 배열 선언과 동시에 초기화
    val itemString = arrayOf<String>("사과", "복숭아", "배") // 타입 파라미터 생략 가능함.

    for(fruit in itemString){
        println("fruit : $fruit")
    }
    println()

    val numArray = arrayOf<Int>(1,2,3,4,5) // <Int>로 초기화된 배열
    for(num in numArray){
        print("$num, ")
    }
    println()

    // 다양한 타입의 값을 저장
    val itemAny = arrayOf("Kotlin", 100, "Java", 97, true)
    for(item in itemAny){
        print("$item, ")
    }
    println()

    // [2] arrayOfNulls() 함수 : null 값을 가지는 배열 생성(크기만 지정함)
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