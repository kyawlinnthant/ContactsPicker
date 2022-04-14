package klt.mdy.contactspicker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import klt.mdy.contactspicker.model.Contacts


@Composable
fun DataView(
    data: List<Contacts>,
    onItemClicked: (Contacts) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        items(
            items = data,
            key = {
                it.id
            }
        ) { account ->
            ContactsItem(
                name = account.name,
                onItemClick = {
                    onItemClicked(account)
                }
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    Surface {
        DataView(
            data = listOf(
                Contacts(
                    name = "koko kyaw",
                    id = "1",
                    photo = null,
                ),
                Contacts(
                    name = "koko linn",
                    id = "2",
                    photo = null,
                ),
                Contacts(
                    name = "koko thant",
                    id = "3",
                    photo = null,
                ),
                Contacts(
                    name = "koko kyaw linn thant",
                    id = "4",
                    photo = null,
                ),

                ),
            onItemClicked = {}
        )

    }
}