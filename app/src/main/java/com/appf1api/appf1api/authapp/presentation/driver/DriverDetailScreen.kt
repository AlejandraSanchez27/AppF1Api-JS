package com.appf1api.appf1api.authapp.presentation.driver

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appf1api.appf1api.authapp.domain.model.Driver
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource

@Composable
fun DriverDetailScreen(
    driver: Driver,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            val teamColor = when(driver.team){
                "Mercedes" -> Color.Cyan
                "Ferrari" -> Color.Red
                "McLaren" -> Color(0xFFFF8000)
                "Red Bull" -> Color(0xFF001A72)
                "Aston Martin" -> Color.Green
                "Alpine F1 Team" -> Color(0xFF00AEEF)
                "Williams" -> Color(0xFF00A0FF)
                else -> Color.Gray
            }
            Row(verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Piloto",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(Modifier.height(24.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(
                        getDriverImage(
                            driver.id
                        )
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(
                            3.dp,
                            teamColor,
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = driver.fullName,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
                Spacer(Modifier.height(8.dp))

                Text(
                    text = driver.nationality,
                    color = Color.Gray
                )
                Spacer(Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(4.dp)
                            .height(20.dp)
                            .background(teamColor)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = driver.team,
                        color = Color.LightGray
                    )
                }
                Spacer(Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1A1D29)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = driver.points,
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = "PUNTOS",
                                color = Color.Gray
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))

                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1A1D29)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = driver.wins,
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = "VICTORIAS",
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}