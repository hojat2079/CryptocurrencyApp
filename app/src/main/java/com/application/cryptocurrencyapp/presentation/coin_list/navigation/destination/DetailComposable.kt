package com.application.cryptocurrencyapp.presentation.coin_list.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.application.cryptocurrencyapp.common.Constant.DETAILS_SCREEN
import com.application.cryptocurrencyapp.common.Constant.LIST_ARGUMENT_KEY
import com.application.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen

fun NavGraphBuilder.detailComposable() {
    composable(
        route = DETAILS_SCREEN,
        arguments = listOf(
            navArgument(name = LIST_ARGUMENT_KEY) {
                type = NavType.StringType
            }
        ),
    ) {
        CoinDetailScreen()
    }
}