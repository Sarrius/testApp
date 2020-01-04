package com.example.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.data.repository.BaseRepo
import com.example.domain.entity.NetworkState
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open abstract class BaseUseCase(private vararg val repos: BaseRepo) {

    protected val compositeDisposable = CompositeDisposable()

    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}

fun <T> Single<T>.handleNetworkState(networkState: MutableLiveData<NetworkState>?): Disposable {
    return this.subscribe({
        networkState?.postValue(NetworkState.SUCCESS)
    }, {
        networkState?.postValue(NetworkState.error(it))
    })
}
