package com.example.myapplication
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Thème personnalisé intégré
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFFBB86FC),
                    secondary = Color(0xFF03DAC5),
                    background = Color(0xFFF2F2F2)
                )
            ) {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileSection()
            Spacer(modifier = Modifier.height(24.dp))
            ContactInfo()
        }
    }
}

@Composable
fun ProfileSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.nawal), // Ton image dans drawable
            contentDescription = "Photo de profil",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("ICHENE Nawal", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Data Analyst ", fontStyle = FontStyle.Italic, color = Color.Gray)
    }
}

@Composable
fun ContactInfo() {
    Column {
        ContactItem(Icons.Default.Phone, "+212 643613792")
        ContactItem(Icons.Default.Share, "@nawalich")
        ContactItem(Icons.Default.Email, "nawal.ichene@um5r.ac.ma")
    }
}

@Composable
fun ContactItem(icon: ImageVector, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.DarkGray,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(info)
    }
}
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        BusinessCard()
    }
}


