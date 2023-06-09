package com.example.kotlinprojects.chap04.sec01
fun main() {
    var x = 3

    // x의 값에 따라 해당 값으로 분기하여 처리하고 when문을 빠져나감
    // switch-case 문과 유사함. 명령문이 아닌 표현식으로 간주함.
    when(x){
        1 -> {
            println("x == 1")
        }
        2 -> {
            println("x == 2")
        }
        3 -> {
            println("x == 3")
        }
        else -> {
            println("x는 1,2,3이 아니다!")
        }
    }
    when(x){
        0,1 ->{
            println("x == 0 or 1")
        }
        2,3 ->{
            println("x == 2 or 3")
        }
        else ->{
            println("x이 1,2,3이 아니다!")
        }
    }

    when(x){
        in 1..3 ->{
            println("x == 1 or 2 or 3")
        }
        in 4..6 ->{
            println("x == 4 or 5 or 6")
        }
        !in 1..6 ->{
            println("x == !(1,2,3,4,5,6)")
        }
    }
    // fun 과 when 연계 사용
    // 함수 f1의 매개변수에 따라 when 문 처리함
    // 함수의 리턴값의 데이터 타입은 추론할 수 있기에 생략 가능함

    var x2 = f1(1) ; var x3 = f1(2)
    println("x2 : $x2")
    println("x3 : $x3")

    var x4 = f1(3) ; var x5 = f1(5)
    println("x4 : $x4")
    println("x5 : $x5")
}

fun f1(b1:Int) : Int = when(b1){
    1->{
        100
    }
    2->{
        200
    }
    3->{
        300
    }
    else ->{
        100 + 200 + 300
    }
}