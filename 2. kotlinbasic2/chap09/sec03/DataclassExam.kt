package com.example.kotlinbasic2.chap09.sec03
// Data Class

// Data Class 선언
data class Customer(val name : String, val age : Int, val tel : String) {
    init{
        println("멤버 속성이 초기화 되었습니다.")
    }

    var nationality : String = "KOREA"
    constructor(name : String, age: Int, tel : String, _nationality: String) : this(name, age, tel){
        nationality = _nationality
    }
}

fun main() {
    // 객체 생성
    val obj1 = Customer("손흥민", 28, "010-123-4567")
    val obj2 = Customer("이강인", 19, "010-456-7891")
    val obj3 = Customer("봉준호", 52, "010-789-1234", "Korea")


    // 객체를 println(obj1)로 출력하면 자동으로 생성된 toString()이 호출되어
    // 객체의 모든 속성값이 문자열로 변환된 후 출력함
    println("obj1 : $obj1")
    println("obj2 : $obj2")
    println("obj3 : $obj3")

    println("${obj3.name} 감독의 국적은 ${obj3.nationality} 입니다")

    // 자동으로 생성된 equals() 메서드가 호출되어 두 객체의 모든 속성값을 비교
    // 모든 속성의 값이 같으면 true 출력
    println(obj1 == obj2) // false

    // 각 객체의 해시 코드값을 비교하여 같으면 true 출력
    println(obj1.hashCode() == obj2.hashCode()) // false
    println("obj1.hashCode() : ${obj1.hashCode()} == obj2.hashCode() : ${obj2.hashCode()}")


    // copy() : 변경을 원하는 속성값만 바꾸고 나머지 속성은 복사시켜 새로운 객체 생성함
    val obj4 = obj1.copy(tel = "010-777-7777")
    println(obj4)
    println(obj4 == obj1) // false

    // === : 참조하는 객체가 같은지 비교함.
    println(obj4 === obj1) // 서로 다른 객체를 참조하고 있기 때문에 false


    // 객체 디스트럭처링(destructuring) : 객체가 가지고 있는 프로퍼티를 개별 변수로 분해
    // 데이터 클래스 구조를 기준으로 각 속성값을 변수로 추출해주는 componentN() 함수를 자동 생성, 호출해줌
    val (fname, fAge, fTel) = obj1  // 특정 속성을 추출할 필요가 없을때는 _ 를 넣어줌
    println("$fname, $fAge, $fTel")


    // 객체 데이터가 많은 경우 디스트럭처링
    val customerList = listOf(obj1, obj2, obj3, obj4) // 모든 객체를 컬렉션 List로 구성 후 for문으로 객체 프로퍼티 분해
    for ((name, age, tel) in customerList) {
        println("name : $name, age : $age, tel : $tel")
    }
    println("========================================")
    //람다식으로 디스트럭처링

    val lambdaCustom = { (name, age, tel): Customer ->
        println("name : $name, age : $age, tel : $tel")
    }

    for (obj in customerList) {
        lambdaCustom(obj)
    }

    println("=========================================")

    val obj5 = Customer("김민재", 27, "010-321-1234")
    val obj6 = Customer("김혜인", 17, "010-111-1111")
    val obj7 = Customer("최민아", 21, "010-333-3333")

    // 고객 등록
    val manager = CustomerManager()
    manager.joinCustomer(obj1)
    manager.joinCustomer(obj2)
    manager.joinCustomer(obj3)
   // manager.joinCustomer(obj4)
    manager.joinCustomer(obj5)
    manager.joinCustomer(obj6)
    manager.joinCustomer(obj7)

    // 등록 고객 리스트 출력
    manager.printAllCustomer()
}

class CustomerManager{
    // Customer 클래스 타입의 고객 리스트
    private val customList = ArrayList<Customer>()

    //회원가입
    fun joinCustomer(customer: Customer){
        when {
            customer.age < 20 -> {
                println("나이가 20세 미만 : ${customer.name} - ${customer.age}")
                return
            }
            else ->{
                println("나이가 20세 이상 : ${customer.name} - ${customer.age}")
            }
        }
        this.customList.add(customer)
    }

    //회원 리스트 출력
    fun printAllCustomer(){
        println("=".repeat(50))
        println(" === 등록 고객 리스트 (총 ${customList.size} 명) ===")
        println("=".repeat(50))

        this.customList.forEach{
            println(it)
        }
    }

}
