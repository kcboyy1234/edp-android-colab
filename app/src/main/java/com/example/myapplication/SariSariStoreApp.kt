package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Custom Colors
val StoreBlue = Color(0xFF1976D2)
val StorePink = Color(0xFFE91E63)
val StoreLightGray = Color(0xFFF5F5F5)
val StoreTextSecondary = Color(0xFF757575)

@Composable
fun SariSariStoreApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        StoreHeader()
        NavigationTabs()
        Spacer(modifier = Modifier.height(16.dp))
        ProductsSection()
    }
}

@Composable
fun StoreHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
            .background(StoreBlue)
            .padding(16.dp),
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(Color.Green),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Crokocyle Sari-Sari",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Text(
                text = "di pwede utang hahahaha",
                color = Color.White,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Aug 3, 08:06 PM",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.AccountCircle,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp),
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Cashier", color = Color.White, fontSize = 14.sp)
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.3f)),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    modifier = Modifier.height(32.dp),
                ) {
                    Text(text = "Switch Cashier", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun NavigationTabs() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TabItem("Bilihan\n(POS)", isActive = true)
        TabItem("Mga\nTransaksyon", isActive = false)
        TabItem("Ulat\n(Reports)", isActive = false)
    }
}

@Composable
fun TabItem(label: String, isActive: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            color = if (isActive) StorePink else StoreTextSecondary,
            fontSize = 14.sp,
            fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        if (isActive) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(2.dp)
                    .background(StorePink)
            )
        }
    }
}

@Composable
fun ProductsSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Mga Paninda (Products)",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search product name", fontSize = 14.sp) },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = StoreLightGray,
                    unfocusedBorderColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(StoreLightGray, RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "All prices", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Categories Grid
        val categories = listOf(
            CategoryData("All", StorePink, isActive = true),
            CategoryData("Bakery", Color(0xFFFDECEA)),
            CategoryData("Beverages", Color(0xFFE3F2FD)),
            CategoryData("Dairy & Eggs", Color(0xFFFFFDE7)),
            CategoryData("Desserts &\nKakanin", Color(0xFFFCE4EC)),
            CategoryData("Fresh Produce", Color(0xFFE8F5E9)),
            CategoryData("Frozen Goods", Color(0xFFE0F7FA)),
            CategoryData("Meat &\nSeafood", Color(0xFFFFEBEE)),
            CategoryData("Pantry &\nCondiments", Color(0xFFF3E5F5)),
            CategoryData("Rice & Grains", Color(0xFFEFEBE9)),
            CategoryData("Snacks", Color(0xFFFFF3E0))
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.heightIn(max = 300.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = StoreTextSecondary)
        ) {
            Text("View all available products")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Product Example
        ProductCard()
    }
}

@Composable
fun CategoryCard(data: CategoryData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = if (data.isActive) data.color else StoreLightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.White.copy(alpha = 0.8f), CircleShape)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = data.name,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                color = if (data.isActive) Color.White else Color.Black,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                lineHeight = 12.sp
            )
        }
    }
}

@Composable
fun ProductCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = StoreLightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(text = "#1", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFFFFF3E0), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(text = "SNACKS", fontSize = 10.sp, color = Color(0xFFE65100))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Dried Mangoes (200g)", fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "P 180.00", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = StoreBlue)
        }
    }
}

data class CategoryData(val name: String, val color: Color, val isActive: Boolean = false)

@Preview(showBackground = true)
@Composable
fun SariSariStorePreview() {
    SariSariStoreApp()
}
