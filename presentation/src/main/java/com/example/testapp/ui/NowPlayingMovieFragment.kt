package com.example.testapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.common.utils.reformatDate
import com.example.common.utils.loadPoster
import com.example.testapp.R
import com.example.testapp.ui.viewmodel.NowPlayingMovieViewModel
import kotlinx.android.synthetic.main.fragment_now_playing_movie.*
import org.koin.android.ext.android.inject

class NowPlayingMovieFragment : Fragment() {

    private val nowPlayingMovieViewModel: NowPlayingMovieViewModel by inject()

    object Param{ var movieId: Int = 0 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nowPlayingMovieViewModel.requestMovieData(Param.movieId)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_now_playing_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSubscriptions()
    }


    private fun initSubscriptions() {
        nowPlayingMovieViewModel.movieLiveData.observe(this, Observer {
            iv_poster.loadPoster(
                    it?.posterPath,
            R.drawable.ic_no_image,
            50)//TODO hardcoded rounding

            tv_scoreValue.text = it.voteAverage.toString()
            tv_ratingValue.text = "N/A"//TODO
            tv_releaseDateValue.text = it.releaseDate?.reformatDate()
            tv_movieName.text = it.title
            tv_movieDescription.text = it.overview
        })

    }


}