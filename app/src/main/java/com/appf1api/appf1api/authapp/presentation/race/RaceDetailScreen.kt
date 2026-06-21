package com.appf1api.appf1api.authapp.presentation.race

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appf1api.appf1api.authapp.domain.model.Race
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip

@Composable
fun RaceDetailScreen(
    race: Race,
    onBackClick: () -> Unit
) {
    val formatter = SimpleDateFormat(
        "yyyy-MM-dd",
        Locale.getDefault()
    )
    val raceDate = formatter.parse(race.date)
    var remainingTime by remember {
        mutableStateOf(0L)
    }
    LaunchedEffect(Unit) {
        while (true) {
            remainingTime = if (raceDate != null) {
                raceDate.time - System.currentTimeMillis()
            } else {
                0L
            }
            delay(1000)
        }
    }
    val days = TimeUnit.MILLISECONDS.toDays(
        remainingTime
    )
    val hours = TimeUnit.MILLISECONDS.toHours(
        remainingTime
    ) % 24
    val minutes = TimeUnit.MILLISECONDS.toMinutes(
        remainingTime
    ) % 60
    val seconds = TimeUnit.MILLISECONDS.toSeconds(
        remainingTime
    ) % 60

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
            Row(
                verticalAlignment = Alignment.CenterVertically
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
                    text = "Carrera",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(
                    getCircuitImage(
                        race.circuitName
                    )
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(
                        RoundedCornerShape(
                            20.dp
                        )
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "🏁 ${race.raceName}",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1A1D29)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = days.toString(),
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.White
                    )

                    Text(
                        text = "DÍAS",
                        color = Color(0xFFE10600),
                        style = MaterialTheme.typography.titleSmall
                    )
                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CountdownItem(
                            value = hours.toString(),
                            label = "HORAS"
                        )
                        CountdownItem(
                            value = minutes.toString(),
                            label = "MIN"
                        )
                        CountdownItem(
                            value = seconds.toString(),
                            label = "SEG"
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1A1D29)
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(
                        text = "📍 Circuito",
                        color = Color.Red
                    )

                    Text(
                        text = race.circuitName,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "🌍 País",
                        color = Color.Red
                    )

                    Text(
                        text = race.country,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "🏙 Ciudad",
                        color = Color.Red
                    )

                    Text(
                        text = race.locality,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "📅 Fecha",
                        color = Color.Red
                    )

                    Text(
                        text = race.date,
                        color = Color.White
                    )
                }
            }
        }
    }
}
@Composable
fun CountdownItem(
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = label,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall
        )
    }
}