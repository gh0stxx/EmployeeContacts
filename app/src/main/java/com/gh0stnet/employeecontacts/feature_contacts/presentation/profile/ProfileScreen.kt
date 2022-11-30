package com.gh0stnet.employeecontacts.feature_contacts.presentation.profile

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.ZoomIn
import androidx.compose.material.icons.outlined.ZoomOut
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.gh0stnet.employeecontacts.ContactApp
import com.gh0stnet.employeecontacts.R
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.ContactViewModel
import com.gh0stnet.employeecontacts.feature_contacts.presentation.destinations.AddEditScreenDestination
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import com.gh0stnet.employeecontacts.ui.theme.LightOrange
import com.gh0stnet.employeecontacts.ui.theme.Red
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun ProfileScreen(
    people: People,
    navigator: DestinationsNavigator,
    viewModel: ContactViewModel = hiltViewModel()
) {

    val trebuchetFont = FontFamily(
        Font(R.font.trebuc, FontWeight.Normal), Font(R.font.trebuc_bold, FontWeight.Bold)
    )

    val context = LocalContext.current
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Red, darkIcons = false
        )
    }

    Scaffold(Modifier.background(MaterialTheme.colorScheme.background), topBar = {
        TopAppBar(title = { Text(stringResource(R.string.PROFILE)) },

            actions = {
                TopAppBarActionButton2(
                    imageVector = imageVector(viewModel),
                    description = stringResource(R.string.TOGGLE_FONT),
                    app = viewModel.app
                )
            },
            navigationIcon = {
            IconButton(onClick = {
                navigator.navigateUp()
            },
            ) {
                Icon(Icons.Rounded.ArrowBack, stringResource(R.string.BACK_ARROW))
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Red,
            titleContentColor = Color.LightGray,
            navigationIconContentColor = LightGrey
        )
        )
    }, floatingActionButtonPosition = FabPosition.End, floatingActionButton = {
        FloatingActionButton(
            onClick = { navigator.navigate(AddEditScreenDestination(user = people)) },
            containerColor = Red,
            contentColor = LightGrey,
            shape = IconButtonDefaults.outlinedShape
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = stringResource(R.string.EDIT_CONTACT))
        }
    }) { values ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(
                        enabled = true, state = ScrollState(initial = DEFAULT_BUFFER_SIZE)
                    )
                    .background(MaterialTheme.colorScheme.background)

            ) {
                Surface(
                    modifier = Modifier.height(320.dp), color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .absoluteOffset(0.dp, (-100).dp)
                            .background(
                                Brush.verticalGradient(
                                    0F to Red,
                                    .6F to Red,
                                    1F to Color.Transparent
                                )
                            )
                    )
                    Box(
                        Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painter(people.id!!),
                            contentDescription = stringResource(R.string.PROFILE_PIC),
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
                        letterSpacing = 2.sp,
                        text = "${people.firstName} ${people.lastName}",
                        fontSize = 28.sp,
                        fontFamily = trebuchetFont,
                        fontWeight = FontWeight.Bold,
                        color = LightOrange
                    )
                    Text(
                        text = people.dept,
                        fontSize = 18.sp,
                        fontFamily = trebuchetFont,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(65.dp, 20.dp, 10.dp, 10.dp)
                ) {
                    Text(
                        text = "Phone",
                        fontFamily = trebuchetFont,
                        fontWeight = FontWeight.Bold,
                        color = LightOrange,
                        modifier = Modifier.weight(2.5f),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "Email",
                        color = LightOrange,
                        modifier = Modifier.weight(2f),
                        fontSize = 20.sp,
                        fontFamily = trebuchetFont,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(65.dp, 0.dp, 10.dp, 0.dp)
                ) {
                    ClickableText(

                        text = AnnotatedString(people.phoneNumber),
                        modifier = Modifier.weight(2.5f),
                        style = TextStyle(
                            fontFamily = trebuchetFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = if(viewModel.app.isBigger.value)18.sp else 14.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        ContextCompat.startActivity(
                            context, Intent(
                                Intent.ACTION_DIAL, Uri.parse("tel:" + people.phoneNumber)
                            ), null
                        )
                    }
                    ClickableText(
                        text = AnnotatedString(people.email),
                        modifier = Modifier.weight(2f),
                        style = TextStyle(
                            fontFamily = trebuchetFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = if(viewModel.app.isBigger.value)18.sp else 14.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        ContextCompat.startActivity(
                            context, Intent(
                                Intent.ACTION_SENDTO, Uri.parse("mailto:" + people.email)
                            ), null
                        )
                    }
                }
                Spacer(modifier = Modifier.size(2.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(65.dp, 20.dp, 10.dp, 10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.ADDRESS),
                        color = LightOrange,
                        modifier = Modifier.weight(2f),
                        fontFamily = trebuchetFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(65.dp, 0.dp, 10.dp, 0.dp)

                ) {
                    Text(
                        text = people.address,
                        fontFamily = trebuchetFont,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(2f),
                        fontSize = if(viewModel.app.isBigger.value)18.sp else 14.sp,                    )
                    Text(
                        text = "${people.city} ${people.state} ${people.postcode}",
                        fontFamily = trebuchetFont,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(2f),
                        fontSize = if(viewModel.app.isBigger.value)18.sp else 14.sp,                    )
                }
                Row() {

                }
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(R.string.LOGO),
                    modifier = Modifier
                        .size(150.dp)
                        .padding(65.dp, 0.dp, 10.dp, 0.dp)
                )

                }



            }
        }
    }


@Composable
private fun imageVector(viewModel: ContactViewModel) =
    if (viewModel.app.isBigger.value)
        Icons.Outlined.ZoomOut
    else
        Icons.Outlined.ZoomIn

@Composable
fun TopAppBarActionButton2(
    imageVector: ImageVector, description: String, app: ContactApp
) {
    IconButton(
        onClick = {
            app.toggleFontSize()

        }, colors = IconButtonDefaults.outlinedIconButtonColors(
            contentColor = LightGrey,
        )
    ) {
        Icon(imageVector = imageVector, contentDescription = description, modifier = Modifier.size(28.dp))
    }
}

@Composable
private fun painter(id: Int): Painter {

    return when(id) {
        1 -> painterResource(id = R.drawable.profile_pic11)
        2 -> painterResource(id = R.drawable.profile2)
        3 -> painterResource(id = R.drawable.profile_pic3)
        4 -> painterResource(id = R.drawable.profile4)
        6 -> painterResource(id = R.drawable.profile6)
        7 -> painterResource(id = R.drawable.profile_pic13)
        8 -> painterResource(id = R.drawable.profile8)
        9 -> painterResource(id = R.drawable.poppa)
        11 -> painterResource(id = R.drawable.baby)
        else -> painterResource(id = R.drawable.profile_pic1)
    }
}
