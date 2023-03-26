package com.example.kotlinprojects.chap01.sec02

open class Animal{
    open fun shout(){
        println("Animal 은 소리를 냅니다.")
    }
}

class Dog : Animal() {
    override fun shout(){
        println("강아지가 멍멍 소리를 냅니다.")
    }
}

class Cat : Animal() {
    override fun shout(){
        println("고양이가 야옹 소리를 냅니다.")
    }
}

class UsingSuperclass(val t : Animal){
    fun doShouting(){
        t.shout()
    }
}

class UsingGeneric<T:Animal> (val t : T){
    fun doShouting(){
        t.shout()
    }
}

fun main(){
    UsingSuperclass(Animal()).doShouting()
    UsingSuperclass(Dog()).doShouting()
    UsingSuperclass(Cat()).doShouting()

    println("============================")

    UsingGeneric<Animal>(Animal()).doShouting()

    UsingGeneric(Dog()).doShouting()
    UsingGeneric(Cat()).doShouting()
}