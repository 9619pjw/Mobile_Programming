package com.example.kotlinbasic2.chap08.sec01.sample2

open class Shape{
    var x : Int = 0
    var y : Int = 0
    lateinit var name : String

    open fun print() {
        println("$name : location : $x, $y")
    }
}

open class Rect: Shape(){
    var width : Int = 0
    var height : Int = 0

    override fun print(){
        println("$name : location : $x, $y, width : $width, height : $height")
    }
}

class Circle : Shape(){
    var r : Int = 0

    override fun print() {
        println("$name : location : $x, $y, radius : $r ")
    }
}

fun main(){
    val rect = Rect()
    rect.name = "Rect"
    rect.x = 10
    rect.y = 10
    rect.width = 20
    rect.height = 20
    rect.print()

    val circle = Circle()
    circle.name = "Circle"
    circle.x = 30
    circle.y = 30
    circle.r = 5
    circle.print()
}