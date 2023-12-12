package com.example.qinetralaundry

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qinetralaundry.HomeActivity
import com.example.qinetralaundry.ui.theme.Blue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            demo()

        }
    }
}

@Composable
fun demo() {

    Column {
        Text(
            text = "Welcome to Android Programming",
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(60.dp)
                .padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Qinetra Laundry is a dry cleaning and laundry service provider offering personal door to door delivery anywhere in Nairobi. M1, Alongside Naivas Supermarket, Naivasha Road.",
            fontSize = 15.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "DRY CLEANING",
            fontSize = 15.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "We didn’t come up with the phrase ‘environment friendly’, but come to think of it, maybe we should have.\n" +
                    "\n" +
                    "With no hazardous chemicals in our portfolio, we work on a clean conscience, and put people and planet before profits, because you deserve better.\n" +
                    "\n" +
                    "Just think of us as your personal assistant.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Blue),
            shape = RectangleShape
        )

        {
            Icon(imageVector = Icons.Default.Add ,
                contentDescription = "",
                tint = Color.White)

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "MORE SERVICES",
                color = Color.White)

        }
        Spacer(modifier = Modifier.height(5.dp))

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        
    Row {

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Blue),
            shape = CutCornerShape(5.dp)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack ,
                contentDescription = "",
                tint = Color.White)

            Text(text = "BACK", color = Color.White)
        }
        Spacer(modifier = Modifier.width(30.dp))

        val context = LocalContext.current

        Button(onClick = { context.startActivity(Intent(context, HomeActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(Blue),
            shape = CutCornerShape(5.dp)
        ) {
            Text(text = "NEXT", color = Color.White)

            Icon(imageVector = Icons.Default.ArrowForward ,
                contentDescription = "",
                tint = Color.White)
        }

        Button(onClick = { context.startActivity(Intent(context, IntentActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(Blue),
            shape = CutCornerShape(5.dp)
        ) {
            Text(text = "CONTACT US", color = Color.White)

            Icon(imageVector = Icons.Default.ArrowForward ,
                contentDescription = "",
                tint = Color.White)
        }

    }
    

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun demoPreview(){
    demo()
}