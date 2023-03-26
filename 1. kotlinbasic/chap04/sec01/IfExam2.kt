package com.example.kotlinprojects.chap04.sec01

fun main(){
    print("Enter the score: ")
    var score: Double? = readLine()?.toDoubleOrNull()
    println(score)

    var grade : Char = 'F'

    if(score != null){
        if(score >= 90) {
            grade = 'A'
        }else if (score >= 80 && score <= 89.9){
            grade = 'B'
        }else if (score >= 70 && score <= 79.9){
            grade = 'C'
        }else if (score >= 60 && score <= 69.9){
            grade = 'D'
        }
    }
    println("Score : $score, Grade : $grade")
}