package com.example.kotlinprojects.chap06.sec02

fun main(){
    val name = "손흥민"
    val email = "son101@naver.com"

    userInfo(name)
    userInfo(name, email)
    userInfo(name, "son202@naver.com")
    println()

    namedParm(z=300)
    namedParm(x=800, z=300)
}

fun userInfo(name: String, email: String = "gest@naver.com"){
    val sendMessage = "${name} 님의 이메일은 ${email}입니다."
    println(sendMessage)
}

fun namedParm(x: Int = 100, y: Int = 200, z:Int){
    println("x+y+z: ${x+y+z}")
}