package com.example.kotlinprojects.chap04.sec01

fun main(){
    whenUsage(2,50,"서울특별시")
}

// whenUsage() 함수 ... 함수 안에서 when 표현식 사용함.

fun whenUsage(inputType: Int, score : Int, city : String){
    when(inputType){
        1   -> println("Type-1")
        2, 3 -> println("Type-2-3")
        else ->{ // 또 다른 when을 넣을 수 있음.
            println("Type-Unidentified")
        }
    }
    // 함수의 실행 결과를 확인하여 실행함.
    when(inputType){
        checkInputType(inputType)->{
            println("Type normal")
        }
        else -> println("Type abnormal")
    }

    // in 연산자와 범위 연산자를 사용하여 원하는 범위의 값에 있는지 확인하여 실행함.
    val start  = 0; val end = 100
    when(score){
        in start .. (end/4) -> println("be within 25%")
        50 -> println("average")
        in start..end -> println("be within range")
        else -> println("out of range")
    }

    // when()과 is 연산자를 사용하여 city 변수의 타입이 String인지 검사하고
    // String이면 문자열의 맨 앞이 "서울"로 시작하는지 확인한 후 그 결과를 isSeoul 변수에 저장함
    val isSeoul = when(city){
        is String -> city.startsWith("서울")
        else -> false
    }
    println(isSeoul)

    // String 클래스의 함수들을 사용하여 city 변수의 문자열 값을 검사함
    when{
        city.isEmpty()               -> println("도시명이 없습니다.")
        city.substring(0,2) == "서울" -> println("city : $city")
        else                         -> println(city)
    }
}

fun checkInputType(inputType: Int): Int{
    return if (inputType in 1..3) inputType else -1
}