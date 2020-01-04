package com.example.testapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.NowPlayingMovieExtendedModel
import com.example.domain.usecase.NowPlayingMovieUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class NowPlayingMovieViewModel : ViewModel(), KoinComponent {

    private val nowPlayingListUseCase: NowPlayingMovieUseCase by inject()

    val movieLiveData = MutableLiveData<NowPlayingMovieExtendedModel>()

    fun requestMovieData(id: Int){
        nowPlayingListUseCase.getNowPlayingById(id, movieLiveData)
    }
}