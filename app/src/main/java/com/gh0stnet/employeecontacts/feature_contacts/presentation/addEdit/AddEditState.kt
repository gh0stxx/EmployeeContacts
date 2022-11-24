package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

data class AddEditState(
    var id: Int? = null,
    var firstName: String = "",
    var firstNameError: String? = null,
    var lastName: String = "",
    var lastNameError: String? = null,
    var email: String = "",
    val emailError: String? = null,
    var address: String = "",
    var addressError: String? = null,
    var city: String = "",
    var cityError: String? = null,
    var sstate: String = "",
    var stateError: String? = null,
    var postcode: String = "",
    var postcodeError: String? = null,
    var phone: String = "",
    var phoneError: String? = null,
    var dept: String = "",
    var deptError: String? = null
)
