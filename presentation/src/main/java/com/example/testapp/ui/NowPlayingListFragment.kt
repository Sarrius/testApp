package com.example.testapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.ui.vidgets.NowPlayingPagedListAdapter
import com.example.testapp.ui.vidgets.NowPlayingPosterDiffUtil
import com.example.testapp.ui.viewmodel.NowPlayingViewModel
import kotlinx.android.synthetic.main.fragment_now_playing_list.*
import org.koin.android.ext.android.inject

class NowPlayingListFragment : Fragment(), View.OnClickListener {

    private val nowPlayingViewModel: NowPlayingViewModel by inject()
    private lateinit var nowPlayingPagedListAdapter: NowPlayingPagedListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nowPlayingViewModel.requestInitialData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_now_playing_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initList()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initList() {
        nowPlayingPagedListAdapter = NowPlayingPagedListAdapter(
            NowPlayingPosterDiffUtil(),
            this
        )

        rv_now_playing.adapter = nowPlayingPagedListAdapter
        rv_now_playing.layoutManager = GridLayoutManager(
            context,
            2,
            RecyclerView.VERTICAL,
            false
        )
    }

    override fun onClick(v: View?) {

    }
}