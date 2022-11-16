package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

import android.util.Patterns

class ValidateEmail {
    fun execute(email: String) : ValidationResult {
        if(email.isBlank()) {
            return  ValidationResult(
                success = false,
                errorMessage = "Email cannot be blank"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                success = false,
                errorMessage = "Please enter a valid email"
            )
        }
        return ValidationResult(
            success = true
        )
    }
}