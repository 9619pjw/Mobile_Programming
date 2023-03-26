package com.example.kotlinprojects.chap02.sec02

class GenericEx03<T,A>{
    var userID : T? = null
    var score : A? = null
}

fun main(){
    var obj : GenericEx03<String, Int> = GenericEx03()

    obj.userID = "ugkang"
    obj.score = 100

    println("userID : ${obj.userID}, score : ${obj.score}")
}