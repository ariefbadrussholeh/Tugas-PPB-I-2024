package com.ariefbadrussholeh.alfamind.util

import java.text.NumberFormat
import java.util.Locale

fun Double.toRupiah(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
    return format.format(this).replace("Rp", "Rp ")
}