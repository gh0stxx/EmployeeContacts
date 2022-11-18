package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

class ValidateCity {
    fun execute(name: String) : ValidationResult{
        if(name.isBlank()) {
            return ValidationResult(
                success = false,
                errorMessage = "City cannot be empty"
            )
        }

        return ValidationResult(
            success = true
        )
    }

}