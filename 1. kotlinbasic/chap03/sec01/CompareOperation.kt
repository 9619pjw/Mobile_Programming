package com.example.kotlinprojects.chap03.sec01

fun main(){
    var a =10; var b = 10; var c = 100

    println("a==b : ${a==b}" )
    println("a.equals(c) : ${a.equals(c)}")
    println("a!=b : ${a!=b}")
    println("!(a.equals(c) : ${!(a.equals(c))}")

    println("c>a : ${c>a}")
    println("a>b : ${a>b}")
    println("a>c : ${a>c}")

    println("c.compareTo(a) > 0 : ${c.compareTo(a)}")
    println("a.compareTo(b) > 0 : ${a.compareTo(b)}")
    println("a.compareTo(c) > 0 : ${a.compareTo(c)}")

}