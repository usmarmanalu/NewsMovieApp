package com.dicoding.newsmovieapp

import androidx.navigation.*
import org.junit.*

fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    Assert.assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}