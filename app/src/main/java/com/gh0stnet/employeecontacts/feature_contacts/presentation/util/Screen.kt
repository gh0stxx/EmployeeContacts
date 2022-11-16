package com.gh0stnet.employeecontacts.feature_contacts.presentation.util

sealed class Screen(val route: String) {
    object ContactScreen: Screen("contact_screen")
    object ProfileScreen: Screen("profile_screen")

    object AddEditScreen: Screen("add_screen")
}
