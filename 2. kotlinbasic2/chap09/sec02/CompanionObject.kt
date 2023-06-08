package com.example.kotlinbasic2.chap09.sec02

class UserClass{
    companion object {
        var userCount : Int = 0

        fun userInfo(){
            println("userCount : $userCount")
        }
    }

    fun addFunc(){
        userCount++
        userInfo()
    }
}

fun main(){
    println(UserClass.userCount)
    UserClass.userInfo()

    val obj = UserClass()
    obj.addFunc()
}