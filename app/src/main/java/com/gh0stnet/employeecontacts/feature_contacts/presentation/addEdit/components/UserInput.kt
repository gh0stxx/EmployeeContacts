package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gh0stnet.employeecontacts.ui.theme.Grey
import com.gh0stnet.employeecontacts.ui.theme.LightOrange

@OptIn(ExperimentalMaterial3Api::class)
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
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .padding(top = 10.dp)
                .width(300.dp),
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.secondary
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
            singleLine = true
        )
        if (hasError != null) {
            Text(text = hasError, color = Color.Red, fontSize = 12.sp)
        }
    }
}
