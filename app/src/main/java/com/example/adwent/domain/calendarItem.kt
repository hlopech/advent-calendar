package com.example.adwent.domain

import androidx.compose.ui.graphics.Color


data class CalendarItem(
    val backgroundColor: Color,
    val title: String,
    val locked: Boolean = true,
    val dayNum: Int
)
