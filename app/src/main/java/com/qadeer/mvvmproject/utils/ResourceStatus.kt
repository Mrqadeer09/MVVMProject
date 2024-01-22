package com.qadeer.mvvmproject.utils

data class ResourceStatus<out T>(val status: Status, val data: T?, val message: String?) {


    enum class Status {
        SUCCESS,
        VERIFY,
        ERROR,
        LOADING,
    }

    companion object {

        fun <T> success(data: T?): ResourceStatus<T> {
            return ResourceStatus(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?, data: T? = null): ResourceStatus<T> {
            return ResourceStatus(Status.ERROR, null, message)
        }

        fun <T> verify(message: String, data: T? = null): ResourceStatus<T> {
            return ResourceStatus(Status.VERIFY, data, message)

        }

        fun <T> loading(data: T? = null): ResourceStatus<T> {
            return ResourceStatus(Status.LOADING, data, null)

        }


    }


}