package com.application.cryptocurrencyapp.presentation.coin_list.navigation

import androidx.navigation.NavHostController
import com.application.cryptocurrencyapp.domain.model.Coin

class Screen(private val navController: NavHostController) {
    val list: (Coin) -> Unit = {
        navController.navigate("coin_detail_screen/${it.id}")
    }
    val detail: () -> Unit = {
        navController.popBackStack()
    }
}