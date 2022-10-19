package com.frank.jetpackcomposeyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.frank.jetpackcomposeyoutube.ui.catalog.category.CategoryScreen
import com.frank.jetpackcomposeyoutube.ui.catalog.product.ProductDetailScreen
import com.frank.jetpackcomposeyoutube.ui.checkout.CheckoutScreen
import com.frank.jetpackcomposeyoutube.ui.customer.AddressDetailScreen
import com.frank.jetpackcomposeyoutube.ui.customer.CustomerInfoScreen
import com.frank.jetpackcomposeyoutube.ui.customer.MyAccountScreen
import com.frank.jetpackcomposeyoutube.ui.home.HomeScreen
import com.frank.jetpackcomposeyoutube.ui.theme.JetpackComposeYoutubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}


@Composable
fun MainApp() {

}
