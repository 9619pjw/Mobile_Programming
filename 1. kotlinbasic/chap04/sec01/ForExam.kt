package com.example.kotlinprojects.chap04.sec01
// for (요소 변수 in 컬렉션(범위)){
//      반복할 문장
//}

fun main(){
    val item1 = arrayOf("사과", "복숭아", "배")
    for(item in item1){
        println("item1 : $item")
    }
    println()

    // 배열의 indices 속성을 참조하여 배열에 저장된 요소의 인덱스값을 참조함
    for(i in item1.indices){
        println("item1[$i] : ${item1[i]}")
    }
    println()

    // ArrayList 객체를 생성
    val item2 = listOf("서울", "경기", "인천")
    // for-in 문으로 List의 각 요소값을 출력
    for(item in item2){
        println("item2 : $item")
    }
    println()

    // List의 indices 속성을 참조하여 List에 저장된 요소의 인덱스값을 참조함
    for(i in item2.indices) {
        println("item2[$i] : ${item2[i]}")
    }
    println()

    // 특정 범위 반복문
    var sum : Int = 0
    for(i in 1..10) sum+=i
    println("sum: $sum")
    println()

    // 다양한 범위 반복문
    for(i in 1..10) print("$i, ")
    println()
    for(i in 10 downTo 1) print("$i, ")
    println()
    for(i in 1..10 step 2) print("$i, ")
    println()
    for(i in 10 downTo 1 step 2) print("$i, ")
}