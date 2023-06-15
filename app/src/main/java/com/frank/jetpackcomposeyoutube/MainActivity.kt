package com.frank.jetpackcomposeyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.frank.jetpackcomposeyoutube.ui.catalog.category.CategoryScreen
import com.frank.jetpackcomposeyoutube.ui.catalog.product.ProductDetailScreen
import com.frank.jetpackcomposeyoutube.ui.checkout.CheckoutScreen
import com.frank.jetpackcomposeyoutube.ui.checkout.CheckoutSuccessScreen
import com.frank.jetpackcomposeyoutube.ui.customer.Address
import com.frank.jetpackcomposeyoutube.ui.customer.AddressBookNavigation
import com.frank.jetpackcomposeyoutube.ui.customer.AddressBookScreen
import com.frank.jetpackcomposeyoutube.ui.customer.AddressDetailScreen
import com.frank.jetpackcomposeyoutube.ui.customer.AddressNavType
import com.frank.jetpackcomposeyoutube.ui.customer.CustomerInfoScreen
import com.frank.jetpackcomposeyoutube.ui.customer.MyAccountScreen
import com.frank.jetpackcomposeyoutube.ui.home.HomeScreen
import com.frank.jetpackcomposeyoutube.ui.theme.JetpackComposeYoutubeTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainApp()
        }
    }
}


@Composable
fun MainApp() {
    val navController = rememberNavController()
    JetpackComposeYoutubeTheme {
        NavHost(navController = navController, startDestination = "home") {

            composable(route = "home") {
                HomeScreen(
                    openCategoryAction = {
                        navController.navigate("category")
                    },
                    openMyAccountScreen = {
                        navController.navigate("myAccount")
                    },
                    editCustomerInfo = {
                        navController.navigate("customer")
                    },
                    openAddressBook = {
                        val address = Address(id = 1, street = "hoang hoa tham", city = "ha noi")
                        navController.navigate(AddressBookNavigation.createRoute(address))
                    }
                )
            }

            composable(route = AddressBookNavigation.route, arguments = listOf(
                navArgument(AddressBookNavigation.addressArg) {
                    nullable = true
                    type = AddressNavType()
                }
            )) {
                val address = AddressBookNavigation.fromNav(it)
                AddressBookScreen(addresses = listOf(address)) {
                    navController.popBackStack()
                }
            }

            composable(route = "category") {
                CategoryScreen() { productId ->
                    navController.navigate("product/$productId")
                }
            }

            // route
            // NamedNavArgument : a quick way to create new one is using navArgument
            composable(route = "product/{productId}", arguments = listOf(navArgument("productId") {
                type = NavType.StringType
            })) { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")
                requireNotNull(productId)
                ProductDetailScreen(productId = productId) { cartId, customerId ->
                    navController.navigate("checkout/$cartId/$customerId")
                }
            }

            navigation(startDestination = "myAccount", route = "customer") {
                composable(route = "myAccount") {
                    MyAccountScreen(
                        navController = navController,
                        openAddressScreen = { addressId ->
                            val route =
                                if (addressId != null) "addressDetail?addressId=$addressId" else "addressDetail"
                            navController.navigate(route)
                        })
                }

                composable(
                    route = "addressDetail?addressId={addressId}",
                    arguments = listOf(navArgument("addressId") {
                        nullable = true
                    })
                ) { backStackEntry ->
                    val addressId = backStackEntry.arguments?.getString("addressId")
                    AddressDetailScreen(addressId = addressId) {
                        navController.previousBackStackEntry
                            ?.savedStateHandle
                            ?.set("new_address_id", it)
                        navController.popBackStack()
                    }
                }

                composable(route = "customerInfo") {
                    CustomerInfoScreen() {
                        navController.popBackStack()
                    }
                }

            }

            composable(
                route = "checkout/{cartId}/{customerId}",
                arguments = listOf(
                    navArgument("cartId") { type = NavType.StringType },
                    navArgument("customerId") { type = NavType.StringType })
            ) { backStackEntry ->
                val cartId = backStackEntry.arguments?.getString("cartId")
                val customerId = backStackEntry.arguments?.getString("customerId")
                requireNotNull(cartId)
                requireNotNull(customerId)
                CheckoutScreen(cartId = cartId, customerId = customerId) {
                    navController.navigate("checkoutSuccess")
                }
            }

            composable(route = "checkoutSuccess") {
                CheckoutSuccessScreen(goHomeAction = {
                    navController.popBackStack(route = "home", inclusive = false, saveState = true)
                }, viewOrderDetailAction = {

                })
            }

        }
    }
}