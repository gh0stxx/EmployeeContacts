package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

class ValidateCountry {
        fun execute(name: String) : ValidationResult{
        if(name.isBlank()) {
            return ValidationResult(
                success = false,
                errorMessage = "Country cannot be empty"
            )
    }
        return ValidationResult(
                success = true
                )
    }
}
