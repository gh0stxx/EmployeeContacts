package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gh0stnet.employeecontacts.ui.theme.Charcoal
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import java.lang.Error

@Composable
fun UserInput(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    hasError: String?,
    onTextChange: (String) -> Unit

    ) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {

             Text(
                 text = hint,
                 modifier = Modifier.baselineHeight(28.dp),
                 style = TextStyle(
                     fontWeight = FontWeight.Bold,
                     fontSize = 12.sp,
                     lineHeight = 16.sp,
                     letterSpacing = 0.4.sp

                 ),
                 color = Charcoal
             )


        BasicTextField(value = text, onValueChange = onTextChange,
                modifier = Modifier.baselineHeight(28.dp),
            textStyle = TextStyle(
                fontWeight =  FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp,
                background = LightGrey,

            )

            )

        Divider(modifier = Modifier.padding(top = 10.dp))
                         if(hasError != null) {
                Text(text = hasError, color = Color.Red)
            }
    }
}