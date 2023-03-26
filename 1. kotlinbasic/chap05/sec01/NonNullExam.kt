package com.example.kotlinprojects.chap05.sec01

fun main(){
    ignoreNulls("Kotlin")
}

fun ignoreNulls(s:String?){
    val sNotNull : String = s!!
    println("sNotNull.length : ${sNotNull.length}")
}