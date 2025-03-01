package com.example.adwent.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import java.time.LocalDate

@Composable
fun PrizeScreen(navController: NavController) {
    val currentDate = LocalDate.now()

    val day = currentDate.dayOfMonth
    when(day){
        10->{
            Text("1")
        }
        11->{
            Text("2")

        }
        12->{
            Text("3")

        }
        13->{
            Text("4")

        }
        14->{
            Text("5")

        }
        15->{
            Text("7")

        }
        16->{
            Text("6")

        }
        17->{
            Text("17")

        }
    }
}