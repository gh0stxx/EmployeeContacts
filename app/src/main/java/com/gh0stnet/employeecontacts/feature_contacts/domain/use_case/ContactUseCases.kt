package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

data class ContactUseCases (
    val getContacts: GetContacts,
    val deleteContact: DeleteContact,
    val addContact: AddContact,
    val getContact: GetContact,
    val validateFirstName: ValidateFirstName,
    val validateLastName: ValidateLastName,
    val validatePhone: ValidatePhone,
    val validateEmail: ValidateEmail,
    val validateAddress: ValidateAddress,
    val validateCity: ValidateCity,
    val validateState: ValidateState,
    val validatePostcode: ValidatePostcode,
    val validateDept: ValidateDept,
    val validationResult: ValidationResult
)
