package com.example.qinetralaundry

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qinetralaundry.R
import com.example.qinetralaundry.ui.theme.Blue

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            home()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home(){
    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(title = { Text(text = "Home", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Blue),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription ="" ,
                        tint = Color.White)
                        
                    }
                    


            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "",
                        tint = Color.White
                    )


                }
            }

            )
        Spacer(modifier = Modifier.height(20.dp))

      var mysearch by remember { mutableStateOf("") }

        OutlinedTextField(value = mysearch,
            onValueChange ={mysearch=it} ,
            leadingIcon = { Icon(imageVector =Icons.Default.Search ,
                contentDescription ="",
                tint = Color.Gray )},
            placeholder = { Text(text = "Search Here...")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)

        )
        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
            contentAlignment = Alignment.Center) {

            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Your favourite meal",
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )


        }
        val context = LocalContext.current

        Button(onClick = { context.startActivity(Intent(context,RegisterActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(Blue),
            shape = CutCornerShape(5.dp)
        ) {
            Text(text = "NEXT", color = Color.White)

        }




    }


}
@Preview(showBackground = true)
@Composable
fun homePreview(){
    home()
}