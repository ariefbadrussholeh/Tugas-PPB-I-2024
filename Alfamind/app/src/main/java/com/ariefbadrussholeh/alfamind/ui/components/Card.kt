package com.ariefbadrussholeh.alfamind.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.alfamind.data.Product
import com.ariefbadrussholeh.alfamind.util.toRupiah

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .width(180.dp)
            .clickable {
                onClick()
            }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(Color(0xFFFAFAFA))
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(Color.White)
                    .height(220.dp)
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = product.name,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = product.price.toRupiah(),
                        style = MaterialTheme.typography.bodySmall,
                        textDecoration = TextDecoration.LineThrough,
                        color = Color(0x50000000)
                    )
                    Text(
                        text = ((product.discountedPrice / product.price - 1) * 100).toInt()
                            .toString() + "%",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(MaterialTheme.colorScheme.secondary)
                            .padding(4.dp)
                            .clip(
                                RoundedCornerShape(30.dp)
                            )
                    )
                    Text(
                        text = product.discountedPrice.toRupiah(),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                ElevatedButton(
                    onClick = { },
                    colors = ButtonDefaults.elevatedButtonColors(
                        contentColor = Color.White,
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Tambah",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}