package com.example.kotlinprojects.chap06.sec01

fun main(){
    val userID : String? = getUserID()

    if (userID != null) sendNotification(userID)

    userID?.let{userID -> sendNotification(userID)}

    userID?.let{sendNotification(it)}

    userID?.let{sendNotification(it)}?:run{println("아이디가 없습니다!")}

    userID?.let{
        println("$it 님에게 알림 메시지를 보냈습니다.")
    }?: run{
        println("userID가 null입니다.")
    }
}

fun getUserID() : String?{
    return "user01"
}

fun sendNotification(userID : String){
    println("$userID 님에게 알림 메시지를 보냈습니다.")
}