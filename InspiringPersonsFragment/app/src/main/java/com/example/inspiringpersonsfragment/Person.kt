package com.example.inspiringpersonsfragment

import java.util.*

data class Person (
    val id: Int = 0,
    val name: String,
    val birthday: GregorianCalendar,
    val photo: String,
    var info: String,
    val quote: String){
}