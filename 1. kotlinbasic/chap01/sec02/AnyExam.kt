package com.example.kotlinprojects.chap01.sec02

// 코틀린에서는 기본 타입 변수를 선언할 때 타입을 지정하지 않으면
// 초기화 되는 값을 기준으로 컴파일러가 타입을 추론하여 지정 (초기화 없을 시 타입 명시해야함)
// 기본 타입 외에 객체나 함수를 사용할 때에도 타입을 추론함.
// 제네릭 타입을 사용하는 배열과 컬렉션에서도 타입을 추론함
fun main(){
    checkArgs("Kotlin")
    checkArgs(100)
    checkArgs(100.0)
}
// 명시적으로 부모 클래스를 지정해주지 않으면 기본적으로 Any 클래스를 상속
// 변수의 타입을 Any로 지정하면 null값이 아닌 어떤 타입의 값/객체를 저장/참조할 수 있음
fun checkArgs(type : Any){ // 매개변수의 타입을 Any 타입으로 선언함
    when(type){ // == Java의 switch
        is String -> println("Type is String : $type")
        is Int -> println("Type is Int: $type")
        is Float -> println("Type is Float : $type")
    }
}