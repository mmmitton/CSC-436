package com.zybooks.snackulator.ui.bevmods

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.snackulator.data.Beverage
import com.zybooks.snackulator.data.Milk
import com.zybooks.snackulator.data.MilkDataSource
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.DropDownBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground

@Composable
fun MilkDropDown(beverage: Beverage, onMilkChange: (Milk) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val milkData = MilkDataSource()
    val milkOptions = milkData.getMilkList()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .border(6.dp, color = HeaderBackground, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = beverage.milk?.milk_type?.name ?: "Choose Milk",
                color = ButtonBackground,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.ArrowDropDown, contentDescription = "More options")
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(color = DropDownBackground)
        ) {
            milkOptions.forEach { milk ->
                DropdownMenuItem(
                    text = { Text(text = milk.milk_type.name, color = ButtonBackground) },
                    onClick = {
                        // Instead of updating local state, call the callback.
                        onMilkChange(milk)
                        expanded = false
                    }
                )
            }
        }
    }
}

