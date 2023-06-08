package com.example.kotlinbasic2.chap08.sec01

// 스마트 캐스팅 <- 명시적으로 캐스팅을 하지 않아도 자동으로 캐스팅 되는것을 의미함
// 상속 관계에 있는 객체를 명시적으로 캐스팅할 때는 as 연산자를 사용한다.
fun smartCast(data : Any) : Int{
    return if(data is Int) data * data else 0
}

class MyClass1 {
    fun fun1(){
       println("fun1()... 호출")
    }
}
class MyClass2{
    fun fun2(){
        println("fun2()... 호출")
    }
}

fun smartCast2(obj: Any){
    when(obj){
        is MyClass1 -> obj.fun1()
        is MyClass2 -> obj.fun2()
    }
}


open class Super
class Sub1 : Super()

fun main(){
    println("result : ${smartCast(10)}")
    println("result : ${smartCast2(10.0)}")

    smartCast(MyClass1())
    smartCast(MyClass2())

    // 하위 객체를 상위 객체 타입으로 대입 (스마트 캐스팅)
    val obj1 : Super = Sub1()

    //val obj2 : Sub1 = Super() <-- 상위 객체를 하위 객체 타입으로 대입하려 했으나 타입 미스매치로 실패
}