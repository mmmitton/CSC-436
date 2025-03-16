package com.zybooks.snackulator.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.snackulator.R
import com.zybooks.snackulator.ui.theme.ButtonBackground
import com.zybooks.snackulator.ui.theme.DropDownBackground
import com.zybooks.snackulator.ui.theme.FavoriteHeart
import com.zybooks.snackulator.ui.theme.HeaderBackground
import com.zybooks.snackulator.ui.theme.SnackulatorTheme
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{
            Row(modifier = Modifier.fillMaxWidth()
                .height(30.dp)
                .background(ButtonBackground)){}
        }
        item {
            TopBox()
        }
        item{
            ResturantDropDown(navController)
        }
        item{
            Trending()
        }


        item{
            Image(
                painter = painterResource(id = R.drawable.java_chip_frap),
                contentDescription = "Java Chip Frap",
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        item{
            Image(
                painter = painterResource(id = R.drawable.iced_vanilla_latte),
                contentDescription = "Java Chip Frap",
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        item{
            Image(
                painter = painterResource(id = R.drawable.pink_drink),
                contentDescription = "Java Chip Frap",
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        item{
            Image(
                painter = painterResource(id = R.drawable.pink_frap),
                contentDescription = "Java Chip Frap",
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

    }


}


@Composable
fun TopBox(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(HeaderBackground, shape = RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(6.dp) // Add space between Text and Image
        ) {
            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                style = TextStyle(
                    fontSize = 24.sp,  // Set the font size
                    fontFamily = FontFamily.SansSerif,  // Set the font family (e.g., SansSerif)
                    fontWeight = FontWeight.Bold  // Set the font weight (e.g., Bold)
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.snack_logo_white),
                contentDescription = "Snackulator Logo",
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .size(150.dp)
                    .align(Alignment.CenterHorizontally) // Center the image horizontally
            )
            Text(
                text = stringResource(R.string.app_slogan),
                color = Color.White,
                style = TextStyle(
                    fontSize = 18.sp,  // Set the font size
                    fontFamily = FontFamily.SansSerif,  // Set the font family (e.g., SansSerif)
                    fontWeight = FontWeight.Bold  // Set the font weight (e.g., Bold)
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(50.dp)) {
                Button(
                    onClick = {},
                    colors = ButtonColors(ButtonBackground,
                        Color.White,
                        Color.Gray,
                        Color.Gray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.75f)
                ) {
                    Text(
                        text = stringResource(R.string.profile)
                    )

                }
                Button(
                    onClick = {},
                    colors = ButtonColors(ButtonBackground,
                        Color.White,
                        Color.Gray,
                        Color.Gray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.75f)
                ){
                    Text(
                        text = stringResource(R.string.Favorites)
                    )
                }
            }
        }
    }
}


@Composable
fun ResturantDropDown(navController: NavController){
    var expanded by remember { mutableStateOf(false) }  // Track the dropdown state
    //var selectedOption by remember { mutableStateOf("Starbucks") }
    //val options = listOf("Starbucks", "More coming Eventually...")

    Box( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(Color.White, shape = RoundedCornerShape(16.dp))
        .border(6.dp, color = HeaderBackground, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        )
        {
            Text(
                text = "Choose Restaurant",
                color = ButtonBackground,
                style = TextStyle(
                    fontSize = 18.sp,  // Set the font size
                    fontFamily = FontFamily.SansSerif,  // Set the font family (e.g., SansSerif)
                    fontWeight = FontWeight.Bold  // Set the font weight (e.g., Bold)
                ),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)

            )
            IconButton(onClick = { expanded = !expanded },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
                    ){
                Icon(Icons.Default.ArrowDropDown, contentDescription = "More options")
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(color = DropDownBackground)
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Starbucks",
                        color = ButtonBackground
                    )
                },
                onClick = {
                    navController.navigate("starbucks")
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = "More Coming... eventually...",
                        color = ButtonBackground
                    )
               },
                onClick = { /* Do something... */ }
            )
        }
    }
}

@Composable
fun Trending(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .size(300.dp, 100.dp) // Make it vertically narrower
            .clip(HouseShape()) // Apply the house shape
            .background(ButtonBackground, shape = RoundedCornerShape(6.dp)) // Set background color
            .padding(16.dp), // Padding for the text inside the house shape
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), // Ensure the row takes up the full width
            horizontalArrangement = Arrangement.Center, // Center items horizontally
            verticalAlignment = Alignment.Bottom // Align vertically in the center
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "heart",
                tint = FavoriteHeart
            )

            Spacer(modifier = Modifier.width(8.dp)) // Add space between icon and text

            Text(
                text = "Trending Near You",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(8.dp)) // Add space between text and icon

            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "heart",
                tint = FavoriteHeart
            )
        }


    }
}

// Define the custom NarrowHouseShape
fun HouseShape(): GenericShape {
    return GenericShape { size, _ ->
        // Start at the bottom left of the rectangle
        moveTo(0f, size.height)
        // Draw the left side of the house (a rectangle)
        lineTo(0f, size.height * 0.7f) // Narrower height for the house body
        // Draw the triangular roof starting from the left side
        lineTo(size.width / 2, 0f) // Peak of the roof
        lineTo(size.width, size.height * 0.7f) // Right side of the roof
        // Draw the right side of the house (a rectangle)
        lineTo(size.width, size.height)
        close() // Close the shape
    }
}






@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    SnackulatorTheme { }

}

