package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

data class AddEditState(
    val firstName: String = "",
    val firstNameError: String? = null,
    val lastName: String = ",",
    val lastNameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val address: String = ",",
    val addressError: String? = null,
    val state: String = "",
    val stateError: String? = null,
    val country: String = ",",
    val countryError: String? = null,
    val phone: String = "",
    val phoneError: String? = null,
    val dept: String = "",
    val deptError: String? = null
)
