package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Myapplication()
            }
        }
    }
}

@Composable
fun Myapplication() {

    var newItem by remember { mutableStateOf("") }
    val groceries = remember {
        mutableStateListOf(
            "Biscuit",
            "Egg",
            "Milk",
            "Bread",
            "Apple",
            "Banana",
            "Chicken",
            "Rice",
            "Coffee",
            "Sugar"
        )
    }
    var errorMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "My Grocery List", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = newItem,
                onValueChange = { 
                    newItem = it
                    errorMessage = "" // Clear error when user types
                },
                label = { Text("Enter an item") },
                modifier = Modifier.weight(1f),
                isError = errorMessage.isNotEmpty()
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                // Challenge 1: ignore empty/blank items
                if (newItem.isNotBlank()) {
                    val trimmedItem = newItem.trim()
                    // Challenge 2: prevent duplicates (case-insensitive)
                    if (groceries.contains(trimmedItem)) {
                        errorMessage = "Item already exists!"
                    } else {
                        groceries.add(trimmedItem)
                        newItem = ""
                        errorMessage = ""
                    }
                }
            }) {
                Text("Add")
            }
        }
        
        // Display error message if any
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Total items: ${groceries.size}", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(8.dp))


        Button(onClick = { 
            groceries.clear()
            errorMessage = ""
        }) {
            Text("Clear All")
        }

        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn {
            items(groceries) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item, fontSize = 18.sp)
                    IconButton(onClick = { groceries.remove(item) }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Delete")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GroceryListAppPreview() {
    MaterialTheme {
        Myapplication()
    }
}
