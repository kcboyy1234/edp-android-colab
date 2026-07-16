package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FC))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF5B86E5),
                                Color(0xFF36D1DC)
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color(0xCC0D47A1)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier.align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(R.drawable.profile_photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .border(
                            5.dp,
                            Color.White,
                            CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                "Kyle Christian B Gonzales",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "BSIT Student • Android Developer",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "About Me",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                "KOKAK"
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Skills",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            val skills = listOf(
                "Kotlin",
                "Android",
                "Compose",
                "Java"
            )

            LazyRow {

                items(skills) {

                    AssistChip(
                        onClick = { },
                        label = {
                            Text(it)
                        }
                    )

                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            ContactCard(
                Icons.Default.Phone,
                "0936-821-8210git --version"
            )

            ContactCard(
                Icons.Default.Email,
                "kcgonzales78193@liceo.edu.ph"
            )

            ContactCard(
                Icons.Default.LocationOn,
                "Cagayan de Oro City"
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                StatItem("12", "Projects")
                StatItem("6", "Skills")
                StatItem("2026", "Year")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(30.dp)
            ) {

                Text(
                    "Contact Me",
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun ContactCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(18.dp)
    ) {

        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF2962FF)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(text)
        }
    }
}

@Composable
fun StatItem(
    number: String,
    label: String
) {

    Card(
        shape = RoundedCornerShape(18.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                number,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Text(label)
        }
    }
}