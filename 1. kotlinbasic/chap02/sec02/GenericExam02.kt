package com.example.kotlinprojects.chap02.sec02

// 클래스 선언부에 2개의 제네릭 형식 타입을 지정

class GenericEx03<T,A>{
    var userID : T? = null
    var score : A? = null
}

fun main(){
    // 객체를 생성하면서 어떤 타입으로 사용할 것인지 타입 지정함
    var obj : GenericEx03<String, Int> = GenericEx03()

    // 프로퍼티에 지정된 타입에 맞는 데이터를 할당함
    obj.userID = "ugkang"
    obj.score = 100

    println("userID : ${obj.userID}, score : ${obj.score}")
}