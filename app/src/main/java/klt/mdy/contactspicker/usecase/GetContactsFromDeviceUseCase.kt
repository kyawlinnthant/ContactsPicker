package klt.mdy.contactspicker.usecase

import klt.mdy.contactspicker.data.DataResource
import klt.mdy.contactspicker.model.Contacts
import klt.mdy.contactspicker.repo.ContactsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContactsFromDeviceUseCase @Inject constructor(
    private val contactsRepository: ContactsRepository
) {
    suspend operator fun invoke(): Flow<DataResource<List<Contacts>>> {
        return contactsRepository.getContacts()
    }

}