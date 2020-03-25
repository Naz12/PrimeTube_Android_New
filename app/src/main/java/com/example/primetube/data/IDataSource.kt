package com.example.primetube.data

import com.example.primetube.model.Error

interface IDataSource<T> {
    fun get(token: String?, id: String, search: String?, filter: String?, pageNumber: Int?, successCallback: (result: T?) -> Unit)
    fun <K> add(
        data: T,
        token: String,
        successCallback: (result: K?) -> Unit,
        errorCallback: (error: Error?) -> Unit
    )
}