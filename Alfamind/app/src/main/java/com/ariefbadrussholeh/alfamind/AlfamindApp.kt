package com.ariefbadrussholeh.alfamind

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ariefbadrussholeh.alfamind.ui.navigation.Screen
import com.ariefbadrussholeh.alfamind.ui.screen.detailcategory.DetailCategoryScreen
import com.ariefbadrussholeh.alfamind.ui.screen.detailproduct.DetailProductScreen
import com.ariefbadrussholeh.alfamind.ui.screen.home.HomeScreen
import com.ariefbadrussholeh.alfamind.ui.screen.registration.RegistrationFormScreen
import com.ariefbadrussholeh.alfamind.ui.screen.registration.RegistrationHomeScreen
import com.ariefbadrussholeh.alfamind.ui.screen.registration.RegistrationOTPScreen
import com.ariefbadrussholeh.alfamind.ui.screen.storeprofile.StoreProfileScreen

@Composable
fun AlfamindApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.RegistrationHome.route,
    ) {
        composable(Screen.RegistrationHome.route) {
            RegistrationHomeScreen(
                navigateRegistrationOTP = {
                    navController.navigate(Screen.RegistrationOTP.route)
                }
            )
        }
        composable(Screen.RegistrationOTP.route) {
            RegistrationOTPScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                navigateToRegistrationForm = {
                    navController.navigate(Screen.RegistrationForm.route)
                }
            )
        }
        composable(Screen.RegistrationForm.route) {
            RegistrationFormScreen(
                navigateToHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.DetailCategory.route,
            arguments = listOf(
                navArgument("categoryName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName")
            if (categoryName != null) {
                DetailCategoryScreen(navController = navController, categoryName = categoryName)
            }
        }
        composable(
            route = Screen.DetailProduct.route,
            arguments = listOf(
                navArgument("productCode") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val productCode = backStackEntry.arguments?.getString("productCode")
            if (productCode != null) {
                DetailProductScreen(
                    productCode = productCode,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
        composable(Screen.StoreProfile.route) {
            StoreProfileScreen(
                navigateBack = {
                    navController.navigateUp()
                },
            )
        }
    }
}