package com.dmm.meditation_ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dmm.meditation_ui.presentation.theme.MeditationUITheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MeditationUITheme {
				MainScreen()
			}
		}
	}
}