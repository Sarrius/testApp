package com.example.testapp.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.NetworkState
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_now_playing_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initInitialData()
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initSubscriptions()
    }

    private fun initView() {
        initList(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        initSwipeToRefresh()
    }

    private fun initList(isPortrait: Boolean) {
        nowPlayingPagedListAdapter = NowPlayingPagedListAdapter(
            NowPlayingPosterDiffUtil(),
            this
        )

        rv_nowPlaying.adapter = nowPlayingPagedListAdapter
        rv_nowPlaying.layoutManager = GridLayoutManager(
            context,
            if(isPortrait)2 else 3,
            RecyclerView.VERTICAL,
            false
        )
    }


    private fun initInitialData() {
        nowPlayingListViewModel.initialLiveDataState.observe(this, Observer {
            handleNetworkState(it)
        })
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

    private fun showError(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
    }

    private fun initSubscriptions() {
        nowPlayingListViewModel.apply {
            pagedListLiveData.observe(this@NowPlayingListFragment, Observer {pagedList ->
                nowPlayingPagedListAdapter.submitList(pagedList)
                nextPageState.observe(this@NowPlayingListFragment, Observer { nextPageState ->
                    nowPlayingPagedListAdapter.setNetworkState(nextPageState)
                })
            })
        }
    }

    private fun handleNetworkState(networkState: NetworkState) {
        when (networkState.status) {
            Status.PROGRESS -> handleProgress(true)
            Status.FAILED -> {
                handleProgress(true)
                networkState.throwable?.let { error -> showError(error) }
            }
            Status.SUCCESS -> handleProgress(false)
        }
    }

    private fun handleProgress(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
        rlProgress.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun onClick(v: View?) {
        v?.let { openFragment(it.id) }
    }

    private fun openFragment(id: Int) {
        NowPlayingMovieFragment.Param.movieId = id

        activity?.let {
            it as MainActivity
            it.replaceFragment(NowPlayingMovieFragment())
        }
    }
}