package com.example.kotlinbasic2.chap08.sec02

// 추상 클래스

// 추상 클래스 선언 (기본 생성자에서 프로퍼티 선언)
abstract class VehicleSpecs(val carName: String, val year : String, val model : String) {
    //추상 프로퍼티
    abstract var maxSpeed: Double
    // 일반 프로퍼티
    var color : String = "Black"

    // 추상 메서드
    abstract fun start()
    abstract fun end()

    // 일반 메서드
    fun displayInfo() {
        println("[SPECS] : carName : $carName, year : $year, model : $model, maxSpeed: $maxSpeed, color: $color")
    }
}

class Car (carName : String,
            year : String,
            model : String,
            override var maxSpeed : Double) : VehicleSpecs(carName, year, model ) {
                /* 추상 메서드 오버라이딩은 반드시 구현해야함
                * ㄴ 미구현시 Class 'Car' is not abstract and does not implement abstract base class member
                * */

            override fun start() {
                println("Car started!")
            }
            override fun end() {
                println("Car stopped!")
            }
}

// MotorCycle 클래스 선언함
class Motorcycle(carName : String,
                 year : String,
                 model : String,
                 override var maxSpeed: Double) : VehicleSpecs(carName, year, model) {

    //추상 클래스 오버라이딩
    override fun start() {
        println("MotorCycle started!")
    }

    override fun end() {
        println("MotorCycle stopped!")
    }
}

fun main(){
    val car = Car("GENESIS", "2022", "G80", 300.0)
    car.displayInfo()
    car.start()
    car.end()
    println("========================================")

    val bike = Motorcycle("HARLEY-DAVIDSON", "2022", "STREET-750", 250.0)
    bike.color = "Red"

    bike.displayInfo()
    bike.start()
    bike.end()
}