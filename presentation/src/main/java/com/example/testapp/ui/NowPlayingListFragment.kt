package com.example.testapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Status
import com.example.testapp.R
import com.example.testapp.ui.vidgets.NowPlayingPagedListAdapter
import com.example.testapp.ui.vidgets.NowPlayingPosterDiffUtil
import com.example.testapp.ui.viewmodel.NowPlayingListViewModel
import kotlinx.android.synthetic.main.fragment_now_playing_list.*
import org.koin.android.ext.android.inject


class NowPlayingListFragment : Fragment(), View.OnClickListener {

    private val nowPlayingListViewModel: NowPlayingListViewModel by inject()
    private lateinit var nowPlayingPagedListAdapter: NowPlayingPagedListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nowPlayingListViewModel.requestInitialData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_now_playing_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initSubscriptions()
    }

    private fun initView() {
        initList()
        initSwipeToRefresh()
    }

    private fun initList() {
        nowPlayingPagedListAdapter = NowPlayingPagedListAdapter(
            NowPlayingPosterDiffUtil(),
            this
        )

        rv_nowPlaying.adapter = nowPlayingPagedListAdapter
        rv_nowPlaying.layoutManager = GridLayoutManager(
            context,
            2,
            RecyclerView.VERTICAL,
            false
        )
    }

    private fun initSwipeToRefresh() {
        nowPlayingListViewModel.refreshLiveDataState.observe(this, Observer {
            sl_nowPlaying.isRefreshing = it?.status == Status.PROGRESS
            val msg = it?.throwable
            if (msg != null) {
                showError(msg)
            }
        })
        sl_nowPlaying.setOnRefreshListener {
            nowPlayingListViewModel.refresh()
        }
    }

    private fun showError(msg: Throwable) {

    }

    private fun initSubscriptions() {
        nowPlayingListViewModel.pagedListLiveData.observe(this, Observer {
            nowPlayingPagedListAdapter.submitList(it)
        })
    }

    override fun onClick(v: View?) {
        v?.let { openFragment(it.id) }

    }

    private fun openFragment(id: Int){
        NowPlayingMovieFragment.Param.movieId = id

        activity?.let {
            it as MainActivity
            it.replaceFragment(NowPlayingMovieFragment())
        }
    }
}