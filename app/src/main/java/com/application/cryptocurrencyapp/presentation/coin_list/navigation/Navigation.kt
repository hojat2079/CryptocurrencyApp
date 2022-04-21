package com.application.cryptocurrencyapp.presentation.coin_list.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.application.cryptocurrencyapp.common.Constant.LIST_SCREEN
import com.application.cryptocurrencyapp.presentation.coin_list.navigation.destination.detailComposable
import com.application.cryptocurrencyapp.presentation.coin_list.navigation.destination.listComposable

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember {
        Screen(navController = navController)
    }
    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(navigateToDetailsScreen = screen.list)
        detailComposable()
    }


}