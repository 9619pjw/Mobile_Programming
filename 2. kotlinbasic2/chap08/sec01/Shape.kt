package com.example.kotlinbasic2.chap08.sec01

open class Shape{
    var x : Int = 0
        set(value){
            field = if(value < 0) 0 else value
        }
    var y : Int = 0
        set(value){
            field = if(value<0) 0 else value
        }
    lateinit var name : String

    fun print(){
        println("$name : location : $x, $y")
    }
}

class Rect : Shape() {
    var width : Int = 0
        set(value) {
            field = if(value < 0) 0 else value
        }
    var height : Int = 0
        set(value){
            field = if(value < 0) 0 else value
        }
}

class Circle : Shape() {
    var r : Int = 0
        set(value){
            field = if(value<0) 0 else value
        }
}

fun main(){
    // 객체 생성
    val rect = Rect()
    rect.name = "Rect"
    rect.x = 10
    rect.y = 10
    rect.width = 20
    rect.height = 20
    rect.print()

    //객체 생성
    val circle = Circle()
    circle.name = "Circle"
    circle.x = 30
    circle.y = 30
    circle.r = 5
    circle.print()
}