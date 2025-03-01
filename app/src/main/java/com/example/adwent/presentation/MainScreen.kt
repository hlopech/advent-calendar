package com.example.adwent.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.adwent.R
import com.example.adwent.presentation.utils.checkDay
import com.example.adwent.presentation.utils.shimmerBrush
import com.example.adwent.presentation.viewModel.MainViewModel
import com.example.adwent.ui.theme.Pink

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {

    val viewModel: MainViewModel = viewModel()

    val calendarList = viewModel.calendarList
    Scaffold(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        shimmerBrush(
                            targetValue = 15000f,
                            showShimmer = true
                        )
                    )
                    .paint(
                        painterResource(R.drawable.background),
                        contentScale = ContentScale.FillBounds
                    )
            ) {

                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier.padding(top = 50.dp),
                    border = BorderStroke(1.dp, Color.Red),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "Адветн календарик\n для Марго",
                        color = Color.Red,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight(900),
                        modifier = Modifier.padding(15.dp)
                    )

                }

                Spacer(Modifier.fillMaxHeight(0.1f))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.padding(8.dp)
                ) {
                    items(calendarList) { item ->

                        ElevatedButton(
                            modifier = Modifier
                                .padding(4.dp)
                                .height(100.dp),
                            onClick = {
                                if (checkDay(item.dayNum)) {
                                    navController.navigate("prizeScreen")
                                } else {
                                }
                            },
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.elevatedButtonColors(
                                when (checkDay(item.dayNum)) {
                                    true -> item.backgroundColor
                                    else -> Color.Gray
                                }
                            )
                        ) {

                            Text(
                                text = item.title,
                                color = Color.White,
                                fontSize = 30.sp,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .wrapContentHeight(),
                                textAlign = TextAlign.Center

                            )
                        }
                    }
                }
            }
        }
    )
}

