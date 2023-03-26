package com.example.kotlinprojects.chap05.sec01

class Address(val streetAddress: String, val zipCode: Int)
class Company(val companyName: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun main(){
    val address = Address("경기 성남시 분당구 정자일로 95", 13561)
    val naver = Company("네이버", address)
    val sony = Person("손흥민", naver)
    val alex = Person("알렉스", null)

    try{
        printAddress(sony)
        printAddress(alex)
    }catch(e: IllegalArgumentException){
        print(e.message)
    }
}

fun printAddress(person: Person){
    val address = person.company?.address
        ?: throw IllegalArgumentException("주소가 없습니다.")

    with(address){
        println("회사주소 : $streetAddress")
        println("우편번호 : $zipCode")
        println("수신자 : ${person.name}")
    }
}
