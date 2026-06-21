package com.appf1api.appf1api.authapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appf1api.appf1api.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onLogoutClick: () -> Unit,
    onRaceClick: () -> Unit,
    modifier: Modifier = Modifier,
    onDriverClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFF121212)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 420.dp),
                horizontalAlignment = Alignment.Start
            ) {
                when {
                    uiState.isLoading -> CircularProgressIndicator()
                    uiState.user != null -> {
                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lol),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    text = "Bienvenid(a), ${uiState.user?.name}",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = Color.White
                                )
                                Text(
                                    text = "Tu centro de control F1",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.LightGray
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = onRaceClick,
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF1E1E24)
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = "🏁 Próxima carrera",
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Color(0xFFE10600)
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                uiState.nextRace?.let { race ->

                                    Text(
                                        text = race.raceName,
                                        color = Color.White,
                                        style = MaterialTheme.typography.titleMedium
                                    )

                                    Text(
                                        text = race.circuitName,
                                        color = Color.LightGray
                                    )

                                    Text(
                                        text = race.country,
                                        color = Color.LightGray
                                    )

                                    Text(
                                        text = race.date,
                                        color = Color.LightGray
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF1E1E24)
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = "🏆 Clasificación de pilotos",
                                    color = Color(0xFFE10600),
                                    style = MaterialTheme.typography.titleLarge
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFF11131D)
                                    )
                                ) {
                                    Column(
                                        modifier = Modifier.padding(16.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Spacer(modifier = Modifier.width(16.dp))

                                            Text(
                                                text = "#",
                                                color = Color.Gray,
                                                modifier = Modifier.width(24.dp)
                                            )

                                            Spacer(modifier = Modifier.width(12.dp))

                                            Text(
                                                text = "PILOTO",
                                                color = Color.Gray,
                                                modifier = Modifier.weight(2f)
                                            )

                                            Text(
                                                text = "PTS",
                                                color = Color.Gray,
                                                modifier = Modifier.width(40.dp)
                                            )

                                            Text(
                                                text = "VIC",
                                                color = Color.Gray,
                                                modifier = Modifier.width(30.dp)
                                            )

                                            Spacer(modifier = Modifier.width(26.dp))
                                        }
                                        Spacer(modifier = Modifier.height(12.dp))

                                        uiState.drivers.take(10).forEach { driver ->
                                            val teamColor = when(driver.team){
                                                "Mercedes" -> Color.Cyan
                                                "Ferrari" -> Color.Red
                                                "McLaren" -> Color(0xFFFF8000)
                                                "Red Bull" -> Color(0xFF001A72)
                                                "Aston Martin" -> Color.Green
                                                "Alpine F1 Team" -> Color(0xFF0073CF)
                                                "Williams" -> Color(0xFF00A0FF)
                                                else -> Color.Gray
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clickable {
                                                        onDriverClick(driver.id)
                                                    }
                                                    .padding(vertical = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .width(4.dp)
                                                        .height(32.dp)
                                                        .background(teamColor)
                                                )

                                                Spacer(modifier = Modifier.width(12.dp))

                                                Text(
                                                    text = driver.position,
                                                    color = Color.White,
                                                    modifier = Modifier.width(20.dp)
                                                )
                                                Spacer(modifier = Modifier.width(12.dp))

                                                Column(
                                                    modifier = Modifier.weight(2f)
                                                ) {
                                                    Text(
                                                        text = driver.fullName,
                                                        color = Color.White,
                                                        style = MaterialTheme.typography.bodyLarge
                                                    )

                                                    Text(
                                                        text = driver.team,
                                                        color = Color.LightGray,
                                                        style = MaterialTheme.typography.bodySmall
                                                    )
                                                }

                                                Text(
                                                    text = driver.points,
                                                    color = Color.White,
                                                    modifier = Modifier.width(45.dp)
                                                )
                                                Text(
                                                    text = driver.wins,
                                                    color = Color(0xFFE10600),
                                                    modifier = Modifier.width(25.dp)
                                                )
                                                Spacer(modifier = Modifier.width(8.dp))

                                                Icon(
                                                    imageVector = Icons.Default.ChevronRight,
                                                    contentDescription = null,
                                                    tint = Color.Gray,
                                                    modifier = Modifier.size(18.dp)
                                                )
                                            }
                                            HorizontalDivider(
                                                thickness = 0.5.dp,
                                                color = Color(0xFF2A2D3A)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "🏭 Clasificación de constructores",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Spacer(modifier = Modifier.height(8.dp))

                                Text("1. McLaren")
                                Text("2. Ferrari")
                                Text("3. Mercedes")
                            }
                        }
                    }
                    uiState.errorMessage != null -> Text(
                        text = uiState.errorMessage,
                        color = MaterialTheme.colorScheme.error
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = onLogoutClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cerrar sesión")
                }
            }
        }
    }
}