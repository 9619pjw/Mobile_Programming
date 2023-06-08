package com.example.kotlinbasic2.chap07.sec03
// lateinit를 사용한 속성 지연 초기화
class Student{
    lateinit var name : String // name 속성에 대한 초기화 지연 선언

    fun initName(_name : String){ // name 속성 초기화 함수
        this.name = _name
    }
    fun initCheck(){ // 속성 초기화 여부 확인하는 함수
        if(!::name.isInitialized) // isInitialized <- 프로퍼티 초기화 여부 검사 API
            println("not Initialized")
        else
            println("initialized : ${::name.get()}") // ::name.get() <- name의 게터 호출
        /*
        * :: <- 프로퍼티 참조 (리플렉션)
        * 리플렉션 : 클래스, 함수, 프로퍼티에 대한 레퍼런스(정보, 참조 등)를 런타임 때 동적으로 분석해내는 기법
        * 속성 앞에 :: 를 명시하면 속성을 객체로 액세스하여 객체에 대한 속성을 참조할 수 있음
        * */
    }
}

fun main(){
    val sony = Student() // rectObj 객체 생성

    sony.initCheck() // name 초기화 여부

    sony.initName("손흥민")// 해당 시점에서 name 속성 초기화가 이루어짐

    println("name : ${sony.name}") // 초기화 없이 name 속성에 접근시 UninitializedPropertyAccessException 발생함

    sony.initCheck() // name 초기화 여부
}