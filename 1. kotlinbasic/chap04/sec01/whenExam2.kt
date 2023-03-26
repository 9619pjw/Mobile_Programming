package com.example.kotlinprojects.chap04.sec01

fun main(){
    whenUsage(2,50,"서울특별시")
}

fun whenUsage(inputType: Int, score : Int, city : String){
    when(inputType){
        1   -> println("Type-1")
        2, 3 -> println("Type-2-3")
        else ->{
            println("Type-Unidentified")
        }
    }

    when(inputType){
        checkInputType(inputType)->{
            println("Type normal")
        }
        else -> println("Type abnormal")
    }
    val start  = 0; val end = 100
    when(score){
        in start .. (end/4) -> println("be within")
    }
}

fun checkInputType(inputType: Int): Int{
    return if (inputType in 1..3) inputType else -1
}