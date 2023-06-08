package com.example.kotlinprojects.chap06.sec02

var global = 10

fun main(){
    val x = 20
    val y = 30

    fun nestedFunc(){
        global += 1
        val x = 200
        println("nestedFunc x : $x")
        println("nestedFunc y : $y")
        println("nestedFunc gloabal: $global")
    }

    nestedFunc()
    outsideFunc()
}

fun outsideFunc(){
    global += 1
    val z = 500
    println("outsideFunc z : $z")
    println("outsideFunc global : $global")
}