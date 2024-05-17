package com.ariefbadrussholeh.accessbykai.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.ariefbadrussholeh.accessbykai.R

data class PaymentData (
    val title: String,
    val icon: Painter,
    val selected: Boolean = false
)

val paymentData: List<PaymentData>
    @Composable
    get() = listOf(
        PaymentData(
            title = "BRI MOBILE BANKING",
            icon = painterResource(id = R.drawable.ic_brimo)
        ),
        PaymentData(
            title = "BNI MOBILE BANKING",
            icon = painterResource(id = R.drawable.ic_bnimo)
        ),
        PaymentData(
            title = "GOPAY",
            icon = painterResource(id = R.drawable.ic_gopay)
        ),
        PaymentData(
            title = "OVO",
            icon = painterResource(id = R.drawable.ic_ovo),
            selected = true
        ),
        PaymentData(
            title = "SHOPEE PAY",
            icon = painterResource(id = R.drawable.ic_shopeepay)
        ),
    )