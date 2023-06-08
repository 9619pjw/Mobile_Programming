package com.example.kotlinprojects.chap04.sec01

// 레이블 : break 또는 return 이후 루프를 빠져나갈 위치를 지정하는 것.
// 레이블 이름 뒤에 @를 붙이고, 사용 시 @ 뒤에 레이블 이름을 지정.
fun main(){
    for (i in 1..10){
        if (i == 6) break
        print("$i, ")
    }
    println()

    for(i in 1..10){
        if (i == 6) continue
        print("$i, ")
    }
    println()

    first@ for (i in 1..3){
        for(j in 1..3){
            println("i: $i, j: $j")
            if(j==2) break@first
        }
    }
    println()

    first@ for(i in 1..3){
        for(j in 1..3){
            println("i: $i, j: $j")
            if(j==2) continue@first
        }
    }
    println()
}