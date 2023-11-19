package com.dicoding.newsmovieapp

import android.annotation.*
import android.content.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.dicoding.newsmovieapp.navigation.*
import com.dicoding.newsmovieapp.ui.screen.detail.*
import com.dicoding.newsmovieapp.ui.screen.favorite.*
import com.dicoding.newsmovieapp.ui.screen.home.*
import com.dicoding.newsmovieapp.ui.screen.profile.*
import com.dicoding.newsmovieapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ModifierParameter")
@Composable
fun MovieApp(
    navHostController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,


    ) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailMovie.route) {
                BottomBar(navHostController)
            }
        }, modifier = modifier

    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screen.Home.route) {
                HomeScreen { movieId ->
                    navHostController.navigate(Screen.DetailMovie.createRoute(movieId))
                }
            }

            composable(Screen.Favorite.route) {
                FavoriteScreen(
                    navigateToDetail = { movieId ->
                        navHostController.navigate(Screen.DetailMovie.createRoute(movieId))
                    }
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }

            composable(
                route = Screen.DetailMovie.route,
                arguments = listOf(navArgument("movieId") {
                    type = NavType.LongType
                }),

                ) {
                val id = it.arguments?.getLong("movieId") ?: -1L
                DetailScreen(
                    movieId = id,
                    navigateBack = {
                        navHostController.navigateUp()
                    }, navigateToMovie = {
                        navHostController.popBackStack()
                        navHostController.navigate(Screen.Favorite.route) {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun BottomBar(
    navHostController: NavHostController, modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite,
                screen = Screen.Favorite
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )

        navigationItems.map { item ->
            NavigationBarItem(selected = currentRoute == item.screen.route, onClick = {
                navHostController.navigate(item.screen.route) {
                    popUpTo(navHostController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            }, icon = {
                Icon(
                    contentDescription = item.title, imageVector = item.icon
                )
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetHeroesAppPreview() {
    NewsMovieAppTheme {
        MovieApp()
    }
}