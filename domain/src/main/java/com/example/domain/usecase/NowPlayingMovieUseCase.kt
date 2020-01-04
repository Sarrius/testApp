package com.example.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.data.repository.NowPlayingRepository
import com.example.domain.entity.NowPlayingMovieExtendedModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import mapToExtendedEntity

class NowPlayingMovieUseCase(
    private val nowPlayingRepository: NowPlayingRepository
) :BaseUseCase(){

    fun getNowPlayingById(id: Int, movieRequestState: MutableLiveData<NowPlayingMovieExtendedModel>){
        nowPlayingRepository.getNowPlayingById(id)
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.mapToExtendedEntity() }
            .subscribe({
                movieRequestState.postValue(it)
            },{}).addTo(compositeDisposable)
    }
}