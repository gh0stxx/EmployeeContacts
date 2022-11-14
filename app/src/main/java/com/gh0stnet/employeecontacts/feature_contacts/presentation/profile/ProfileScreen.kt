package com.gh0stnet.employeecontacts.feature_contacts.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gh0stnet.employeecontacts.R

@Composable
fun ProfileScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {

            Surface(modifier = Modifier.height(380.dp)) {

                val image = ImageBitmap.imageResource(R.drawable.redbg)
                val brush = remember(image) {
                    ShaderBrush(
                        ImageShader(
                            image,

                            TileMode.Repeated,
                            TileMode.Repeated,
                        )
                    )
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .absoluteOffset(0.dp, (-100).dp)
                        .height(200.dp)
                        .background(brush)

                ) {

                }
                Box(
                    Modifier
                        .fillMaxSize()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_pic2),
                        contentDescription = "Profile pic",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(260.dp)
                            .clip(CircleShape)
                            .align(Alignment.BottomCenter)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Fred Flintstone", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "Human Resources", fontSize = 12.sp)

            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(75.dp, 20.dp, 50.dp, 10.dp)
            ) {
                Text(
                    text = "Phone",
                    color = Color.Red,
                    modifier = Modifier.weight(3f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Email",
                    color = Color.Red,
                    modifier = Modifier.weight(2f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(75.dp, 0.dp, 50.dp, 0.dp)
            ) {
                Text(text = "0411 255 444", color = Color.Black, modifier = Modifier.weight(3f))
                Text(text = "Fred@ROI.com", color = Color.Black, modifier = Modifier.weight(2f))


            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(75.dp, 20.dp, 50.dp, 10.dp)
            ) {
                Text(
                    text = "Address",
                    color = Color.Red,
                    modifier = Modifier.weight(3f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(75.dp, 0.dp, 50.dp, 0.dp)
            ) {
                Text(
                    text = "123 Abc Rd, Sydney NSW 2000",
                    color = Color.Black,
                    modifier = Modifier.weight(3f)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    ProfileScreen()
}

