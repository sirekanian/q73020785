package com.sirekanian.so.q73020785

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sirekanian.so.q73020785.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var username by remember { mutableStateOf("") }
    var helloMessage by remember { mutableStateOf("") }
    var isDialogVisible by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = helloMessage.ifEmpty { "Welcome!" },
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.h5,
        )
        Button(
            onClick = { isDialogVisible = true },
            content = { Text("EDIT") },
        )
    }
    if (isDialogVisible) {
        MyAlertDialog(
            title = {
                Text(
                    text = "Enter Name",
                    style = MaterialTheme.typography.h6,
                )
            },
            content = {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Name") },
                )
            },
            dismissButton = {
                TextButton(
                    onClick = { isDialogVisible = false },
                    content = { Text("CANCEL") },
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        helloMessage = "Hello, $username!"
                        isDialogVisible = false
                    },
                    content = { Text("OK") },
                )
            },
            onDismiss = {
                isDialogVisible = false
            },
        )
    }
}
