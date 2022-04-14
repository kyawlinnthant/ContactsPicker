package klt.mdy.contactspicker.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import klt.mdy.contactspicker.model.Contacts
import klt.mdy.contactspicker.udf.ContactsListUi

@Composable
fun ContactsView(
    vm: ContactsViewModel,
    onItemClicked: (Contacts) -> Unit,
) {
    val state = vm.state.value

    LaunchedEffect(key1 = true) {
        vm.getContactsFromDevice()
    }

    Surface {
        when (state.uiState) {
            is ContactsListUi.Data -> {
                DataView(
                    data = state.uiState.data,
                    onItemClicked = onItemClicked
                )
            }
            ContactsListUi.EmptyContact -> {
                EmptyView(
                    title = "No Contact",
                    description = "There is no contact in your device!"
                )
            }
            is ContactsListUi.Error -> {
                ContactsListErrorView(errorMessage = state.uiState.message)
            }
            ContactsListUi.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}
