package com.example.facebookpam2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.facebookpam2.ui.theme.FacebookPam2Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookPam2Theme {
                // A surface container using the 'background' color from the theme
                TransparentSystemBars()
                val navController= rememberNavController()
                val homeRoute="home"
                val siginRoute="signin"
                NavHost(navController , startDestination = "home" ){
                    composable("home"){
                        HomeScreen(
                            navigateToSignin = {
                                navController.navigate(siginRoute){
                                    popUpTo(homeRoute){
                                        inclusive=true
                                    }
                                }
                            }
                        )
                    }
                    composable( siginRoute) {
                        SignInScreen(
                            navigateToHome = {
                                navController.navigate(homeRoute) {
                                    popUpTo( siginRoute) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
@Composable
    private fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {

        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }
    }


