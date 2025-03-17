package com.zybooks.snackulator.ui.bevmods

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown

import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
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

import com.zybooks.snackulator.data.Syrup
import com.zybooks.snackulator.data.SyrupDataSource
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.DropDownBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground


@Composable
fun SyrupDis(beverage: Beverage) {
    // Iterate over the beverage’s syrup map and display only those with pump count > 0.
    beverage.syrups?.forEach { (syrup, pumpCount) ->
        if (pumpCount > 0) {
            SyrupBoxDis(syrup, pumpCount) { newPumpCount ->
                if (newPumpCount <= 0) {
                    // Remove the syrup if the count is zero or less.
                    beverage.syrups?.remove(syrup)
                } else {
                    // Otherwise, update the pump count.
                    beverage.syrups?.put(syrup, newPumpCount)
                }
            }
        }
    }
}

@Composable
fun SyrupBoxDis(
    syr: Syrup,
    pumps: Int,
    onPumpChange: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .border(6.dp, color = HeaderBackground, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = syr.name,
                color = ButtonBackground,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                Icons.Rounded.Close,
                contentDescription = "Remove Pump",
                modifier = Modifier.clickable {
                    if (pumps > 0) {
                        onPumpChange(pumps - 1)
                    }
                },
                tint = HeaderBackground
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = pumps.toString(),
                color = ButtonBackground,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                Icons.Default.AddCircle,
                contentDescription = "Add Pump",
                modifier = Modifier.clickable {
                    onPumpChange(pumps + 1)
                },
                tint = HeaderBackground
            )
        }
    }
}


@Composable
fun SyrupDropDown(beverage: Beverage) {
    var expanded by remember { mutableStateOf(false) }

    val syrupData = SyrupDataSource()
    val syrOptions = syrupData.getSyrupList()

    // Display a label based on whether any syrup is already added.
    val displayText = if (beverage.syrups.isNullOrEmpty()) "Add Syrup" else "Add Another Syrup"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { expanded = !expanded })
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
                text = displayText,
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
            syrOptions.forEach { syrup ->
                DropdownMenuItem(
                    text = { Text(text = syrup.name, color = ButtonBackground) },
                    onClick = {
                        if (beverage.syrups == null) {
                            // Initialize the stateful syrup map if needed.
                            beverage.syrups = mutableStateMapOf(syrup to 1)
                        } else {
                            val currentCount = beverage.syrups?.get(syrup) ?: 0
                            if (currentCount == 0) {
                                // Remove the syrup if its count is 0, then add it with a count of 1.
                                beverage.syrups?.remove(syrup)
                                beverage.syrups?.put(syrup, 1)
                            } else {
                                // Otherwise, just increment the pump count.
                                beverage.syrups?.put(syrup, currentCount + 1)
                            }
                        }
                        expanded = false
                    }
                )
            }
        }

    }
}



