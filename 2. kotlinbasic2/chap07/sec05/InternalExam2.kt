package com.example.kotlinbasic2.chap07.sec05
// internal 가시성 지시자 - 같은 모듈의 다른 패키지 파일

import com.example.kotlinbasic2.chap07.sec04.InternalClass

fun main(){
    val obj = InternalClass() // 접근 가능

    obj.addFunc() // 접근 가능
}