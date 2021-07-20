package com.rdx.light

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
import com.rdx.light.ui.theme.LightTheme

class MainActivity : ComponentActivity() {

   var status = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LightTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LightButton()
                }
            }

        }
    }

 private fun getLight() {

    var camera = getSystemService(Context.CAMERA_SERVICE) as CameraManager

    val cameraListId = camera.cameraIdList[0]

     if(status == false){
         status = true
         camera.setTorchMode(cameraListId,status)
     } else {
         status = false
         camera.setTorchMode(cameraListId,status)
     }


    }



    @Composable
    fun LightButton() {

            Scaffold() {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
                    /*Button(onClick = { getLight() },colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Red)) {
                        Text("Click")
                    }*/

                    ExtendedFloatingActionButton(


                        text = { Text("Click to Light") },
                        onClick = { getLight()},
                        elevation = FloatingActionButtonDefaults.elevation(8.dp)
                    )
                }
            }


    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        LightTheme {
            LightButton()
        }
    }

}










