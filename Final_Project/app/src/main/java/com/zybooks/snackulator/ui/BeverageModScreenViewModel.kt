package com.zybooks.snackulator.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.zybooks.snackulator.data.Beverage

@Composable
fun BeverageModScreenViewModel(initialBeverage: Beverage) {
    var beverage by remember { mutableStateOf(initialBeverage) }
    BeverageModScreen(
        beverage = beverage,
        onUpdate = { updatedBeverage ->
            beverage = updatedBeverage
        }
    )
}
