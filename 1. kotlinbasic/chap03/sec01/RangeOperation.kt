package com.example.kotlinprojects.chap03.sec01

// 범위 연산자는 시작값 .. 끝값으로 나타내며, 시작값과 끝값은 비교가 가능한 동일 타입이면서 끝값이 시작 값과 같거나 커야함.

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    val lowerAlphaRange = 'a'..'z'
    val numberRange = 1..100

    println("isLower : ${'d' in lowerAlphaRange}")
    println("isNumber : ${101 in numberRange}")
    println()

    // for 루프 반복 처리
    for(i in 1..10) print("$i, ")
    println()
    for(i in 'a'..'z') print("$i, ")
    println()

    // 날짜 범위 사용
    val start = LocalDate.now() // 현재 날짜를 가져옴.
    println("start : $start")
    // plusDays() ... 인자로 전달된 값을 현재 일자부터 더한 날짜를 범위로 변환
    val end = start..start.plusDays(5)
    println("end : $end")

    // plusWeeks() ... 인자로 전달된 값을 현재 요일에 더한 날짜로 변환(주 단위로)
    println("add weeks : ${start.plusWeeks(1)}")
    println("add weeks : ${start..start.plusWeeks(1)}")

}