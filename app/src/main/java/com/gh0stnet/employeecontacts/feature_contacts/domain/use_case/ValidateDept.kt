package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

class ValidateDept {

    fun execute(dept: String): ValidationResult {
        if (dept.isEmpty()) {
            return ValidationResult(
                success = false,
                errorMessage = "Please select a department"
            )
        }
        return ValidationResult(
            success = true
        )
    }
}

