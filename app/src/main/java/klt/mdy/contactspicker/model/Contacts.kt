package klt.mdy.contactspicker.model

import android.graphics.Bitmap

data class Contacts(
    val id: String,
    val name: String,
    val photo : Bitmap?
) {
    var numbers = listOf<String>()
    var emails = listOf<String>()
}

