package klt.mdy.contactspicker.udf

import klt.mdy.contactspicker.model.Contacts

sealed class ContactsListUi {
    object Loading : ContactsListUi()
    object EmptyContact : ContactsListUi()
    data class Error(val message: String) : ContactsListUi()
    data class Data(val data: List<Contacts>) : ContactsListUi()
}
