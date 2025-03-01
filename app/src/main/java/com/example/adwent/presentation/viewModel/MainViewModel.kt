package com.example.adwent.presentation.viewModel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.adwent.domain.CalendarItem
import com.example.adwent.domain.DayNum
import com.example.adwent.ui.theme.Pink
import com.example.adwent.ui.theme.Pink2
import com.example.adwent.ui.theme.Purple
import com.example.adwent.ui.theme.Purple2
import com.example.adwent.ui.theme.Purple3
import com.example.adwent.ui.theme.Red
import com.example.adwent.ui.theme.Red2

class MainViewModel : ViewModel() {

    val calendarList = listOf(
        CalendarItem(Color.Red, "День 1", false, 10),
        CalendarItem(Purple, "День 2", false, 11),
        CalendarItem(Pink, "День 3", false, 12),
        CalendarItem(Pink2, "День 4", false,13),
        CalendarItem(Red, "День 5", false,14),
        CalendarItem(Purple2, "День 6", false,15),
        CalendarItem(Purple3, "День 7", false,16),
        CalendarItem(Red2, "День 8", false,17),
    )
}