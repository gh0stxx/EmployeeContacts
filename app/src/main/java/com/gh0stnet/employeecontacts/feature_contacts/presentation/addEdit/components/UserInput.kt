package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gh0stnet.employeecontacts.ui.theme.Grey
import com.gh0stnet.employeecontacts.ui.theme.LightOrange

@Composable
fun UserInput(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    hasError: String?,
    keyboard: KeyboardOptions,
    onTextChange: (String) -> Unit,


) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 0.dp, end = 0.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            leadingIcon = {

            },
            value = text,

            onValueChange = onTextChange,
            modifier = Modifier
                .padding(top = 10.dp)
                .width(300.dp),
            textStyle = TextStyle(
                color = if (isSystemInDarkTheme()) Color.LightGray else Color.Black
            ),
            keyboardOptions = keyboard,
            label = {
                Text(
                    hint, style = TextStyle(
                        color = LightOrange
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = LightOrange,
                unfocusedBorderColor = Grey
            ),
        )
        if (hasError != null) {
            Text(text = hasError, color = Color.Red)
        }
    }
}
