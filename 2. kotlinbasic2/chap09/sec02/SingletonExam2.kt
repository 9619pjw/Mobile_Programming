package com.example.kotlinbasic2.chap09.sec02

class CarSerialNumber2{
    // 국가명 상수로 enum class 선언
    enum class Country(val label: String){
        KOREA("한국"), USA("미국")
    }

    object KoreanFactoryNo{
        var serialNumber = 0
            set(value){
                field = value
                println("Current-serial-No(KOREA) : ${serialNumber}")
            }

        fun increaseNumber(){
            serialNumber++
        }
    }

    object UsaFactoryNo{
        var serialNubmer = 0
            set(value){
                field = value
                println("Current-serial-No(USA) : ${serialNubmer}")
            }
        fun increaseNumber(){
            serialNubmer++
        }
    }

    abstract class Car(country : Country){
        private val serial : Int

        abstract fun carInfo()

        fun printSerial(): String{
            return "제품번호는 $serial"
        }

        init{
            when(country) {
                Country.KOREA ->{
                    KoreanFactoryNo.increaseNumber()
                    serial = KoreanFactoryNo.serialNumber
                }
                Country.USA ->{
                    UsaFactoryNo.increaseNumber()
                    serial = UsaFactoryNo.serialNubmer
                }
            }
        }
    }

    class Genesis(private val country : Country) : Car(country){
        override fun carInfo(){
            println("이 자동차 모델은 제네시스, ${printSerial()}번입니다.")
        }
    }

    class Grandeur(private val country: Country) : Car(country){
        override fun carInfo(){
            println("이 자동차 모델은 그렌져, ${printSerial()} 번입니다.")
        }
    }
}

fun main(){
    val car1 = CarSerialNumber2.Genesis(CarSerialNumber2.Country.KOREA)
    val car2 = CarSerialNumber2.Grandeur(CarSerialNumber2.Country.KOREA)
    val car3 = CarSerialNumber2.Genesis(CarSerialNumber2.Country.KOREA)
    println()

    var car4 =  CarSerialNumber2.Genesis(CarSerialNumber2.Country.USA)
    var car5 =  CarSerialNumber2.Grandeur(CarSerialNumber2.Country.USA)
    println()

    car3.carInfo()
}