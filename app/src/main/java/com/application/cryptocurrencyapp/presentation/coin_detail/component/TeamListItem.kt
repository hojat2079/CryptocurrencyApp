package com.application.cryptocurrencyapp.presentation.coin_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.application.cryptocurrencyapp.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = teamMember.name, style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position, style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic, color = MaterialTheme.colors.onBackground,

            )
    }
}