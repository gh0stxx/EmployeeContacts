package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

class ValidatePostcode {
        fun execute(name: String) : ValidationResult{
        if(name.isBlank()) {
            return ValidationResult(
                success = false,
                errorMessage = "Postcode cannot be empty"
            )
    }
        return ValidationResult(
                success = true
                )
    }
}
