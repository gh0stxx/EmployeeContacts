package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gh0stnet.employeecontacts.R

@Composable
fun ContactItem(
    // person: People,
    // modifier: Modifier,
) {
    Surface {
        Row(
            Modifier
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shadowElevation = 7.dp,
                shape = RoundedCornerShape(30, 90, 90, 0),
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_pic2),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        //.padding(5.dp)
                        .width(104.dp)
                        .height(61.dp)
                        .clip(shape = RoundedCornerShape(30, 90, 90, 0))
                        .border(
                            0.1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(30, 90, 90, 0)
                        )
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Fred Flintstone", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "Human Resources", fontSize = 10.sp, color = Color.Red)
            }
        }
    }
}

@Preview
@Composable
fun Preview(
    //   person: People,
    //   modifier: Modifier,
) {
    ContactItem()
}
