package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReactiveScreen() {
    // State for the counter
    var count by remember { mutableStateOf(0) }
    
    // State for the name (rememberSaveable to survive rotation)
    var name by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Part B: Reactive Greeting
        Text(
            text = if (name.isBlank()) "Hello, stranger!" else "Hello, $name!",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        // Part D: Hoisted Counter Controls
        CounterControls(
            count = count,
            onIncrement = { count++ },
            onDecrement = { count-- },
            onReset = { count = 0 }
        )
    }
}

@Composable
fun CounterControls(
    count: Int, // value flows DOWN
    onIncrement: () -> Unit, // events flow UP
    onDecrement: () -> Unit,
    onReset: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Count: $count", fontSize = 24.sp)
        
        Spacer(Modifier.height(16.dp))
        
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = onDecrement) { Text("–") }
            Button(onClick = onReset) { Text("Reset") }
            Button(onClick = onIncrement) { Text("+") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReactiveScreenPreview() {
    MaterialTheme {
        Surface {
            ReactiveScreen()
        }
    }
}
