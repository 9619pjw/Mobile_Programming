package com.example.kotlinprojects.chap06.sec02

fun main(){
    MemberShip().memberInfo()
}

class MemberShip{
    val id : String = "G101"
    val grade : String = "Gold"

    fun memberInfo(){
        println("귀하의 Id는 ${id}이고, 고객등급은 ${grade} 입니다.")
    }
}