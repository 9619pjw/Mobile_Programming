package com.example.kotlinprojects.chap05.sec01

fun main(){
    val userId = 1001
    var idCheck: String?

    idCheck = userId as? String?
    println("idCheck : $idCheck")
}