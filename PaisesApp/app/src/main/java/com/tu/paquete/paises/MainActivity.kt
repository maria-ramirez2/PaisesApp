package com.tu.paquete.paises // CAMBIA ESTO por el nombre real de tu paquete

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

// ... (mismos imports anteriores)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    val countries = remember {
        mutableStateListOf(
            "Panamá", "México", "Argentina", "Chile", "Colombia",
            "España", "Italia", "Francia", "Japón", "Brasil",
            "Canadá", "Alemania", "Portugal", "Corea del Sur"
        )
    }
    val favorites = remember { mutableStateListOf<String>() }
    var showFavorites by remember { mutableStateOf(false) }

    // Definimos el color turquesa una sola vez para reutilizarlo
    val primaryColor = Color(0xFF00B6BA)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (showFavorites) "Países Favoritos" else "Directorio de Países",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif // Aplicado aquí
                    )
                },
                actions = {
                    Button(
                        onClick = { showFavorites = !showFavorites },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor), // Color turquesa
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Ver " + if (showFavorites) "Todos" else "Favoritos")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (!showFavorites) {
                CountryInput(
                    onAdd = { newCountry -> if (newCountry.isNotBlank()) countries.add(newCountry) },
                    buttonColor = primaryColor // Pasamos el color al input
                )

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(countries) { country ->
                        CountryCard(
                            name = country,
                            accentColor = primaryColor, // Pasamos el color al card
                            onFavorite = {
                                if (!favorites.contains(country)) favorites.add(country)
                            }
                        )
                    }
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(favorites) { favorite ->
                        CountryCard(
                            name = favorite,
                            onFavorite = {},
                            isFavoriteView = true,
                            accentColor = primaryColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CountryInput(onAdd: (String) -> Unit, buttonColor: Color) {
    var text by remember { mutableStateOf("") }

    Row(modifier = Modifier.padding(16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Escribe un país", fontFamily = FontFamily.Serif) },
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { onAdd(text); text = "" },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            modifier = Modifier.height(56.dp)
        ) {
            Text("Agregar", fontFamily = FontFamily.Serif)
        }
    }
}

@Composable
fun CountryCard(name: String, onFavorite: () -> Unit, accentColor: Color, isFavoriteView: Boolean = false) {
    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFBFBFB)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.3f)) // Borde sutil del color turquesa
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif, // Aplicado aquí
                color = Color(0xFF1A1A1A)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                TextButton(onClick = {
                    Toast.makeText(context, "Detalles de: $name", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Detalles", color = accentColor, fontFamily = FontFamily.Serif)
                }

                if (!isFavoriteView) {
                    ElevatedButton(
                        onClick = onFavorite,
                        colors = ButtonDefaults.elevatedButtonColors(contentColor = accentColor)
                    ) {
                        Text("Favorito", fontFamily = FontFamily.Serif)
                    }
                }
            }
        }
    }
}