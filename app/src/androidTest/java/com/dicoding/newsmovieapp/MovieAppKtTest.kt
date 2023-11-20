package com.dicoding.newsmovieapp

import androidx.activity.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.*
import androidx.navigation.compose.*
import androidx.navigation.testing.*
import com.dicoding.newsmovieapp.data.fake.*
import com.dicoding.newsmovieapp.navigation.*
import com.dicoding.newsmovieapp.ui.theme.*
import org.junit.*

class MovieAppKtTest {
    @get: Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navHostController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            NewsMovieAppTheme {
                navHostController = TestNavHostController(LocalContext.current)
                navHostController.navigatorProvider.addNavigator(ComposeNavigator())
                MovieApp(navHostController = navHostController)
            }
        }
    }

    @Test
    fun navHost_startDestination() {
        navHostController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_bottomNavigation_working() {
        composeTestRule.onNodeWithContentDescription("Home", ignoreCase = false).assertExists()
            .performClick()
        navHostController.assertCurrentRouteName(Screen.Home.route)

        composeTestRule.onNodeWithContentDescription("Favorite", ignoreCase = false).assertExists()
            .performClick()
        navHostController.assertCurrentRouteName(Screen.Favorite.route)

        composeTestRule.onNodeWithContentDescription("Profile", ignoreCase = false).assertExists()
            .performClick()
        navHostController.assertCurrentRouteName(Screen.Profile.route)

    }

    @Test
    fun searchMovie_Found() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.search_movie))
            .performTextInput(MovieData.dummyMovie[5].runtime)
        composeTestRule.onNodeWithTag("MovieList").assertIsDisplayed()
        composeTestRule.onNodeWithText(MovieData.dummyMovie[5].runtime).assertIsDisplayed()
    }

    @Test
    fun searchMovie_notFound() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.search_movie))
            .performTextInput("Bangkit Academy")
    }
}