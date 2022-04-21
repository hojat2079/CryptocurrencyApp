package com.application.cryptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.application.cryptocurrencyapp.presentation.coin_list.navigation.SetupNavigation
import com.application.cryptocurrencyapp.presentation.ui.theme.ConcurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConcurrencyAppTheme {

                SetupNavigation(
                        navController = rememberNavController()
                    )
            }
        }
    }
}