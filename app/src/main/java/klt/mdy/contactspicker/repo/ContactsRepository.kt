package klt.mdy.contactspicker.repo

import klt.mdy.contactspicker.data.DataResource
import klt.mdy.contactspicker.model.Contacts
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {
    suspend fun getContacts(): Flow<DataResource<List<Contacts>>>
}