package com.application.cryptocurrencyapp.presentation.coin_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.application.cryptocurrencyapp.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(all = 20.dp)
            .clickable(onClick = { onClick(coin) }),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground
            ,overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinListItem(
        coin = Coin(
            id = "btc-bitcoin",
            name = "Bitcoin",
            isActive = true,
            rank = 1,
            symbol = "BTC",
        ),
        onClick = {}
    )
}