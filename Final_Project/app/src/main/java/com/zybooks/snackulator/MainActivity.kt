package com.zybooks.snackulator

import com.zybooks.snackulator.ui.SnackApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.zybooks.snackulator.ui.theme.SnackulatorTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnackulatorTheme {
                SnackApp()
            }
        }
    }
}