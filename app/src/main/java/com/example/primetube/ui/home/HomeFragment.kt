package com.example.primetube.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primetube.R
import com.example.primetube.Services.HttpClient
import com.example.primetube.adapter.VideoAdapter
import com.example.primetube.databinding.FragmentHomeBinding
import com.example.primetube.model.Channel
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        val root = inflater.inflate(R.layout.fragment_home, container, false)

        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context) , container , false)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel
        return binding.root
//        homeViewModel.signin(context!!)
//              homeViewModel.registerUser(context!!)
//            homeViewModel.getChannel(context!!)
//            homeViewModel.getChannelHome(context!! , "5ce6ccb86aa9050f509ecbb5")

//
//
//        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        homeViewModel.getHomeVideo(context!! , 10)
//        homeViewModel.getHomeVideo2()

        homeViewModel.error.observe(viewLifecycleOwner , Observer { error ->
            var bundle = Bundle()
            bundle.putString("message" , error.errorMessage)
            bundle.putString("src" , error.errorSrc)
            findNavController().navigate(R.id.errorFragment , bundle)
        })





//        homeViewModel.registerUser(context!!)

//        var channel = Channel(null , "android channel" , "channel created from android")
//            homeViewModel.createChannel(context!! , channel)





    }
}