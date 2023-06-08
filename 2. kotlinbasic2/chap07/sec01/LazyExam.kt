package com.example.kotlinbasic2.chap07.sec01

import android.accounts.Account

fun main(){

    val account = Account()

    println(account.balance)
    println("========================")
    println("account.balance : ${account.balance}")
}

class Account(){
    init{
        println("init block")
    }
    val balance : Int by lazy{
        print("Setting balance : ")
        10000
    }
}