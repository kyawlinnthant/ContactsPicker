package klt.mdy.contactspicker.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import klt.mdy.contactspicker.data.DataResource
import klt.mdy.contactspicker.udf.ContactsListUi
import klt.mdy.contactspicker.udf.ContactsState
import klt.mdy.contactspicker.usecase.GetContactsFromDeviceUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val useCase: GetContactsFromDeviceUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ContactsState())
    val state: State<ContactsState> get() = _state

    init {

        getContactsFromDevice()
    }

    fun getContactsFromDevice() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                uiState = ContactsListUi.Loading
            )
            useCase().collect {

                when (it) {
                    is DataResource.LoadingEvent -> {
                        _state.value = state.value.copy(
                            uiState = ContactsListUi.Loading
                        )
                    }
                    is DataResource.ErrorEvent -> {
                        _state.value = state.value.copy(
                            uiState = ContactsListUi.Error(
                                message = it.message ?: "Error from device"
                            )

                        )
                    }
                    is DataResource.SuccessEvent -> {

                        if (it.data.isNullOrEmpty()) {
                            _state.value = state.value.copy(
                                uiState = ContactsListUi.EmptyContact
                            )
                        } else {
                            _state.value = state.value.copy(
                                uiState = ContactsListUi.Data(
                                    data = it.data
                                )
                            )
                        }


                    }
                }
            }
        }
    }
}