package klt.mdy.contactspicker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmptyViewWithAction(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onActionClicked: () -> Unit,
    actionText: String,
    actionColor: Color
) {
    Surface {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                modifier = modifier.fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(32.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = description,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(32.dp))
            TextButton(onClick = onActionClicked) {
                Text(
                    text = actionText,
                    color = actionColor
                )
            }

        }
    }

}

@Composable
@Preview
private fun Preview() {
    Surface {
        EmptyViewWithAction(
            title = "No permission",
            description = "This cannot be done without permission",
            onActionClicked = {},
            actionColor = MaterialTheme.colors.primary,
            actionText = " Go to Setting"
        )
    }
}

@Composable
fun EmptyView(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {
    Surface {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                modifier = modifier.fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(32.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = description,
                textAlign = TextAlign.Center
            )

        }
    }

}

@Composable
@Preview
private fun NoActionPreview() {
    Surface {
        EmptyView(
            title = "No Contacts",
            description = "There is no contact in your account",
        )
    }
}