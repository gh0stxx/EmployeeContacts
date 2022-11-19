package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

class ValidateDept {

            fun execute(name: String) : ValidationResult{

        return ValidationResult(
                success = true
                )
    }
}
