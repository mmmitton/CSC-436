package com.zybooks.snackulator.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.snackulator.data.Beverage
import com.zybooks.snackulator.data.Milk
import com.zybooks.snackulator.ui.bevmods.DrizzleDis
import com.zybooks.snackulator.ui.bevmods.MilkDropDown
import com.zybooks.snackulator.ui.bevmods.PowderDis
import com.zybooks.snackulator.ui.bevmods.PowderDropDown
import com.zybooks.snackulator.ui.bevmods.SauceDropDown
import com.zybooks.snackulator.ui.bevmods.SizeDropDown
import com.zybooks.snackulator.ui.bevmods.SyrupDis
import com.zybooks.snackulator.ui.bevmods.SyrupDropDown
import com.zybooks.snackulator.ui.bevmods.ToppingDis
import com.zybooks.snackulator.ui.bevmods.ToppingDropDown
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground

@Composable
fun BeverageModScreen(beverage: Beverage,  onUpdate: (Beverage) -> Unit){
    LazyColumn() {
        item{
            BevModTagline()
        }

        item{
            Row(){
                DisplayCard(beverage)
                NutritionDisplay(beverage)
            }

        }

        item{
            Text(
                text = "Choose Drink Size",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 6.dp)

            )
        }

        item {
            SizeDropDown(beverage = beverage, onSizeChange = { newSize ->
                // Update the beverage and notify the view model.
                beverage.size = newSize
                onUpdate(beverage)
            })
        }

        item{
            Text(
                text = "Choose Milk Option",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 6.dp)

            )
        }

        item {
            MilkDropDown(beverage = beverage, onMilkChange = { newMilk: Milk ->
                beverage.milk = newMilk
                onUpdate(beverage)
            })
        }

        item{
            Text(
                text = "Choose Syrup Options",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 6.dp)

            )
        }

        item{
            if(beverage.sauces != null) {
                Column {
                    SyrupDis(beverage)
                    SyrupDropDown(beverage)
                }

            }else{
                SyrupDropDown(beverage)
            }

        }

        item{
            Text(
                text = "Choose Topping Options",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 6.dp)

            )
        }

        item{
            if(beverage.toppings != null){
                ToppingDis(beverage)
                ToppingDropDown(beverage)

            }else{
                ToppingDropDown(beverage)
            }

        }

        item{
            Text(
                text = "Choose Drizzle Options",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 6.dp)
            )
        }

        item{
            if(beverage.sauces != null){
                DrizzleDis(beverage)
                SauceDropDown(beverage)
            }else{
                SauceDropDown(beverage)
            }

        }

        item{
            Text(
                text = "Choose Powder Options",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 6.dp)

            )
        }

        item{
            if(beverage.powders != null){
                PowderDis(beverage)
                PowderDropDown(beverage)
            }else{
                PowderDropDown(beverage)
            }

        }


    }
}

@Composable
fun BevModTagline() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "☕✨ Espresso Yourself—One Sip at a Time! ✨☕",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = HeaderBackground,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DisplayCard(beverage: Beverage){
    Box(
        modifier = Modifier
            .size(300.dp)
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), // Allow the Column to fill the Box
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Vertically center the content
        ) {
            Image(
                painter = painterResource(id = beverage.pic), // Correct way to use the image resource
                contentDescription = "Drink Image",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .size(100.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp)) // Adds space between image and text

            Text(
                text = beverage.name,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun NutritionDisplay(beverage: Beverage) {
    // Compute nutrition values based on current beverage state.
    val cal = beverage.calculateCalories()
    val protein = beverage.calculateProtein()
    val carbs = beverage.calculateCarbs()
    val fat = beverage.calculateFat()
    val sodium = beverage.calculateSodium()

    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Total Calories: $cal",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "Total Protein: $protein",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "Total Carbs: $carbs",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "Total Fat: $fat",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "Total Sodium: $sodium",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = ButtonBackground,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ModPrev(){
    //BeverageModScreen(myBeverage)
}