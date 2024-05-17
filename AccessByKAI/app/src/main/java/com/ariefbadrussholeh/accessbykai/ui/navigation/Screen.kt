package com.ariefbadrussholeh.accessbykai.ui.navigation

sealed class Screen(val route: String) {
    object Onboarding: Screen("Onboarding")
    object Registration: Screen("Registration")
    object Login: Screen("Login")
    object Home: Screen("Home")
    object FindTicket: Screen("FindTicket")
    object DetailOrder: Screen("DetailOrder")
    object OrderSuccess: Screen("OrderSuccess")
}