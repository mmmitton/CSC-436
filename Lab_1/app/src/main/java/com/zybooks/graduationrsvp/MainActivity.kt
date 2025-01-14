package com.zybooks.graduationrsvp
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.GlideImage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.zybooks.graduationrsvp.ui.theme.GraduationRSVPTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraduationRSVPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GradScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun GradScreen(modifier: Modifier = Modifier) {
    // Stack the background and content using Box
    androidx.compose.foundation.layout.Box(modifier = Modifier.fillMaxSize()) {
        Background()
        // Place the content over the background
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally // Centers items horizontally
        ) {
            GradInviteText()
        }
    }
}

@Preview
@Composable
fun GradInviteText() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // Centers text horizontally
        modifier = Modifier
            .fillMaxSize() // Takes up available space
    ) {
        Text(
            text = stringResource(R.string.title),
            fontSize = 50.sp,
            lineHeight = 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = FontFamily.Cursive
        )
        Stars()
        Text(
            text = stringResource(R.string.sub_text),
            fontSize = 20.sp,
            lineHeight = 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = stringResource(R.string.date),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Green
        )
        Text(
            text = stringResource(R.string.time),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Green
        )
        Text(
            text = stringResource(R.string.location),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Green
        )
        RSVPbox()
    }
}

@Preview(showBackground = true)
@Composable
fun GradPreview() {
    GraduationRSVPTheme {
        GradScreen()
    }
}

@Preview
@Composable
fun Background(){
    Image(
        painter = painterResource(R.drawable.galaxy_background),
        contentDescription = "App Background",
        alpha = 0.9f,
        alignment = Alignment.Center,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

}

@Preview
@Composable
fun Stars() {
    AsyncImage(
        model = R.drawable.silver_star, // Replace with your GIF resource
        contentDescription = "Rotating Star",
        modifier = Modifier.size(100.dp), // Adjust size as needed
        contentScale = ContentScale.Crop
    )
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GradCap() {
    GlideImage(
        model = R.drawable.moving_grad_cap,
        contentDescription = "Graduation Cap",
        modifier = Modifier.size(100.dp), // Adjust size as needed
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun RSVPbox() {
    // Remember the state of the checkbox
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it}, // Update the state on click
            modifier = Modifier.padding(end = 8.dp),
        )
        Text(
            text = if (isChecked) "RSVP'd" else "Click to RSVP",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
    if(isChecked){
        GradCap()
    }
}