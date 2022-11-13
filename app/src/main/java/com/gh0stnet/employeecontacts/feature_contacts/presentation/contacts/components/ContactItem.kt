package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gh0stnet.employeecontacts.R

@Composable
fun ContactItem(
    // person: People,
    // modifier: Modifier,
) {
    Column(Modifier.padding(5.dp)) {
       Image (
          painter = painterResource(id = R.drawable.profile_pic2),
            contentDescription = "Profile picture",
           contentScale = ContentScale.Crop,


           modifier = Modifier
               .width(104.dp)
               .height(61.dp)
               .clip(shape = RoundedCornerShape(30,90,90,0))

        )
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
