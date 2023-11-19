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
    fun navHost_clickItem_navigateToDetailWithData() {
        composeTestRule.onNodeWithTag("MovieList").performScrollToIndex(2)
        composeTestRule.onNodeWithText(MovieData.dummyMovie[5].title).performClick()
        navHostController.assertCurrentRouteName(Screen.DetailMovie.route)
        composeTestRule.onNodeWithText(MovieData.dummyMovie[5].title).assertIsDisplayed()
    }
}