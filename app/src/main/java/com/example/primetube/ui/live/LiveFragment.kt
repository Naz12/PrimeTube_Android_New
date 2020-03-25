package com.example.primetube.ui.live

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.primetube.R
import com.example.primetube.databinding.LiveFragmentBinding
import kotlinx.android.synthetic.main.live_fragment.*

class LiveFragment : Fragment() {

    companion object {
        fun newInstance() = LiveFragment()
    }

    private lateinit var viewModel: LiveViewModel
    private lateinit var binding : LiveFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LiveFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProviders.of(this).get(LiveViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.liveViewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.error.observe(viewLifecycleOwner , Observer { error ->
            var bundle = Bundle()
            bundle.putString("message" , error.errorMessage)
            bundle.putString("src" , error.errorSrc)
            findNavController().navigate(R.id.errorFragment , bundle)
        })
    }



}
