package com.zybooks.snackulator.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.zybooks.snackulator.R
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.DropDownBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground
import com.zybooks.snackulator.ui.theme.SnackulatorTheme


@Composable
fun HotCoffeeScreen(){
    LazyColumn {
        item{
            HotCoffeeTagline()
        }

        item{
            BrewedCoffees()
        }

        item{
            Americanos()
        }

        item{
            Lattes()
        }
    }


}

@Composable
fun HotCoffeeTagline() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "🔥☕",  // Emojis for the beginning
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = HeaderBackground,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default
        )

        Spacer(modifier = Modifier.width(8.dp))  // Space between emoji and text

        Text(
            text = "Hotter Than Your Ex, Sweeter Than Your Next!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = HeaderBackground,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default
        )

        Spacer(modifier = Modifier.width(8.dp))  // Space between text and emoji

        Text(
            text = "☕🔥",  // Emojis for the end
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = HeaderBackground,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default  // Ensuring emojis render correctly
        )
    }
}

@Composable
fun Americanos(){
    Column(modifier = Modifier
        .padding(6.dp)
        .background(DropDownBackground, shape = RoundedCornerShape(6.dp))
        .padding(6.dp)
    ) {
        Text(
            text = "Americano",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = ButtonBackground,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default
        )

        Spacer(modifier = Modifier.width(15.dp))

        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.Absolute.Left
        ){
            item{
                CoffeeCard("Cafe Americano", R.drawable.americano_logo)
            }

        }
    }
}

@Composable
fun BrewedCoffees(){
    Column(modifier = Modifier
        .padding(6.dp)
        .background(DropDownBackground, shape = RoundedCornerShape(6.dp))
        .padding(6.dp)
    ) {
        Text(
            text = "Brewed Coffee",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = ButtonBackground,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default
        )

        Spacer(modifier = Modifier.width(15.dp))

        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
            ) {
            item{
                CoffeeCard("Blonde Roast - Sunsera", R.drawable.brewed_blonde_logo)
            }
            item{
                CoffeeCard("Medium Roast - Pike Place", R.drawable.brewed_pike)
            }

            item{
                CoffeeCard("Featured Dark Roast", R.drawable.brewed_blonde_logo)
            }

            item{
                CoffeeCard("Caffe Misto", R.drawable.cafe_miso_logo)
            }
        }
    }
}

@Composable
fun Lattes(){
    Column(modifier = Modifier
        .padding(6.dp)
        .background(DropDownBackground, shape = RoundedCornerShape(6.dp))
        .padding(6.dp)
        ) {
        Text(
            text = "Lattes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = ButtonBackground,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default
        )

        Spacer(modifier = Modifier.width(15.dp))

        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.Absolute.Left
        ){
            item{
                CoffeeCard("Caffe Latte", R.drawable.caffe_latte_logo)
            }

            item {
                CoffeeCard("Lavender Oatmilk Latte", R.drawable.lavender_oatmilk_latte)
            }

            item{
                CoffeeCard("Cinnamon Dolce Latte", R.drawable.cinnamon_dolce_latte)
            }

            item{
                CoffeeCard("Blonde Vanilla Latte", R.drawable.blonde_vanilla_latte)
            }

            item{
                CoffeeCard("Pistachio Latte", R.drawable.pistacio_latte)
            }

        }
    }
}

@Composable
fun CoffeeCard(name: String, pic: Int) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .padding(6.dp)
            .clickable(
                onClick = {

                }
            ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), // Allow the Column to fill the Box
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Vertically center the content
        ) {
            Image(
                painter = painterResource(id = pic), // Correct way to use the image resource
                contentDescription = "Drink Image",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .size(65.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp)) // Adds space between image and text

            Text(
                text = name,
                style = TextStyle(
                    fontSize = 12.sp,
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
fun ScreenHCPreview() {
    SnackulatorTheme { HotCoffeeScreen() }


}