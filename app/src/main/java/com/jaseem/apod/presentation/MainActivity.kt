package com.jaseem.apod.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.jaseem.apod.presentation.ui.theme.AssignmentNasaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentNasaTheme {
                ApodScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
