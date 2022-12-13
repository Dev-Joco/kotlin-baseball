package baseball.model.data

sealed class Result<out R> {

    val succeeded: Boolean
        get() = this is Success && data != null

    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val error: Any) : Result<Nothing>()

}