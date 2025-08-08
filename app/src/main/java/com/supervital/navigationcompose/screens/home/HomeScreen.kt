package com.supervital.navigationcompose.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.reflect.Modifier

@Composable
fun HomeScreen() {
    Text("Home Page Screen Content",
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        modifier = androidx.compose.ui.Modifier.padding(top = 15.dp))
}