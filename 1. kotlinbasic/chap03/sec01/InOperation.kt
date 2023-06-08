package com.example.kotlinprojects.chap03.sec01

fun main(){
    val num = arrayOf(100,200,300,400,500)
    println("${200 in num}") //  num.contains(200) ... true
    println("${num.contains(200)}") // true
    println("${200 !in num}") // !num.contains(200) ... false
    println("${!num.contains(200)}") // true

    for(i in num){
        print("$i, ")
    }
}