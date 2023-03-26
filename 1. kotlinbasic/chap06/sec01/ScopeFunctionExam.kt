package com.example.kotlinprojects.chap06.sec01

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


    val noteModel = myNoteBook.run{
        println("model : $model, year : $year, price : $price")
        "model : ${model}(${year})"
        100
    }
    println(noteModel)

    val isAcademicProbation = s2.run {
        isGPA()
    }
    println("학사 경고 : $isAcademicProbation")

    val isAcademicWarning = run {
        s1.isGPA()
    }
    println("학사 경고 : $isAcademicWarning")

    with(myNoteBook){
        println("model : $model, year : $year, price : $price")
    }

    val infoNoteBook = myNoteBook.let{
        "MyNoteBook => model : ${it.model}, year : ${it.year}, price : ${it.price}"
    }
    println(infoNoteBook)

    var myNoteBook2 = NoteBook("LG그램 360",2023,300).also{
        it.model = "[New! 2023] ${it.model}"
        it.getDiscount()
    }
    println("MyNoteBook2 => model: ${myNoteBook2.model}, price :${myNoteBook2.price}")
}
