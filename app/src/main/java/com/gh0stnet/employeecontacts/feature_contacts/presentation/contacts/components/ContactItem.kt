package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components

import android.app.Application
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gh0stnet.employeecontacts.ContactApp
import com.gh0stnet.employeecontacts.R
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.presentation.destinations.ProfileScreenDestination
import com.gh0stnet.employeecontacts.ui.theme.Charcoal
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import com.gh0stnet.employeecontacts.ui.theme.LightOrange
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ContactItem(
    person: People,
    navigator: DestinationsNavigator,
    app: ContactApp
) {

    val trebuchetFont = FontFamily(
        Font(R.font.trebuc, FontWeight.Normal),
        Font(R.font.trebuc_bold, FontWeight.Bold)
    )

    Card(

        Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {

                navigator.navigate(
                    ProfileScreenDestination(
                        People(
                            firstName = person.firstName,
                            lastName = person.lastName,
                            state = person.state,
                            id = person.id,
                            address = person.address,
                            city = person.city,
                            postcode = person.postcode,
                            dept = person.dept,
                            phoneNumber = person.phoneNumber,
                            email = person.email
                        )
                    )
                )
            }, elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        border = BorderStroke(0.2.dp, if(app.isDark.value) Color.Black else LightGrey )
    ) {

        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shadowElevation = 5.dp,
                shape = RoundedCornerShape(30, 90, 90, 0),
                modifier = Modifier.padding(10.dp, 10.dp, 0.dp, 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_pic1),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(104.dp)
                        .height(65.dp)
                        .clip(shape = RoundedCornerShape(30, 90, 90, 0))
                        .border(
                            0.1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(30, 90, 90, 0)
                        )
                )
            }
            Spacer(modifier = Modifier.size(15.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${person.firstName} ${person.lastName}",
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 1.5.sp,
                    fontFamily = trebuchetFont,
                )
                Text(
                    text = person.dept,
                    fontSize = 16.sp,
                    color = LightOrange,
                    fontFamily = trebuchetFont
                )

            }

        }

    }
    //Divider(color = MaterialTheme.colorScheme.secondary, thickness = 0.3.dp)
}
