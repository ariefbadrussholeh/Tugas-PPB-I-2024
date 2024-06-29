package com.ariefbadrussholeh.alfamind.ui.navigation

sealed class Screen (val route: String) {
    object RegistrationHome: Screen("RegistrationHome")
    object RegistrationOTP: Screen("RegistrationOTP")
    object RegistrationForm: Screen("RegistrationForm")
    object Home: Screen("Home")
    object DetailCategory: Screen("DetailCategory/{categoryName}") {
        fun createRoute(categoryName: String) = "DetailCategory/$categoryName"
    }
    object DetailProduct: Screen("DetailProduct/{productCode}") {
        fun createRoute(productCode: String) = "DetailProduct/$productCode"
    }
    object StoreProfile: Screen("StoreProfile")
}