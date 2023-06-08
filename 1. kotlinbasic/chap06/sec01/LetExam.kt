package com.example.kotlinprojects.chap06.sec01
// let 함수
// safe Calls(?.) 연산자와 함께 null 처리


fun main(){
    // getUserID() 함수에서 반환된 사용자 ID로 초기화
    // => 사용자 ID를 null값으로 반환할 수 있음(userID를 String? 선언)
    val userID : String? = getUserID()

    // 사용자 ID를 인자로 sendNotification(userID) 함수를 호출하여
    // 사용자에게 알림 메시지를 전송하는 방법
    // [방법 1] ... null 처리없이 sendNotification(userID:String) 함수 호출
    // : 매개변수의 타입이 String이므로 Type mismatch 오류가 발생 -> null이 아님을 확인하는 로직 필요함
    // sendNotification(userID) // error : Type mismatch

    // [방법 2] ... if문으로 userID가 null이 아닌지 검사한 후 sendNotification(userID) 함수 호출
    if (userID != null) sendNotification(userID)

    // [방법 3] ... 안전호출 연산자 (?.)를 이용하여 null 처리 후, let 함수를 이용해 sendNotification(userID) 함수 호출
    // 1) ?. 이용하여 userID 값이 null이 아니면 let 함수 실행
    // 2) let 함수는 인자로 전달된 함수나 람다식을 실행한 후 그 결과값을 반환함
    // 람다식({})을 let 함수의 인자로 전달.
    // 람다식 : "userID"를 매개변수로 받아 sendNotification(userID) 함수 호출
    userID?.let{userID -> sendNotification(userID)}


    // [방법 4] ... 방법 3 람다식 간략화하여 sendNotification(userID) 함수 호출
    // let 함수에서 함수타입(userID ->)을 생략하고, sendNotification(it) 함수 호출
    // it은 코틀린의 키워드로, let 함수를 호출할 때 전달되는 인자(userID)를 말함
    userID?.let{sendNotification(it)}

    // 엘비스 연산자 ?: 사용하여 userID가 null일때 로직을 처리함
    userID?.let{sendNotification(it)}?:run{println("아이디가 없습니다!")}

    // [방법 5] ... userID 변수의 값이 null이 아니면, let 함수에 직접 실행할 코드블럭을 전달하여 실행
    userID?.let{
        println("$it 님에게 알림 메시지를 보냈습니다.")
    }?: run{
        println("userID가 null입니다.")
    }
}
// 사용자 id를 반환하는 함수
fun getUserID() : String?{
    return "user01"
}

// 사용자에게 알림 메시지를 보내는 함수
fun sendNotification(userID : String){
    println("$userID 님에게 알림 메시지를 보냈습니다.")
}