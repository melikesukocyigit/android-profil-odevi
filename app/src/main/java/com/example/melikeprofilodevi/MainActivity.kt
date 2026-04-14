package com.example.melikeprofilodevi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Scaffold ile ekranın temel yapısını kuruyoruz
            Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                ProfileScreen(Modifier.padding(paddingValues))
            }
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    // Skillset listesi
    val skills = listOf("Kotlin", "Android Studio", "Jetpack Compose", "Git & GitHub", "iOS Development")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- 1. Bölüm: Kişisel Bilgiler ve Fotoğraf ---

        // YENİ EKLENEN FOTOĞRAF KISMI
        Image(
            painter = painterResource(id = R.drawable.melike_profil),
            contentDescription = "Profil Resmi",
            contentScale = ContentScale.Crop, // Fotoğrafı esnetmeden yuvarlağın içine tam oturtur
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape) // Fotoğrafı yuvarlak keser
                .border(2.dp, Color.LightGray, CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Melike Su Koçyiğit",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Üsküdar Üniversitesi", fontSize = 18.sp, color = Color.Gray)

        Text(
            text = "Yazılım Mühendisi 4. Sınıf Öğrencisi",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFD81B60)
        )

        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        Spacer(modifier = Modifier.height(16.dp))

        // --- 2. Bölüm: Skillset Alanı (Liste) ---
        Text(
            text = "Yeteneklerim (Skillset)",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // LazyColumn ile listeden alınan elemanları gösteriyoruz
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(skills) { skill ->
                SkillItem(skillName = skill)
            }
        }
    }
}

@Composable
fun SkillItem(skillName: String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFFF5F5F5),
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "•",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD81B60)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = skillName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}