package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.gh0stnet.employeecontacts.ui.theme.Grey
import com.gh0stnet.employeecontacts.ui.theme.LightOrange

@Composable
fun DeptSelection(hasError: String?, onTextChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Management", "Human Resources", "Accounts", "Sales")
    var selectText by remember { mutableStateOf("") }
    var dropDownWidth by remember { mutableStateOf(0) }

    val icon = if (expanded) Icons.Filled.ArrowDropUp
    else Icons.Filled.ArrowDropDown
    Column(modifier = Modifier.padding(
        start = 35.dp,
        end = 35.dp,
        top = 10.dp,
        bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        OutlinedTextField(
            value = selectText,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()

                .onSizeChanged {
                    dropDownWidth = it.width
                },

            textStyle = TextStyle(

                color = MaterialTheme.colorScheme.secondary
            ),
            readOnly = true,
            label = {
                Text(
                    "Department",
                    style = TextStyle(
                        color = LightOrange
                    ),
                )
            },
            trailingIcon = {
                Icon(
                    icon,
                    "contentDescription",
                    Modifier

                        .clickable { expanded = !expanded },
                    tint = LightOrange
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = LightOrange,
                unfocusedBorderColor = Grey,
            ),
            singleLine = true

        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .width(with(LocalDensity.current) { dropDownWidth.toDp() }),
            properties = PopupProperties(focusable = true)
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    onTextChange(label)
                    selectText = label
                    expanded = false
                })
                {
                    Text(
                        text = label,
                        style = TextStyle(
                            color = LightOrange
                        ),
                    )
                }
            }
        }
        if (hasError != null) {
            androidx.compose.material3.Text(text = hasError, color = Color.Red, fontSize = 12.sp, textAlign = TextAlign.Center)
        }
    }

}