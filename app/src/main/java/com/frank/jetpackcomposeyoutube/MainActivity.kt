package com.frank.jetpackcomposeyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.frank.jetpackcomposeyoutube.ui.detail.DetailScreen
import com.frank.jetpackcomposeyoutube.ui.detail.DetailViewModel
import com.frank.jetpackcomposeyoutube.ui.home.HomeScreen
import com.frank.jetpackcomposeyoutube.ui.list.ListScreen
import com.frank.jetpackcomposeyoutube.ui.main.MainRoute
import com.frank.jetpackcomposeyoutube.ui.profile.ProfileRoute
import com.frank.jetpackcomposeyoutube.ui.profile.ProfileViewModel
import com.frank.jetpackcomposeyoutube.ui.register.RegisterRoute
import com.frank.jetpackcomposeyoutube.ui.register.RegisterViewModel
import com.frank.jetpackcomposeyoutube.ui.theme.JetpackComposeYoutubeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()


            JetpackComposeYoutubeTheme {
                NavHost(navController = navController, startDestination = "/") {


                    composable(route = "/") {
                        MainRoute(
                            onNavigateDetail = {
                                navController.navigate("detail/")
                            },
                            onNavigateToHome = {
                                navController.navigate("home/")
                            },
                            onNavigateList = {
                                navController.navigate("list/")
                            }
                        )
                    }

                    composable(route = "home/") {
                        HomeScreen {
                            navController.navigate("register/")
                        }
                    }

                    composable(route = "register/") {
                        RegisterRoute() { userName ->
                            navController.navigate("profile/$userName")
                        }
                    }

                    composable(route = "profile/{userName}",
                        arguments = listOf(
                            navArgument(name = "userName") { type = NavType.StringType }
                        )
                    ) { navBackStackEntry ->
                        val username = navBackStackEntry.arguments?.getString("userName")
                        requireNotNull(username)
                        ProfileRoute(userName = username) {
                            navController.popBackStack()
                        }
                    }

                    composable("detail/"){
                        val viewModel:DetailViewModel = hiltViewModel()
                        DetailScreen(viewModel = viewModel) {
                            navController.navigate("home/")
                        }
                    }


                    composable("list/"){
                        ListScreen()
                    }

                }
            }
        }
    }

}




