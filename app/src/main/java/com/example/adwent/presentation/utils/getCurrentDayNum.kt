package com.example.adwent.presentation.utils

import java.time.LocalDate

fun getCurrentDayNum(): Int {
    val currentDate = LocalDate.now()
    return currentDate.dayOfMonth
}

fun checkDay(dayNum: Int): Boolean {
    return when (dayNum == getCurrentDayNum()) {
        true -> true
        else -> false
    }
}