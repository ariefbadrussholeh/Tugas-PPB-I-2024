package com.ariefbadrussholeh.accessbykai

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ariefbadrussholeh.accessbykai.ui.navigation.Screen
import com.ariefbadrussholeh.accessbykai.ui.screen.authentication.LoginScreen
import com.ariefbadrussholeh.accessbykai.ui.screen.authentication.RegistrationScreen
import com.ariefbadrussholeh.accessbykai.ui.screen.home.HomeScreen
import com.ariefbadrussholeh.accessbykai.ui.screen.authentication.OnboardingScreen
import com.ariefbadrussholeh.accessbykai.ui.screen.ticket.DetailOrderScreen
import com.ariefbadrussholeh.accessbykai.ui.screen.ticket.FindTicketScreen
import com.ariefbadrussholeh.accessbykai.ui.screen.ticket.OrderSuccessScreen

@Composable
fun AccessByKAIApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route,
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                navigateToRegistration = {
                    navController.navigate(Screen.Registration.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                navigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(
                navigateToHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                navigateToHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToFindTicket = {
                    navController.navigate(Screen.FindTicket.route)
                },
            )
        }
        composable(Screen.FindTicket.route) {
            FindTicketScreen(
                navigateToOrderTicket = {
                    navController.navigate(Screen.DetailOrder.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable(Screen.DetailOrder.route) {
            DetailOrderScreen(
                navigateToOrderSuccess = {
                    navController.navigate(Screen.OrderSuccess.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable(Screen.OrderSuccess.route) {
            OrderSuccessScreen (
                navigateToHome =  {
                    navController.navigate(Screen.Home.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}