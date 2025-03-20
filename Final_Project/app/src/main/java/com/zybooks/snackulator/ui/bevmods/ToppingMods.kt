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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.rounded.Close
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
import com.zybooks.snackulator.data.Topping
import com.zybooks.snackulator.data.ToppingDataSource
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.DropDownBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground

@Composable
fun ToppingDis(beverage: Beverage) {
    // Iterate over the current toppings list.
    beverage.toppings?.forEach { topping ->
        TopBoxDis(topping = topping, onRemove = {
            // Remove the topping by filtering it out of the current list.
            beverage.toppings = beverage.toppings?.filter { it != topping }
        })
    }
}

@Composable
fun TopBoxDis(topping: Topping, onRemove: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .border(6.dp, color = HeaderBackground, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = topping.toppingType.toString(),
                color = ButtonBackground,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                Icons.Rounded.Close,
                contentDescription = "Remove Topping",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onRemove() },
                tint = HeaderBackground
            )
        }
    }
}


@Composable
fun ToppingDropDown(beverage: Beverage) {
    var expanded by remember { mutableStateOf(false) }
    val displayText = if (beverage.toppings.isNullOrEmpty()) "Add Topping" else "Add Another Topping"

    // Get the list of available toppings from your data source.
    // Assuming ToppingDataSource is similar to your other data sources.
    val toppingData = ToppingDataSource()
    val toppingOptions = toppingData.getToppingList()

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
            toppingOptions.forEach { topping ->
                DropdownMenuItem(
                    text = {
                        // Display the topping's name.
                        Text(text = topping.toppingType.toString(), color = ButtonBackground)
                    },
                    onClick = {
                        // Add the topping to the beverage's toppings list.
                        if (beverage.toppings.isNullOrEmpty()) {
                            beverage.toppings = mutableListOf(topping)
                        } else {
                            // Append the new topping. (Duplicates are allowed here; add a check if needed.)
                            beverage.toppings = beverage.toppings!! + topping
                        }
                        expanded = false
                    }
                )
            }
        }
    }
}

