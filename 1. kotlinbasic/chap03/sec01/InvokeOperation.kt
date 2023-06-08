package com.example.kotlinprojects.chap03.sec01
// invoke 연산자
// invoke() 함수에 operator 키워드를 지정하여 해당 클래스에 정의함 ... invoke() 함수를 오버로딩함.
// 클래스의 인스턴스를 함수처럼 호출할 때 또는 익명 함수나 람다식을 변수에 지정하고 실행할 때 유용하게 사용함.

// Person 클래스 선언
class Person(val name: String){
    // Invoke() 함수의 선언 (Overloading)
    operator fun invoke(phone: String, email: String){
        println("name : $name, phone : $phone, email : $email")
    }

}

fun main(){
    //Person 클래스의 인스턴스 생성
    val sony = Person("손흥민")
    println(" name : ${sony.name}")

    // invoke() 함수 호출
    sony.invoke("010-1234-1234", "sony@gmail.com")

    // invoke() 함수 호출(이름없이 간편 호출... 인스턴스(참조변수)에 괄호침)
    sony("010-1234-1234", "sony@gmail.com")

    // 람다식에서 invoke() 함수 호출
    // 람다식은 컴파일 하면서 invoke() 함수 정의하기 때문에
    // result.invoke() 또는 result()로 간편 호출 가능
    val intData = 100
    val result: () -> Int = {intData + 100}
    println(" result : ${result.invoke()}")
    println(" result : ${result()}")
}