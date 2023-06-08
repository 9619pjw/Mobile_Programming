package com.example.kotlinbasic2.chap07.sec01

fun main(){
    var obj1 : Friend = Friend("손흥민", "010-1234-1234")
    println("이름 : ${obj1.name}")
    println("전화 : ${obj1.tel}")

    var obj2 = Friend2("이강인", "010-1234-1234")
    println("이름 : ${obj2.name}")
    println("전화 : ${obj2.tel}")

    var obj3 = Friend3("봉준호", "010-1234-1234")
    println("이름 : ${obj3.name}")
    println("전화 : ${obj3.tel}")

    var obj4 = Friend4("송강호", "010-1234-1234")
    println("이름 : ${obj4.name}")
    println("전화 : ${obj4.tel}")

    var obj5 = Friend5("아이유")
    println("이름 : ${obj5.name}")
    println("전화 : ${obj5.tel}")

    var obj6 = Friend6("김연아", "010-1234-8888")
    println("이름 : ${obj6.name}")
    println("전화 : ${obj6.tel}")
    println("타입 : ${obj6.type}")
}

class Friend constructor(_name : String, _tel: String){
    val name : String
    val tel : String

    init{
        this.name = _name
        this.tel = _tel
        println("멤버 속성이 초기화되었습니다.")
    }
}

class Friend2 (_name: String, _tel: String){
    val name : String
    val tel : String

    init{
        this.name = _name
        this.tel = _tel
        println("멤버 속성이 초기화되었습니다.")
    }
}

class Friend3 (_name : String, _tel : String){
    val name : String = _name
    val tel : String = _tel

    init{
        println("멤버 속성이 초기화되었습니다.")
    }
}

class Friend4(val name : String, val tel : String){
    init{
        println("멤버 속성이 초기화되었습니다 ==> name: ${this.name}, tel : ${this.tel}")
    }
}

class Friend5(val name : String, val tel : String = "010-1234-7777"){
    init{
        println("멤버 속성이 초기화되었습니다.")
    }
}

class Friend6(val name : String, val tel : String, var type : Int = 1){
    init{
        this.type = if(type < 4) type else 4
        println("멤버 속성이 초기화되었습니다.")
    }
}