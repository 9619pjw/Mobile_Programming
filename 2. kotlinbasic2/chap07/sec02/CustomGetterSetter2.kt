package com.example.kotlinbasic2.chap07.sec02


fun main(){
    val sony = Friend()
    println("#1 : ${sony.name}, ${sony.tel}, ${sony.type}")

    sony.name = "손흥민"
    sony.tel = "010-123-4567"
    sony.type = 1
    println("#2 : ${sony.name}, ${sony.tel}, ${sony.type}")

}

//field 특성
// 속성이 생성될 때 해당 속성에 자동으로 만들어지는 식별자로서 해당 속성을 직접 참조함
// field를 사용하면 get()과 set() 내부에서 게터 / 세터 호출하지 않고 private로 선언된 해당 속성의 값을 직접 가져오거나 변경할 수 있음
// field를 사용하면 get()이나 set() 에서 속성을 참조할 때 발생하는 재귀호출을 막을 수 있음
class Friend{
    var name : String? = null
        get() {
            println("#3: name 속성 Getter 호출")
            return if (field != null) field else "이름없음"
        }
        set(value){
            field = value
            println("#4: name 속성 Setter 호출 name = $field")
        }
    var tel : String? = null
        get(){
            println("#5: tel 속성 Getter 호출")
            return if (field != null) field else "전화번호 없음"
        }
        set(value){
            field = value
            println("#6 : tel 속성 Setter 호출 tel = $field")
        }


    var type : Int = 4
        get(){
            println("#7 : type 속성 Getter 호출")
            return field
        }
        set(value : Int){
            field = if(value < 4) value else 4
            println("#8: type 속성 Setter 호출 type = $field")
        }

}