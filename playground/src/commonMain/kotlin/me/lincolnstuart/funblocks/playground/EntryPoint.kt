package me.lincolnstuart.funblocks.playground

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import me.lincolnstuart.funblocks.playground.screens.HomeScreen

@Composable
internal fun EntryPoint() { Navigator(screen = HomeScreen()) }
