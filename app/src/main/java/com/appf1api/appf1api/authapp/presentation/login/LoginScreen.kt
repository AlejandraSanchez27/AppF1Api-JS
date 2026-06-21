package com.appf1api.appf1api.authapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.appf1api.appf1api.authapp.presentation.components.AuthTextField
import com.appf1api.appf1api.authapp.presentation.components.LoadingButton
import com.appf1api.appf1api.authapp.presentation.components.PasswordTextField
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import com.appf1api.appf1api.R
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.lazy.LazyColumn

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors=listOf(
                        Color(0xFFE10600),
                        Color(0xFFB00000),
                        Color(0xFF4A0000),
                        Color.Black
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Image(
                    painter = painterResource(
                        R.drawable.lol
                    ),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp)
                        .clip(CircleShape)
                )

                Text(
                    text = "App F1 Api",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )

                Text(
                    text = "Tu centro de control de Formula 1",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(40.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF2E2E34)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {
                        AuthTextField(
                            value = uiState.email,
                            onValueChange = onEmailChange,
                            label = "Correo electronico",
                            modifier = Modifier.fillMaxWidth(),
                            keyboardType = KeyboardType.Email
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        PasswordTextField(
                            value = uiState.password,
                            onValueChange = onPasswordChange,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        LoadingButton(
                            text = "Iniciar sesion",
                            isLoading = uiState.isLoading,
                            onClick = onLoginClick,
                            modifier = Modifier.fillMaxWidth(),
                            containerColor = Color(0xFFE10600),
                            contentColor = Color.White
                        )
                    }
                }
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                TextButton(
                    onClick = onRegisterClick
                ) {
                    Text(
                        text = "¿No tienes cuenta? Registrate",
                        color = Color.White
                    )
                }
            }
        }
    }
}