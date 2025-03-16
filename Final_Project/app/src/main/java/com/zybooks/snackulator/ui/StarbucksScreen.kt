package com.zybooks.snackulator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.HeaderBackground
import com.zybooks.snackulator.ui.theme.SnackulatorTheme

@Composable
fun StarbucksScreen() {
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
        item {
            TopTitle()
        }
    }
}

@Composable
fun TopTitle(){
    Box(modifier = Modifier
        .background(color = HeaderBackground,
            shape = RoundedCornerShape(16.dp))
        .fillMaxWidth()
        .padding(16.dp)
        ){
        Text(
            text = "Rethink Your Drink",
            color = Color.White,
            style = TextStyle(
                fontSize = 24.sp,  // Set the font size
                fontFamily = FontFamily.SansSerif,  // Set the font family (e.g., SansSerif)
                fontWeight = FontWeight.Bold  // Set the font weight (e.g., Bold)
            ),
            modifier = Modifier
                .align(Alignment.Center)
        )

    }

}

@Composable
fun DrinkCat(){

}

@Preview(showBackground = true)
@Composable
fun ScreenSBPreview() {
    SnackulatorTheme { StarbucksScreen() }

}
