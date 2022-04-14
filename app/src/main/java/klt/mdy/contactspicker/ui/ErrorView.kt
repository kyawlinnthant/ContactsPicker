package klt.mdy.contactspicker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContactsListErrorView(
    modifier: Modifier = Modifier,
    errorMessage: String,
) {
    Surface {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Error"
            )
            Spacer(modifier = modifier.width(16.dp))

            Text(
                text = errorMessage,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
@Preview
private fun ContactsErrorPreview() {
    Surface {
        ContactsListErrorView(errorMessage = "Something went wrong!")
    }
}