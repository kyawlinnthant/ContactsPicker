package klt.mdy.contactspicker.data

import java.io.IOException

sealed class DataResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class LoadingEvent<T> : DataResource<T>()
    class ErrorEvent<T>(errorMessage: String) : DataResource<T>(null, errorMessage)
    class SuccessEvent<T>(data: T) : DataResource<T>(data)

}

suspend fun <T> safeDataCall(
    request: suspend () -> T
): DataResource<T> {
    return try {
        val response = request()
        DataResource.SuccessEvent(response)

    } catch (e: Exception) {
        DataResource.ErrorEvent(e.message ?: e.toString())
    } catch (e: IOException) {
        DataResource.ErrorEvent(e.message ?: e.toString())
    }
}