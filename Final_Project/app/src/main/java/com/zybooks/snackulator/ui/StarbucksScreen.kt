package com.zybooks.snackulator.ui

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zybooks.snackulator.R
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground
import com.zybooks.snackulator.ui.theme.SnackulatorTheme

@Composable
fun StarbucksScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .height(30.dp)
                    .background(ButtonBackground)

            ) {}
        }

        item{
            Text(
                text = "☕ Brew-tifully Yours!",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = HeaderBackground // A nice coffee brown color
                ),
                modifier = Modifier.padding(16.dp)
            )

        }

        item{
            DrinkCat("Hot Coffees", R.drawable.hot_coffee_logo,navController,"hot_coffee")
        }

        item{
            DrinkCat("Cold Coffees", R.drawable.iced_coffee_logo,navController,"hot_coffee")
        }

        item{
            DrinkCat("Hot Teas", R.drawable.hot_tea_logo,navController,"hot_coffee")
        }

        item{
            DrinkCat("Cold Teas", R.drawable.cold_tea_logo,navController,"hot_coffee")
        }

        item{
            DrinkCat("Frappuccinos", R.drawable.frap_logo,navController,"hot_coffee")
        }

        item{
            DrinkCat("Refreshers", R.drawable.refresher_logo,navController,"hot_coffee")
        }

        item{
            DrinkCat("Iced Energy", R.drawable.iced_energy_logo, navController, "hot_coffee")
        }


    }
}



@Composable
fun DrinkCat(name: String, pic: Int,navController: NavController,route : String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(6.dp, color = ButtonBackground)
            .clickable(
                onClick = {
                    navController.navigate(route)
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = pic), // Correct way to use the image resource
            contentDescription = "Drink Image",
            modifier = Modifier.size(64.dp) // Adjust the size as needed
        )

        Spacer(modifier = Modifier.width(8.dp)) // Adds space between image and text

        Text(
            text = name,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = ButtonBackground
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenSBPreview() {
    SnackulatorTheme {}

}
