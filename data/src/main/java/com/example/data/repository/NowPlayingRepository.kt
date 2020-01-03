package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.data.model.MovieDbModel
import com.example.data.model.NowPlayingPosterModel
import com.example.data.repository.datasource.api.NowPlayingApiDataSource
import com.example.data.repository.datasource.local.NowPlayingDbDataSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import mapToEntity

class NowPlayingRepository(
    private val nowPlayingApiDataSource: NowPlayingApiDataSource,
    private val nowPlayingDbDataSource: NowPlayingDbDataSource
) : BaseRepo(), BoundaryCallbackListener {

    override fun requestInitialData(): Single<Unit> {
        return getPagingSingle(null, true)
    }

    override fun refresh(): Single<Unit> {
        return getPagingSingle(null, true)
    }

    fun getNowPlayingPaged(page: Int?): Single<Unit> {
       return getPagingSingle(page, false)
    }

    fun getNowPlayingById(id: Int) {

    }

    //here is the only place for entity mapping
    fun requestListData(): LiveData<PagedList<NowPlayingPosterModel>> {
        return LivePagedListBuilder(
            nowPlayingDbDataSource.getNowPlaying().map { it.mapToEntity() }
            , 20
        ).setBoundaryCallback(NowPlayingBoundaryCallback(this))
            .build() //TODO page size configurable val
    }

    override fun onZeroLoaded() {
        getPagingSingle(null, false)
    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingPosterModel) {
        //TODO implement page
        getPagingSingle(itemAtEnd.page, false)
    }

    private fun getPagingSingle(page: Int?, rewrite: Boolean): Single<Unit> {
        return nowPlayingApiDataSource.getNowPlaying(page)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map{ writeItemsIntoDb(it, rewrite) }
    }

    private fun writeItemsIntoDb(nowPlayingList: List<MovieDbModel>, rewrite: Boolean){
        database.nowPlayingDao().insertAllNowPlaying(nowPlayingList, rewrite)
    }
}