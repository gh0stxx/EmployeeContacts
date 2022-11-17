package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

data class AddEditState(
    val firstName: String = "",
    var firstNameError: String? = null,
    val lastName: String = "",
    var lastNameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val address: String = "",
    var addressError: String? = null,
    val sstate: String = "",
    var stateError: String? = null,
    val country: String = "",
    var countryError: String? = null,
    val phone: String = "",
    var phoneError: String? = null,
    val dept: String = "",
    var deptError: String? = null
)
