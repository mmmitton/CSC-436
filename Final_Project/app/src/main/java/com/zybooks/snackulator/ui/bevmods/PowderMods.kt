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
import com.zybooks.snackulator.data.Powder
import com.zybooks.snackulator.data.PowderDataSource
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.DropDownBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground

@Composable
fun PowderDis(beverage: Beverage) {
    // Iterate over the beverage’s powder map and display only those with pump count > 0.
    beverage.powders?.forEach { (powder, pumpCount) ->
        if (pumpCount > 0) {
            PowderBoxDis(powder, pumpCount) { newPumpCount ->
                if (newPumpCount <= 0) {
                    // Remove the powder if the pump count is zero or less.
                    beverage.powders?.remove(powder)
                } else {
                    // Otherwise update the pump count.
                    beverage.powders?.put(powder, newPumpCount)
                }
            }
        }
    }
}

@Composable
fun PowderBoxDis(
    powder: Powder,
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
                text = powder.name,
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
fun PowderDropDown(beverage: Beverage) {
    var expanded by remember { mutableStateOf(false) }
    // Change the label based on whether any powder is already added.
    val displayText = if (beverage.powders.isNullOrEmpty()) "Add Powder" else "Add Another Powder"

    // Retrieve available powders from your data source.
    val powderData = PowderDataSource()
    val powderOptions = powderData.getPowderList()

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
            powderOptions.forEach { powder ->
                DropdownMenuItem(
                    text = { Text(text = powder.name, color = ButtonBackground) },
                    onClick = {
                        if (beverage.powders == null) {
                            // If null, initialize with a stateful map.
                            beverage.powders = mutableStateMapOf(powder to 1)
                        } else {
                            // Increment the count if the powder already exists; otherwise add it with a count of 1.
                            val currentCount = beverage.powders?.get(powder) ?: 0
                            beverage.powders?.put(powder, currentCount + 1)
                        }
                        expanded = false
                    }
                )
            }
        }
    }
}

