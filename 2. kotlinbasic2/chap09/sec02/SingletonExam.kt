package com.example.kotlinbasic2.chap09.sec02
// object 키워드를 이용한 singletone 구현

class CarSerialNumber {
    // 국가명 상수로 enum class 선언
    enum class Country(val label: String){
        KOREA("한국"), USA("미국")
    }

    // 한국 공장 singleton ... 제품 시리얼 번호
    object KoreanFactoryNo{
        var serialNumber = 0
            set(value){
                field = value
                println("Current-serial-No(KOREA): $serialNumber")
            }
        fun increaseNumber(){
            serialNumber++
        }
    }

    // 미국 공장 singleton ... 제품 시리얼 번호
    object UsaFactoryNo {
        var serialNumber = 0
            set(value){
                field = value
                println("Current-serial-No(USA) : $serialNumber")
            }
        fun increaseNumber(){
            serialNumber++
        }
    }

    class Genesis(private val country : Country){
        private val serial : Int // 품번

        init {
            when(country){
                Country.KOREA ->{
                    KoreanFactoryNo.increaseNumber()
                    serial = KoreanFactoryNo.serialNumber
                }
                Country.USA -> {
                    UsaFactoryNo.increaseNumber()
                    serial = UsaFactoryNo.serialNumber
                }
            }
        }
    }
    class Grandure(private val country : Country){
        private val serial: Int

        init{
            when(country){
                Country.KOREA -> {
                    KoreanFactoryNo.increaseNumber()
                    serial = KoreanFactoryNo.serialNumber
                }
                Country.USA -> {
                    UsaFactoryNo.increaseNumber()
                    serial = UsaFactoryNo.serialNumber
                }
            }
        }
    }
}

fun main(){
    val car1 = CarSerialNumber.Genesis(CarSerialNumber.Country.KOREA)
    val car2 = CarSerialNumber.Genesis(CarSerialNumber.Country.KOREA)
    val car3 = CarSerialNumber.Grandure(CarSerialNumber.Country.KOREA)

    println("현재 한국 생산 시리얼 번호 : ${CarSerialNumber.KoreanFactoryNo.serialNumber}")
    println()

    val car4 = CarSerialNumber.Genesis(CarSerialNumber.Country.USA)
    val car5 = CarSerialNumber.Grandure(CarSerialNumber.Country.USA)
    println("현재 미국 생산 시리얼 번호 : ${CarSerialNumber.UsaFactoryNo.serialNumber}")
}