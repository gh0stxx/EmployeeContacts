package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

data class ValidationResult(
    val success: Boolean,
    val errorMessage: String? = null
)