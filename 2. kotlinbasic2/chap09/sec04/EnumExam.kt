package com.example.kotlinbasic2.chap09.sec04

// enum class

enum class FriendType{
    SCHOOL, COMPANY, SNS, OTHERS
}

// enum 항목을 인자로 받아 문자열로 반환하는 함수 선언
// enum 클래스인 FriendType을 인자로 받아 when 표현식으로 항목을 구분하여 문자열로 반환
fun getFriendTypeName(friend: FriendType) =
    when(friend) {
        FriendType.SCHOOL -> "학교 친구"
        FriendType.COMPANY -> "회사 친구"
        FriendType.SNS -> "SNS 친구"
        FriendType.OTHERS -> "기타 친구"
    }

fun main(){
    // enum 클래스 상수 참조
    println(FriendType.SCHOOL)
    println(FriendType.SCHOOL.ordinal)
    println(FriendType.COMPANY.ordinal)
    println(FriendType.COMPANY.name)
    println(FriendType.SNS.toString())
    println(FriendType.valueOf("COMPANY"))

    // FriendType 클래스의 모든 항목 이름을 배열로 생성
    val friends = FriendType.values()
    for(item in friends){
        println(item)
    }

    //enum 항목을 인자로 받아 문자열로 반환하는 getFriendTypeName() 함수 호출
    println(getFriendTypeName(FriendType.SCHOOL))
    println(getFriendTypeName(FriendType.SNS))
}