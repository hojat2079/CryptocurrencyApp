package com.application.cryptocurrencyapp.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.application.cryptocurrencyapp.domain.model.Coin
import com.application.cryptocurrencyapp.presentation.coin_list.component.CoinListItem

@Composable
fun CoinListScreen(
    viewModel: CoinListViewModel = hiltViewModel(),
    navigateToDetailsScreen: (Coin) -> Unit,
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = state.coins) { coin ->
                CoinListItem(coin = coin, onClick = navigateToDetailsScreen)
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)

            )
        }
        if (state.loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}