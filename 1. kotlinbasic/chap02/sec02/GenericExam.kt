package com.example.kotlinprojects.chap02.sec02

// 제네릭 ... 함수나 클래스에서 사용할 내부 데이터 타입을 일반화 하는 것을 의미함
// 클래스나 함수, 변수 등을 선언할 때 타입을 예측할 수 없거나 하나의 타입으로 고정할 수 없는 경우
// 제네릭 형식 타입으로 선언하고 인스턴스 생성시 실제 타입으로 대체하는 기법.

class FillInTheBlankQuestion( // 빈칸 채우기
    val questionText: String,
    val answer: String
)

class TrueOrFalseQuestion( // 참 거짓
    val questionText: String,
    val answer : Boolean
)

class NumericQuestion( // 산술문제
    val qustionText: String,
    val answer: Int
)

class Question<T>(
    val questionText: String,
    val answer : T
)

fun main(){
    val q1 = Question<String>("안드로이드 앱 제작을 위한 공식 제작환경?", "As")
    val q2 = Question<Boolean>("코틀린은 자바와 비슷하다", true)
    val q3 = Question<Int>("안드로이드 13 version API level : ", 33)
}