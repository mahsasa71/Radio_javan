package ir.android.radiojavan.models

interface IResponse<T> {
    fun onSuccess(response : T)
    fun onFailure(errorResponse : String)
}