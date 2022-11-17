package com.gh0stnet.employeecontacts.feature_contacts.domain.util

sealed class OrderType
{
    object Ascending: OrderType()
    object Descending: OrderType()
}