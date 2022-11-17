package com.gh0stnet.employeecontacts.feature_contacts.presentation.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gh0stnet.employeecontacts.R
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.presentation.destinations.AddEditScreenDestination
import com.gh0stnet.employeecontacts.ui.theme.Charcoal
import com.gh0stnet.employeecontacts.ui.theme.LightOrange
import com.gh0stnet.employeecontacts.ui.theme.Red
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun ProfileScreen(
    people: People,
    navigator: DestinationsNavigator
) {

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Red,
            darkIcons = false
        )
    }

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = {
                        navigator.navigateUp()
                    }) {
                        Icon(Icons.Rounded.ArrowBack, "back arrow")
                    }
                },
                backgroundColor = Red,
                contentColor = Color.White
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigator.navigate(AddEditScreenDestination) },
                backgroundColor = Red,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add contact")
            }
        },
        content = {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.surface) {
                Column(modifier = Modifier.background(if (isSystemInDarkTheme()) Charcoal else Color.White)) {

                    Surface(
                        modifier = Modifier.height(320.dp),
                        color = if (isSystemInDarkTheme()) Charcoal else Color.White
                    ) {

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
                                .background(brush)

                        ) {

                        }
                        Box(
                            Modifier
                                .fillMaxSize()

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile_pic1),
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
                        Text(
                            letterSpacing = 5.sp,
                            text = "${people.firstName} ${people.lastName}",
                            fontSize = 30.sp,

                            fontWeight = FontWeight.Bold,
                            color = if (isSystemInDarkTheme()) Color.LightGray else Color.Black
                        )
                        Text(
                            text = people.dept,
                            fontSize = 14.sp,
                            color = if (isSystemInDarkTheme()) Color.LightGray else Color.Black
                        )

                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(75.dp, 20.dp, 50.dp, 10.dp)
                    ) {
                        Text(
                            text = "Phone",
                            color = LightOrange,
                            modifier = Modifier.weight(3f),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Email",
                            color = LightOrange,
                            modifier = Modifier.weight(2f),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(75.dp, 0.dp, 50.dp, 0.dp)
                    ) {
                        Text(
                            text = people.phoneNumber,
                            color = if (isSystemInDarkTheme()) Color.LightGray else Color.Black,
                            modifier = Modifier.weight(3f)
                        )
                        Text(
                            text = people.dept,
                            color = if (isSystemInDarkTheme()) Color.LightGray else Color.Black,
                            modifier = Modifier.weight(2f)
                        )


                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(75.dp, 20.dp, 50.dp, 10.dp)
                    ) {
                        Text(
                            text = "Address",
                            color = LightOrange,
                            modifier = Modifier.weight(3f),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(75.dp, 0.dp, 50.dp, 0.dp)
                    ) {
                        Text(
                            text = "${people.address}, ${people.state} ${people.country}",
                            color = if (isSystemInDarkTheme()) Color.LightGray else Color.Black,
                            modifier = Modifier.weight(3f)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(150.dp)
                            .padding(75.dp, 0.dp, 0.dp, 0.dp)
                    )
                }
            }
        }
    )
}
