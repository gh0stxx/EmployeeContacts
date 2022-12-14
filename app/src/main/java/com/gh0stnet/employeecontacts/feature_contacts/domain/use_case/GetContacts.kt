package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case
import kotlinx.coroutines.flow.Flow
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.PeopleRepo
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.OrderType
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.PeopleOrder
import kotlinx.coroutines.flow.map
import java.util.Locale

class GetContacts(
    private  val  repo: PeopleRepo
) {

    operator fun invoke(
        peopleOrder: PeopleOrder = PeopleOrder.Name(OrderType.Ascending)
    ): Flow<List<People>> {
        return  repo.getContacts().map { contact_db ->
            when(peopleOrder.orderType) {
                is OrderType.Ascending -> contact_db.sortedBy { it.lastName.lowercase(Locale.getDefault()) }
                is OrderType.Descending -> contact_db.sortedByDescending { it.lastName.lowercase(Locale.getDefault()) }
            }
        }
    }
}
