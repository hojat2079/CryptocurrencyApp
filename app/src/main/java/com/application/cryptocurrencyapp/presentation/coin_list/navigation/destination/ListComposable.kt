package com.application.cryptocurrencyapp.presentation.coin_list.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.cryptocurrencyapp.common.Constant.LIST_SCREEN
import com.application.cryptocurrencyapp.domain.model.Coin
import com.application.cryptocurrencyapp.presentation.coin_list.CoinListScreen

fun NavGraphBuilder.listComposable(
    navigateToDetailsScreen: (Coin) -> Unit,
) {
    composable(
        route = LIST_SCREEN
    ) {
        CoinListScreen(navigateToDetailsScreen = navigateToDetailsScreen)
    }
}