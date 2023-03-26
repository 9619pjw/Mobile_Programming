package com.example.kotlinprojects.chap03.sec01

class Person(val name: String){
    operator fun invoke(phone: String, email: String){
        println("name : $name, phone : $phone, email : $email")
    }

}

fun main(){
    val sony = Person("손흥민")
    println(" name : ${sony.name}")

    sony.invoke("010-1234-1234", "sony@gmail.com")

    sony("010-1234-1234", "sony@gmail.com")

    val intData = 100
    val result: () -> Int = {intData + 100}
    println(" result : ${result.invoke()}")
    println(" result : ${result()}")
}