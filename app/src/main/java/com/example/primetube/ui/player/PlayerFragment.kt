package com.example.primetube.ui.player

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.primetube.databinding.PlayerFragmentBinding
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class PlayerFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerFragment()
    }

    private lateinit var binding : PlayerFragmentBinding
    private lateinit var viewModel: PlayerViewModel

    private lateinit var Player : SimpleExoPlayer

    override fun onStart() {
super.onStart()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PlayerFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.playerviewmodel = viewModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var args = arguments?.getString("videoid")
        if(!args.isNullOrEmpty()){
            viewModel.getVideoData(args)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.videoData.observe(viewLifecycleOwner , Observer { video ->
            var trackSelector = DefaultTrackSelector()
            trackSelector.parameters = trackSelector.buildUponParameters().setMaxVideoSizeSd().build()
            Player = ExoPlayerFactory.newSimpleInstance(context , trackSelector)
            binding.playerView.player = Player

            var datasourceFactory  = DefaultDataSourceFactory(context , "primetube-android-app")
            var mediasourceFactory = DashMediaSource.Factory(datasourceFactory)
            var mpd = video.videoPath.replace("localhost" , "10.240.72.81")
            var mediaSource =  mediasourceFactory.createMediaSource(Uri.parse(mpd))

            Player.playWhenReady = viewModel.playWhenReady
            Player.seekTo(viewModel.currentWindow , viewModel.playbackPosition)
            Player.prepare(mediaSource)
        })
    }

    override fun onPause() {
        viewModel.playWhenReady = Player.playWhenReady
        viewModel.playbackPosition = Player.currentPosition
        viewModel.currentWindow = Player.currentWindowIndex
        Player.release()
        super.onPause()
    }

    override fun onStop() {
        binding.playerView.player = null
        Player.release()
        super.onStop()
    }

//    private fun initializePlayer(context : Context , manifestUrl : String){
//        var trackSelector = DefaultTrackSelector()
//        trackSelector.parameters = trackSelector.buildUponParameters().setMaxVideoSizeSd().build()
//        Player = ExoPlayerFactory.newSimpleInstance(context , trackSelector)
//
//
//
//    }



}
