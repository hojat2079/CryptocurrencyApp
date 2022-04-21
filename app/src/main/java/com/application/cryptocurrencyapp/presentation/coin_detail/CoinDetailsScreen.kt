package com.application.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.application.cryptocurrencyapp.presentation.coin_detail.component.TagItem
import com.application.cryptocurrencyapp.presentation.coin_detail.component.TeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} ${coin.symbol}",
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (coin.isActive) "active" else "inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            style = MaterialTheme.typography.body2,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .weight(2f)
                                .align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description,
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp
                    ) {
                        coin.tags.forEach { tag ->
                            TagItem(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(items = coin.team) { team ->
                    TeamListItem(
                        teamMember = team,
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider()
                }
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