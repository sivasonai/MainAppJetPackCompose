package com.siva.mainapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siva.common.utils.NavRoute
import com.siva.ipdetails.IPDetailsRoute
import com.siva.ipdetails.IPDetailsViewModel
import com.siva.ipdetails.IPMapRoute

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = NavRoute.ipDetailsScreen) {

        composable(NavRoute.ipDetailsScreen) {
            val viewModel: IPDetailsViewModel = hiltViewModel()
            IPDetailsRoute(viewModel = viewModel) {
                navController.navigate(NavRoute.mapScreen)
            }
        }

        composable(NavRoute.mapScreen) {
            IPMapRoute(onPopBack = { navController.popBackStack() })
        }

    }
}