package com.example.qinetralaundry

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.qinetralaundry.ui.theme.Blue
import com.example.qinetralaundry.ui.theme.QinetraLaundryTheme

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myintent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myintent(){

    val mContext= LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds)
    ){

        TopAppBar(title = { Text(text = "Intents", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Black),
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

        //MPESA
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            OutlinedButton(
                onClick = {
                    val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                },
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                shape = CutCornerShape(5.dp),
                border = BorderStroke(3.dp, Color.Black)
            ) {
                Text(text = "PAY VIA MPESA")

            }
        }


        Spacer(modifier = Modifier.height(5.dp))


        //EMAIL
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            Button(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ianmonye3@gmail.com"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "book laundry pick up")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                    mContext.startActivity(shareIntent)
                },
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Blue)
            ) {
                Text(text = "EMAIL")
            }
        }

        Spacer(modifier = Modifier.height(5.dp))


        //SHARE
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            Button(onClick = {
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Have a look at our reliable laundry services")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
            },
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Blue)
            ) {
                Text(text = "SHARE")
            }

        }


        Spacer(modifier = Modifier.height(5.dp))


        //CALL
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            Button(onClick = {
                val callIntent=Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0720245837".toUri()
                mContext.startActivity(callIntent)
            },
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Blue)
            ) {
                Text(text = "CALL")
            }

        }


        Spacer(modifier = Modifier.height(5.dp))


        //SMS
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            Button(onClick = {
                val smsIntent=Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0720245837".toUri()
                smsIntent.putExtra("sms_body","Welcome customer to Qinetra laundry")
                mContext.startActivity(smsIntent)
            },
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Blue)
            ) {
                Text(text = "SMS")
            }

        }


        Spacer(modifier = Modifier.height(5.dp))


        //SETTINGS
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            Button(onClick = {
                val settingsIntent=Intent(Settings.ACTION_SETTINGS)
                mContext.startActivity(settingsIntent)

            },
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Blue)
            ) {
                Text(text = "SETTINGS")
            }


        }


        Spacer(modifier = Modifier.height(5.dp))


        //CAMERA
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {

            Button(onClick = {
                val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                    mContext.startActivity(cameraIntent)
                }else{
                    println("Camera app is not available")
                }
            },
                modifier = Modifier
                    .size(width = 380.dp, height = 70.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Blue)
            ) {
                Text(text = "CAMERA")
            }
        }






    }

}

@Preview(showBackground = true)
@Composable
fun myintentPreview() {
   myintent()
}