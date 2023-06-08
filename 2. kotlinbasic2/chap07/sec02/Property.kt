package com.example.kotlinbasic2.chap07.sec02

fun main(){
    val result = data1 + data2
    println("result : $result")

    var obj = MyUser("a101", "손흥민")
    println("userId : ${obj.userId}, name : ${obj.name}")
}

// 최상위 변수
var data1 = 100
var data2 = 200

class MyUser(var userId : String, var name: String)