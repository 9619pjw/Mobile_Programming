package com.example.kotlinbasic2.chap07.sec02

import com.example.kotlinbasic2.chap07.sec01.Student

// 코틀린의 클래스 속성은 private로 접근제한자가 지정되며 게터와 세터를 통해서만 속성값 가져오거나 변경함.
// 모든 속성에는 get()과 set() 함수가 자동으로 생성되어 해당 속성을 참조할 떄 게터와 세터가 자동으로 호출
// 속성에 대한 추가적인 처리가 필요할 때, 해당 속성에 get()/set() 함수를 선언하고 필요한 코드 작성

fun main(){
    val s1 = Student(101, "손흥민", 27)
    println("id : ${s1.id}, name : ${s1.name}, age: ${s1.age}")
    println()

    // 속성값 변경

    s1.name = "이강인"
    s1.age = 20
    println("id : ${s1.id}, name : ${s1.name}, age : ${s1.age}")
}

class Student(_id : Int, _name : String, _age : Int){
    val id : Int = _id
        get() = field
    var name : String = _name
        get() = field
        set(value){
            field = value
        }
    var age : Int = _age
        get() = field
        set(value){
            field = value
        }
}