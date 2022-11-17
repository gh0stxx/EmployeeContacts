package com.gh0stnet.employeecontacts.feature_contacts.domain.util

sealed class PeopleOrder(val orderType: OrderType) {
    class  Name(orderType: OrderType): PeopleOrder(orderType)

    fun copy(orderType: OrderType): PeopleOrder {
        return when (this) {
            is Name -> Name(orderType)
        }
    }
}

