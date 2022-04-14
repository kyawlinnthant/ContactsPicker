package klt.mdy.contactspicker.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContactsItem(
    modifier: Modifier = Modifier,
    name: String,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onItemClick)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = modifier.width(16.dp))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Right arrow",
            tint = MaterialTheme.colors.onSurface.copy(0.7f)
        )
        Spacer(modifier = modifier.width(8.dp))
    }
}

@Composable
@Preview
private fun Preview() {
    Surface {
        ContactsItem(
            name = "Ko Ko Kyaw",
            onItemClick = {}
        )
    }
}