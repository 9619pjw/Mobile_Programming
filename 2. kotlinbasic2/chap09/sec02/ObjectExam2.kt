package com.example.kotlinbasic2.chap09.sec02

fun main(){
    // 익명으로 object객체를 생성하여 참조변수에 할당
    var carSerialNo = object{
        // 속성 설정
        var serialNo = 0

        // 메서드 설정
        fun serialNoUp(){
            serialNo++
        }
        fun serialNoDown(){
            if(serialNo > 0) serialNo--
        }
        fun serialNoClear(){
            serialNo = 0
        }
    }

    println("serialNo : ${carSerialNo.serialNo}")
    carSerialNo.serialNoUp()
    carSerialNo.serialNoUp()

    println("serialNo: ${carSerialNo.serialNo}")
    carSerialNo.serialNoDown()

    println("serialNo: ${carSerialNo.serialNo}")
    carSerialNo.serialNoClear()

    println("serialNo : ${carSerialNo.serialNo}")
}

