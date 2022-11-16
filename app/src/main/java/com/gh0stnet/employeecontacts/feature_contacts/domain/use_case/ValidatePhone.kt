package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

import android.util.Patterns

class ValidatePhone {

        fun execute(email: String) : ValidationResult {
        if(email.isBlank()) {
            return  ValidationResult(
                success = false,
                errorMessage = "Phone number cannot be blank"
            )
        }
        if(!Patterns.PHONE.matcher(email).matches()) {
            return ValidationResult(
                success = false,
                errorMessage = "Please enter a valid phone number"
            )
        }
        return ValidationResult(
            success = true
        )
    }
}