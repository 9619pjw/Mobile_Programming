package com.example.kotlinprojects.chap06.sec01

// 특정 객체의 컨텍스트 내에서 특정 작업을 실행하기 위한 목적만을 가진 고차 함수로서 자신을 호출한 객체를 람다식의
// 인자로 전달하고, 람다식을 실행한 후 그 결과를 반환해주는 범위 지정 함수.
// apply, with, let, run, also
class NoteBook(var model: String, var year : Int, var price: Int){
    fun getDiscount() {
        price -= 25
    }
}
data class Student(
    var id : String = "",
    var name : String = "",
    var gpa : Float = 0.0f
){
    fun isGPA() : Boolean = gpa < 1.5f
}

fun main(){
    var notebook = NoteBook("LG그램",2023,250)
    println("model : ${notebook.model}, year : ${notebook.year}, price : ${notebook.price} ")

    // T.apply{} .. 람다식 인자 this, 반환값 T(this) .
    // 특정 객체를 생성하면서 초기화 과정을 수행할 때 많이 사용함
    // 람다식 인자로 생성한 객체(this)를 전달하며, 속성을 초기화 한 후 변경된 객체를 반환
    // 참조 연산자 없이 인스턴스 멤버 사용 가능함.
    var myNoteBook = NoteBook("LG그램",2023,250).apply{
        model = "[New!] $model"
        getDiscount()
        println("model : $model, year : $year, price : $price")
    }

    var s1 = Student()
    s1.id = "C2022001"
    s1.name = "아이유"
    s1.gpa = 4.5f
    println("ID : ${s1.id}, NAME : ${s1.name}, GPA : ${s1.gpa}")

    var s2 = Student().apply{
        id = "C2022002"
        name = "John"
        gpa = 1.4f
        println("ID : $id, NAME : $name, GPA : $gpa")
    }

    // T.run{} / run{} ... 람다식 인자 this 또는 X , 반환값 실행결과(최종값)
    // 객체에서 호출하는 형태와 인자가 없는 익명 함수처럼 동작하는 두가지 형태
    // 인스턴스의 함수나 속성을 스코프 내에서 처리한 후에 결과값을 받아야할때 유용함
    // 호출 형태(T : 수신 객체) 1. 객체에서 호출 (T.run{...}) 2. 객체없이 호출 (run{...})
    // apply처럼 run 스코프 안에서 참조 연산자 없이 인스턴스 멤버를 사용하며, 반환값은 람다식의 실행결과를 반환
    // safe calls (?.) 연산자와 함께 사용 가능함
    val noteModel = myNoteBook.run{
        println("model : $model, year : $year, price : $price")
        "model : ${model}(${year})"
    }
    println(noteModel)


    val isAcademicProbation = s2.run {
        isGPA()
    }
    println("학사 경고 : $isAcademicProbation")

    // 수신 객체없이 호출하는 형태 (람다식 안에 수신 객체를 명시함)
    val isAcademicWarning = run {
        s1.isGPA()
    }
    println("학사 경고 : $isAcademicWarning")


    // with(T) ... 람다식 인자 this 반환값 실행결과(최종값)
    // run과 동일한 기능. 인스턴스를 참조 연산자 대신 파라미터로 받아 처리함.
    with(myNoteBook){
        println("model : $model, year : $year, price : $price")
    }

    // T.let{} ... 람다식 인자 it 반환값 실행결과(최종값)
    // 자신을 호출한 객체를 람다식의 인자로 전달하고, 람다식의 실행 결과를 반환
    // let은 주로 nullable한 값을 처리할 때 사용함 (?.와 함께 사용가능)
    // 람다식 인자가 한개일 경우 it를 통해 인스턴스를 사용함
    val infoNoteBook = myNoteBook.let{
        "MyNoteBook => model : ${it.model}, year : ${it.year}, price : ${it.price}"
    }
    println(infoNoteBook)


    // T.also{} ... 람다식 인자 it 반환값 T(it)
    // apply와 같이 인스턴스 자신을 다시 반환하며, it을 통해서 인스턴스를 사용
    // apply가 주로 객체 생성 후 초기화(속성 설정) 후 객체를 반환했다면
    // also는 속성 설정뿐만 아니라 객체에 대한 추가적인 작업(유효성 검사)을 한 후 객체를 반환.
    var myNoteBook2 = NoteBook("LG그램 360",2023,300).also{
        it.model = "[New! 2023] ${it.model}"
        it.getDiscount()
    }
    println("MyNoteBook2 => model: ${myNoteBook2.model}, price :${myNoteBook2.price}")
}
