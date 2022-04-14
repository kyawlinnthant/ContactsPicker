package klt.mdy.contactspicker.ui

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionRequestView(
    vm: ContactsViewModel,
    permissionsState: MultiplePermissionsState,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionsState.permissions.forEach { permissionState ->
            when (permissionState.permission) {
                Manifest.permission.READ_CONTACTS -> {
                    when {
                        permissionState.isPermanentlyDenied() -> {

                            EmptyViewWithAction(
                                title = "Permission permanently denied!",
                                description = "You cannot use this feature. If you want to use this feature, go to App Setting and accept it.",
                                onActionClicked = {

                                },
                                actionText = "Go to Setting",
                                actionColor = MaterialTheme.colors.primary
                            )

                        }
                        permissionState.shouldShowRationale -> {

                            EmptyViewWithAction(
                                title = "Permission needed",
                                description = "To use this feature, you need to accept permission! Do it now!",
                                onActionClicked = {

                                },
                                actionText = "Accept",
                                actionColor = MaterialTheme.colors.primary
                            )

                        }

                        permissionState.hasPermission -> {
                            ContactsView(
                                vm = vm,
                                onItemClicked = {

                                }
                            )
                        }

                    }
                }
            }
        }
    }
}

@ExperimentalPermissionsApi
fun PermissionState.isPermanentlyDenied(): Boolean {
    return !shouldShowRationale && !hasPermission
}