package com.ariefbadrussholeh.accessbykai.ui.screen.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.accessbykai.data.Ticket
import com.ariefbadrussholeh.accessbykai.data.ticketList
import com.ariefbadrussholeh.accessbykai.ui.components.CustomCenterAlignedTopBar
import com.ariefbadrussholeh.accessbykai.ui.theme.AccessByKAITheme

@Composable
fun FindTicketScreen(
    navigateToOrderTicket: (() -> Unit),
    navigateBack: (() -> Unit)
) {
    Scaffold(
        topBar = {
            CustomCenterAlignedTopBar(title="Cari Tiket", navigateBack = navigateBack)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                DateCard(date = "15", day = "RAB")
                DateCard(date = "16", day = "KAM")
                DateCard(date = "17", day = "JUM", now = true)
                DateCard(date = "18", day = "SAB")
                DateCard(date = "19", day = "MIN")
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(ticketList) { ticket ->
                    TicketCard(
                        data = ticket,
                        navigateToOrderTicket = navigateToOrderTicket
                    )
                }
            }
        }
    }
}

@Composable
private fun TicketCard(
    data: Ticket,
    navigateToOrderTicket: (() -> Unit)
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.size(width = 200.dp, height = 100.dp)

            ) {
                Text(
                    text = data.argo,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "SGU",
                            style = MaterialTheme.typography.labelMedium,
                        )
                        Text(
                            text = data.startLeaving,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.alpha(0.7f)
                        )
                    }
                    Divider(Modifier.width(100.dp))
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "ML",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = data.arrive,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.alpha(0.7f)
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = data.argoClass,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                    Text(
                        text = data.estimatedTime,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier.size(width = 200.dp, height = 100.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = data.price,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Sisa " + data.ticketRemaining.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
                FilledIconButton(
                    onClick = navigateToOrderTicket,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                    ),
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Composable
private fun DateCard(
    date: String,
    day: String,
    now: Boolean = false
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (now) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.clickable {  }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = date,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = day,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LightThemePreview() {
    AccessByKAITheme {
        FindTicketScreen(navigateToOrderTicket = {}, navigateBack = {})
    }
}
@Preview(showBackground = true)
@Composable
private fun DarkThemePreview() {
    AccessByKAITheme(
        darkTheme = true
    ) {
        FindTicketScreen(navigateToOrderTicket = {}, navigateBack = {})
    }
}