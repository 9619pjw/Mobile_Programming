package com.example.kotlinprojects.chap01.sec02

// open class ... 슈퍼 클래스로 사용함. 오버라이딩 사용 가능
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

// 기본 생성자의 매개변수를 부모 클래스 타입으로 지정하는 경우,
// 부모 클래스를 상속한 모든 자식 클래스를 받을 수 있으나
// 자식 클래스를 받는 경우 매번 부모 클래스 타입으로 캐스팅 연산이 일어나기 때문에 성능이 저하됨.

class UsingSuperclass(val t : Animal){
    fun doShouting(){
        t.shout()
    }
}

// 제네릭을 사용하는 경우는 제네릭이 인스턴스 생성 단계에서 인자로 전달된 타입으로 대체됨
// 캐스팅 연산이 불필요함 ... 성능이 우수하다.
class UsingGeneric<T:Animal> (val t : T){ // <타입 파라미터 : 타입 범주>
    fun doShouting(){
        t.shout()
    }
}

fun main(){
    UsingSuperclass(Animal()).doShouting()
    UsingSuperclass(Dog()).doShouting()
    UsingSuperclass(Cat()).doShouting()

    println("============================")

    UsingGeneric<Animal>(Animal()).doShouting() // Animal 객체를 인자로 전달하고, doShouting() 호출함

    // 생성자의 파라미터로 전달된 객체를 보고 <타입 파라미터>를 추론함
    UsingGeneric(Dog()).doShouting()
    UsingGeneric(Cat()).doShouting()
}